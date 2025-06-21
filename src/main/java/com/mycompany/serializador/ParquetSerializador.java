 
package com.mycompany.serializador;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.ParquetWriter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParquetSerializador implements ISerializador{

    @Override
    public boolean serializar(String rutaEntrada, String rutaSalida) {
        File archivoTxt = new File(rutaEntrada);
        File archivoParquet = new File(rutaSalida);
        File carpetaDestino = archivoParquet.getParentFile();
        if (carpetaDestino != null && !carpetaDestino.exists()) {
            carpetaDestino.mkdirs();
        }

        String esquemaJson = """
        {
          "type": "record",
          "name": "LineaTexto",
          "fields": [
            { "name": "texto", "type": "string" }
          ]
        }
        """;
        
        Schema schema = new Schema.Parser().parse(esquemaJson);

        Path outputPath = new Path(rutaSalida);
        ParquetWriter<GenericRecord> writer = null;
        try {
            writer = AvroParquetWriter.<GenericRecord>builder(outputPath)
                    .withSchema(schema)
                    .withCompressionCodec(CompressionCodecName.SNAPPY)
                    .withPageSize(1024)
                    .build();
        } catch (IOException ex) {
            Logger.getLogger(ParquetSerializador.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTxt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                GenericRecord record = new GenericData.Record(schema);
                record.put("texto", linea);
                writer.write(record);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParquetSerializador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParquetSerializador.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ParquetSerializador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Archivo Parquet creado en: " + rutaSalida);
        return true;
    }
}



package com.mycompany.serializador;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.ParquetWriter;
import java.io.*;

public class ParquetSerializador {

    public void serializarParquet(String rutaEntrada, String rutaSalida) throws IOException {
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
        ParquetWriter<GenericRecord> writer = AvroParquetWriter.<GenericRecord>builder(outputPath)
                .withSchema(schema)
                .withCompressionCodec(CompressionCodecName.SNAPPY) 
                .withPageSize(1024) 
                .build();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTxt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                GenericRecord record = new GenericData.Record(schema);
                record.put("texto", linea);
                writer.write(record);
            }
        }

        writer.close();
        System.out.println("Archivo Parquet creado en: " + rutaSalida);
    }
}


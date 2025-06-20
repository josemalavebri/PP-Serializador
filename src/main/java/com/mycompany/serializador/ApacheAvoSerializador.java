package com.mycompany.serializador;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.DatumWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheAvoSerializador implements ISerializador{

    @Override
     public boolean serializar(String rutaEntrada, String rutaSalida) {

         File archivoTxt = new File(rutaEntrada);
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

         File archivoAvro = new File(rutaSalida);
         File carpetaDestino = archivoAvro.getParentFile();

         if (carpetaDestino != null && !carpetaDestino.exists()) {
             carpetaDestino.mkdirs();
         }

         DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);

         try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter)) {
             dataFileWriter.create(schema, archivoAvro);

             try (BufferedReader br = new BufferedReader(new FileReader(archivoTxt))) {
                 String linea;
                 while ((linea = br.readLine()) != null) {
                     GenericRecord record = new GenericData.Record(schema);
                     record.put("texto", linea);
                     dataFileWriter.append(record);
                 }
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(ApacheAvoSerializador.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
             } catch (IOException ex) {
                 Logger.getLogger(ApacheAvoSerializador.class.getName()).log(Level.SEVERE, null, ex);
                 return false; 
             }

             System.out.println("Archivo serializado correctamente a " + rutaSalida);
             return true; 

         } catch (IOException ex) {
             Logger.getLogger(ApacheAvoSerializador.class.getName()).log(Level.SEVERE, null, ex);
             return false; 
         }
     }
}

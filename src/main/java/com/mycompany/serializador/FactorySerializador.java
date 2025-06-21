
package com.mycompany.serializador;


public class FactorySerializador {
    
    public static ISerializador Crear(String tipo) {
        
        if(tipo.equalsIgnoreCase("archivo.avro")){
            return new ApacheAvoSerializador();
        }
        
        if(tipo.equalsIgnoreCase("archivo.parquet")){
            return new ParquetSerializador();
        }
        return null;
      
    }
}


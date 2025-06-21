
package com.mycompany.serializador;


public class Serializacion {
    
    public boolean serializar(String tipo, String rutaEntrada,String rutaSalida){
        return FactorySerializador.Crear(tipo).serializar(rutaEntrada, rutaSalida);
    }
}

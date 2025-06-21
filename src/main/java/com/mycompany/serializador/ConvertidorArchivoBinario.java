
package com.mycompany.serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ConvertidorArchivoBinario {

    public StringBuilder convertir(File archivo){
        StringBuilder builder = new StringBuilder();
         try (FileInputStream fis = new FileInputStream(archivo)) {
            int b;
            while ((b = fis.read()) != -1) {
                builder.append(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0')).append(" ");
            }
           return builder;
        } catch (IOException e) {
             System.out.println("Error al convertir:"+ e.getMessage());
             return builder;
        }
    }
}

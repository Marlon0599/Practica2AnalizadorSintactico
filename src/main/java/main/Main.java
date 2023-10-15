
package main;

import java.io.File;
import lexicalPart.Ventana;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String ruta = "/home/marlon/Documentos/LabLenguajes/Practica2AnalizadorSintactico/src/main/java/lexicalPart/Lexer.flex";
        generarLexer(ruta); 
        Ventana play = new Ventana();
        play.setVisible(true);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}

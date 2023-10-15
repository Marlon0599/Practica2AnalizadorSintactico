package syntacticPart;

import Reportes.TablaBloque;
import java.util.ArrayList;
import java.util.List;

public class Validar {

    private static ArrayList<String> listaDeErrores = new ArrayList<>();

    public static void lectorSintactico(String[] entrada) {
        SepararArreglos(entrada);
    }

    public static void SepararArreglos(String[] entrada) {

        List<String> arregloRestantes = new ArrayList<>();
        List<List<String>> arreglosFor = new ArrayList<>();
        List<List<String>> arregloWhile = new ArrayList<>();
        List<List<String>> arregloIf = new ArrayList<>();
        List<List<String>> arregloPrint = new ArrayList<>();
        List<List<String>> arregloElse = new ArrayList<>();
        List<List<String>> arregloDef = new ArrayList<>();
        List<List<String>> arregloElif = new ArrayList<>();
        List<List<String>> arregloReturn = new ArrayList<>();
        List<List<String>> arregloImport = new ArrayList<>();
        List<List<String>> arregloClass = new ArrayList<>();
        List<List<String>> arregloDefinirVar = new ArrayList<>();

        List<String> arregloActual = null;

        for (int i = 0; i < entrada.length; i++) {
            String elemento = entrada[i];
            switch (elemento) {
                case "for":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arreglosFor.add(arregloActual);
                    break;
                case "while":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloWhile.add(arregloActual);
                    break;
                case "if":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloIf.add(arregloActual);
                    break;
                case "print":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloPrint.add(arregloActual);
                    break;
                case "else":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloElse.add(arregloActual);
                    break;
                case "def":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloDef.add(arregloActual);
                    break;
                case "elif":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloElif.add(arregloActual);
                    break;
                case "return":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloReturn.add(arregloActual);
                    break;
                case "import":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloImport.add(arregloActual);
                    break;
                case "class":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloClass.add(arregloActual);
                    break;
                case "abcd":
                    arregloActual = new ArrayList<>();
                    arregloActual.add(elemento);
                    arregloDefinirVar.add(arregloActual);
                    break;
                default:
                    if (arregloActual != null) {
                        arregloActual.add(elemento);
                    } else {
                        arregloRestantes.add(elemento);
                    }
                    break;
            }
        }

        String[][] entradaFor = new String[arreglosFor.size()][];
        String[][] entradaWhile = new String[arregloWhile.size()][];
        String[][] entradaIf = new String[arregloIf.size()][];
        String[][] entradaPrint = new String[arregloPrint.size()][];
        String[][] entradaElse = new String[arregloElse.size()][];
        String[][] entradaDef = new String[arregloDef.size()][];
        String[][] entradaElif = new String[arregloElif.size()][];
        String[][] entradaReturn = new String[arregloReturn.size()][];
        String[][] entradaImport = new String[arregloImport.size()][];
        String[][] entradaClass = new String[arregloClass.size()][];
        String[][] entradaDefinirVar = new String[arregloDefinirVar.size()][];

        /**
         * **********************************************
         */
        //convertir a un arreglo
        for (int i = 0; i < arreglosFor.size(); i++) {
            List<String> listaInterna = arreglosFor.get(i);
            entradaFor[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaWhile.length; i++) {
            List<String> listaInterna = arregloWhile.get(i);
            entradaWhile[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaIf.length; i++) {
            List<String> listaInterna = arregloIf.get(i);
            entradaIf[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaPrint.length; i++) {
            List<String> listaInterna = arregloPrint.get(i);
            entradaPrint[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaElse.length; i++) {
            List<String> listaInterna = arregloElse.get(i);
            entradaElse[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaDef.length; i++) {
            List<String> listaInterna = arregloDef.get(i);
            entradaDef[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaElif.length; i++) {
            List<String> listaInterna = arregloElif.get(i);
            entradaElif[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaReturn.length; i++) {
            List<String> listaInterna = arregloReturn.get(i);
            entradaReturn[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaImport.length; i++) {
            List<String> listaInterna = arregloImport.get(i);
            entradaImport[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaClass.length; i++) {
            List<String> listaInterna = arregloClass.get(i);
            entradaClass[i] = listaInterna.toArray(new String[0]);
        }
        for (int i = 0; i < entradaDefinirVar.length; i++) {
            List<String> listaInterna = arregloDefinirVar.get(i);
            entradaDefinirVar[i] = listaInterna.toArray(new String[0]);
        }

// Imprimir los resultados
        /*System.out.println("Arreglo Restantes: " + arregloRestantes);
        
        for (int i = 0; i < arreglosFor.size(); i++) {
            System.out.println("Arreglo For " + (i + 1) + ": " + arreglosFor.get(i));
        }
        //System.out.println("Arreglo While: " + arregloWhile);
        for(int i = 0; i < arregloWhile.size(); i++){
            System.out.println("Arreglo While " + (i + 1) + ": " + arregloWhile.get(i));
            }
        for(int i = 0; i < arregloIf.size(); i++){
            System.out.println("Arreglo If " + (i + 1) + ": " + arregloIf.get(i));
        }
        for(int i = 0; i < arregloPrint.size(); i++){
            System.out.println("Arreglo Print " + (i + 1) + ": " + arregloPrint.get(i));
        }
        for(int i = 0; i < arregloElse.size(); i++){
            System.out.println("Arreglo Else " + (i + 1) + ": " + arregloElse.get(i));
        }
        for(int i = 0; i < arregloDef.size(); i++){
            System.out.println("Arreglo Def " + (i + 1) + ": " + arregloDef.get(i));
        }
        for(int i = 0; i < arregloElif.size(); i++){
            System.out.println("Arreglo Elif " + (i + 1) + ": " + arregloElif.get(i));
        }
        for(int i = 0; i < arregloReturn.size(); i++){
            System.out.println("Arreglo Return " + (i + 1) + ": " + arregloReturn.get(i));
        }
        for(int i = 0; i < arregloImport.size(); i++){
            System.out.println("Arreglo Import " + (i + 1) + ": " + arregloImport.get(i));
        }
        for(int i = 0; i < arregloClass.size(); i++){
            System.out.println("Arreglo Class " + (i + 1) + ": " + arregloClass.get(i));
        }
        for(int i = 0; i < arregloDefinirVar.size(); i++){
            System.out.println("Arreglo Definir Variable " + (i + 1) + ": " + arregloDefinirVar.get(i));
        }*/
        /**
         * *****************************************************
         */
        if (entradaFor.length > 0) {
            for (int i = 0; i < entradaFor.length; i++) {
                if (Analizador.analizarFor(entradaFor[i])) {
                    //System.out.println("La entrada es una estructura FOR válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaFor[i]);
                    tB.addArrayToList(tB.getData(), entradaFor[i]);
                } else {
                    //System.out.println("La entrada no es una estructura FOR válida.");
                    listaDeErrores.add("La entrada no es una estructura FOR valida.");
                }
            }
        }

        if (entradaWhile.length > 0) {
            for (int i = 0; i < entradaWhile.length; i++) {
                if (Analizador.analizarWhile(entradaWhile[i])) {
                    //System.out.println("La entrada es una estructura WHILE válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaWhile[i]);
                    tB.addArrayToList(tB.getData(), entradaWhile[i]);
                } else {
                    //System.out.println("La entrada no es una estructura WHILE válida.");
                    listaDeErrores.add("La entrada no es una estructura WHILE valida.");

                }
            }
        }

        if (entradaIf.length > 0) {
            for (int i = 0; i < entradaIf.length; i++) {
                if (Analizador.analizarIf(entradaIf[i])) {
                    //System.out.println("La entrada es una estructura IF válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaIf[i]);
                    tB.addArrayToList(tB.getData(), entradaIf[i]);
                } else {
                    //System.out.println("La entrada no es una estructura IF válida.");
                    listaDeErrores.add("La entrada no es una estructura IF valida.");
                }
            }
        }

        if (entradaPrint.length > 0) {
            for (int i = 0; i < entradaPrint.length; i++) {
                if (Analizador.analizarPrint(entradaPrint[i])) {
                    //System.out.println("La entrada es una estructura PRINT válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaPrint[i]);
                    tB.addArrayToList(tB.getData(), entradaPrint[i]);
                } else {
                    //System.out.println("La entrada no es una estructura PRINT válida.");
                    listaDeErrores.add("La entrada no es una estructura PRINT valida.");
                }
            }
        }

        if (entradaElse.length > 0) {
            for (int i = 0; i < entradaElse.length; i++) {
                if (Analizador.analizarElse(entradaElse[i])) {
                    //System.out.println("La entrada es una estructura ELSE válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaElse[i]);
                    tB.addArrayToList(tB.getData(), entradaElse[i]);
                } else {
                    //System.out.println("La entrada no es una estructura ELSE válida.");
                    listaDeErrores.add("La entrada no es una estructura ELSE valida.");
                }
            }
        }

        if (entradaDef.length > 0) {
            for (int i = 0; i < entradaDef.length; i++) {
                if (Analizador.analizarDef(entradaDef[i])) {
                    //System.out.println("La entrada es una estructura DEF válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaDef[i]);
                    tB.addArrayToList(tB.getData(), entradaDef[i]);
                } else {
                    //System.out.println("La entrada no es una estructura DEF válida.");
                    listaDeErrores.add("La entrada no es una estructura DEF valida.");
                }
            }
        }

        if (entradaElif.length > 0) {
            for (int i = 0; i < entradaElif.length; i++) {
                if (Analizador.analizarElif(entradaElif[i])) {
                    //System.out.println("La entrada es una estructura ELIF válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaElif[i]);
                    tB.addArrayToList(tB.getData(), entradaElif[i]);
                } else {
                    //System.out.println("La entrada no es una estructura ELIF válida.");
                    listaDeErrores.add("La entrada no es una estructura ELIF valida.");
                }
            }
        }

        if (entradaReturn.length > 0) {
            for (int i = 0; i < entradaReturn.length; i++) {
                if (Analizador.analizarReturn(entradaReturn[i])) {
                    //System.out.println("La entrada es una estructura RETURN válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaReturn[i]);
                    tB.addArrayToList(tB.getData(), entradaReturn[i]);
                } else {
                    //System.out.println("La entrada no es una estructura RETURN válida.");
                    listaDeErrores.add("La entrada no es una estructura RETURN valida.");
                }
            }
        }

        if (entradaImport.length > 0) {
            for (int i = 0; i < entradaImport.length; i++) {
                if (Analizador.analizarImport(entradaImport[i])) {
                    //System.out.println("La entrada es una estructura IMPORT válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaImport[i]);
                    tB.addArrayToList(tB.getData(), entradaImport[i]);
                } else {
                    //System.out.println("La entrada no es una estructura IMPORT válida.");
                }
            }
        }

        if (entradaClass.length > 0) {
            for (int i = 0; i < entradaClass.length; i++) {
                if (Analizador.analizarClass(entradaClass[i])) {
                    //System.out.println("La entrada es una estructura CLASS válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaClass[i]);
                    tB.addArrayToList(tB.getData(), entradaClass[i]);
                } else {
                    //System.out.println("La entrada no es una estructura CLASS válida.");
                    listaDeErrores.add("La entrada no es una estructura CLASS valida.");
                }
            }
        }
        if (entradaDefinirVar.length > 0) {
            for (int i = 0; i < entradaDefinirVar.length; i++) {
                if (Analizador.analizarClass(entradaDefinirVar[i])) {
                    //System.out.println("La entrada es una estructura DEFINIR VARIABLE válida.");
                    TablaBloque tB = new TablaBloque();
                    tB.setEntrada(entradaDefinirVar[i]);
                    tB.addArrayToList(tB.getData(), entradaDefinirVar[i]);
                } else {
                    //System.out.println("La entrada no es una estructura DEFINIR VARIABLE válida.");
                    listaDeErrores.add("La entrada no es una estructura DEFINIR VARIABLE valida.");
                }
            }
        }

    }

    public static ArrayList<String> getListaDeErrores() {
        return listaDeErrores;
    }

    public void limpiarListaDeErrores() {
        listaDeErrores.clear();
    }

    public static void setListaDeErrores(String error) {
        listaDeErrores.add(error);
    }

}

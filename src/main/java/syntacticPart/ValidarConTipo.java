package syntacticPart;

import java.util.ArrayList;
import java.util.List;

public class ValidarConTipo {

    public static void ValidarMain(String[] entrada1) {
        ValidarConTipo(entrada1);
        NumerosAritmeticos(entrada1);
        OperadoresAsignacion(entrada1);
        OperadoresComparacion(entrada1);
        OperadoresLogicos(entrada1);
        OperadoresBits(entrada1);
    }

    public static void ValidarConTipo(String[] entrada1) {
        //String[] entrada1 = { "Identificador", "Asignacion", "Identificador", "Asignacion", "Cadena", "OtraCadena2", "OtraCadena3", "Identificador", "Asignacion", "NumeroEntero"};

        boolean primeraCondicion = false;
        boolean segundaCondicion = false;

        for (int i = 0; i < entrada1.length - 2; i++) {
            if (entrada1[i].equals("Identificador") && entrada1[i + 1].equals("Asignacion")) {
                // Encontrado "Identificador" seguido de "Asignacion"
                primeraCondicion = true;
                String terceraPalabra = entrada1[i + 2];
                if (terceraPalabra.equals("Cadena") || terceraPalabra.equals("NumeroEntero") || terceraPalabra.equals("Booleanas")) {

                    segundaCondicion = true;
                }
                if (primeraCondicion == true && segundaCondicion == false) {
                    Validar.setListaDeErrores("Error falta definir entidad");
                }
                // Imprimir resultados aquí o realizar otras acciones según sea necesario
                //System.out.println("ValidarConTipo \nGrupo [" + entrada1[i] + ", " + entrada1[i + 1] + ", " + terceraPalabra + "] -> [Condición 1 " + (primeraCondicion ? "Verdadero" : "Falso") + ", Condición 2 " + (segundaCondicion ? "Verdadero" : "Falso") + "]");
                // Reiniciar las condiciones para el siguiente grupo
                primeraCondicion = false;
                segundaCondicion = false;
            }
        }
    }

    public static void NumerosAritmeticos(String[] entrada1) {
        //String[] entrada1 = {"OtraCadena1", "Identificador", "Asignacion", "NumeroEntero", "Aritmeticos", "NumeroEntero","Aritmeticos", "OtraCadena2", "OtraCadena3", "Identificador", "Asignacion", "NumeroEntero"};

        List<SubArreglo> subarreglos = new ArrayList<>();
        SubArreglo subarreglo = null;

        for (String palabra : entrada1) {
            if (palabra.equals("Identificador") && subarreglo == null) {
                subarreglo = new SubArreglo();
                subarreglo.agregarPalabra(palabra);
            } else if (subarreglo != null && (palabra.equals("Asignacion") || palabra.equals("NumeroEntero") || palabra.equals("Aritmeticos"))) {
                subarreglo.agregarPalabra(palabra);
            } else if (subarreglo != null) {
                subarreglos.add(subarreglo);
                subarreglo = null;
            }
        }

        // Agregar el último subarreglo si es necesario
        if (subarreglo != null) {
            subarreglos.add(subarreglo);
        }

        // Imprimir los subarreglos y verificar el último elemento
        for (SubArreglo sub : subarreglos) {
            //System.out.println(sub.palabras);
            //System.out.println("Termina en NumeroEntero: " + sub.terminaEnNumeroEntero());
            //System.out.println("Termina en Aritmeticos: " + sub.terminaEnAritmeticos());
            if (sub.terminaEnAritmeticos()) {
                Validar.setListaDeErrores("Error al definir entidad");
            }
        }
    }

    public static void OperadoresAsignacion(String[] entrada1) {
        //String[] entrada1 = { "Identificador","Aritmeticos", "Asignacion", "NumeroEntero", "Asignacion", "Cadena", "OtraCadena2", "OtraCadena3", "Identificador","Aritmeticos", "Asignacion", "NumeroEntero"};

        boolean primeraCondicion = false;
        boolean segundaCondicion = false;

        if (entrada1.length >= 3) {

            for (int i = 0; i < entrada1.length - 3; i++) {
                if (entrada1[i].equals("Identificador") && entrada1[i + 1].equals("Aritmeticos") && entrada1[i + 2].equals("Asignacion")) {
                    // Encontrado "Identificador" seguido de "Asignacion"
                    primeraCondicion = true;
                    String terceraPalabra = entrada1[i + 3];
                    if (terceraPalabra.equals("NumeroEntero")) {
                        segundaCondicion = true;
                    }
                    if (primeraCondicion == true && segundaCondicion == false) {
                        Validar.setListaDeErrores("Error al definir la entidad");
                    }
                    // Imprimir resultados aquí o realizar otras acciones según sea necesario
                    //System.out.println("OperadoresAsignacion \n Grupo [" + entrada1[i] + ", " + entrada1[i + 1] + ", " + terceraPalabra + "] -> [Condición 1 " + (primeraCondicion ? "Verdadero" : "Falso") + ", Condición 2 " + (segundaCondicion ? "Verdadero" : "Falso") + "]");
                    // Reiniciar las condiciones para el siguiente grupo
                    primeraCondicion = false;
                    segundaCondicion = false;
                }
            }
        }
    }

    public static void OperadoresComparacion(String[] entrada1) {
        //String[] entrada1 = { "Identificador", "Asignacion", "NumeroEntero", "Comparacion", "NumeroEntero", "OtraCadena2", "OtraCadena3", "Identificador","Aritmeticos", "Asignacion", "NumeroEntero"};

        boolean primeraCondicion = false;
        boolean segundaCondicion = false;
        if (entrada1.length >= 4) {
            for (int i = 0; i < entrada1.length - 4; i++) {
                if (entrada1[i].equals("Identificador") && entrada1[i + 1].equals("Asignacion") && entrada1[i + 2].equals("NumeroEntero") && entrada1[i + 3].equals("Comparacion")) {
                    // Encontrado "Identificador" seguido de "Asignacion"
                    primeraCondicion = true;
                    String terceraPalabra = entrada1[i + 4];
                    if (terceraPalabra.equals("NumeroEntero")) {
                        segundaCondicion = true;
                    }
                    if (primeraCondicion == true && segundaCondicion == false) {
                        Validar.setListaDeErrores("Error al definir entidad operadores de comparacion");
                    }
                    // Imprimir resultados aquí o realizar otras acciones según sea necesario
                    //System.out.println("Grupo [" + entrada1[i] + ", " + entrada1[i + 1] + ", " + 
                    //entrada1[i+2] + " " + entrada1[i+3] + " " +terceraPalabra + "] -> [Condición 1 " + (primeraCondicion ? "Verdadero" : "Falso") + ", Condición 2 " + (segundaCondicion ? "Verdadero" : "Falso") + "]");
                    // Reiniciar las condiciones para el siguiente grupo
                    primeraCondicion = false;
                    segundaCondicion = false;
                }
            }
        }
    }

    public static void OperadoresLogicos(String[] entrada1) {
        //String[] entrada1 = { "Identificador", "Asignacion", "NumeroEntero", "Comparacion","NumeroEntero","Logicos", "NumeroEntero","Comparacion","NumeroEntero","aweq","qweq",

        boolean primeraCondicion = false;
        boolean segundaCondicion = false;
        boolean terceraCondicion = false;
        boolean cuartaCondicion = false;
        boolean quintaCondicion = false;

        if (entrada1.length >= 6) {
            for (int i = 0; i < entrada1.length - 8; i++) {
                System.out.println("**" + i);
                if (entrada1[i].equals("Identificador") && entrada1[i + 1].equals("Asignacion") && entrada1[i + 2].equals("NumeroEntero") && entrada1[i + 3].equals("Comparacion")
                        && entrada1[i + 4].equals("NumeroEntero") && entrada1[i + 5].equals("Logicos")) {
                    // Encontrado "Identificador" seguido de "Asignacion"
                    primeraCondicion = true;
                    String septimaPalabra = entrada1[i + 6];
                    if (septimaPalabra.equals("NumeroEntero")) {
                        segundaCondicion = true;
                        String octavaPalabra = entrada1[i + 7];
                        if (octavaPalabra.equals("Comparacion")) {
                            terceraCondicion = true;
                            String ultimaPalabra = entrada1[i + 8];
                            System.out.println("****" + ultimaPalabra + entrada1[8]);
                            if (ultimaPalabra.equals("NumeroEntero")) {
                                cuartaCondicion = true;
                            }
                            if (terceraCondicion == true && cuartaCondicion == false) {
                                Validar.setListaDeErrores("Error al definir la entidad operadores logicos");
                            }
                        }
                        if (segundaCondicion == true && terceraCondicion == false) {
                            Validar.setListaDeErrores("Error al definir la entidad operadores logicos");
                        }
                    }

                    if (primeraCondicion == true && segundaCondicion == false) {
                        Validar.setListaDeErrores("Error al definir la entidad operadores logicos");
                    }
                    // Imprimir resultados aquí o realizar otras acciones según sea necesario
                    //System.out.println("Grupo [" + entrada1[i] + ", " + entrada1[i + 1] + ", " + 
                    //entrada1[i+2] + " " + entrada1[i+3] +  "] -> [Condición 1 " + (primeraCondicion ? "Verdadero" : "Falso") + ", Condición 2 " + (segundaCondicion ? "Verdadero" : "Falso") + "]");
                    // Reiniciar las condiciones para el siguiente grupo
                    primeraCondicion = false;
                    segundaCondicion = false;
                    terceraCondicion = false;
                    cuartaCondicion = false;
                }
            }
        }
    }

    public static void OperadoresBits(String[] entrada1) {
        //String[] entrada1 = { "Identificador", "Asignacion", "NumeroEntero", "Bits", "NumeroEntero", "OtraCadena2", "OtraCadena3", "Identificador","Aritmeticos", "Asignacion", "NumeroEntero"};

        boolean primeraCondicion = false;
        boolean segundaCondicion = false;

        if (entrada1.length >= 4) {

            for (int i = 0; i < entrada1.length - 4; i++) {
                if (entrada1[i].equals("Identificador") && entrada1[i + 1].equals("Asignacion") && entrada1[i + 2].equals("NumeroEntero")
                        && entrada1[i + 3].equals("Bits")) {
                    // Encontrado "Identificador" seguido de "Asignacion"
                    primeraCondicion = true;
                    String ultimaPalabra = entrada1[i + 4];
                    if (ultimaPalabra.equals("NumeroEntero")) {
                        segundaCondicion = true;
                    }
                    if (primeraCondicion == true && segundaCondicion == false) {
                        Validar.setListaDeErrores("Error al definir la entidad operadores de bits");
                    }
                    // Imprimir resultados aquí o realizar otras acciones según sea necesario
                    //System.out.println("Grupo [" + entrada1[i] + ", " + entrada1[i + 1] + ", " + ultimaPalabra + "] -> [Condición 1 " + (primeraCondicion ? "Verdadero" : "Falso") + ", Condición 2 " + (segundaCondicion ? "Verdadero" : "Falso") + "]");
                    // Reiniciar las condiciones para el siguiente grupo
                    primeraCondicion = false;
                    segundaCondicion = false;
                }
            }
        }
    }

}

class SubArreglo {

    List<String> palabras = new ArrayList<>();

    public void agregarPalabra(String palabra) {
        palabras.add(palabra);
    }

    public boolean terminaEnNumeroEntero() {
        return !palabras.isEmpty() && palabras.get(palabras.size() - 1).equals("NumeroEntero");
    }

    public boolean terminaEnAritmeticos() {
        return !palabras.isEmpty() && palabras.get(palabras.size() - 1).equals("Aritmeticos");
    }

}

package syntacticPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizador {

    public static boolean analizarFor(String[] entrada) {
        String regexFor = "for\\s+[a-zA-Z_][a-zA-Z_0-9]*\\s+in\\s+range\\s*\\(\\s*\\d+\\s*\\)\\s*:";

        Pattern patron = Pattern.compile(regexFor);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexFor + ".*$");
    }

    public static boolean analizarWhile(String[] entrada) {
        String regexWhile = "while\\s+[a-zA-Z_][a-zA-Z_0-9]*\\s*[<>=]\\s*\\d+\\s*:";
        Pattern patron = Pattern.compile(regexWhile);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexWhile + ".*$");
    }

    public static boolean analizarIf(String[] entrada) {
        String regexIf = "if\\s+[^:\\n]+:\\s*";
        Pattern patron = Pattern.compile(regexIf);

        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexIf + ".*$");

    }

    public static boolean analizarPrint(String[] entrada) {
        String regexPrint = "print\\s*\\(.*?\\)";
        Pattern patron = Pattern.compile(regexPrint);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexPrint + ".*$");
    }

    public static boolean analizarElse(String[] entrada) {
        String regexElse = "else:";
        Pattern patron = Pattern.compile(regexElse);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append("");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexElse + ".*$");
    }

    public static boolean analizarDef(String[] entrada) {
        String regexDef = "def\\s+[a-zA-Z_][a-zA-Z_0-9]*\\s*\\(.*?\\)\\s*:";
        Pattern patron = Pattern.compile(regexDef);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexDef + ".*$");
    }

    public static boolean analizarElif(String[] entrada) {
        String regexElif = "elif\\s+.*?:";
        Pattern patron = Pattern.compile(regexElif);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexElif + ".*$");
    }

    public static boolean analizarReturn(String[] entrada) {
        String regexReturn = "return\\s+.*?";
        Pattern patron = Pattern.compile(regexReturn);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexReturn + ".*$");
    }

    public static boolean analizarImport(String[] entrada) {
        String regexImport = "import\\s+[a-zA-Z_]\\w*";
        Pattern patron = Pattern.compile(regexImport);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexImport + ".*$");
    }

    public static boolean analizarClass(String[] entrada) {
        String regexClass = "\\bclass\\s+[a-zA-Z_][a-zA-Z_0-9]*\\s*(:|\\()";
        Pattern patron = Pattern.compile(regexClass);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexClass + ".*$");
    }

    public static boolean analizarDefinirVar(String[] entrada) {
        String regexVariableAssignment = "\\b[a-zA-Z_][a-zA-Z_0-9]*\\s*=\\s*((\".*?\")|('.*?')|\\d+|True|False)\\b";
        Pattern patron = Pattern.compile(regexVariableAssignment);

        // Concatenar todos los elementos en una sola cadena
        StringBuilder cadena = new StringBuilder();
        for (String elemento : entrada) {
            cadena.append(elemento).append(" ");
        }

        String cadenaCompleta = cadena.toString().trim();

        // Verificar si la cadena cumple con el patrón al inicio o en cualquier posición
        Matcher matcher = patron.matcher(cadenaCompleta);

        return matcher.matches() || cadenaCompleta.matches("^.*" + regexVariableAssignment + ".*$");
    }

}

package lexicalPart;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class InsertColored {

    public static void InsertColored(JTextPane textPane, String[] arreglo, String[] tipo, int[] linea) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
        SimpleAttributeSet wordStyle = new SimpleAttributeSet();

        textPane.setText("");
        Color moradoRGB = new Color(128, 0, 128, 255);
        Color celeste = new Color(0, 191, 255);
        boolean nuevaLinea = true; // Bandera para detectar cambios de línea

        for (int i = 0; i < arreglo.length; i++) {
            String word = arreglo[i];
            switch (tipo[i]) {
                // Configura el estilo según el tipo de palabra
                case "Identificador":
                    StyleConstants.setForeground(wordStyle, Color.WHITE);
                    break;
                case "Aritmeticos":
                case "Comparacion":
                case "Logicos":
                case "Asignacion":
                case "Bits":
                    StyleConstants.setForeground(wordStyle, celeste);
                    break;
                case "PalabrasClave":
                    StyleConstants.setForeground(wordStyle, moradoRGB);
                    break;
                case "NumeroEntero":
                case "NumeroDecimal":
                case "Cadena":
                case "Booleanas":
                    StyleConstants.setForeground(wordStyle, Color.RED);
                    break;
                case "Comentario":
                    StyleConstants.setForeground(wordStyle, Color.LIGHT_GRAY);
                    break;
                case "Otros":
                    StyleConstants.setForeground(wordStyle, Color.GREEN);
                    break;
            }

            try {
                // Verifica si hay un cambio de línea y, si es así, agrega una nueva línea
                if (nuevaLinea) {
                    doc.insertString(doc.getLength(), "\n", defaultStyle);
                    nuevaLinea = false;
                }

                // Inserta la palabra en el documento con el estilo
                doc.insertString(doc.getLength(), word + " ", wordStyle);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }

            // Verifica si hay un cambio de línea basado en el arreglo 'linea'
            if (i < linea.length - 1 && linea[i] != linea[i + 1]) {
                nuevaLinea = true;
            }
        }
    }

}

package syntacticPart;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Errores {

    public static void EscribirErrores(JTextPane textPane, ArrayList<String> errores) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet atributos = new SimpleAttributeSet();
        StyleConstants.setForeground(atributos, Color.RED);

        try {
            textPane.setText("");
            // Recorre la lista de errores y agrega cada uno al JTextPane
            for (String error : errores) {
                doc.insertString(doc.getLength(), error + "\n", atributos);
            }
        } catch (Exception e) {
            System.out.println("Error al escribir en el JTextPane: " + e.getMessage());
        }
    }

}

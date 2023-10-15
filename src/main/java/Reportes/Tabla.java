package Reportes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lexicalPart.panelPrincipal;

public class Tabla {

    static panelPrincipal pP = new panelPrincipal();
    static String[] abc = {"a", "b"};

    public static String[] entrada;
    public static int[] linea;

    public static <T> T[] copyArray(T[] sourceArray) {
        if (sourceArray == null) {
            return null; // Devuelve null si el arreglo de origen es nulo
        }

        // Utiliza el operador clone para copiar el arreglo
        return sourceArray.clone();
    }

    public static JPanel createTablePanel() {
        System.out.println("tABLA");
        String[] prueba = pP.getLexemas();
        int[] pruebaLinea = pP.getLineas();
        System.out.println("desdeTABLA" + prueba.length + "Linea" + pruebaLinea.length);
        List<String> words = new ArrayList<>(Arrays.asList("Valor 1", "Valor 2", "Valor 3", "Valor 4"));
        List<Integer> lineMarkers = new ArrayList<>(Arrays.asList(0, 0, 0, 0)); // Marca la línea de cada palabra
        entrada = copyArray(abc);
        //String[] abc = {"a","b"};
        addArrayToList(words, pP.getLexemas());
        addIntArrayToList(lineMarkers, pP.getLineas());

        JFrame frame = new JFrame("Tabla en Java Swing con Filas Personalizadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyTableModel model = new MyTableModel(words, lineMarkers);
        JTable table = new JTable(model);

        // Agrega un oyente de clic en las celdas
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    // Muestra un JOptionPane al hacer clic en la celda
                    //int posicionGlobal = ;
                    int line = row;
                    JOptionPane.showMessageDialog(null, "Celda seleccionada: " + table.getValueAt(row, column) + " \n "
                            + "Linea: " + line + "\n Columna: " + (column + 1));
                }
            }
        });

        // Crea un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setSize(1080, 720);
        panel.setLocation(0, 35);
        panel.setVisible(true);

        //frame.getContentPane().add(panel);
        //frame.pack();
        //frame.setVisible(true);
        return panel;
    }

    static class MyTableModel extends AbstractTableModel {

        private List<List<String>> rows = new ArrayList<>();

        MyTableModel(List<String> words, List<Integer> lineMarkers) {
            // Inicializa las filas basadas en lineMarkers
            int maxLine = lineMarkers.stream().mapToInt(Integer::intValue).max().orElse(0);
            for (int i = 0; i <= maxLine; i++) {
                rows.add(new ArrayList<>());
            }

            // Llena las filas con las palabras correspondientes
            for (int i = 0; i < words.size(); i++) {
                int line = lineMarkers.get(i);
                rows.get(line).add(words.get(i));
            }
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return rows.stream().mapToInt(List::size).max().orElse(0);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (rowIndex >= 0 && rowIndex < rows.size()) {
                if (columnIndex >= 0 && columnIndex < rows.get(rowIndex).size()) {
                    return rows.get(rowIndex).get(columnIndex);
                }
            }
            return null;
        }
    }

    public static void addArrayToList(List<String> entrada, String[] array) {
        if (array != null && array.length > 0) {
            List<String> newRow = Arrays.asList(array);
            entrada.addAll(newRow);
            //posicionGlobal += array.length;
        }
    }

    public static void addIntArrayToList(List<Integer> entrada, int[] array) {
        if (array != null && array.length > 0) {
            for (int num : array) {
                entrada.add(num);
            }
        }
    }

}

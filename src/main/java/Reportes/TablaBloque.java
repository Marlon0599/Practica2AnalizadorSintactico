package Reportes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TablaBloque {

    private String[] entrada;
    private static List<List<Object>> data2 = new ArrayList<>();

    public static JPanel agregarBloque() {

        TablaBloque tB = new TablaBloque();
        //data.add(Arrays.asList("Valor 1", "Valor 2", "Valor 3"));
        String[] entrada1 = {"A", "B", "C", "D", "E,F"};

        tB.addArrayToList(tB.getData(), entrada1);

        //addArrayToList(data, tB.getEntrada());
        MyTableModel model = new MyTableModel(data2);
        JTable table = new JTable(model);
        // Agrega un oyente de clic en las celdas
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    // Muestra un JOptionPane al hacer clic en la celda
                    JOptionPane.showMessageDialog(null, "Celda seleccionada: " + table.getValueAt(row, column));
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

        return panel;
    }

    static class MyTableModel extends AbstractTableModel {

        private List<List<Object>> data;

        MyTableModel(List<List<Object>> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            // Encuentra el número máximo de columnas en las filas
            return data.stream().mapToInt(List::size).max().orElse(0);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Asegúrate de no exceder los límites de las listas
            if (rowIndex >= 0 && rowIndex < data.size()) {
                List<Object> rowData = data.get(rowIndex);
                if (columnIndex >= 0 && columnIndex < rowData.size()) {
                    return rowData.get(columnIndex);
                }
            }
            return null;
        }
        TablaBloque tB = new TablaBloque();
    }

    public static void addArrayToList(List<List<Object>> data, String[] array) {
        if (array != null && array.length > 0) {
            List<Object> newRow = Arrays.asList(array);
            data.add(newRow);
        }
    }

    public String[] getEntrada() {
        return entrada;
    }

    public void setEntrada(String[] entrada) {
        this.entrada = entrada;
    }

    public static List<List<Object>> getData() {
        return data2;
    }

    public static void setData(List<List<Object>> data) {
        TablaBloque.data2 = data;
    }

}

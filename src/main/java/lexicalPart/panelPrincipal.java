package lexicalPart;

import lexicalPart.Tokens;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import syntacticPart.Errores;
import syntacticPart.Validar;
import syntacticPart.ValidarConTipo;

public class panelPrincipal extends JPanel {

    ArrayList<Tokens> listaTokens = new ArrayList<>();
    ArrayList<String> listaLexemas = new ArrayList<>();
    ArrayList<Integer> listaLineas = new ArrayList<>();
    InsertColored a = new InsertColored();
    private static String[] lexemas;
    private static int[] lineas;

    JTextPane txtEntrada = new JTextPane();
    private JTextPane espacioPanel = new JTextPane();
    private JTextArea lineaNumeros;
    private JScrollPane scroll = new JScrollPane(lineaNumeros, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private int totalLines;

    public panelPrincipal() {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.add(scroll);
        //setPreferredSize(new Dimension(1080,720));    
        //this.setBounds(0, 0, 1080, 720);
        this.setSize(1080, 720);
        this.setLocation(0, 35);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //JTextPane espacioPanel = new JTextPane();
        JButton btnAnalizar = new JButton();
        JButton btnLimpiar = new JButton();
        JButton btnCargar = new JButton();

        Color grisRGBA = new Color(128, 128, 128, 255);
        espacioPanel.setBackground(Color.darkGray);
        espacioPanel.setForeground(Color.white);
        espacioPanel.setBounds(40, 400, 1000, 300);
        espacioPanel.setEditable(false);

        lineaNumeros = new JTextArea("1");
        lineaNumeros.setBackground(grisRGBA);
        lineaNumeros.setEditable(false);
        lineaNumeros.setFocusable(false);
        lineaNumeros.setFont(new Font("Arial", Font.PLAIN, 12));

        scroll.setBounds(0, 0, 40, 350);
        scroll.setRowHeaderView(lineaNumeros);

        JScrollPane scrollPane = new JScrollPane(txtEntrada);
        scrollPane.setBounds(40, 0, 1000, 350);

        txtEntrada.setBackground(grisRGBA);
        txtEntrada.setForeground(Color.white);
        //txtEntrada.setBounds(40,0,1000,350);
        txtEntrada.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }

        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBounds(500, 360, 100, 25);
        btnLimpiar.setBackground(Color.green);
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEntrada.setText("");
            }
        });

        JFileChooser fileChooser = new JFileChooser();

        btnCargar.setText("Cargar");
        btnCargar.setBounds(700, 360, 100, 25);
        btnCargar.setBackground(Color.green);
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                        StringBuilder fileContent = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            fileContent.append(line).append("\n");
                        }
                        txtEntrada.setText(fileContent.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnAnalizar.setText("Analizar");
        btnAnalizar.setBounds(40, 360, 100, 25);
        btnAnalizar.setBackground(Color.green);
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = txtEntrada.getText();
                espacioPanel.setText(texto);

                /**
                 * ***********************
                 */
                File archivo = new File("archivo.txt");
                PrintWriter escribir;
                try {
                    escribir = new PrintWriter(archivo);
                    escribir.print(txtEntrada.getText());
                    escribir.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Reader lector = new BufferedReader(new FileReader("archivo.txt"));
                    Lexer lexer = new Lexer(lector);
                    String resultado = "";

                    while (true) {
                        Tokens tokens = lexer.yylex();
                        if (tokens == null) {
                            resultado += "FIN";
                            espacioPanel.setText(resultado);
                            break;
                        }
                        listaTokens.add(tokens);
                        switch (tokens) {
                            case ERROR:
                                resultado += "El simbolo no esta definido\n";
                                break;
                            case Identificador:
                            case NumeroEntero:
                            case NumeroDecimal:
                            case Reservadas:
                            case Aritmeticos:
                            case Comparacion:
                            case Logicos:
                            case Asignacion:
                            case PalabrasClave:
                            case Cadena:
                            case Booleanas:
                            case Comentario:
                            case Otros:
                            case Bits:
                                resultado += "Linea: " + lexer.posicion + lexer.lexeme + ": Es un  " + tokens + "\n";
                                listaLexemas.add(lexer.lexeme);
                                listaLineas.add(lexer.posicion);
                        }

                    }

                    String[] tiposArray = new String[listaTokens.size()];
                    for (int i = 0; i < listaTokens.size(); i++) {
                        tiposArray[i] = listaTokens.get(i).toString();
                    }

                    String[] lexmasArray = new String[listaLexemas.size()];
                    for (int i = 0; i < listaLexemas.size(); i++) {
                        lexmasArray[i] = listaLexemas.get(i).toString();
                    }

                    int[] lineasArray = new int[listaLineas.size()];
                    for (int i = 0; i < listaLineas.size(); i++) {
                        lineasArray[i] = listaLineas.get(i);
                        System.out.println("********LIneas " + lineasArray[i]);
                        System.out.println(resultado);
                    }

                    Validar lS = new Validar();
                    ValidarConTipo VcT = new ValidarConTipo();
                    lS.lectorSintactico(lexmasArray);
                    a.InsertColored(txtEntrada, lexmasArray, tiposArray, lineasArray);
                    VcT.ValidarMain(tiposArray);
                    lexemas = copyArray(lexmasArray);
                    lineas = copyIntArray(lineasArray);
                    Errores.EscribirErrores(espacioPanel, Validar.getListaDeErrores());

                    txtEntrada.setForeground(Color.WHITE);
                    listaLexemas.clear();
                    listaTokens.clear();
                    listaLineas.clear();
                    lS.limpiarListaDeErrores();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);

                    /**
                     * ***********************
                     */
                }

            }
        });

        //this.add(txtEntrada);
        this.add(scrollPane);
        this.add(espacioPanel);
        this.add(btnAnalizar);
        this.add(btnLimpiar);
        this.add(btnCargar);
        espacioPanel.setText("");

    }

    public static String[] getLexemas() {
        return lexemas;
    }

    public static void setLexemas(String[] lexemas) {
        panelPrincipal.lexemas = lexemas;
    }

    public static int[] getLineas() {
        return lineas;
    }

    public static void setLineas(int[] lineas) {
        panelPrincipal.lineas = lineas;
    }

    public static <T> T[] copyArray(T[] sourceArray) {
        if (sourceArray == null) {
            return null; // Devuelve null si el arreglo de origen es nulo
        }

        // Utiliza el operador clone para copiar el arreglo
        return sourceArray.clone();
    }

    public static int[] copyIntArray(int[] sourceArray) {
        if (sourceArray == null) {
            return null; // Devuelve null si el arreglo de origen es nulo
        }

        int[] copiedArray = new int[sourceArray.length];

        // Copia los elementos del arreglo de origen al nuevo arreglo
        for (int i = 0; i < sourceArray.length; i++) {
            copiedArray[i] = sourceArray[i];
        }

        return copiedArray;
    }

    public JTextPane getEspacioPanel() {
        return espacioPanel;
    }

    private void updateLineNumbers() {
        totalLines = txtEntrada.getDocument().getDefaultRootElement().getElementCount();
        StringBuilder lineNumbersText = new StringBuilder();
        for (int i = 1; i <= totalLines; i++) {
            lineNumbersText.append(i).append(".\n");
        }
        lineaNumeros.setText(lineNumbersText.toString());
    }

}

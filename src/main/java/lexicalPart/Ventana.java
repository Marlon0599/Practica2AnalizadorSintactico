package lexicalPart;

import Reportes.panelTablas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

    JButton btnAnalizar = new JButton();
    JButton btnTablas = new JButton();
    JButton btnParametros = new JButton();
    JButton btnAcercaDe = new JButton();
    JButton btnAyuda = new JButton();
    JButton btnExtra = new JButton();

    public Ventana() {

        this.setLayout(null);

        this.setTitle("Mi Ventana");
        this.setSize(1080, 790);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        configComponentes();

    }

    public void configComponentes() {
        panelPrincipal pPrincipal = new panelPrincipal();
        panelTablas pTabla = new panelTablas();
        this.add(pPrincipal);
        this.add(pTabla);

        btnAnalizar.setText("Analizador");
        btnAnalizar.setBounds(0, 0, 180, 30);
        btnAnalizar.setBackground(Color.darkGray);
        btnAnalizar.setForeground(Color.white);
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pPrincipal.setVisible(true);
                pTabla.setVisible(false);

            }
        });

        btnTablas.setText("Tablas");
        btnTablas.setBounds(180, 0, 180, 30);
        btnTablas.setBackground(Color.darkGray);
        btnTablas.setForeground(Color.white);
        btnTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pPrincipal.setVisible(false);
                pTabla.setVisible(true);

            }
        });

        btnParametros.setText("Parametros");
        btnParametros.setBounds(360, 0, 180, 30);
        btnParametros.setBackground(Color.darkGray);
        btnParametros.setForeground(Color.white);

        btnAcercaDe.setText("Acerca De");
        btnAcercaDe.setBounds(540, 0, 180, 30);
        btnAcercaDe.setBackground(Color.darkGray);
        btnAcercaDe.setForeground(Color.white);
        btnAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Practica 2 Lenguajes Formales y de Programacion \n"
                        + "Marlon Antonio Ramos Sacalxot 201931077", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnAyuda.setText("Ayuda");
        btnAyuda.setBounds(720, 0, 180, 30);
        btnAyuda.setBackground(Color.darkGray);
        btnAyuda.setForeground(Color.white);
        btnAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Para mas ayuda puede \n"
                        + "buscar informacion en el manual \n"
                        + "de usuario que se encuentra dentro \n"
                        + "de la documentacion", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnExtra.setText("Cargar Archiv");
        btnExtra.setBounds(900, 0, 180, 30);
        btnExtra.setBackground(Color.darkGray);
        btnExtra.setForeground(Color.white);

        this.getContentPane().add(btnAnalizar);
        this.getContentPane().add(btnTablas);
        this.getContentPane().add(btnParametros);
        this.getContentPane().add(btnAcercaDe);
        this.getContentPane().add(btnAyuda);
        this.getContentPane().add(btnExtra);
    }
}

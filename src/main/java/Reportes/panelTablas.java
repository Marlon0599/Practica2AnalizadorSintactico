/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author marlon
 */
public class panelTablas extends JPanel {

    public panelTablas() {
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        this.setSize(1080, 720);
        this.setLocation(0, 35);
        configComponentes();
    }

    private void configComponentes() {
        JButton btnTablaGlobal = new JButton();
        JButton btnTablaBloque = new JButton();
        final JPanel panelCambiante = new JPanel();
        panelCambiante.setLayout(null);
        panelCambiante.setBackground(Color.yellow);
        panelCambiante.setSize(1080, 720);
        panelCambiante.setLocation(0, 35);

        //JPanel pTabla = Reportes.Tabla.createTablePanel();
        //this.add(pTabla);
        btnTablaGlobal.setText("Tabla Global");
        btnTablaGlobal.setBounds(0, 0, 250, 30);
        btnTablaGlobal.setBackground(Color.darkGray);
        btnTablaGlobal.setForeground(Color.white);
        btnTablaGlobal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelGrafico.setVisible(false);
                //panelCambiante = panelPrincipal;
                //panelCambiante.repaint();
                JPanel pTabla = Reportes.Tabla.createTablePanel();
                //this.add(pTabla);
                //pTabla.repaint();

                panelCambiante.removeAll(); // Quita todos los componentes del JPanel
                panelCambiante.revalidate(); // Revalida el panel para que se ajuste a su nuevo contenido
                panelCambiante.repaint();
                panelCambiante.add(pTabla);

            }
        });

        btnTablaBloque.setText("Tabla Bloque");
        btnTablaBloque.setBounds(250, 0, 250, 30);
        btnTablaBloque.setBackground(Color.darkGray);
        btnTablaBloque.setForeground(Color.white);
        btnTablaBloque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelGrafico.setVisible(false);
                //panelCambiante = panelPrincipal;
                //panelCambiante.repaint();
                JPanel pTablaBloque = Reportes.TablaBloque.agregarBloque();
                //this.add(pTabla);
                //pTabla.repaint();
                panelCambiante.removeAll(); // Quita todos los componentes del JPanel
                panelCambiante.revalidate(); // Revalida el panel para que se ajuste a su nuevo contenido
                panelCambiante.repaint();
                panelCambiante.add(pTablaBloque);

            }
        });

        this.add(btnTablaGlobal);
        this.add(btnTablaBloque);
        this.add(panelCambiante);

    }

}

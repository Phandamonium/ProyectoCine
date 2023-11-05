/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author mlarr
 */
public class Principal extends JFrame{
    
    JPanel bienvenida;
    JMenuBar barraHerramientas;
    AgregarPelicula agregarPelicula;
    
    public Principal () throws SQLException{
        iniciarComponentes();
        this.add(agregarPelicula);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.barraHerramientas.setBackground(Color.GRAY);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setJMenuBar(barraHerramientas); 
        this.getContentPane().add(agregarPelicula);
        
        iniciarMenu();
        iniciarPanelBienvenida();
    }
    
    public void iniciarComponentes() throws SQLException{
        barraHerramientas = new JMenuBar();
        agregarPelicula = new AgregarPelicula();
        bienvenida = new JPanel();
    }
    
    private void iniciarMenu(){
        JMenu opciones;
        JMenu ayuda;
        JMenuItem agregar, eliminar, modificar, listar, acercaDe;
        //items menu opciones
        agregar = new JMenuItem("Agregar película");
        eliminar = new JMenuItem("Eliminar película");
        modificar = new JMenuItem("Modificar película");
        listar = new JMenuItem("Lista películas");
        
        //Items menu ayuda
        acercaDe = new JMenuItem("Acerca de");
        
        //Creación menus
        ayuda = new JMenu("Ayuda");
        opciones = new JMenu("Opciones");
        
        opciones.add(agregar);
        opciones.add(eliminar);
        opciones.add(modificar);
        opciones.add(listar);
        
        ayuda.add(acercaDe);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarActionPerformed(e);
            }
        });
        
        this.barraHerramientas.add(opciones);
        this.barraHerramientas.add(ayuda);
    }
    
    private void iniciarPanelBienvenida(){
        
        JLabel bienvenidos = new JLabel("Bienvenidos al cine");
        this.bienvenida.setLayout(null);
        bienvenidos.setFont(new Font("calibri", Font.CENTER_BASELINE, 50));
        bienvenidos.setBounds(190,210, 500,100);
        this.bienvenida.add(bienvenidos);
        this.getContentPane().add(bienvenida);
    }
    
    private void agregarActionPerformed(ActionEvent e){
        this.agregarPelicula.setVisible(true);
    }
}

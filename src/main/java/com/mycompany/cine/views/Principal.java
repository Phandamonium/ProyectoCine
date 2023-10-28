/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    AgregarPelicula ventanaAgregar;
    
    public Principal (){
        iniciarComponentes();
        this.add(ventanaAgregar);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.barraHerramientas.setBackground(Color.GRAY);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setJMenuBar(barraHerramientas); 
        this.getContentPane().add(ventanaAgregar);
        
        iniciarMenu();
        iniciarPanelBienvenida();
    }
    
    public void iniciarComponentes(){
        barraHerramientas = new JMenuBar();
        ventanaAgregar= new AgregarPelicula();
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
                System.out.println("Agregar");
                ventanaAgregar.setVisible(true);
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
    
}

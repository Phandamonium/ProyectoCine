/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.views;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mlarr
 */
public class AgregarPelicula extends JPanel{
    
    JLabel id, titulo, director, anno, duracion;
    
    public AgregarPelicula(){
        this.setSize(800, 600);
        this.setBackground(Color.red);
        this.setVisible(false);
    }
}

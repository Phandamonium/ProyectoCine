/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.views;

import com.mycompany.cine.controller.ConectorDB;
import com.mycompany.cine.controller.PeliculaController;
import com.mycompany.cine.model.PeliculaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mlarr
 */
public class AgregarPelicula extends JPanel{
    
    //Componentes Del panel
    private JTextField JTextFieldID, JTextFieldTitulo, JTextFieldDirector, JTextFieldAnno, JTextFieldDuracion, JTextFieldGenero;
    private JButton JButtonLimpiar, JButtonAgregarPelicula;
    private JLabel JLabelNuevaPelicula, JLabelID, JLabelTitulo, JLabelDirector, JLabelAnno,JLabelDuracion, JLabelGenero;
    
    //Variables
    private final int posXinicial = 170, posYinicial = 130, TextFieldWidth = 70, TextFieldheight = 20, espaciosuma = 40;
    protected Connection conexionOCI;
    protected ConectorDB conector;
    
    public AgregarPelicula() throws SQLException {
        iniciarJLabels();
        iniciarJTextField();
        iniciarJButton();
        this.conector = new ConectorDB();
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(false);
    }
    
    //Iniciar componentes
    private void iniciarJTextField(){
        JTextFieldID = new JTextField();
        this.JTextFieldID.setBounds(posXinicial, posYinicial, TextFieldWidth, TextFieldheight);
        this.add(this.JTextFieldID);
        JTextFieldID.setEnabled(false);
        
        JTextFieldTitulo = new JTextField();
        this.JTextFieldTitulo.setBounds(posXinicial, posYinicial+espaciosuma, TextFieldWidth+430, TextFieldheight);
        this.add(this.JTextFieldTitulo);
        
        JTextFieldDirector = new JTextField();
        this.JTextFieldDirector.setBounds(posXinicial, posYinicial+espaciosuma*2, TextFieldWidth+430, TextFieldheight);
        this.add(this.JTextFieldDirector);
        
        JTextFieldGenero = new JTextField();
        this.JTextFieldGenero.setBounds(posXinicial, posYinicial+espaciosuma*3, TextFieldWidth+430, TextFieldheight);
        this.add(this.JTextFieldGenero);
        
        JTextFieldAnno = new JTextField();
        this.JTextFieldAnno.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                JTextFieldAnnoKeyTyped(e);
            }
        });
        
        this.JTextFieldAnno.setBounds(posXinicial, posYinicial+espaciosuma*4, TextFieldWidth, TextFieldheight);
        this.add(this.JTextFieldAnno);
        
        JTextFieldDuracion = new JTextField();
        this.JTextFieldDuracion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                JTextFieldDuracionKeyTyped(e);
            }
        });
        this.JTextFieldDuracion.setBounds(posXinicial+167, posYinicial+espaciosuma*4, TextFieldWidth, TextFieldheight);
        this.add(this.JTextFieldDuracion);
                                                                                                                                                                                                                                                                                                                                          
    }
    
    private void iniciarJButton(){
        JButtonLimpiar = new JButton("Limpiar");
        this.JButtonLimpiar.setBounds( 500, 450,  80,35);
        
        this.JButtonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButtonLimpiarActionPerformed(e);
            }
        });
        this.add(JButtonLimpiar);
        
        JButtonAgregarPelicula = new JButton("Añadir");
        this.JButtonAgregarPelicula.setBounds( 600, 450,  80,35);
        
        this.JButtonAgregarPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButtonAgregarPeliculaActionPerformed(e);
            }
        });
        this.add(JButtonAgregarPelicula);
    }
    
    private void iniciarJLabels(){
        JLabelID = new JLabel("ID:");
        JLabelID.setBounds(posXinicial-20,posYinicial, 70,22);
        JLabelID.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelID);
        
        JLabelTitulo = new JLabel("Titulo:");
        JLabelTitulo.setBounds(posXinicial-45,posYinicial+espaciosuma, 70,22);
        JLabelTitulo.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelTitulo);
        
        JLabelDirector = new JLabel("Director:");
        JLabelDirector.setBounds(posXinicial-62,posYinicial+espaciosuma*2, 70,22);
        JLabelDirector.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelDirector);
        
        JLabelGenero = new JLabel("Género:");
        JLabelGenero.setBounds(posXinicial-56,posYinicial+espaciosuma*3, 70,22);
        JLabelGenero.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelGenero);
        
        JLabelAnno = new JLabel("Año:");
        JLabelAnno.setBounds(posXinicial-34,posYinicial+espaciosuma*4, 70,22);
        JLabelAnno.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelAnno);
        
        JLabelDuracion = new JLabel("Duración:");
        JLabelDuracion.setBounds(posXinicial+100,posYinicial+espaciosuma*4, 70,22);
        JLabelDuracion.setFont(new Font("Segoe UI",Font.BOLD,14));
        this.add(JLabelDuracion);
        
        JLabelNuevaPelicula = new JLabel("Nueva Película");
        JLabelNuevaPelicula.setBounds(posXinicial+120, posYinicial-70, 600, 25);
        JLabelNuevaPelicula.setFont(new Font("Segoe UI",Font.BOLD,30));
        this.add(JLabelNuevaPelicula);
    }
    //Control de eventos
    private void JButtonLimpiarActionPerformed(ActionEvent e){
        this.JTextFieldTitulo.setText("");
        this.JTextFieldDirector.setText("");
        this.JTextFieldAnno.setText("");
        this.JTextFieldDuracion.setText("");
        this.JTextFieldGenero.setText("");
    }
    
    private void JButtonAgregarPeliculaActionPerformed(ActionEvent e){
        PeliculaDAO peliculaNueva = new PeliculaDAO();
        
        
        peliculaNueva.setTitulo(this.JTextFieldTitulo.getText());
        peliculaNueva.setDirector(this.JTextFieldDirector.getText());
        peliculaNueva.setAnno(Integer.valueOf(this.JTextFieldAnno.getText()));
        peliculaNueva.setDuracion(Integer.valueOf(this.JTextFieldDuracion.getText()));
        peliculaNueva.setGenero(this.JTextFieldGenero.getText());
        
        PeliculaController controller = new PeliculaController();
        try{
            controller.agregarPeliculaController(peliculaNueva, this.conector.getConn());
        }catch(SQLException ex){
            Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    private void JTextFieldAnnoKeyTyped(KeyEvent e){
        System.out.println("Typed");
        int key = e.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        
        if(!numeros){
            e.consume();
        }
    }
    
    private void JTextFieldDuracionKeyTyped(KeyEvent e){
        System.out.println("Typed");
        int key = e.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        
        if(!numeros){
            e.consume();
        }
    }
    
 
}

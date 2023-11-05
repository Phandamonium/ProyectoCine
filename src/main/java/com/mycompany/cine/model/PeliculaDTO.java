package com.mycompany.cine.model;


import com.mycompany.cine.model.PeliculaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mlarr
 */

//Declaracion de query y preparación de statement
public class PeliculaDTO {
    
    public boolean agregarPelicula(PeliculaDAO peliculaNueva, Connection conexion) throws SQLException{
       
        String queryStatement = "INSERT INTO MOVIE(TITULO, DIRECTOR, ANNO, DURACION, GENERO) VALUES(?,?,?,?,?)";

        System.out.println("\nQuery is "+ queryStatement);
        
        PreparedStatement ps = conexion.prepareStatement(queryStatement);
        
        ps.setString(1, peliculaNueva.getTitulo());
        ps.setString(2, peliculaNueva.getDirector());
        ps.setInt(3, peliculaNueva.getAnno());
        ps.setInt(4, peliculaNueva.getDuracion());
        ps.setString(5, peliculaNueva.getGenero());
        
        int resultado = ps.executeUpdate();
        
        
        System.out.println("Cantidad insertados: " + resultado);
        return true;
    }
}
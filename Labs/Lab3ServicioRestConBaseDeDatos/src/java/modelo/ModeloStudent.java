/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import student.Student;

/**
 *
 * @author Mike
 */
public class ModeloStudent {
    
    public void insertStudent(Student s){
        

        try{
            Conexion conex = new Conexion();
            
            String query = "insert into student (idCourse, name, deposit)" + " values (?, ?, ?)";          
            PreparedStatement cs = conex.getConexion().prepareStatement(query);
            cs.setInt(1, s.getIdCourse());
            cs.setString(2, s.getName());
            cs.setDouble(3, s.getDeposit());
            cs.executeUpdate();           
            conex.desconectar();
            cs.close();
        }catch(SQLException e){
            System.out.println(e.getStackTrace());
        
        }

    }
    
}

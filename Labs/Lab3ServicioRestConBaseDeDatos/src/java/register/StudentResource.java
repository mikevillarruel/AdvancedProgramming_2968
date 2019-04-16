/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.ModeloStudent;
import student.Student;

/**
 * REST Web Service
 *
 * @author Mike
 */
@Path("student")
public class StudentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    /**
     * Retrieves representation of an instance of register.StudentResource
     * @return an instance of student.Student
     */
    @GET
    @Path("{idCourse}/{name}/{deposit}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getJson(@PathParam("idCourse") int idCourse,@PathParam("name") String name, @PathParam("deposit") double deposit ) {
        ModeloStudent modelo = new ModeloStudent();
        Student s = new Student(idCourse,name,deposit);
        modelo.insertStudent(s);
        return s;
    } 
    
    /**
     * PUT method for updating or creating an instance of StudentResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Student content) {
    }
}

package test;

import java.sql.*;

import datos.Conexion;

//import java.util.*;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		
			Connection conexion = null;
		
		try {
			conexion = Conexion.getConnection();
			if (conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}
			PersonaDAO personaDao = new PersonaDAO(conexion);
			Persona cambioPersona = new Persona();
			cambioPersona.setIdPersona(2);
			cambioPersona.setNombre("Perico");
			cambioPersona.setApellido("Palotes");
			cambioPersona.setEmail("chicho@chuchu");
			cambioPersona.setTelefono("5478395734");
			
			personaDao.actualizar(cambioPersona);
			
			Persona newPersona = new Persona();
			newPersona.setNombre("Pepe");
			newPersona.setApellido("Padilla");
			personaDao.insertar(newPersona); 
			
			conexion.commit();
			System.out.println("Se ha hecho commit");
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("Entramos al rollback");
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

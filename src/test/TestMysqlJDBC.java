package test;

import java.sql.*;

public class TestMysqlJDBC {

	public static void main(String[] args) {
		//String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root", "Cacawetes69");
			Statement instruccion = conexion.createStatement();
			var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
			ResultSet resultado = instruccion.executeQuery(sql);
			
			while (resultado.next()) {
				System.out.print("Id Persona:" + resultado.getString("id_persona"));
				System.out.print(" Nombre:" + resultado.getString("nombre"));
				System.out.print(" apellido:" + resultado.getString("apellido"));
				System.out.print(" email:" + resultado.getString("email"));
				System.out.println("");

			}
			resultado.close();
			instruccion.close();
			conexion.close();
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

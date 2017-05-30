package ar.edu.ub.proyectoalgoritmogenetico.modelo;

import java.sql.*;

public class ManejadorDB {

	public void borrarCromosomasBD() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Tomas\\Documents\\UB\\2do año\\Programacion 3\\Algoritmo genetico\\BDAG.accdb");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE * FROM CROMOSOMAS");
		conn.close();
		stmt.close();
	}

	public void insertarCromosomasBD(Poblacion poblacion) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Tomas\\Documents\\UB\\2do año\\Programacion 3\\Algoritmo genetico\\BDAG.accdb");
		Statement stmt = conn.createStatement();
		for (Cromosoma cromosoma : poblacion.getPoblacion()) {
			stmt.executeUpdate("INSERT INTO CROMOSOMAS (representacionBinaria,representacionHexadecimal) VALUES ('" + cromosoma.getBinarioString() + "','" + cromosoma.getHexadecimalString() + "')");
			conn.commit();
		}	
		conn.close();
		stmt.close();
	}
}

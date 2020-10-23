package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	
	private Connection db;
	private static final String DB_HOST = "jdbc:mysql://localhost/glin";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "";
	
	public ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.db = DriverManager.getConnection(DB_HOST,DB_USER_NAME,DB_PASSWORD);
			System.out.println("Connection réussie...");
		} catch(ClassNotFoundException e) {
			System.out.println("Erreur du Driver: "+e);
		}catch(SQLException e) {
			System.out.println("Erreur Base de donnée: "+e);
		}
	}
	
	public ResultSet query(String req) {
		try {
			Statement st = this.db.createStatement();
			return st.executeQuery(req);
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
			return null;
		}
	}
	
	public boolean execute(String req) {
		try {
			Statement st = this.db.createStatement();
			st.executeUpdate(req);
			return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL: "+e);
			return false;
		}
	}
}

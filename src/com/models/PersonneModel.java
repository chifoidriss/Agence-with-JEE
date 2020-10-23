package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.beans.ConnectDB;
import com.beans.Personne;

public class PersonneModel {
	private ConnectDB db;
	
	public PersonneModel() {
		this.db = new ConnectDB();
	}
	
	public Personne getById(int id) {
		String req = "SELECT * FROM personne WHERE id="+id;
		ResultSet rs = this.db.query(req);
		Personne p = null;
		
		try {
			while(rs.next()) {
				p = new Personne(rs.getInt("id"),
								 rs.getString("nom"),
								 rs.getString("prenom"),
								 rs.getString("email"),
								 rs.getInt("telephone"));
			}
		} catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return p;
	}
	
	public boolean addPersonne(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		
		String req = "INSERT INTO personne(nom,prenom,email,telephone,password) "
				+ "VALUES('"+nom+"','"+prenom+"','"+email+"','"+telephone+"','"+password+"')";
		return this.db.execute(req);
	}
	
	public Personne connecter(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Personne p = null;
		
		String req = "SELECT * FROM personne "
				+ "WHERE (email='"+email+"' OR telephone='"+email+"')"
				+ "AND password='"+password+"'";
		ResultSet rs = this.db.query(req);
		try {
			while(rs.next()) {
				p = this.getById(rs.getInt("id"));
				request.getSession(true).setAttribute("personne",p);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		
		return p;
	}
}

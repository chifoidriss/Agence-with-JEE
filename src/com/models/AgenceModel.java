package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beans.ConnectDB;
import com.beans.Agence;

public class AgenceModel {
	private ConnectDB db;

	public AgenceModel() {
		this.db = new ConnectDB();
	}
	
	public ArrayList<Agence> getAgences() {
		String req = "SELECT * FROM agence";
		ResultSet rs = this.db.query(req);
		ArrayList<Agence> ag = new ArrayList<Agence>();
		
		try {
			while(rs.next()) {
				Agence a = new Agence(rs.getInt("id"),
									  rs.getString("nom"),
									  rs.getString("adresse"));
				ag.add(a);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return ag;
	}
	
	public boolean addAgence(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		
		String req = "INSERT INTO agence(nom,adresse)"
				+ "VALUES('"+nom+"','"+adresse+"')";
		return this.db.execute(req);
	}
	
	public Agence getById(int id) {
		String req = "SELECT * FROM agence WHERE id="+id;
		ResultSet rs = this.db.query(req);
		Agence a = null;
		
		try {
			while(rs.next()) {
				a = new Agence(rs.getInt("id"),
								rs.getString("nom"),
								rs.getString("adresse"));
			}
		} catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return a;
	}
	
	public boolean delById(int id) {
		String req = "DELETE FROM agence WHERE id="+id;
		return this.db.execute(req);
	}

}

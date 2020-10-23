package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beans.ConnectDB;
import com.beans.Voiture;

public class VoitureModel {
	private ConnectDB db;

	public VoitureModel() {
		this.db = new ConnectDB();
	}
	
	public ArrayList<Voiture> getVoitures() {
		String req = "SELECT * FROM voiture";
		ResultSet rs = this.db.query(req);
		ArrayList<Voiture> vt = new ArrayList<Voiture>();
		
		try {
			while(rs.next()) {
				Voiture v = new Voiture(rs.getInt("id"),
									  rs.getString("immatriculation"),
									  rs.getInt("nbPlaces"),
									  rs.getString("categorie"));
				vt.add(v);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return vt;
	}

	public Voiture getById(int id) {
		String req = "SELECT * FROM voiture WHERE id="+id;
		ResultSet rs = this.db.query(req);
		Voiture vt = null;
		
		try {
			while(rs.next()) {
				vt = new Voiture(rs.getInt("id"),
								rs.getString("immatriculation"),
								rs.getInt("nbPlaces"),
								rs.getString("categorie"));
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return vt;
	}
	
	public boolean addVoiture(HttpServletRequest request) {
		String immatriculation = request.getParameter("immatriculation");
		String nbPlaces = request.getParameter("nbPlaces");
		String categorie = request.getParameter("categorie");
		
		String req = "INSERT INTO voiture(immatriculation,nbPlaces,categorie)"
				+ "VALUES('"+immatriculation+"','"+nbPlaces+"','"+categorie+"')";
		return this.db.execute(req);
	}
}

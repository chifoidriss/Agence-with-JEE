package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beans.Agence;
import com.beans.ConnectDB;
import com.beans.Voiture;
import com.beans.Voyage;

public class VoyageModel {
	private ConnectDB db;
	
	public VoyageModel() {
		this.db = new ConnectDB();
	}
	
	public ArrayList<Voyage> getVoyages() {
		String req = "SELECT * FROM voyage";
		ResultSet rs = this.db.query(req);
		ArrayList<Voyage> voy = new ArrayList<Voyage>();
		AgenceModel am = new AgenceModel();
		VoitureModel vm = new VoitureModel();
		
		try {
			while(rs.next()) {
				Agence dep = am.getById(rs.getInt("depart"));
				Agence arr = am.getById(rs.getInt("arrivee"));
				Voiture vo = vm.getById(rs.getInt("idVoit"));
				Voyage v = new Voyage(rs.getInt("id"),
									  dep,arr,vo,
									  rs.getDate("dateDepart"),
									  rs.getDate("dateArrivee"),
									  rs.getInt("prix"),
									  rs.getString("type"));
				voy.add(v);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return voy;
	}
	
	public boolean addVoyage(HttpServletRequest request) {
		String depart = request.getParameter("depart");
		String arrivee = request.getParameter("arrivee");
		String idVoit = request.getParameter("idVoit");
		String dateDepart = request.getParameter("dateDepart");
		String dateArrivee = request.getParameter("dateArrivee");
		String prix = request.getParameter("prix");
		String type = request.getParameter("type");
		
		String req = "INSERT INTO voyage(depart,arrivee,idVoit,dateDepart,dateArrivee,prix,type)"
				+ "VALUES('"+depart+"','"+arrivee+"','"+idVoit+"','"+dateDepart+"','"+dateArrivee+"','"+prix+"','"+type+"')";
		return this.db.execute(req);
	}

	public Voyage getById(int id) {
		String req = "SELECT * FROM voyage WHERE id="+id;
		ResultSet rs = this.db.query(req);
		AgenceModel am = new AgenceModel();
		VoitureModel vm = new VoitureModel();
		Voyage v = null;
		try {
			while(rs.next()) {
				Agence dep = am.getById(rs.getInt("depart"));
				Agence arr = am.getById(rs.getInt("arrivee"));
				Voiture voit = vm.getById(rs.getInt("idVoit"));
				v = new Voyage(rs.getInt("id"),
									  dep,arr,voit,
									  rs.getDate("dateDepart"),
									  rs.getDate("dateArrivee"),
									  rs.getInt("prix"),
									  rs.getString("type"));
			}
		} catch(SQLException e) {
			System.out.println("Erreur SQL: "+e);
		}
		return v;
	}

}

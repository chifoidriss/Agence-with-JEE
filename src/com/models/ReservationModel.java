package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beans.ConnectDB;
import com.beans.Personne;
import com.beans.Reservation;
import com.beans.Voyage;

public class ReservationModel {
	
	private ConnectDB db;
	
	public ReservationModel() {
		db = new ConnectDB();
	}
	
	public ArrayList<Reservation> getReservations(){
		String req = "SELECT * FROM reservation";
		ResultSet rs = this.db.query(req);
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		
		PersonneModel cm = new PersonneModel();
		VoyageModel vm = new VoyageModel();
		
		try {
			while(rs.next()) {
				Personne c = cm.getById(rs.getInt("idCli"));
				Voyage v = vm.getById(rs.getInt("idVoy"));
				Reservation r = new Reservation(rs.getInt("id"),c,v,rs.getDate("dateReserve"));
				res.add(r);
				
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL :"+ e);
		}
		
		return res;
		
	}
	
	public ArrayList<Reservation> getReservations(int idVoy){
		String req = "SELECT * FROM reservation WHERE idVoy="+idVoy;
		ResultSet rs = this.db.query(req);
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		
		PersonneModel pm = new PersonneModel();
		VoyageModel vm = new VoyageModel();
		
		try {
			while(rs.next()) {
				Personne p = pm.getById(rs.getInt("idCli"));
				Voyage v = vm.getById(rs.getInt("idVoy"));
				Reservation r = new Reservation(rs.getInt("id"),p,v,rs.getDate("dateReserve"));
				res.add(r);
				
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL :"+ e);
		}
		
		return res;
		
	}
	
	public boolean addReserve(HttpServletRequest request) {
		String id_cli = request.getParameter("idCli");
		String id_voy = request.getParameter("idVoy");
		
		String req = "INSERT INTO reservation(idCli,idVoy,dateReserve)" +
					"VALUES('"+id_cli+"','"+id_voy+"',NOW())";
		return this.db.execute(req);
	}
	
	public Reservation getById(int id) {
		String req= "SELECT * FROM reservation WHERE id="+id;
		ResultSet rs = this.db.query(req);
		Reservation res = null;
		PersonneModel cm = new PersonneModel();
		VoyageModel vm = new VoyageModel();
		
		try {
			while(rs.next()) {
				Personne c = cm.getById(rs.getInt("idCli"));
				Voyage v = vm.getById(rs.getInt("idVoy"));
				res = new Reservation (rs.getInt("id"),c,v,rs.getDate("dateReserve"));
						
			}
		}catch(SQLException e) {
			System.out.println("erreur SQL :"+e);
		}
		return res;
	}

}

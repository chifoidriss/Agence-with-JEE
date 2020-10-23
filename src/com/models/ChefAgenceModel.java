package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beans.Agence;
import com.beans.ChefAgence;
import com.beans.ConnectDB;

public class ChefAgenceModel {
	
	private ConnectDB db;
	
	public ChefAgenceModel() {
		
		db = new ConnectDB();
	}
	
	public ArrayList<ChefAgence> getchefs(){
		String req = "SELECT * FROM chefagence";
		ResultSet rs = this.db.query(req);
		ArrayList<ChefAgence> chefs = new ArrayList<ChefAgence>();
		
		AgenceModel am= new AgenceModel();
		
		try {
			while(rs.next()) {
				Agence ag = am.getById(rs.getInt("idAg"));
				ChefAgence c = new ChefAgence(rs.getInt("id"),ag,
													rs.getString("nom"),
													rs.getString("prenom"),
													rs.getString("email"),
													rs.getInt("telephone"),
													rs.getString("password"));
				chefs.add(c);
				
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL :"+ e);
		}
		
		return chefs;
		
	}
	
	public boolean addChef(HttpServletRequest request) {
		String idAg = request.getParameter("idAg");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		
		String req = "INSERT INTO chefagence(idAg,nom,prenom,email,telephone,password)" +
					"VALUES('"+idAg+"','"+nom+"','"+prenom+"','"+email+"','"+telephone+"','"+password+"')";
		return this.db.execute(req);
	}
	
	public ChefAgence connecter(HttpServletRequest request) {
		String email_phone = request.getParameter("email");
		String password = request.getParameter("password");
		ChefAgence p=null;
		
		String re= "SELECT * FROM chefagence "
				+ " WHERE (email='"+email_phone+"' OR telephone= '"+email_phone+"')"
				+ " AND password='"+password+"'";
		ResultSet rs = this.db.query(re);
		try {
			while(rs.next()) {
				p = this.getById(rs.getInt("id"));
				System.out.println(p);
				request.getSession(true).setAttribute("chef",p);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQL :"+ e);
		}
		return p;
	};
	
	public ChefAgence getById(int id) {
		String req= "SELECT * FROM chefagence WHERE id="+id;
		ResultSet rs = this.db.query(req);
		ChefAgence c = null;
		AgenceModel am= new AgenceModel();
		
		try {
			while(rs.next()) {
				Agence ag = am.getById(rs.getInt("idAg"));
				c = new ChefAgence (	rs.getInt("id"),ag,
										rs.getString("nom"),
										rs.getString("prenom"),
										rs.getString("email"),
										rs.getInt("telephone"),
										rs.getString("password"));				
			}
		}catch(SQLException e) {
			System.out.println("erreur SQL :"+e);
		}
		return c;
	}
	

}

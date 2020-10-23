package com.beans;

import java.sql.Date;

public class Voyage{
	private int id;
	private Agence depart;
	private Agence arrivee;
	private Voiture v;
	private Date dateDepart;
	private Date dateArrivee;
	private int prix;
	private String type;
	
	public Voyage(int id, Agence depart, Agence arrivee, Voiture v, Date dateDepart, Date dateArrivee, int prix,
			String type) {
		super();
		this.id = id;
		this.depart = depart;
		this.arrivee = arrivee;
		this.v = v;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.prix = prix;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Agence getDepart() {
		return depart;
	}

	public void setDepart(Agence depart) {
		this.depart = depart;
	}

	public Agence getArrivee() {
		return arrivee;
	}

	public void setArrivee(Agence arrivee) {
		this.arrivee = arrivee;
	}

	public Voiture getV() {
		return v;
	}

	public void setV(Voiture v) {
		this.v = v;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
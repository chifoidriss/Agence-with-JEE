package com.beans;

public class Voiture {
	private int id;
	private String immatriculation;
	private int nbPlaces;
	private String categorie;
		
	public Voiture(int id, String immatriculation, int nbPlaces, String categorie) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.nbPlaces = nbPlaces;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}

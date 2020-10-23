package com.beans;

public class ChefAgence  {
	private int id_chef;
	private Agence Ag;
	private String nom;
	private String prenom;
	private String email;
	private int tel;
	private String password;
	
	public ChefAgence(int id_chef, Agence ag, String nom, String prenom, String email, int tel, String password) {

		this.id_chef = id_chef;
		Ag = ag;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.password = password;
	}

	public int getId_chef() {
		return id_chef;
	}

	public void setId_chef(int id_chef) {
		this.id_chef = id_chef;
	}

	public Agence getAg() {
		return Ag;
	}

	public void setAg(Agence ag) {
		Ag = ag;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	


	}

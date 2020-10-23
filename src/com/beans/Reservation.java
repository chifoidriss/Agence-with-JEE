package com.beans;

import java.sql.Date;

public class Reservation {
	private int id;
	private Personne idCli;
	private Voyage idVoy;
	private Date dateReserve;
	
	public Reservation(int id, Personne idCli, Voyage idVoy, Date dateReserve) {
		super();
		this.id = id;
		this.idCli = idCli;
		this.idVoy = idVoy;
		this.dateReserve = dateReserve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personne getIdCli() {
		return idCli;
	}

	public void setIdCli(Personne idCli) {
		this.idCli = idCli;
	}

	public Voyage getIdVoy() {
		return idVoy;
	}

	public void setIdVoy(Voyage idVoy) {
		this.idVoy = idVoy;
	}

	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
	}
	
}

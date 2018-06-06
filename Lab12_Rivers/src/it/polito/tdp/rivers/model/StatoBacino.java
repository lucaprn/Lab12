package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class StatoBacino {
	
	private LocalDate day;
	private double flussoEntrata;
	private double occupazioneBacino;
	private double flussoUscita;
	
	public StatoBacino(LocalDate data, double flussoEntrata, double occupazioneBacino, double flussoUscita) {
		super();
		this.day = data;
		this.flussoEntrata = flussoEntrata;
		this.occupazioneBacino = occupazioneBacino;
		this.flussoUscita = flussoUscita;
	}
	public double getFlussoEntrata() {
		return flussoEntrata;
	}
	public void setFlussoEntrata(double flussoEntrata) {
		this.flussoEntrata = flussoEntrata;
	}
	public double getOccupazioneBacino() {
		return occupazioneBacino;
	}
	public void setOccupazioneBacino(double occupazioneBacino) {
		this.occupazioneBacino = occupazioneBacino;
	}
	public double getFlussoUscita() {
		return flussoUscita;
	}
	public void setFlussoUscita(double flussoUscita) {
		this.flussoUscita = flussoUscita;
	}
	
	
	

}

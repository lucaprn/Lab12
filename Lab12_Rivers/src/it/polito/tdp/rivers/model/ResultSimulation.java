package it.polito.tdp.rivers.model;



public class ResultSimulation {
	private int numeroNoServizio;
	private int numeroStrabordi;
	private int normaleServizio;
	private double qMedia;
	public ResultSimulation(int numeroNoServizio, int numeroStrabordi, int normaleServizio, double qMedia) {
		super();
		this.numeroNoServizio = numeroNoServizio;
		this.numeroStrabordi = numeroStrabordi;
		this.normaleServizio = normaleServizio;
		this.qMedia = qMedia;
	}
	public int getNumeroNoServizio() {
		return numeroNoServizio;
	}
	public void setNumeroNoServizio(int numeroNoServizio) {
		this.numeroNoServizio = numeroNoServizio;
	}
	public int getNumeroStrabordi() {
		return numeroStrabordi;
	}
	public void setNumeroStrabordi(int numeroStrabordi) {
		this.numeroStrabordi = numeroStrabordi;
	}
	public int getNormaleServizio() {
		return normaleServizio;
	}
	public void setNormaleServizio(int normaleServizio) {
		this.normaleServizio = normaleServizio;
	}
	public double getqMedia() {
		return qMedia;
	}
	public void setqMedia(double qMedia) {
		this.qMedia = qMedia;
	}
	
	
	
	
}

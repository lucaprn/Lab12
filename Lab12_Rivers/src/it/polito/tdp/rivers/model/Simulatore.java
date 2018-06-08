package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

public class Simulatore {
	
	
	//parametri iniziale
	
	private double Q;
	private double f_min;
	
	//parametri di simulazione
	private double C;
	private int k; 
	private double f_medio;
	private List<Flow> flussi;
	//private List<StatoBacino> lista = new ArrayList<>();
	
	//parametri di simulazione
	private double qMedio;
	private int tracimazioni;
	private int noFlussoMinimo;
	private int normaleServizio;
	
		public void simula() {
			
		int sommaQ=0;
			
		//flusso minimo
		f_min=0.8*f_medio;
				
		//capienza totale bacino
		Q=k*f_medio*30;
				
		//occupazione iniziale
		C=Q/2;
		//queue
		
		for(Flow s : this.flussi) {
			Double entrata = s.getFlow(); 
			Double uscita;
			Double Prob = Math.random();
			
			if(Prob<=0.05) {
				uscita = f_min*10;
			}else {
				uscita=f_min;
			}
			
			double quantitaAcqua = (entrata-uscita)*60*60*24;
			
			if(C+quantitaAcqua>Q) {
				C=Q;
				tracimazioni++;
		
			}else if(C+quantitaAcqua<0) {
				C=0;
				noFlussoMinimo++;
			} else {
				C+=quantitaAcqua;
				normaleServizio++;
			}
			
			sommaQ+=C;
		}
		qMedio=sommaQ/this.flussi.size();
		
	}

		
		public void run(List<Flow> flows, int k, double flussoMedio) {
			noFlussoMinimo=0;
			tracimazioni=0;
			this.k=k;
			this.f_medio=flussoMedio;
			flussi=new ArrayList<>(flows);
			this.simula();
		}



		public int getTracimazioni() {
			return tracimazioni;
		}



		public int getNoFlussoMinimo() {
			return noFlussoMinimo;
		}



		public double getqMedio() {
			return qMedio;
		}


		public int getNormaleServizio() {
			return normaleServizio;
		}
		
		
		
		
	

}

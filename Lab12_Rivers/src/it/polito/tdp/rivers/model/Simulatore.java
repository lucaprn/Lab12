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
	private List<StatoBacino> lista = new ArrayList<>();
	
	
	public void run(List<Flow> flows, int k, double flussoMedio) {
		this.k=k;
		this.f_medio=flussoMedio;
		flussi=new ArrayList<>(flows);
		this.simula();
	}

	//inizializzazione
	public void simula() {
		
		//flusso minimo
		f_min=0.8*f_medio;
				
		//capienza totale bacino
		Q=k*f_medio*30;
				
		//occupazione iniziale
		C=Q/2;
		//queue
		
		for(Flow s : this.flussi) {
			Double entrata; 
			Double uscita = f_min;
			Double Prob = Math.random();
			if(Math.random()<=Prob) {
				entrata = f_min*10;
			}else {
				entrata = f_medio;
			}
			C+=(entrata-uscita);
			if(C>Q) {
				
			}else if(C<0) {
				
			}else {
				
			}
			
			
			
			
		}

		
	}
	

}

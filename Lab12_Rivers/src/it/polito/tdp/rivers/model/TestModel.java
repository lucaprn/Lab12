package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
	
		List<Flow> result = model.getFlussi(new River(2));
		River river = new River(2);
		
//		for(Flow f : result) {
//			System.out.println(f);
//		}
//		
		ResultSimulation resultSimulation = model.runSimulazione(4, river);
		System.out.println("\n--------risultato simulazione---------\n");
		System.out.println("Numero di giorni di normale servizio : "+resultSimulation.getNormaleServizio());
		System.out.println("Numero di giorni di mancato servizio : "+resultSimulation.getNumeroNoServizio());
		System.out.println("Numero di giorni di strabordamenti : "+resultSimulation.getNumeroStrabordi());
		System.out.println("Quantita di acqua media bacino : "+resultSimulation.getqMedia());

	}

}

package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
	River river = new River(4);
		List<Flow> result = model.getFlussi(river);
		
		
//		for(Flow f : result) {
//			System.out.println(f);
//		}
//		
		ResultSimulation resultSimulation = model.runSimulazione(12, river);
		System.out.println("\n-------risultato simulazione--------\n");
		System.out.println("Giorni soddisfacimento fabbisogno : "+resultSimulation.getNormaleServizio()+resultSimulation.getNumeroStrabordi());
		System.out.println("Giorni di mancato servizio : "+resultSimulation.getNumeroNoServizio());
		System.out.println("Quantita di acqua media bacino : "+resultSimulation.getqMedia());

	}

}

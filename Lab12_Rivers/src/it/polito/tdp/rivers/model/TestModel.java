package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
	
		List<Flow> result = model.getFlussi(new River(2));
		
		for(Flow f : result) {
			System.out.println(f);
		}
		

	}

}

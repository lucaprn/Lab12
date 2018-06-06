package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiversIDMap;

public class TestRiversDAO {

	public static void main(String[] args) {
		RiversIDMap map = new RiversIDMap();
		RiversDAO dao = new RiversDAO();
		System.out.println(dao.getAllRivers(map));
		
		River r = new River(5);
		CoppiaMisurazioni c = dao.getCoppia(r);
		
		System.out.println("Prima Misurazione : "+c.getPrima()+"  Ultima Misurazione : "+c.getUltima());
		
		System.out.println(" Misurazioni : "+dao.getNmisurazioni(r));
		
		System.out.println(" Media : "+dao.getMedia(r));
		
	}

}

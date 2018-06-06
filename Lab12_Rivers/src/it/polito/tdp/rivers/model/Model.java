package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.db.CoppiaMisurazioni;
import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	RiversIDMap riverMap;
	private FlowIDMap flowMap;
	private RiversDAO dao;
	private List<River> rivers;
	private List<Flow> flussi;
	
	
	public Model() {
		riverMap=new RiversIDMap();
		flowMap=new FlowIDMap();
		dao=new RiversDAO();
		rivers=new ArrayList(dao.getAllRivers(riverMap));
	}
	
	public List<River> getAllRivers(){
		return dao.getAllRivers(riverMap);
	} 
	
	public CoppiaMisurazioni getCoppiaMisurazioni(River r) {
		return dao.getCoppia(r);
	}
	
	public int getNumero(River r) {
		return dao.getNmisurazioni(r);
	}
	
	public double getMedie(River r) {
		return dao.getMedia(r);
	}
	
	public List<Flow> getFlussi(River r) {
		this.flussi=new ArrayList<>(dao.getAllFlussi(r,this.flowMap,this.riverMap));
		return flussi;
	}

}

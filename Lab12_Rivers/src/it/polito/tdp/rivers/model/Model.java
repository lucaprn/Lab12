package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import it.polito.tdp.rivers.db.CoppiaMisurazioni;
import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	RiversIDMap riverMap;
	private FlowIDMap flowMap;
	private RiversDAO dao;
	private List<River> rivers;
	private List<Flow> flussi;
	private Simulatore simulatore;
	
	
	public Model() {
		riverMap=new RiversIDMap();
		flowMap=new FlowIDMap();
		dao=new RiversDAO();
		rivers=new ArrayList(dao.getAllRivers(riverMap));
		simulatore = new Simulatore();
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
	
	public ResultSimulation runSimulazione(int k,River r) {
		ResultSimulation result;
		simulatore.run(this.getFlussi(r),k,this.getMedie(r));
		result = new ResultSimulation(simulatore.getNoFlussoMinimo(), simulatore.getTracimazioni(), simulatore.getNormaleServizio(),simulatore.getqMedio());
		return result;
		
	}

}

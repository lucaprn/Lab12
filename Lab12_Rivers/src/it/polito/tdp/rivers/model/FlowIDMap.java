package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class FlowIDMap {
	
	private Map<Integer,Flow> mappa = new HashMap<>();
	
	public Flow get(Flow r) {
		Flow old = mappa.get(r.getId());
		if(old==null) {
			mappa.put(r.getId(), r);
			return r;
		}else {
			return old;
		}
	}
	
	public void put(Flow r) {
		mappa.put(r.getId(), r);
	}

}

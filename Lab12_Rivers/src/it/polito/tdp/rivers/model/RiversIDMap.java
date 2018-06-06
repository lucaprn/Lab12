package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class RiversIDMap {
	
	private Map<Integer,River> mappa = new HashMap<>();
	
	public River get(River r) {
		River old = mappa.get(r.getId());
		if(old==null) {
			mappa.put(r.getId(), r);
			return r;
		}else {
			return old;
		}
	}
	
	public void put(River r) {
		mappa.put(r.getId(), r);
	}

}

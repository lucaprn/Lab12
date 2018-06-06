package it.polito.tdp.rivers.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.FlowIDMap;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiversIDMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RiversDAO {

	public List<River> getAllRivers(RiversIDMap riverMap) {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				River r = new River(res.getInt("id"), res.getString("name"));
				rivers.add(riverMap.get(r));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public CoppiaMisurazioni getCoppia(River r) {
		
		final String sql = "SELECT MAX(day) as ultima, MIN(day) as prima FROM flow WHERE river=?";
		
		CoppiaMisurazioni result=null;

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result=new CoppiaMisurazioni(res.getDate("prima").toLocalDate(), res.getDate("ultima").toLocalDate());
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
	
	public int getNmisurazioni(River r) {
		
		final String sql = "SELECT COUNT(id) as misurazioni FROM flow WHERE river=?";
		
		int punteggio = -1;

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				punteggio=res.getInt("misurazioni");
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return punteggio;
	}
	
public double getMedia(River r) {
		
		final String sql = "SELECT AVG(flow) as media FROM flow WHERE river=?";
		
		double media = -1;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				media = res.getDouble("media");
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return media;
	}

public List<Flow> getAllFlussi(River r, FlowIDMap flowMap, RiversIDMap riverMap) {
	
	final String sql = "SELECT f.id, f.day, f.flow, f.river, r.id, r.name\n" + 
			"from flow as f, river as r\n" + 
			"where f.river = ? AND f.river=r.id\n" + 
			"order by f.day";
	
	List<Flow> result = new ArrayList<>();

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, r.getId());
		ResultSet res = st.executeQuery();

		while (res.next()) {
			Flow f = new Flow(res.getInt("f.id") ,res.getDate("f.day").toLocalDate(), res.getDouble("f.flow"),riverMap.get(new River(res.getInt("r.id"),res.getString("r.name"))));
			result.add(flowMap.get(f));
		}

		conn.close();
		
	} catch (SQLException e) {
		//e.printStackTrace();
		throw new RuntimeException("SQL Error");
	}
	return result;
}
	
	
	
}

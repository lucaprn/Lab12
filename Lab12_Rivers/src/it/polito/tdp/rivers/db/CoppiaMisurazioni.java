package it.polito.tdp.rivers.db;

import java.time.LocalDate;

public class CoppiaMisurazioni {
	private LocalDate prima;
	private LocalDate ultima;
	
	public CoppiaMisurazioni(LocalDate prima, LocalDate ultima) {
		this.prima=prima;
		this.ultima=ultima;
	}

	public LocalDate getPrima() {
		return prima;
	}

	public void setPrima(LocalDate prima) {
		this.prima = prima;
	}

	public LocalDate getUltima() {
		return ultima;
	}

	public void setUltima(LocalDate ultima) {
		this.ultima = ultima;
	}
	
	
}

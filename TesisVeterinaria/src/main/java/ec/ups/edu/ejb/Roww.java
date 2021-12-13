package ec.ups.edu.ejb;

import java.io.Serializable;

public class Roww implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int nombreConsta;
	private String valorConsta;
	
	
	
	public Roww() {
	}



	public Roww(int nombreConsta, String valorConsta) {
		
		this.nombreConsta = nombreConsta;
		this.valorConsta = valorConsta;
	}



	public int getNombreConsta() {
		return nombreConsta;
	}



	public void setNombreConsta(int nombreConsta) {
		this.nombreConsta = nombreConsta;
	}



	public String getValorConsta() {
		return valorConsta;
	}



	public void setValorConsta(String valorConsta) {
		this.valorConsta = valorConsta;
	}



	@Override
	public String toString() {
		return "Roww [nombreConsta=" + nombreConsta + ", valorConsta=" + valorConsta + "]";
	}
	
	
	
}

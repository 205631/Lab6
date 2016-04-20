package it.polito.tdp.sudoku.modelprova;

public class Cella {

	private int riga;
	private int col;
	private int valore;
	
	public Cella(int riga, int col) {
		super();
		this.riga = riga;
		this.col = col;
		valore=0;
	}
	
	public Cella(int riga, int col,int valore) {
		super();
		this.riga = riga;
		this.col = col;
		this.valore=valore;
	}

	public int getRiga() {
		return riga;
	}

	public void setRiga(int riga) {
		this.riga = riga;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + riga;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cella other = (Cella) obj;
		if (col != other.col)
			return false;
		if (riga != other.riga)
			return false;
		return true;
	}
	
	
	
	
}

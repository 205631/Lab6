package it.polito.tdp.sudoku.modelprova;

import java.util.ArrayList;
import java.util.List;

public class SudokuProva {


	private List<Cella> solParziale;
	
	public void SudokuProva(){
		
		solParziale=new ArrayList<Cella>();
	}
	
	public List<Cella> trova(){
		
		solParziale.clear();
		
		ricorsione(0);
		
		return solParziale;
	}
	
	public boolean ricorsione(int livello){
		
		if(livello==10){
			return true;
		}
		for(int val=1;val<=9;val++){
			for(int col=1;col<=9;col++){
				if(filtro(livello,col,solParziale,val)==true){
					solParziale.add(new Cella(livello,col,val));
					boolean b=ricorsione(livello+1);
					if(b==true){
						return true;
					}
					solParziale.remove(new Cella(livello,col,val));
				}
			}
		}
		
		
		return false;
	}
	
	public boolean filtro(int livello,int col,List<Cella> solParziale,int val){
		
		//CONTROLLO RIGA
		for(int i=1;i<=9;i++){
			if(i!=col){
				int p=solParziale.indexOf(new Cella(livello,i));
				if(solParziale.get(p).getValore()==val){
					return false;
				}
			}
		}
			
		//CONTROLLO COLONNA
		for(int i=1;i<=9;i++){
			if(i!=col){
				int p=solParziale.indexOf(new Cella(i,col));
				if(solParziale.get(p).getValore()==val){
					return false;
				}
			}
		}
		
		//CONTROLLO MATRICE
		
		
		
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
	
		
		
	}

}

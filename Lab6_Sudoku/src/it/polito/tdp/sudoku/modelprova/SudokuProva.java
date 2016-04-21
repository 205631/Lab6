package it.polito.tdp.sudoku.modelprova;

import java.util.ArrayList;
import java.util.List;

public class SudokuProva {


	private List<Cella> solParziale;
	
	public SudokuProva(){
	
		solParziale=new ArrayList<Cella>();
		for(int i=1;i<=9; i++){
			for(int j=1;j<=9;j++){
				Cella c=new Cella(i,j);
				solParziale.add(c);
			}
		}
	}
	
	public List<Cella> trova(){
		
		//solParziale.clear();
		for(int j=1;j<=9;j++)
			ricorsione(j);
		
		
		return solParziale;
	}
	
	private boolean ricorsione(int livello){

		if(livello==10){
			return true;
		}
		for(int col=1;col<=9;col++){
			for(int val=1;val<=9;val++){
				if(filtro(livello,col,solParziale,val)==true){
					int p=solParziale.indexOf(new Cella(livello,col));
					solParziale.get(p).setValore(val);
					
					boolean b=ricorsione(livello+1);
					if(b==true)
						return true;
					
					solParziale.get(p).setValore(0);
				}
			}
		}
		
		
		return false;
	}
	
	//MOSTRUOSO
	private boolean controlloMatrice(int livello,int col,List<Cella> solParziale,int val){
		//PRIMA "RIGA"
		if(livello<=3){
			//PRIMO QUADRATO
			if(col<=3){
				for(int i=1;i<=3;i++){
					for(int j=1;j<=3;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
			//TERZO QUADRATO
			if(col>=7){
				for(int i=1;i<=3;i++){
					for(int j=7;j<=9;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}else{
				//SECONDO QUADRATO
				for(int i=1;i<=3;i++){
					for(int j=4;j<=6;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
		}
		//TERZA "RIGA"
		if(livello>=7){
			//PRIMO QUADRATO
			if(col<=3){
				for(int i=7;i<=9;i++){
					for(int j=1;j<=3;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
			//TERZO QUADRATO
			if(col>=7){
				for(int i=7;i<=9;i++){
					for(int j=7;j<=9;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}else{
				//SECONDO QUADRATO
				for(int i=7;i<=9;i++){
					for(int j=4;j<=6;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
		}else{
			//SECONDA "RIGA"
			
			if(col<=3){
				for(int i=4;i<=6;i++){
					for(int j=1;j<=3;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
			//TERZO QUADRATO
			if(col>=7){
				for(int i=4;i<=6;i++){
					for(int j=7;j<=9;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}else{
				//SECONDO QUADRATO
				for(int i=4;i<=6;i++){
					for(int j=4;j<=6;j++){
						if(livello!=i && col!=j){
							int p=solParziale.indexOf(new Cella(i,j));
							if(solParziale.get(p).getValore()==val)
								return false;
						}
					}
				}
			}
			
		}
		
		return true;
	}

	
	
	private boolean filtro(int livello,int col,List<Cella> solParziale,int val){
		
		//CONTROLLO NUMERO GIA' INSERITO
		
		int temp=solParziale.indexOf(new Cella(livello,col));
		if(solParziale.get(temp).getValore()!=0)
			return false;
		
		
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
			if(i!=livello){
				int p=solParziale.indexOf(new Cella(i,col));
				if(solParziale.get(p).getValore()==val){
					return false;
				}
			}
		}
		
		//CONTROLLO MATRICE
		if(controlloMatrice(livello,col,solParziale,val)== false)
			return false;
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		SudokuProva sp=new SudokuProva();
		List<Cella> l=sp.trova();
		
		for(int i=0;i<81;i++){
			if(i==9 || i==18 || i==27 || i==36 || i==45 || i==54 || i==63 || i==72)
				System.out.print("\n");
			System.out.print(l.get(i)+" ");
		}
		
		
		
	}

}

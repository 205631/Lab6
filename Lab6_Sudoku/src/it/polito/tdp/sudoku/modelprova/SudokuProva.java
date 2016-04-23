package it.polito.tdp.sudoku.modelprova;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuProva {


	private Map<Cella,Integer> solParziale;
	private int conta=0;

	
	public SudokuProva(){
	
		solParziale=new HashMap<Cella,Integer>();
		for(int i=1;i<=9; i++){
			for(int j=1;j<=9;j++){
				Cella c=new Cella(i,j);
				solParziale.put(c, 0);
			}
		}
	}
	
	public Map<Cella,Integer> trova(){
		
		ricorsione(1);
		
		
		return solParziale;
	}
	
	private boolean ricorsione(int livello){
		
		if(controlloFine()==81)//da modificare
			return true;
		
		if(livello==10){
			livello=1;
			/*for(int i=1;i<=9;i++){
				for(int j=1;j<=9;j++){
					System.out.print(solParziale.get(new Cella(i,j))+" ");
					if(j==9)
						System.out.print("\n");
				}
			}
			System.out.print("\n");*/
		}
		
		for(int val=1;val<=9;val++){
			for(int col=1;col<=9;col++){
				if(filtro(livello,col,solParziale,val)==true){
					solParziale.put(new Cella(livello,col),val);
					
					
						boolean b=ricorsione(livello+1);
						if(b==true)
							return true;
						
						solParziale.put(new Cella(livello,col),0);
				}
			}
		}
		return false;
	}
	
	//MOSTRUOSO
	private boolean controlloMatrice(int livello,int col,Map<Cella,Integer> solParziale,int val){
		/*//PRIMA "RIGA"
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
		
		return true;*/
		int r=livello;
		int c=col;
		if(livello==1||livello==4||livello==7)
			r++;
		if(livello==3||livello==6||livello==9)
			r--;
		if(col==1||col==4||col==7)
			c++;
		if(col==3||col==6||col==9)
			c--;
		
		for(int ri=(r-1);ri<=r+1;ri++){
			for(int co=(c-1);co<=c+1;co++){
				if(solParziale.get(new Cella(ri,co))==val)
					return false;				
			}			
		}	
		return true;
		
	}

	
	
	private boolean filtro(int livello,int col,Map<Cella,Integer> solParziale,int val){
	
		//CONTROLLO NUMERO GIA' INSERITO
		
		if(solParziale.get(new Cella(livello,col))!=0)
			return false;
		
		
		//CONTROLLO RIGA
		for(int i=1;i<=9;i++){
			if(i!=col){
				if(solParziale.get(new Cella(livello,i))==val){
					return false;
				}
			}
		}
			
		//CONTROLLO COLONNA
		for(int i=1;i<=9;i++){
			if(i!=livello){
				if(solParziale.get(new Cella(i,col))==val){
					return false;
				}
			}
		}
		
		//CONTROLLO MATRICE
		if(controlloMatrice(livello,col,solParziale,val)== false)
			return false;
		
		return true;
	}
	
	private int controlloFine(){
		int c=0;
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if(solParziale.get(new Cella(i,j))!=0)
					c++;
			}
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		SudokuProva sp=new SudokuProva();
		Map<Cella,Integer> l=sp.trova();
		
		
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				System.out.print(l.get(new Cella(i,j))+" ");
				if(j==9)
					System.out.print("\n");
			}
		}
		
		
		
	}

}

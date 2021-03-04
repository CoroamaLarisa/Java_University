package Repo;

import java.util.ArrayList;
import java.util.List;

import Domain.Obiect;
import Exceptions.InexistentCodeException;

public class Repository {

	private List<Obiect> lista_obiecte= new ArrayList<Obiect>();
	private String nume_fisier;
	
	public Repository() {};
	
	public Repository(String nume_fisier) {
		this.nume_fisier=nume_fisier;
	}
	
												//getteri
	public String getNumeFisier() {
		return this.nume_fisier;
	}
	
	public Obiect getObiectAt(int cod) throws InexistentCodeException {
		
		for(Obiect o: lista_obiecte) {
			if(o.getCod()==cod)
				return o;
		}
		
		throw new InexistentCodeException("Nu exista un obiect cu acest cod");
		
	}
	
	public List<Obiect> read(){
		return this.lista_obiecte;
	}
	
	
												//setter
	public void setNumeFisier(String nume_fisier) {
		this.nume_fisier=nume_fisier;
	}
											
	
	public void addObiect(Obiect o) {
		this.lista_obiecte.add(o);
	}
	
	
	
			

	
}

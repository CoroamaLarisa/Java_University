package Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Obiect;
import Exceptions.ExistentCodeException;
import Exceptions.FileInputException;
import Exceptions.InexistentCodeException;
import Repo.Repository;

public class Service {

	Repository r;
	public Service() {}
	
	public Service(Repository r) {
		this.r=r;
	}
	
	
																													//CRUD
	
	
	public void create(String denumire_obiect,String tip, int cod, int sold_initial,float valoare_unitara,int cantitate_ramasa) throws ExistentCodeException {
		
		try {
			r.getObiectAt(cod);																						//se verifica daca exista deja un obiect cu acel cod
			throw new ExistentCodeException("Deja exista un obiect cu acest cod");									//daca exista se arunca o eroare.
			
		}catch(InexistentCodeException e){																			//daca nu exista creem noul obiect si il adaugam in repository
			
			Obiect o = new Obiect(denumire_obiect,tip,cod,sold_initial,valoare_unitara,cantitate_ramasa);
			r.addObiect(o);																							//se foloseste repository-ul pentru a adauga un nou obiect in repo
			
		}
	}
	
	public void readFromFile() throws ExistentCodeException,Exception,FileInputException{							//citim din fisier
		
		try {
			
			BufferedReader bf= new BufferedReader(new FileReader(r.getNumeFisier()));
			
			String line;
			
			while(!((line=bf.readLine())==null)) {																	//cat timp nu s-a ajuns la finalul fisierului luam fiecare linie
				
				String[] felii= line.split(",");
				if(felii.length==6) {																				//verificam daca pe linie sunt 6 atribute, daca nu aruncam o eroare deoarece s-a scris gresit in fisier.
					if(Integer.parseInt(felii[3])<Integer.parseInt(felii[5])) {
						bf.close();																					//se inchide buffer-ul dupa se arunca exceptia
						throw new FileInputException("Nu ati introdus in formatul corect in fisier, soldul initial trebuie sa fie mai mare decat cantitatea ramasa.");		
																													//daca nu a fost introdus corect in fisier, se arunca o eroare custom 
					}
					this.create(felii[0],felii[1],Integer.parseInt(felii[2]),Integer.parseInt(felii[3]),Float.parseFloat(felii[4]),Integer.parseInt(felii[5]));		
																													//daca e corect introducem in repository
					
				}else {
					bf.close();																						//se inchide buffer-ul dupa se arunca exceptia
					throw new FileInputException("Nu ati introdus in formatul corect in fisier");					//daca nu a fost introdus corect in fisier, se arunca o exceptie custom
				}
				
				
			}
			
			bf.close();
			
		}catch(Exception e) {																						//se va prinde orice exceptie aruncata
			throw e;																								//se va arunca din nou exceptia pentru a ajunge in consola
		}
		
	}

	public void update(String denumire_obiect,String tip, int cod, int sold_initial,float valoare_unitara,int cantitate_ramasa) throws InexistentCodeException  {
		
	
			Obiect o = r.getObiectAt(cod);
			o.setDenumireObiect(denumire_obiect);
			o.setTip(tip);
			o.setSoldInitial(sold_initial);
			o.setValoareUnitara(valoare_unitara);
			o.setCantitateRamasa(cantitate_ramasa);
			
			
		
	
}

	public void delete(int cod) {
		
		for(int i=0;i<r.read().size();i++) {
			if(r.read().get(i).getCod()==cod) {	
				r.read().remove(i);																					//se va folosi metoda .remove pentru a se sterge obiectul cu codul dat
			}
		}
	}
	
	public List<Obiect> read(){
		return r.read();																							//folosim metoda .read din repository pentru a returna toate obiectele
	}
	
	
	public List<Obiect> getObiecteEpuizate(){																		// metoda pentru a returna obiectele epuizate
		
		List<Obiect> obiecte_epuizate= new ArrayList<Obiect>();											
		for(Obiect o: r.read()) {
			if(o.getCantitateRamasa()==0)																			//se verifica daca cantitatea ramasa a obiectului este 0
				obiecte_epuizate.add(o);																			//in cazul in care cantitatea este 0, se adauga in lista de obiecte epuizate
		}
		
		return obiecte_epuizate;
		
	}
	
	
public List<Obiect> getObiecteAproapeEpuizate(){																	//metoda pentru a returna obiectele aproape epuizate
	
	
		List<Obiect> obiecte_aproape_epuizate= new ArrayList<Obiect>();
		for(Obiect o: r.read()) {
			if(o.getSoldInitial()>10*o.getCantitateRamasa())														//se verifica daca cantitatea ramasa este mai mica decat 10% din soldul initial
				obiecte_aproape_epuizate.add(o);																	//in care in care conditia este satisfacuta, obiectul este adaugat la lista de obiecte aproape epuizate
		}
		
		return obiecte_aproape_epuizate;
		
	}
	

public Object[][] getObject(List<Obiect> obiecte){																	//dintr-o lista de entitati de tip Obiect se face o matrice de tip Object in care liniile sunt entitatile si coloanele sunt atributele
	
	Object[][] o= new Object[obiecte.size()][6];
	int i=0;
	for(Obiect ob: obiecte) {
		o[i][0]= ob.getDenumireObiect();
		o[i][1]= ob.getTip();
		o[i][2]= ob.getCod();
		o[i][3]= ob.getValoareUnitara();
		o[i][4]= ob.getSoldInitial();
		o[i][5]= ob.getCantitateRamasa();
		i++;
	}
	
	return o;
}
	
public List<Obiect> getObiecteFoarteScumpe(float val){																//metoda pentru a returna obiectele foarte scumpe(mai scumpe decat o valoare data)

	
	List<Obiect> obiecte_scumpe= new ArrayList<Obiect>();
	for(Obiect o: r.read()) {
		if(o.getValoareUnitara()>val)																				//se verifica daca valoarea unitara e mai mare decat valoare data
			obiecte_scumpe.add(o);																					//in care in care conditia este satisfacuta, obiectul este adaugat la lista de obiecte scumpe
	}
	
	return obiecte_scumpe;
	
}

public Object[][] getTipFullPrice(){																		//metoda pentru a returna dictionarul in care tipul obiectelor este cheia, si suma valorilor obiectelor cu acel tip drept valoare
	
	HashMap<String,Float> tip_pret = new HashMap<String,Float>();
	float suma=0.0f;
	float valoare_totala_obiect;
	for(Obiect o: r.read()) {																						//trecem prin fiecare obiect din repository
		valoare_totala_obiect= (o.getSoldInitial()-o.getCantitateRamasa())*o.getValoareUnitara();
		
		if(tip_pret.containsKey(o.getTip())){																		//verificam daca dictionarul contine deja cheia
			
			suma=tip_pret.get(o.getTip());																			//daca deja este cheia in dictionar luam valoarea unitara
			suma+=valoare_totala_obiect;																								//adaugam valoarea totala a obiectului
			tip_pret.put(o.getTip(), suma);																			//punem in dictionar la cheie noua valoare
			
		}else {
			tip_pret.put(o.getTip(), valoare_totala_obiect);														//daca nu exista deja cheia, introducem la acea cheie valoarea unitara a obiectului
		}
	}
	Object[][] obj= new Object[tip_pret.size()][2];
	int i=0;
	for(Map.Entry<String, Float> ek: tip_pret.entrySet()) {															//se face o matrice Object[][] din dictionar pentru a se afisa ca tabel de consola
		
		obj[i][0]=ek.getKey();
		obj[i][1]=ek.getValue();
		i++;
	}
	
	return obj;
	
}

}

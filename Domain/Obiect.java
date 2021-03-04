package Domain;

/*
 * - denumire obiect, 
 - tip, 
 - cod, 
 - sold initial, 
 - cantitate ramasa, 
 - valoare unitara 
*/
public class Obiect {

	private String denumire_obiect,tip;
	private int cod=0,sold_initial=0,cantitate_ramasa=0;
	private float valoare_unitara=0.0f;
	
	public Obiect() {}
	
	public Obiect(String denumire_obiect,String tip, int cod, int sold_initial,float valoare_unitara,int cantitate_ramasa) {
		
		this.denumire_obiect=denumire_obiect;
		this.tip=tip;
		this.cod=cod;
		this.sold_initial=sold_initial;
		this.valoare_unitara=valoare_unitara;
		this.cantitate_ramasa=cantitate_ramasa;
		
	}
													//getteri
	public String getDenumireObiect() {
		return this.denumire_obiect;
	}
	public String getTip() {
		return this.tip;
	}
	public int getCod() {
		return this.cod;
	}
	public int getSoldInitial() {
		return this.sold_initial;
	}
	public float getValoareUnitara() {
		return this.valoare_unitara;
	}
	public int getCantitateRamasa() {
		return this.cantitate_ramasa;
	}
													//setteri
	
	public void setDenumireObiect(String denumire_obiect) {
		this.denumire_obiect=denumire_obiect;
	}
	public void setTip(String tip) {
		this.tip=tip;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	public void setSoldInitial(int sold_initial) {
		this.sold_initial=sold_initial;
	}
	public void setValoareUnitara(float valoare_unitara) {
		this.valoare_unitara=valoare_unitara;
	}
	
	public void setCantitateRamasa(int cantitate_ramasa) {
		this.cantitate_ramasa=cantitate_ramasa;
	}
	
	@Override
	public String toString() {																//override la toString method 
		return String.format("|%-10d|%-20s|%-15s|%15d|%20d|%20.2f|\n", this.cod,this.denumire_obiect,this.tip,this.sold_initial,this.cantitate_ramasa,this.valoare_unitara);
	}
	
}

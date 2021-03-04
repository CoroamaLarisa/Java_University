package UI;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Service.Service;


public class Console {

	private Service s;
	public Console() {};
	public Console(Service s) {
		this.s=s;
	}
	
	public void console(int op,float v) {
		
		String[] columnNames= {"Denumire Obiect","Tip","Cod","Valoare Unitara","Sold Initial","Cantitate Ramasa"};
		String[] columnNames2= {"Tip","Valoare Totala"};
		
			if(op==1) {																							//verificam daca optiunea este 1										
				try {																							//daca este incercam sa citim din fisier
					s.readFromFile();
					System.out.println("\nAu fost introduse " + s.read().size() +" obiecte \n");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
			}else if(s.read().size()!=0) {																		//se verifica daca s-a citit din fisier
				JFrame frame = new JFrame();																	//se creeaza un nou frame pentru a se afisa tabelul asociat optiunii
				switch(op) {
				
				case 2:
					JTable table= new JTable(s.getObject(s.read()),columnNames);								//creem un nou tabel cu o matrice de Objects in care liniile sunt Obiectele iar coloanele sunt atributele , asociate cu columnNames declarate anterior  
					frame.add(new JScrollPane(table));															//il introducem in frame cu un JScrollPane pentru a se afisa si header la tabel(altfel nu se afisau columnNames)
					break;
				case 3:
					JTable table2= new JTable(s.getObject(s.getObiecteEpuizate()),columnNames);					//creem un nou tabel cu o matrice de Objects in care liniile sunt Obiectele iar coloanele sunt atributele , asociate cu columnNames declarate anterior
					frame.add(new JScrollPane(table2));															//il introducem in frame cu un JScrollPane pentru a se afisa si header la tabel(altfel nu se afisau columnNames)
					break;
				case 4:
					JTable table3= new JTable(s.getObject(s.getObiecteAproapeEpuizate()),columnNames);			//creem un nou tabel cu o matrice de Objects in care liniile sunt Obiectele iar coloanele sunt atributele , asociate cu columnNames declarate anterior
					frame.add(new JScrollPane(table3));															//il introducem in frame cu un JScrollPane pentru a se afisa si header la tabel(altfel nu se afisau columnNames)
					break;
				case 5:
					JTable table4= new JTable(s.getObject(s.getObiecteFoarteScumpe(v)),columnNames);			//creem un nou tabel cu o matrice de Objects in care liniile sunt Obiectele iar coloanele sunt atributele , asociate cu columnNames declarate anterior
					frame.add(new JScrollPane(table4));															//il introducem in frame cu un JScrollPane pentru a se afisa si header la tabel(altfel nu se afisau columnNames)
					break;
				case 6:
					JTable table5= new JTable(s.getTipFullPrice(),columnNames2);								//creem un nou tabel cu o matrice de Objects in care liniile sunt Obiectele iar coloanele sunt atributele , asociate cu columnNames declarate anterior
					frame.add(new JScrollPane(table5));															//il introducem in frame cu un JScrollPane pentru a se afisa si header la tabel(altfel nu se afisau columnNames)

					break;
				}
				
																												//ca in GUI.doGUI() setam  optiunile de afisare a frame-ului 
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);											//optam ca atunci cand se inchide fereastra, nu se inchide si tot programul
			    frame.setSize(800,150);
			    frame.setLocationByPlatform(true);
			    frame.setVisible(true);
			    
			}else
				System.out.println("\nNu ati introdus nimic in inventar\n");
		
		
		
	}
	
	public int afisMenu() {
		System.out.println("1. Citeste din fisier. ");
		System.out.println("2. Inventar cu toate obiectele. ");
		System.out.println("3. Tabel cu obiectele epuizate din stoc. ");
		System.out.println("4. Tabel cu obiectele in curs de epuizare. ");
		System.out.println("5. Tabel cu obiectele foarte scumpe. ");
		System.out.println("6. Tabel cu valoarea totala a obiectelor clasificate dupa tipul lor. ");
		System.out.println("0. Iesire din program. ");
		
		int op=citInt("Introduceti o optiune: ");
		
		return op;
		
	}
	
	
	
	public int citInt(String s) {																					//citire numar tip intreg
		System.out.print(s);
		
		try {
			Scanner scn= new Scanner(System.in);
			int no= scn.nextInt();
			
			return no;
		}catch(Exception e) {
			System.out.println("Nu ati introdus corect numarul intreg.");
			return citInt(s);
		}	
	}
	
	public float citFloat(String s) {																				//citire numar tip float
		System.out.print(s);
		
		try {
			Scanner scn= new Scanner(System.in);
			float no= scn.nextFloat();
			
			return no;
		}catch(Exception e) {
			System.out.println("Nu ati introdus corect numarul intreg.");
			return citFloat(s);
		}
	}
	
}

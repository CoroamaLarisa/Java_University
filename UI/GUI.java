package UI;

import Repo.Repository;
import Service.Service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

	

	class GUI{
	    public static void doGUI(){
	    	
	    	
	    	Repository r= new Repository("C://Users//Larisa//eclipse-workspace//Lab4//Obiecte.txt");
	    	Service s= new Service(r);
	    	Console c= new Console(s);
			JFrame frame = new JFrame("Inventar Magazie");										//creem un nou frame
			
			ImageIcon image = new ImageIcon("C:\\Users\\Larisa\\eclipse-workspace\\iconf2.png");					//se initializeaza si declareaza icons care vor fi folosite in fereastra
			ImageIcon icon = new ImageIcon("C:\\Users\\Larisa\\eclipse-workspace\\ce2.png");
			ImageIcon icon2 = new ImageIcon("C:\\Users\\Larisa\\eclipse-workspace\\icon5.png");
			ImageIcon icons = new ImageIcon("C:\\Users\\Larisa\\eclipse-workspace\\a.png");
	       
			JButton button1 = new JButton("Citeste din fisier");														
			button1.addActionListener(new ActionListener() {									//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(1,0)
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	        c.console(1,0);
	    	    }
	    	});
	 
		   JButton button2 = new JButton("Inventar cu toate obiectele");
		   button2.addActionListener(new ActionListener() {										//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(2,0)
			    @Override	
			    public void actionPerformed(ActionEvent e) {
			    	c.console(2,0);
			    }
			});
       
	       JButton button3 = new JButton("Tabel cu obiectele epuizate din stoc");								//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(3,0)
	       button3.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	    	c.console(3,0);
	    	    }
	    	});
	       
	       JButton button4 = new JButton("Tabel cu obiectele in curs de epuizare");								//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(4,0)
	       button4.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	    	c.console(4,0);
	    	    }
	    	});
	       
	       JButton button5 = new JButton("Tabel cu obiectele foarte scumpe");
	       button5.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {										//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(5,0)
	    	    	
	    	    	JFrame frame2 = new JFrame("GUI");											//pentru a aparea un nou frame ca utilizatorul sa introduca valoarea, creem un nou frame
	    	    	Box box4= Box.createVerticalBox();											//se creaza "boxes"(cutii) pentru a introduce obiectele ca sa apara ordonat in frame
	    	    	Box box5= Box.createHorizontalBox();
	    	    	
	    	    	
	    	    	JLabel label2= new JLabel("Introduceti o valoare: ");									//se creaza un label (eticheta)
	    	    	label2.setAlignmentX(Component.LEFT_ALIGNMENT);										//folosim metoda .setAlignment pentru a alinia label-ul la stanga
	    	    	
	    	    	JTextArea editTextArea = new JTextArea("");										//creem un component in care se poate scrie in fereastra 
	    	    	editTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);									//il asezam spre stanga
	    	    	editTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, editTextArea.getMinimumSize().height));			//folosim .setMaximumSize pentru valoare estetica, sa se aseze bine langa eticheta
	    	    	
	    	    	JButton button10 = new JButton("Enter");
	    	    	button10.setAlignmentX(Component.CENTER_ALIGNMENT);									//aliniem noul buton in centru
	    	    	doButtons(button10,icons);																				
	    	    	button10.addActionListener(new ActionListener() {														
	    	    			@Override		
	    		    	    public void actionPerformed(ActionEvent e) {
	    		    	    	c.console(5, Float.parseFloat(editTextArea.getText()));							//facem override la metoda butonului ca la apasarea butonului sa se apeleze metoda c.console(5,v)
	    		    	    														//unde v este valoare introdusa in zona de text din fereastra
	    		    	    }
	    		    	});
	    		   
    		       
	    	    																//codul care urmeaza reprezinta introducerea componentelor create in cutii si cutii rigide intre componente pentru a face spatiu intre ele in fereastra(din nou estetic)
	    	    	
    		       box5.add(Box.createRigidArea(new Dimension(5, 10)));									//se introduce o cutie "rigida" din valoare estetica, pentru a face spatiu intre inceputul cutiei si eticheta introdusa 
    		       box5.add(label2);
    		       box5.add(editTextArea);
    		       box4.add(Box.createRigidArea(new Dimension(5, 10)));
    		       box4.add(box5);
    		       box4.add(Box.createRigidArea(new Dimension(5, 10)));
    		       box4.add(button10);
    		       box4.add(Box.createRigidArea(new Dimension(5, 10)));
    		       box4.setBorder(BorderFactory.createMatteBorder(
    	                   45, 0, 28, 0, icon));												//creem un border matte pentru cutia4 pentru a creea ghirlanda din frame
    		       																											
    		       																//adaugam cutia in frame
    		       frame2.add(box4);
    		       frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);									//deodata ce se inchide frame-ul, optam sa nu se inchida tot programul prin a apela JFRAME.HIDE_ON_CLOSE nu JFRAME.EXIT_ON_CLOSE
    		       frame2.setSize(180,190);													//setam marimea frame-ului
    		       frame2.setLocationByPlatform(true);																		
    		       frame2.setVisible(true);													//facem vizibil frame-ul
	    	    }
	    	});
	       
	       JButton button6 = new JButton("Tabel cu valoarea totala a obiectelor clasificate dupa tipul lor");
	       button6.addActionListener(new ActionListener() {											//facem override 
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	    	c.console(6,0);														//se da ovverride la metoda butonului pentru ca atunci cand este apasat sa apeleze metoda c.console(1,0)
	    	    }
	    	});
	       	
	       																	//aliniem toate butoanele la stanga
	       button1.setAlignmentX(Component.LEFT_ALIGNMENT);
	       button2.setAlignmentX(Component.LEFT_ALIGNMENT);
	       button3.setAlignmentX(Component.LEFT_ALIGNMENT);
	       button4.setAlignmentX(Component.LEFT_ALIGNMENT);
	       button5.setAlignmentX(Component.LEFT_ALIGNMENT);
	       button6.setAlignmentX(Component.LEFT_ALIGNMENT);
	       
	       																													
	       doButtons(button1,icons);
	       doButtons(button2,icons);
	       doButtons(button3,icons);
	       doButtons(button4,icons);
	       doButtons(button5,icons);
	       doButtons(button6,icons);
	       
	       																	//introducem cutii rigide pentru spatii in frame, si dupa butoanele unul cate unul intr-o cutii initializata
	       Box box = Box.createVerticalBox();
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button1);
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button2);
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button3);
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button4);
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button5);
	       box.add(Box.createRigidArea(new Dimension(5, 5)));
	       box.add(button6);
	       
	       
	       																	//creem o noua cutie si introducem eticheta, si o cutie rigida
	       Box b2= Box.createHorizontalBox();
	       b2.add(Box.createRigidArea(new Dimension(5, 5)));
	       b2.add(new JLabel(image));
	       b2.add(Box.createRigidArea(new Dimension(5, 5)));
	       b2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));								//setam un border pentru cutie
	       b2.add(box);															//adaugam cutia cu toate butoanele 
	       b2.setBorder(BorderFactory.createMatteBorder(											//se seteaza un border matte cu ghirlanda
                   45, 0, 35, 0, icon));
	       
	       
	       																	//se face un nou label drept titlu principal,ii setam fontul si alinierea
	       JLabel label= new JLabel("Inventar Magazie");
	       label.setFont(new Font ("Colonna", Font.BOLD, 30));
	       label.setAlignmentX(Component.CENTER_ALIGNMENT);
	       																	//se face o noua cutie cu 2 icons si acel lave
	       Box b4= Box.createHorizontalBox();
	       b4.add(new JLabel(icon2));
	       b4.add(label);
	       b4.add(new JLabel(icon2));
	       																	//in final se creeaza o cutie in care se vor introduce cutiile cu componentele pentru a se introduce in frame
	       Box b3= Box.createVerticalBox();
	       b3.add(b4,BorderLayout.NORTH);
	       b3.add(b2,BorderLayout.SOUTH);
	       frame.add(b3);															//introducem cutia finala in frame
	       
	       
	    
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										//se seteaza ca deodata ce este inchis frame-ul, se inchide si programul
	       frame.setSize(800,650);														//setam marimea frame-ului 
	       frame.setLocationByPlatform(true);
	       frame.setVisible(true);														//facem vizibil frame-ul
	    }
	    
	    private static void doButtons(JButton button4, ImageIcon icons) {									//metoda pentru a seta un icon pentru un button transparent
	    button4.setIcon(icons);														//setam icon-ul butonului
	    button4.setOpaque(false);														//setam opacitatea butonului pe fals, deci sa fie o culoare alba butonul
	    button4.setContentAreaFilled(false);												//setam ca aria sa nu fie plina(a-2-lea pas ca butonul sa fie transparent)
	    button4.setBorderPainted(false);													//setam ca border-ul butonului sa nu mai fie vizibil
	    button4.setFocusPainted(false);													//setam ca atunci cand butonul este atins sa nu i se arate marginile
	    }	
	}



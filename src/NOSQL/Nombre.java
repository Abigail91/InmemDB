package NOSQL;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Nombre {
	     		/**
 * Esta clase se encarga de manejar el nombre dado
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	JFrame ven;
	static JTextField entry;
	
	
	
	public Nombre() {
	ven = new JFrame();
    ven.setSize(400, 400);
    ven.setTitle("InmemDB");
    ven.setLayout(null);
    ven.setResizable(false);
    ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel tex = new JLabel("Nombre de la tabla: ");
    tex.setBounds(60, 100, 300, 100);
    entry = new JTextField();
    entry.setBounds(60, 270, 40, 30);
    entry.addActionListener(action);
    ven.add(entry);
    ven.add(tex);
    ven.setVisible(true);

	}
	 AbstractAction action = new AbstractAction()
     {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 ven.setVisible(false);
            	 new Datos();
             }
             	
     };
     
    
     public static String getTitulo() { 
	          		/**
 * Este metodo se encarga de obtener el titulo
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
    	 String title = entry.getText();
    	 return title; 
    	 
     }
}

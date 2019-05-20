package NOSQL;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Datos {
	JFrame ventana2;
	static JTextField entrada;
	JLabel texto;
	
	public Datos() {
		ventana2 = new JFrame();
		ventana2.setResizable(false);
		ventana2.setSize(400, 400);
		ventana2.setTitle("InmemDB");
		ventana2.setLayout(null);
		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel texto = new JLabel("Inserte la cantidad de columnas: ");
		texto.setBounds(60, 100, 300, 100);
		entrada = new JTextField();
		entrada.setBounds(60, 270, 40, 30);
		entrada.addActionListener(action);
		ventana2.add(entrada);
		ventana2.add(texto);
		ventana2.setVisible(true);
	}
	
	AbstractAction action = new AbstractAction()
	{
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	ventana2.setVisible(false);	
	 	    new Interface();
	 	    Interface.rep = getValor();} //Le asigna el número de columnas al atributo rep de Interface
	    	
	};    
	    	//if(lupa instanceof String) {
	    		
	    	//}
	    	
	public static int getValor() {
	  	Integer result = Integer.valueOf(entrada.getText());	
	   	return result;}
	
	public static Object getDato() {
		
		return entrada.getText();
	}

	
	public static void main(String[] args) {
		new Datos();
	}
}
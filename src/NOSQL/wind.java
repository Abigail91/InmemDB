package NOSQL;
import java.awt.EventQueue;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

public class wind extends JFrame {

	JPanel contentPane;
	JTable table;
	String datos[][];
	
	public wind() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\log.png"));
		setFont(new Font("Lucida Handwriting", Font.PLAIN, 13));
		setTitle("InmemDB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nuevo");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmFila = new JMenuItem("Fila");
		mnNewMenu.add(mntmFila);
		
		JMenu mnArchivo = new JMenu("Abrir");
		mnArchivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnArchivo);
		
		JMenu mnVentana = new JMenu("Editar");
		mnVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnVentana);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	}
	

	
	public wind(ListaEnlazadaSimple<HashTable> lista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\log.png"));
		setFont(new Font("Lucida Handwriting", Font.PLAIN, 13));
		setTitle("InmemDB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nuevo");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmFila = new JMenuItem("Fila");
		mnNewMenu.add(mntmFila);
		
		JMenu mnArchivo = new JMenu("Abrir");
		mnArchivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnArchivo);
		
		JMenu mnVentana = new JMenu("Editar");
		mnVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnVentana);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		String titulos[] = new  String[Datos.getValor()];
		lista.print();
	
		Nodo<HashTable> aux = lista.getFirst();
		int i = 0;
		while (aux != null) {
			titulos[i] = aux.getData().nombre;
			System.out.println(titulos[i]);
			aux = aux.getNext();
			i++;
			}
		Nodo<HashTable> head = lista.getFirst();
		
		  ArrayList<String> newkeys = new ArrayList<String>();
	        
	        Enumeration<String> e1 =  head.getData().keys(); 
	       
	        
	        while (e1.hasMoreElements()) { 
	        	newkeys.add(e1.nextElement());
 } 	
		System.out.println(newkeys);
		if(head.getData().size()==0) {
			String datos[][] = new String[head.getData().size()+1][Datos.getValor()];
			System.out.println(titulos);
		
				for(int x=0; x<Datos.getValor();x++) {
					datos[0][x] = "-";
			}}
			else {
				datos = new String[newkeys.size()][lista.getLen()];
				
				 
				 
				 System.out.println("else");
				 int columna = 0;
			
				for(int fila =0;fila< newkeys.size();fila++) {
					head = lista.getFirst();
					columna = 0;
					while(head!= null) {
						datos[fila][columna] = (String) head.getData().get(newkeys.get(fila));
							head = head.getNext();
							columna++;
							
							
					}
					
				}
				for(int fila =0;fila< newkeys.size();fila++) {
					head = lista.getFirst();
					columna = 0;
					while(head!= null) {
						System.out.println(datos[fila][columna]);
							head = head.getNext();
							columna++;
							
							
					}
					
				}
				
				 }

			
				 



		
		
		  table = new JTable(datos,titulos); JScrollPane sp = new JScrollPane(table);
		  GroupLayout gl_contentPane = new GroupLayout(contentPane);
		  gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		  .addGroup(gl_contentPane.createSequentialGroup() .addComponent(sp,
		  GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
		  .addContainerGap(252, Short.MAX_VALUE)) ); gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		  .addGroup(gl_contentPane.createSequentialGroup() .addComponent(sp,
		  GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
		  .addContainerGap(398, Short.MAX_VALUE)) );
		  contentPane.setLayout(gl_contentPane);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setVisible(true);}
		  
		  
		  private static void addPopup(Component component, final JPopupMenu popup) {
		  component.addMouseListener(new MouseAdapter() { public void
		  mousePressed(MouseEvent e) { if (e.isPopupTrigger()) { showMenu(e); } }
		  public void mouseReleased(MouseEvent e) { if (e.isPopupTrigger()) {
		  showMenu(e); } } private void showMenu(MouseEvent e) {
		  popup.show(e.getComponent(), e.getX(), e.getY()); } });
		 
		 
		  }
	
	

	
}


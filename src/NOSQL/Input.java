package NOSQL;
 
import java.awt.event.ActionEvent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Server.Client;
import Server.Response;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import estructurasDeDatos.ListaEnlazadaSimple;
 
public class Input {
        JFrame ventana3;
        static JTextField entrada3;
        JLabel texto3;
        int rep;
        static String type;
        static ListaEnlazadaSimple <String> lista = new ListaEnlazadaSimple <String>();
        String nombre = "estudiantes";
        static ObjectMapper mapper = new ObjectMapper();
        ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
        static  Response response = new Response();
      
		
 
        public Input(int rep) {
        		
                this.rep = rep;
                ventana3 = new JFrame();
                ventana3.setSize(400, 400);
                ventana3.setTitle("InmemDB");
                ventana3.setLayout(null);
                ventana3.setResizable(false);
                ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JLabel texto3 = new JLabel("Inserte los datos: ");
                texto3.setBounds(60, 100, 300, 100);
                entrada3 = new JTextField();
                entrada3.setBounds(60, 270, 40, 30);
                entrada3.addActionListener(action);
                ventana3.add(entrada3);
                ventana3.add(texto3);
                ventana3.setVisible(true);
        }
 
        public static Object getValue() {
                return entrada3.getText();
        }
       
        public static boolean containsOnlyNumbers(String str) {
                for (int i = 0; i < str.length(); i++) {
                      if (!Character.isDigit(str.charAt(i)))
                        return false;
                    }
                    return true;
        }
       
        public static boolean containsOnlyLong(String str) {
                if(containsOnlyNumbers(str)) {
                        if(Long.parseLong(str)>=Long.MIN_VALUE && Long.parseLong(str)<=Long.MAX_VALUE) {
                                return true;
                        }else {
                                return false;
                        }
                }else {
                        return false;
                }
        }
       
        public static boolean isDouble(String strNum) {
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
        }
       
        public static boolean isFloat(String strNum) {
            try {
                double d = Float.parseFloat(strNum);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
        }
 
        AbstractAction action = new AbstractAction()
        {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	
                        if(rep==1) {
                        	
                        	  
                        	
                                if(type == "String" && entrada3.getText().matches("[a-zA-z]+")) {
                                        ventana3.setVisible(false);
                                        Input.lista.addLast(entrada3.getText());
                                        Input.lista.print();
                                        Input.response.setFila(Input.lista);
                                        Input.response.setCodigo(1);
                                        Input.response.setNombre_tabla(Nombre.entry.getText());
                                        
                                        System.out.println(Input.response.getNombre_tabla());
                                        System.out.println(Input.response.getFila());
                                        System.out.println(Input.response.getCodigo());
                                        
                                       
                                        Client.getInstance().setResponse(Input.response);
                                        

                                     
                                       
                       
                                       
                                }
                                else if(type == "Integer" && containsOnlyNumbers(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        lista.addLast(entrada3.getText());
                                        Input.response.setFila(lista);
                                        new wind();
                                       
                                        
                                }else if(type == "Long" && containsOnlyLong(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        lista.addLast(entrada3.getText());
                                        Input.response.setFila(lista);

                                        new wind();
                                        
                                        
                                }else if(type == "Double" && isDouble(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        lista.addLast(entrada3.getText());
                                        Input.response.setFila(lista);
                                        new wind();
                                        
                                        
                                }else if(type == "Float" && isFloat(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        lista.addLast(entrada3.getText());
                                        Input.response.setFila(lista);

                                        new wind();
                                      
                                }
                                
                                else {
                                        JOptionPane.showMessageDialog(null, "Ingrese el tipo correcto de dato");
                                }
                               
                             
                            //  new wind((ListaEnlazadaSimple<HashTable>) baseDeDatos.tablas.get("Sofia"));
                                                           
                                
                       }
                        else {
                                if(type == "String" && entrada3.getText().matches("[a-zA-z]+")) {
                                        ventana3.setVisible(false);
                                        new Interface();
                                        Input.lista.addLast(entrada3.getText());

                                        Interface.rep = Interface.rep - 1;
                                        
                                }
                                else if(type == "Integer" && containsOnlyNumbers(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        new Interface();
                                        lista.addLast(entrada3.getText());

                                        Interface.rep = Interface.rep - 1;
                                       
                                }else if(type == "Long" && containsOnlyLong(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        new Interface();
                                        lista.addLast(entrada3.getText());

                                        Interface.rep = Interface.rep - 1;
                                        
                                }else if(type == "Double" && isDouble(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        new Interface();
                                        lista.addLast(entrada3.getText());

                                        Interface.rep = Interface.rep - 1;
                                        
                                }else if(type == "Float" && isFloat(entrada3.getText())) {
                                        ventana3.setVisible(false);
                                        new Interface();
                                        lista.addLast(entrada3.getText());
                                        Interface.rep = Interface.rep - 1;
                                       
                                }
                                else {
                                        JOptionPane.showMessageDialog(null, "Ingrese el tipo correcto de dato");
                                }
                                
                        }
 
 
  }
 
 
 
        };    
        
        
   
 
}


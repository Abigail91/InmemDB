package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;

import NOSQL.HashTable;
import NOSQL.wind;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Client{
			  		/**
 * Esta clase se encarga del manejo del cliente
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		
		private static Client cliente = new Client();
		
		private int port;

		private String ip;
	
		private Properties properties;
		
		private Thread thread;
		
		private Response response;
		
		private ListaEnlazadaSimple l = new ListaEnlazadaSimple();
		
		public static boolean resFlag = false;
		
	private Client() {
	}
	
    public  void start()   { 
	    		  		/**
 * Este metodo se encarga de inicializar el cliente
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
        try{ 
        	
        	FileReader reader = new FileReader("C:\\Users\\abiga\\Desktop\\InmemDB\\resources\\ClientProperties.properties");
		
			properties = new Properties();
	
			properties.load(reader);
	
			ip = properties.getProperty("server.ip");
	
			port = Integer.parseInt(properties.getProperty("server.port"));

			thread = new ClientThread(ip,port);
			
			thread.start();
			
        }
			
        catch(Exception e){
        	System.out.println("Error en cliente");
        	System.out.println(e.getMessage());
        } 
    }
    
    
    public static Client getInstance() {
	    		  		/**
 * Este metodo se encarga de obtener el estado del cliente
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
    	return Client.cliente;
    }
    
	public void setResponse(Response response) {
				  		/**
 * Este metodo se encarga de establecer el response
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.response = response;
		this.resFlag = true;
		
	}
	public Response getResponse() {
				  		/**
 * Este metodo se encarga de obtener el response
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return this.response;
	}
	
	public static void main(String[] args) {
		Client.getInstance().start();
	}
}

class ClientThread extends Thread{
			  		/**
 * Esta clase se encarga de manejar el thread del cliente
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	
	private int port;

	private String ip;
	
	
	public ClientThread(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void run() {
		try {
			String out;
			String code;
			String in;
			
			while (true)  {
				Socket client = new Socket(this.ip,this.port);
				
	        	DataOutputStream salida = new DataOutputStream (client.getOutputStream());
				
	        	DataInputStream entrada = new DataInputStream (client.getInputStream());
	        	
	        	if(Client.getInstance().resFlag == true) {
		            if(Client.getInstance().getResponse().getCodigo() == 1) { 
		           	
		        		out = Serializador.serializar(Client.getInstance().getResponse());
		       
		            	salida.writeUTF(out);
		            	
		            	in = entrada.readUTF();
		            		            	
		            	Response response = Serializador.deserializar(in);
		            	
		            	
		            	new wind(response.getTabla());
		            	
		            	Client.getInstance().resFlag = false;
		            }else  if(Client.getInstance().getResponse().getCodigo() == 6) { 
			           	
			        		out = Serializador.serializar(Client.getInstance().getResponse());
			       
			            	salida.writeUTF(out);
			            	
			            	in = entrada.readUTF();
			            		            	
			            	Response response = Serializador.deserializar(in);
			            	response.getFila().print();
			            	
			            	
			            	Client.getInstance().resFlag = false;
			            }
		            
		        }
	            salida.writeUTF("Exit");
		        client.close();
		
		        entrada.close(); 
		
		        salida.close();
	        }
	    }
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

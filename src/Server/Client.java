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
    	return Client.cliente;
    }
    
	public void setResponse(Response response) {
		this.response = response;
		this.resFlag = true;
		
	}
	public Response getResponse() {
		return this.response;
	}
	
	public static void main(String[] args) {
		Client.getInstance().start();
	}
}

class ClientThread extends Thread{
	
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

package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;

import NOSQL.HashTable;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Client{

		private Socket client;

		private int port;

		private String ip;

		private DataOutputStream salida;
		
		private ObjectInputStream entrada;
		
		private Properties properties;
		
		private Thread thread;
		
    public  void start()   { 
        try{ 
        	
        	FileReader reader = new FileReader("C:\\Users\\abiga\\Desktop\\InmemDB\\resources\\ClientProperties.properties");
		
			properties = new Properties();
	
			properties.load(reader);
	
			ip = properties.getProperty("server.ip");
	
			port = Integer.parseInt(properties.getProperty("server.port"));

			client = new Socket(ip,port); 
			
			salida = new DataOutputStream (client.getOutputStream());
			
			entrada = new ObjectInputStream (client.getInputStream());
			
			thread = new ClientThread(client,salida,entrada);
			thread.start();
			
        }
			
        catch(Exception e){
        	System.out.println("Error en cliente");
        	System.out.println(e.getMessage());
        } 
    }
    
    public static void main(String args[]) {
    	Client cliente = new Client();
    	cliente.start();
    }
}

class ClientThread extends Thread{
	
	private DataOutputStream salida;
	
	private ObjectInputStream entrada;
		
	private Socket client;
	
	public ClientThread( Socket socket, DataOutputStream salida,ObjectInputStream entrada) {
		this.client = socket;
		this.salida = salida;
	    this.entrada = entrada; 
	}
	
	public void run() {
		try {
			String out;
			String code;
			String in;
			while (true)  {
				
	        	Scanner scn = new Scanner(System.in);
	        	
	        	code = scn.nextLine();
	        	
	            if(code.equals("1")) { 
	            	
	            	ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
	        		lista.addLast("Cedula","int");
	        		lista.addLast("Carné","int");
	        		lista.addLast("Nombre","String");
	        		
	        		Response response = new Response("Estudiantes",lista,1);
	        		
	        		out = Serializador.serializar(response);
	        		
	            	salida.writeUTF(out);
	            	
	            	
	            	in = (String) entrada.readObject();
	            	
	            	System.out.println(in);
	            	
	            	
	            }
	            
	            else if(code.equals("2")) {
	            	
	            	ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
	            	
	        		lista2.addLast("117690345");
	        		lista2.addLast("2018117463");
	        		lista2.addLast("Abigail");
	        		
	        		Response response = new Response("Estudiantes",lista2,2);
	        		
	        		out = Serializador.serializar(response);
	        		
	            	salida.writeUTF(out);
	            	
	            	in = (String) entrada.readObject();
	            	System.out.println(in);

	            }
	            
	            else if(code.equals("3")) {
	        		Response response = new Response("Estudiantes",null,3);
	        		response.setDato("117690345");
	        		
	        		out = Serializador.serializar(response);
	        		
	            	salida.writeUTF(out);
	            	
	            	in = (String) entrada.readObject();
	            	System.out.println(in);
	            	
	            }
	            
	            else if(code.equals("4")) {
	            	
	        		Response response = new Response("Estudiantes",null,4);
	        		
	        		out = Serializador.serializar(response);
	        		
	            	salida.writeUTF(out);
	            	
	            	ListaEnlazadaSimple<HashTable> tabla = (ListaEnlazadaSimple<HashTable>) entrada.readObject();
	            	tabla.print();
	            }
	            
	            else if(code.equals("5")) {
	            	
	        		Response response = new Response("Estudiantes",null,5);
	        		
	        		out = Serializador.serializar(response);
	        		
	            	salida.writeUTF(out);
	            	
	            	in = (String) entrada.readObject();
	            	System.out.println(in);
	            }
	            
	            else if(code.equals("6")) {
	            	salida.writeUTF("Exit");
	            	break;
	            }
	        }
	        salida.writeUTF("Exit");
	        
	        client.close();
	
	        entrada.close(); 
	
	        salida.close(); 
	        this.stop();
	    }
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

package Server;

import java.net.*;

import NOSQL.HashTable;
import NOSQL.baseDeDatos;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

import java.io.*;

public class Server {
	
	private ServerSocket server;
	
	private Socket socket;
	
	private int port = 9998;
	
	private ObjectOutputStream salida;
	
	private DataInputStream entrada;
	
	public void start() {
		try {
			server = new ServerSocket(port);
			
			while(true) {
				
				socket = new Socket();
				
				socket = server.accept();
				
				System.out.println("Se ha conectado un nuevo cliente");
	            System.out.println();
	            
	            salida = new ObjectOutputStream(socket.getOutputStream());
	            
	            entrada = new DataInputStream(socket.getInputStream());
	            
	            
	            
	            Thread hilo = new ServerThread(socket,salida,entrada);
	            
	            hilo.start();
	             
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String args[]) {
	    Server server = new Server();
	    server.start();
	    }
}

class ServerThread extends Thread{

	private Socket socket;
	
	private ObjectOutputStream salida;
	private DataInputStream entrada;
	
	
	public ServerThread(Socket socket,ObjectOutputStream salida,DataInputStream entrada) {
		this.socket = socket;
		this.salida = salida;
		this.entrada = entrada;
	}
	
	public void run() {
		
		String in;
		String out;
		
		while(true) {
			
			try {
				in = entrada.readUTF();
				
				if(in.equals("Exit")) {
                	
                	//indica que el cliente ha cerrado la conexion
                    System.out.println("Cliente ha enviado EXIT..."); 
                                       
                    //cierra el canal de informacion
                    this.socket.close(); 
                    
                    //indica que la conexion con el cliente se ha cerrado
                    System.out.println("Conexion cerrada"); 
                    break;
                    
                }
				
				Response response = Serializador.deserializar(in);
				if (response.getCodigo() == 1) {
					
					HashTable.nuevo_esquema(response.getFila(),response.getNombre_tabla());
					
					
					salida.writeObject("Se creo la tabla: "+ response.getNombre_tabla());
		
				}
				
				else if (response.getCodigo() == 2) {
					
					HashTable.agregar_fila(response.getFila(),response.getNombre_tabla());
					
					salida.writeObject("Se agrego fila a la tabla: " + response.getNombre_tabla());
				}
				
				else if (response.getCodigo() == 3) {
					
					HashTable.eliminar_fila(response.getDato(),response.getNombre_tabla());
					
					salida.writeObject("Se elimino fila de la tabla: " + response.getNombre_tabla());
				}
				
				else if (response.getCodigo() == 4) {
					
					ListaEnlazadaSimple<HashTable> tabla = (ListaEnlazadaSimple<HashTable>) baseDeDatos.tablas.get(response.getNombre_tabla());
					
					salida.writeObject(tabla);
				}
				
				else if (response.getCodigo() == 5) {
					HashTable.eliminar_esquema(response.getNombre_tabla());
					salida.writeObject("Se eliminado la tabla: " + response.getNombre_tabla());
				}
				
			}
			catch(Exception e) {
				System.out.println("Error dentro del while");
				System.out.println(e.getMessage());
			}
		}
		try {
			this.entrada.close(); 
	        this.salida.close();
		}
		catch(Exception e) {
			System.out.println("Error dentro al intentar cerrar conexion");
			System.out.println(e.getMessage());
		}
	}
}
























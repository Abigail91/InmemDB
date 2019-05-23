package Server;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;

import NOSQL.HashTable;
import NOSQL.baseDeDatos;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

import java.io.*;

public class Server {
			  		/**
 * Esta clase  se encarga del manejo del server
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	
	
	private static Server servidor = new Server();
	
	private ServerSocket server;
	
	private Socket socket;
	
	private int port = 9998;
	
	private DataOutputStream salida;
	
	private DataInputStream entrada;
	
	private baseDeDatos bdserver = new baseDeDatos();
	
	private Server() {
		
	}
	
	public void start() {
				  		/**
 * Este metodo se encarga de inicializar el server
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		try {
			server = new ServerSocket(port);
			
			while(true) {
				
				socket = new Socket();
				
				socket = server.accept();

	            salida = new DataOutputStream(socket.getOutputStream());
	            
	            entrada = new DataInputStream(socket.getInputStream());
	               
	            Thread hilo = new ServerThread(socket,salida,entrada);
	            
	            hilo.start();
	             
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Server getInstance() {
				  		/**
 * Este metodo se encarga de obtener la instancia
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return Server.servidor;
	}
	
	public baseDeDatos getBData() {
		return this.bdserver;
	}
	
	public static void main(String[] args) {
		Server servidor = Server.getInstance();
		servidor.start();
	}
}

class  ServerThread extends Thread{

	private Socket socket;
	
	private DataOutputStream salida;
	
	private DataInputStream entrada;
	
	public ServerThread(Socket socket,DataOutputStream salida,DataInputStream entrada) {
		this.socket = socket;
		this.salida = salida;
		this.entrada = entrada;
	}
	
	public synchronized void run() {
		
		String in;
		String out;
		
			try {
				in = entrada.readUTF();
				
				if(in.equals("Exit")) {
                    this.socket.close(); 
                    return;
                }
				
				Response response = Serializador.deserializar(in);		
				if (response.getCodigo() == 1) {
					
					HashTable.nuevo_esquema(response.getFila(),response.getNombre_tabla(),Server.getInstance().getBData());

					Response responseServer = new Response();
					responseServer.setTabla((ListaEnlazadaSimple<HashTable>) Server.getInstance().getBData().getTablas().get(response.getNombre_tabla()));
				    

					out = Serializador.serializar(responseServer);
					System.out.println(Server.getInstance().getBData().getTablas());
					salida.writeUTF(out);

				}
				
				else if (response.getCodigo() == 2) {
					
					HashTable.agregar_fila(response.getFila(), response.getNombre_tabla(), Server.getInstance().getBData());
					
					salida.writeUTF("Se agrego fila a la tabla: " + response.getNombre_tabla());
				}
				
				else if (response.getCodigo() == 3) {
					
					HashTable.eliminar_fila(response.getDato(),response.getNombre_tabla(),Server.getInstance().getBData());
					
					salida.writeUTF("Se elimino fila de la tabla: " + response.getNombre_tabla());
				}
				
				else if (response.getCodigo() == 4) {

					ListaEnlazadaSimple<HashTable> tabla = (ListaEnlazadaSimple<HashTable>) Server.getInstance().getBData().getTablas().get(response.getNombre_tabla());
					tabla.print();
					
					//salida.writeUTF(tabla);
					
				}
				
				else if (response.getCodigo() == 5) {
					HashTable.eliminar_esquema(response.getNombre_tabla(),Server.getInstance().getBData());
					salida.writeUTF("Se eliminado la tabla: " + response.getNombre_tabla());
				}
				else if (response.getCodigo() == 6) {
					ListaEnlazadaSimple<String> newkeys = new ListaEnlazadaSimple<String>();

					Enumeration<String> e1 = Server.getInstance().getBData().tablas.keys();

					while (e1.hasMoreElements()) {
						newkeys.addLast(e1.nextElement());
					}
					Response responseServer = new Response();
					responseServer.setFila(newkeys);
					System.out.println(newkeys);
				    

					out = Serializador.serializar(responseServer);
					salida.writeUTF(out);

				}
				
			}
			catch(Exception e) {
				System.out.println("Error dentro del while");
				System.out.println(e.getMessage());
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


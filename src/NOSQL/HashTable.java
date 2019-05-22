package NOSQL;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;
public class HashTable<K,T> extends Hashtable{

	public String nombre;
	public String tipo;

	public HashTable() {}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public static ListaEnlazadaSimple<HashTable> nuevo_esquema(ListaEnlazadaSimple<String> titulos,String nombre, baseDeDatos bdatos) {

		ListaEnlazadaSimple<HashTable> tabla = new ListaEnlazadaSimple();
		tabla.setNombre(nombre);
		Nodo<String> aux = titulos.getFirst();
		while (aux != null) {
			HashTable<String,String> columna = new HashTable<String,String>();
			columna.put("nombre",aux.getData());
			columna.nombre = aux.getData();
			columna.tipo = aux.getTipo();
			tabla.addLast(columna);
			aux = aux.getNext();
			}  

		bdatos.getTablas().put(nombre,tabla);

		
		return tabla;
		
		

	}
	
	public static void agregar_fila(ListaEnlazadaSimple<String> nuevo_dato,String tabla, baseDeDatos bdatos) {
		
		ListaEnlazadaSimple<HashTable> tab =  (ListaEnlazadaSimple<HashTable>) bdatos.getTablas().get(tabla);
		Nodo<String> aux = nuevo_dato.getFirst();
		Nodo<HashTable> aux2 = tab.getFirst();
		while (aux != null) {
			aux2.getData().put(nuevo_dato.getFirst().getData(),aux.getData());
			
			
			aux = aux.getNext();
			aux2 = aux2.getNext();
			
			}
	
		
	}
	public static void eliminar_fila(String dato, String tabla,baseDeDatos bdatos) {
		ListaEnlazadaSimple<HashTable> tab =  (ListaEnlazadaSimple<HashTable>) (bdatos.getTablas().get(tabla));
		Nodo<HashTable> aux2 = tab.getFirst();
		while (aux2 != null) {
			aux2.getData().remove(dato);
			
			
			
			aux2 = aux2.getNext();
			}
		
		tab.print();
		System.out.println();
	}
		
	public void print(HashTable<String,HashTable> hash) {
		String response = "";
		
		Enumeration<String> keys = hash.keys();
		Enumeration<String> value = hash.elements();
		while(keys.hasMoreElements()) {
			response +=  keys.nextElement();
			response += " = " + value.nextElement();
			System.out.println(response);
			System.out.println();
			
		}
	}
	
	public static void eliminar_esquema(String nombre,baseDeDatos bdatos) {
		
		bdatos.getTablas().remove(nombre);
		System.out.println(bdatos.getTablas());
		System.out.println();
		
		
	}
	
}


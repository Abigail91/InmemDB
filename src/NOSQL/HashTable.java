package NOSQL;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;
public class HashTable<K,T> extends Hashtable{

	public String nombre;
	public String tipo;

	public static void main(String args[]) {
		ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
		lista.addLast("Cedula","int");
		lista.addLast("Carné","int");
		lista.addLast("Nombre","String");

		
		ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
		lista2.addLast("117690345");
		lista2.addLast("2018117463");
		lista2.addLast("Abigail");
		
		ListaEnlazadaSimple<String> lista3 = new ListaEnlazadaSimple<String>();
		lista3.addLast("1");
		lista3.addLast("117463");
		lista3.addLast("Victoria");
		
		ListaEnlazadaSimple<String> lista4 = new ListaEnlazadaSimple<String>();
		lista4.addLast("2");
		lista4.addLast("11");
		lista4.addLast("Haziel");
	
		
		
		nuevo_esquema(lista,"Estudiantes");
		HashTable.agregar_fila(lista2,"Estudiantes");
		HashTable.agregar_fila(lista3,"Estudiantes");
		HashTable.eliminar_fila("117690345","Estudiantes");
		System.out.println(baseDeDatos.tablas);
		HashTable.agregar_fila(lista4,"Estudiantes");
		eliminar_esquema("Estudiantes");
		
		
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static void nuevo_esquema(ListaEnlazadaSimple<String> titulos,String nombre) {
		ListaEnlazadaSimple<HashTable> tabla = new ListaEnlazadaSimple();
		tabla.setNombre(nombre);
		Nodo<String> aux = titulos.getFirst();
		while (aux != null) {
			HashTable<String,String> columna = new HashTable<String,String>();
			columna.nombre = aux.getData();
			columna.tipo = aux.getTipo();
			tabla.addLast(columna);
			aux = aux.getNext();
			}  
		
		baseDeDatos.tablas.put(nombre,tabla);
		tabla.print();
		System.out.println();
		
		
	}
	
	public static void agregar_fila(ListaEnlazadaSimple<String> nuevo_dato,String tabla) {
		ListaEnlazadaSimple<HashTable> tab = (ListaEnlazadaSimple<HashTable>) baseDeDatos.tablas.get(tabla);
		Nodo<String> aux = nuevo_dato.getFirst();
		Nodo<HashTable> aux2 = tab.getFirst();
		while (aux != null) {
			aux2.getData().put(nuevo_dato.getFirst().getData(),aux.getData());
			
			System.out.println(aux2.getData().tipo);
			aux = aux.getNext();
			aux2 = aux2.getNext();
			
			}
		
		tab.print();
		
		System.out.println();
		
	}
	public static void eliminar_fila(String dato, String tabla) {
		ListaEnlazadaSimple<HashTable> tab = (ListaEnlazadaSimple<HashTable>) baseDeDatos.tablas.get(tabla);
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
	public static void eliminar_esquema(String nombre) {
		
		baseDeDatos.tablas.remove(nombre);
		System.out.println(baseDeDatos.tablas);
		System.out.println();
		
		
	}
	
}


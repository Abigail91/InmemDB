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
		Hashtable<String, HashTable> Tabla = new Hashtable<String, HashTable>();
		ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
		lista.addLast("Cedula");
		lista.addLast("Carné");
		lista.addLast("Nombre");
		ListaEnlazadaSimple<String> tipos = new ListaEnlazadaSimple<String>();
		tipos.addLast("int");
		tipos.addLast("int");
		tipos.addLast("String");
		
		ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
		lista2.addLast("117690345");
		lista2.addLast("2018117463");
		lista2.addLast("Abigail");
		
		ListaEnlazadaSimple<String> lista3 = new ListaEnlazadaSimple<String>();
		lista3.addLast("1");
		lista3.addLast("117463");
		lista3.addLast("Victoria");
	
		
		
		nuevo_esquema(lista,"Estudiantes",tipos);
		HashTable.agregar_fila(lista2,"Estudiantes");
		HashTable.agregar_fila(lista3,"Estudiantes");
		HashTable.eliminar_fila("1","Estudiantes");
		System.out.println(baseDeDatos.tablas);
		eliminar_esquema("Estudiantes");
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static void nuevo_esquema(ListaEnlazadaSimple<String> titulos,String nombre,ListaEnlazadaSimple<String> tipo) {
		ListaEnlazadaSimple<HashTable> tabla = new ListaEnlazadaSimple();
		tabla.setNombre(nombre);
		Nodo<String> aux = titulos.getFirst();
		Nodo<String> aux2 = tipo.getFirst();
		while (aux != null) {
			HashTable<String,String> columna = new HashTable<String,String>();
			columna.nombre = aux.getData();
			columna.tipo = aux2.getData();
			tabla.addLast(columna);
			aux = aux.getNext();
			aux2 = aux2.getNext();
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


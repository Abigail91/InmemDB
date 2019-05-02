package NOSQL;

import java.util.ArrayList;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;

public class HashTable<K,T> extends Hashtable{

	public String nombre;

	public static void main(String args[]) {
		Hashtable<String, ListaEnlazadaSimple> Tabla = new Hashtable<String, ListaEnlazadaSimple>();
		ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
		lista.addLast("Cedula");
		lista.addLast("Carné");
		lista.addLast("Nombre");
		Tabla.put("Cedula", lista);
		ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
		lista2.addLast("117690345");
		lista2.addLast("2018117463");
		lista2.addLast("Abigail");
	
		
		
		nuevo_esquema(lista,"Nombre","Estudiantes");
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static void nuevo_esquema(ListaEnlazadaSimple titulos,String key,String nombre) {
		HashTable tabla = new HashTable<Integer, ListaEnlazadaSimple>();
		tabla.setNombre(nombre);
		tabla.put(key, titulos);
		baseDeDatos.tablas.addLast(tabla);
		
	}
	
	public static void agregar_fila(ListaEnlazadaSimple nuevo_dato,String tabla) {
		Nodo<HashTable> aux = (Nodo<HashTable>) baseDeDatos.tablas.getFirst();
		while (aux != null) {
			if(aux.getData().getNombre() == tabla) {
				aux.getData().put(nuevo_dato.getFirst().getData(), nuevo_dato);
			
			}
			aux = aux.getNext();}
		}

	public String getNombre() {
		return nombre;
	}
	public static void eliminar_fila(String dato, String tabla) {
		Nodo<HashTable> aux = (Nodo<HashTable>) baseDeDatos.tablas.getFirst();
		while (aux != null) {
			if(aux.getData().getNombre() == tabla) {
				aux.getData().remove(dato);
			
			}
			aux = aux.getNext();}
		}
		
}


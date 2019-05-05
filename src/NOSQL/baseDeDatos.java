package NOSQL;

import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;

public class baseDeDatos {
	public static HashTable<String, ListaEnlazadaSimple<HashTable>> tablas = new HashTable<String, ListaEnlazadaSimple<HashTable>>();
	
	public static void main(String args[]) {
		ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
		lista.addLast("Cedula");
		lista.addLast("Carné");
		lista.addLast("Nombre");
		ListaEnlazadaSimple<String> lista2 = new ListaEnlazadaSimple<String>();
		lista2.addLast("117690345");
		lista2.addLast("2018117463");
		lista2.addLast("Abigail");
		ListaEnlazadaSimple<String> lista3 = new ListaEnlazadaSimple<String>();
		lista3.addLast("1");
		lista3.addLast("2018117463");
		lista3.addLast("Victoria");
	
		HashTable.agregar_fila(lista2, "Estudiantes");
		HashTable.agregar_fila(lista3, "Estudiantes");
		
	

		
	}

}

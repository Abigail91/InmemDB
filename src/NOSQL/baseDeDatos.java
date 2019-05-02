package NOSQL;

import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;

public class baseDeDatos {
	public static ListaEnlazadaSimple<HashTable> tablas = new ListaEnlazadaSimple<HashTable>();
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
		HashTable.nuevo_esquema(lista,"Nombre","Estudiantes");
		HashTable.agregar_fila(lista2, "Estudiantes");
		HashTable.agregar_fila(lista3, "Estudiantes");
		
		((ListaEnlazadaSimple<HashTable>) tablas.first.getData().get("Nombre")).print();
		((ListaEnlazadaSimple<HashTable>) tablas.first.getData().get("117690345")).print();
		((ListaEnlazadaSimple<HashTable>) tablas.first.getData().get("1")).print();
		System.out.println(baseDeDatos.tablas.getFirst().getData().size());
		HashTable.eliminar_fila("1", "Estudiantes");
		System.out.println(baseDeDatos.tablas.getFirst().getData().size());

		
	}

}

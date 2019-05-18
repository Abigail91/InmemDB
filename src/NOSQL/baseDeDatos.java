package NOSQL;

import java.io.IOException;

import estructurasDeDatos.ListaEnlazadaSimple;

public class baseDeDatos {
	
	public static HashTable<String, ListaEnlazadaSimple<HashTable>> tablas = new HashTable<String, ListaEnlazadaSimple<HashTable>>();
	
}

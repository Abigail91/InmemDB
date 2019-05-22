package NOSQL;

import java.io.IOException;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;

public class baseDeDatos {
	
	public HashTable<String, ListaEnlazadaSimple<HashTable>> tablas;
	
	public baseDeDatos() {
		this.tablas = new HashTable<String, ListaEnlazadaSimple<HashTable>>();
	}

	public Hashtable getTablas() {
		return this.tablas;
	}
	
}

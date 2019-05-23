package NOSQL;

import java.io.IOException;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;

public class baseDeDatos {
			  		/**
 * Esta clase se encarga del manejo de la base de datos
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	
	public HashTable<String, ListaEnlazadaSimple<HashTable>> tablas;
	
	public baseDeDatos() {
		this.tablas = new HashTable<String, ListaEnlazadaSimple<HashTable>>();
	}

	public Hashtable getTablas() {
		return this.tablas;
	}
	
}

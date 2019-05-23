package Server;

import java.io.IOException;

import NOSQL.HashTable;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Response {
			  		/**
 * Esta clase se encarga de manejar el response por medio de hashtables
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	
	int codigo;
	String nombre_tabla;
	ListaEnlazadaSimple<String> fila;
	ListaEnlazadaSimple<HashTable> tabla;
	String dato;

	HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos;
	
	public Response() {
	}
	
	public Response(String string,ListaEnlazadaSimple fila,int i) {
				  		/**
 * Este metodo se encarga del response
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.codigo = i;
		
		this.fila = fila;
		this.nombre_tabla = string;
	}

	public String getDato() {
				  		/**
 * Este metodo se encarga de obtener el dato
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return dato;
	}

	public void setDato(String dato) {
				  		/**
 * Este metodo se encarga de definir el dato
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.dato = dato;
	}

	public int getCodigo() {
				  		/**
 * Este metodo se encarga de obtener el codigo
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return codigo;
	}

	public void setCodigo(int codigo) {
				  		/**
 * Este metodo se encarga de definir el codigo
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.codigo = codigo;
	}

	public String getNombre_tabla() {
				  		/**
 * Este metodo se encarga de obtener el nombre de la tabla
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return nombre_tabla;
	}

	public void setNombre_tabla(String nombre_tabla) {
				  		/**
 * Este metodo se encarga de definir el nombre en la tabla
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.nombre_tabla = nombre_tabla;
	}

	public ListaEnlazadaSimple<String> getFila() {		  		/**
 * Este metodo se encarga de obtener la fila de la lista enlazada
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return fila;
	}

	public void setFila(ListaEnlazadaSimple<String> fila) {
				  		/**
 * Este metodo se encarga de definir la fila
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.fila = fila;
	}
	
	public void setTabla(ListaEnlazadaSimple<HashTable> tabla) {
				  		/**
 * Este metodo se encarga de definir la tabla
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.tabla = tabla;
	}
	
	public HashTable<String, ListaEnlazadaSimple<HashTable>> getBase_de_datos() {
				  		/**
 * Este metodo se encarga de obtener la base de datos
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return base_de_datos;
	}

	public void setBase_de_datos(HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos) {
				  		/**
 * Este metodo se encarga de definir la base de datos
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.base_de_datos = base_de_datos;
	}

	
	public ListaEnlazadaSimple<HashTable> getTabla(){
		return this.tabla;
	}
	
}


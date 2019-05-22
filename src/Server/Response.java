package Server;

import java.io.IOException;

import NOSQL.HashTable;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Response {
	
	int codigo;
	String nombre_tabla;
	ListaEnlazadaSimple<String> fila;
	ListaEnlazadaSimple<HashTable> tabla;
	String dato;

	HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos;
	
	public Response() {
	}
	
	public Response(String string,ListaEnlazadaSimple fila,int i) {
		this.codigo = i;
		
		this.fila = fila;
		this.nombre_tabla = string;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre_tabla() {
		return nombre_tabla;
	}

	public void setNombre_tabla(String nombre_tabla) {
		this.nombre_tabla = nombre_tabla;
	}

	public ListaEnlazadaSimple<String> getFila() {
		return fila;
	}

	public void setFila(ListaEnlazadaSimple<String> fila) {
		this.fila = fila;
	}
	
	public void setTabla(ListaEnlazadaSimple<HashTable> tabla) {
		this.tabla = tabla;
	}
	
	public HashTable<String, ListaEnlazadaSimple<HashTable>> getBase_de_datos() {
		return base_de_datos;
	}

	public void setBase_de_datos(HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos) {
		this.base_de_datos = base_de_datos;
	}

	
	public ListaEnlazadaSimple<HashTable> getTabla(){
		return this.tabla;
	}
	
}


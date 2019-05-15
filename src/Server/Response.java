package Server;

import java.io.IOException;

import NOSQL.HashTable;
import Serializador.Serializador;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Response {
	
	int codigo;
	String nombre_tabla;
	ListaEnlazadaSimple<String> fila;
	HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos;
	
	public Response() {
	}
	
	public Response(int i, String string, HashTable hashTable,ListaEnlazadaSimple fila) {
		this.codigo = i;
		this.base_de_datos = hashTable;
		this.fila = fila;
		this.nombre_tabla = string;
	}

	public static void main(String args[]) throws IOException {
		ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<String>();
		lista.addLast("Cedula");
		lista.addLast("Carné");
		lista.addLast("Nombre");
		
		Response response = new Response(1,"Estudiantes",new HashTable(),lista);
		
		String json =Serializador.serializar(response);
		System.out.println(Serializador.deserializar(json).codigo);
		
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

	public HashTable<String, ListaEnlazadaSimple<HashTable>> getBase_de_datos() {
		return base_de_datos;
	}

	public void setBase_de_datos(HashTable<String, ListaEnlazadaSimple<HashTable>> base_de_datos) {
		this.base_de_datos = base_de_datos;
	}
	
	

}

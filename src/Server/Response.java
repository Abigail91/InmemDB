package Server;

import estructurasDeDatos.ListaEnlazadaSimple;

public class Response {
	int codigo;
	String nombre_tabla;
	ListaEnlazadaSimple<String> fila;
	String dato;
	
	public Response() {
	}
	public Response(String nombre_tabla, ListaEnlazadaSimple<String> fila, int codigo) {
		this.codigo = codigo;
		this.fila = fila;
		this.nombre_tabla = nombre_tabla;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre_tabla(String nombre_tabla) {
		this.nombre_tabla = nombre_tabla;
	}
	public void setFila(ListaEnlazadaSimple<String> fila) {
		this.fila = fila;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre_tabla() {
		return nombre_tabla;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public ListaEnlazadaSimple<String> getFila() {
		return fila;
	}

	
}

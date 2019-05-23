package NOSQL;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;
public class HashTable<K,T> extends Hashtable{
	/**
 * Esta clase se encarga de el manejo de los hashtables en el proyecto.
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */

	public String nombre;
	public String tipo;

	public HashTable() {}
	
	public void setNombre(String nombre) {
		/**
 * Este metodo se encarga de asignar el nombre
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.nombre = nombre;
	}

	public String getTipo() {
		/**
 * Este metodo se encarga de obtener el tipo del dato
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return tipo;
	}

	public void setTipo(String tipo) {
		/**
 * Este metodo se encarga de asiganr el tipo
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		this.tipo = tipo;
	}

	public String getNombre() {
		/**
 * Este metodo se encarga de obtener el nombre
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		return nombre;
	}

	public static ListaEnlazadaSimple<HashTable> nuevo_esquema(ListaEnlazadaSimple<String> titulos,String nombre, baseDeDatos bdatos) {

		ListaEnlazadaSimple<HashTable> tabla = new ListaEnlazadaSimple();
		tabla.setNombre(nombre);
		Nodo<String> aux = titulos.getFirst();
		while (aux != null) {
			HashTable<String,String> columna = new HashTable<String,String>();
			columna.put("nombre",aux.getData());
			columna.nombre = aux.getData();
			columna.tipo = aux.getTipo();
			tabla.addLast(columna);
			aux = aux.getNext();
			}  

		bdatos.getTablas().put(nombre,tabla);

		
		return tabla;
		
		

	}
	
	public static void agregar_fila(ListaEnlazadaSimple<String> nuevo_dato,String tabla, baseDeDatos bdatos) {
		/**
 * Este metodo se encarga de agregar una fila por medio de listas enlazadas
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		
		ListaEnlazadaSimple<HashTable> tab =  (ListaEnlazadaSimple<HashTable>) bdatos.getTablas().get(tabla);
		Nodo<String> aux = nuevo_dato.getFirst();
		Nodo<HashTable> aux2 = tab.getFirst();
		while (aux != null) {
			aux2.getData().put(nuevo_dato.getFirst().getData(),aux.getData());
			
			
			aux = aux.getNext();
			aux2 = aux2.getNext();
			
			}
	
		
	}
	public static void eliminar_fila(String dato, String tabla,baseDeDatos bdatos) {
		/**
 * Este metodo se encarga de eliminar una fila por medio de listas enlazadas
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		ListaEnlazadaSimple<HashTable> tab =  (ListaEnlazadaSimple<HashTable>) (bdatos.getTablas().get(tabla));
		Nodo<HashTable> aux2 = tab.getFirst();
		while (aux2 != null) {
			aux2.getData().remove(dato);
			
			
			
			aux2 = aux2.getNext();
			}
		
		tab.print();
		System.out.println();
	}
		
	public void print(HashTable<String,HashTable> hash) {
		/**
 * Este metodo se encarga de imprimir el hashtable en pantalla
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		String response = "";
		
		Enumeration<String> keys = hash.keys();
		Enumeration<String> value = hash.elements();
		while(keys.hasMoreElements()) {
			response +=  keys.nextElement();
			response += " = " + value.nextElement();
			System.out.println(response);
			System.out.println();
			
		}
	}
	
	public static void eliminar_esquema(String nombre,baseDeDatos bdatos) {
		/**
 * Este metodo se encarga de eliminar un esquema
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
		
		bdatos.getTablas().remove(nombre);
		System.out.println(bdatos.getTablas());
		System.out.println();
		
		
	}
	
}


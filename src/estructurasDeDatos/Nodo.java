package estructurasDeDatos;

/**
 * Declaración de la clase Nodo
 * @author Victoria Ruiz Vargas
 * Algoritmos y Estructuras de Datos I
 */
public class Nodo <T> implements java.io.Serializable{
	/**
	 * Atributos de la clase Nodo
	 */
	private T data;
	private Nodo<T> next;
	
	/**
	 * Constructor de la clase Nodo que 
	 * inicializa los atributos en nulo
	 */
	public Nodo() {
		this.data = null;
		this.next = null;
	}
	
	/**
	 * Getter del atributo data
	 * @return el elemento dentro del nodo.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter del atributo data
	 * @param el elemento que se desea ingresar en el nodo
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Getter del atributo next
	 * @return el nodo que se encuentra contiguo al actual
	 */
	public Nodo<T> getNext() {
		return next;
	}

	/**
	 * Setter del atributo next
	 * @param el nodo que estará contiguo al actual
	 */
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}

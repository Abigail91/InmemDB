package estructurasDeDatos;

public class ListaEnlazadaSimple<T> implements java.io.Serializable {
			  		/**
 * Esta clase se encarga de manejar las lista enlazadas
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
	

		private int len;
		public Nodo <T> first;
		public String nombre;
		
		public ListaEnlazadaSimple() {
			len = 0;
		}
		
		public String getNombre() {
					  		/**
 * Este metodo se encarga de obtener el nombre
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			return nombre;
		}

		public void setNombre(String nombre) {
					  		/**
 * Este metodo se encarga de definir el nombre
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			this.nombre = nombre;
		}

		public void setLen(int len) {
					  		/**
 * Este metodo se encarga de definir el tamaño
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			this.len = len;
		}

		public int getLen() {
					  		/**
 * Este metodo se encarga de obteer el tamaño
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			return this.len;}

		public void addLast(T data) {
					  		/**
 * Este metodo se encarga de añadir al final de la lista
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			Nodo <T> newNodo = new Nodo <T>();
			newNodo.setData(data);
			if(this.first ==null) {
				this.setFirst(newNodo);
				len += 1;}
			else {
				Nodo <T> aux = this.getFirst();
				while (aux.getNext()!= null) {
					aux = aux.getNext();}
				aux.setNext(newNodo);
				len+=1;

			}

		}
		
		public void addLast(T data,String tipo) {
			Nodo <T> newNodo = new Nodo <T>();
			newNodo.setData(data);
			newNodo.setTipo(tipo);

			

			if(this.getFirst() == null) {

				this.setFirst(newNodo);
				len += 1;}
			else {
				Nodo <T> aux = this.getFirst();
				while (aux.getNext()!= null) {
					aux = aux.getNext();}
				aux.setNext(newNodo);
				len+=1;

			}

		}
		
		
		public void deleteLast() {
					  		/**
 * Este metodo se encarga de eliminar el ultimo objeto en la tabla
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			Nodo<T> aux = new Nodo<T>();
			aux = getFirst();

			if(this.getFirst()==null || len == 1 ) {

				setFirst(null);
			}
			else {
				while(aux.getNext().getNext()!=null){
					aux = aux.getNext();
				}
			aux.setNext(null);
			}
			len--;
		}
		
		public void print() {
					  		/**
 * Este metodo se encarga de impirimir en consola
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			Nodo aux = (Nodo) this.getFirst();
			while (aux != null) {
				System.out.println(aux.getData());
				aux = aux.getNext();}
			
		}

		public Nodo <T> getFirst() {
					  		/**
 * Este metodo se encarga de obtener el primer dato
 * @author: Abigail Abarca, Haziel Gudino, Daniel Nunez, Victoria Ruiz
 
 * @version: 5/22/2019
 
 */
			return first;
		}

		public void setFirst(Nodo <T> first) {
			this.first = first;
		}
		public void delete(String letra) {
			Nodo aux =  this.first;
			while(aux.getNext() != null) {
				if(aux.getNext().getData() == letra ) {
					Nodo next = aux.getNext().getNext();
					aux.setNext(next);
					break;
					
				}else {
					aux = aux.getNext();
				}
				
			}
		}
		public static void main(String args[]) {
			
			
		}
	}



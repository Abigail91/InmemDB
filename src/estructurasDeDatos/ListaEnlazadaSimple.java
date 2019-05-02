package estructurasDeDatos;

public class ListaEnlazadaSimple<T> {
	

		private int len;
		public Nodo <T> first;

		public ListaEnlazadaSimple() {
			len = 0;
			setFirst(null);}

		public boolean isEmpty() {
			return this.getFirst() == null; }

		public int getLen() {
			return this.len;}

		public void addLast(T data) {
			Nodo <T> newNodo = new Nodo <T>();
			newNodo.setData(data);
			if(isEmpty()) {
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
			Nodo<T> aux = new Nodo<T>();
			aux = getFirst();
			if(isEmpty() || len == 1 ) {
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
			Nodo aux = (Nodo) this.getFirst();
			while (aux != null) {
				System.out.println(aux.getData());
				aux = aux.getNext();}
			
		}

		public Nodo <T> getFirst() {
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



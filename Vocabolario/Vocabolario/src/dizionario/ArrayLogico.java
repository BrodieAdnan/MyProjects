package dizionario;

/**
 @author Riccardo Fusaro & Adnan Gazi Latif
 @date 28/03/2017
 @brief Contenitore di parole ordinate in base alla lunghezza.
 */
public class ArrayLogico<T>{
	int dim;//dimensione dell'array.
	int step;//numero di quanto allngare l'array.
	Object[] array;
	int length;

	public ArrayLogico(int dim, int step) { //costruttore più importante.
		try {
			this.dim = dim;
			this.step = step;
			array = new Object[dim];
		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException("Dimensioni sbagliate");
		}
	}

	public ArrayLogico(int dim) throws Exception {//richiamo al primo costruttore con step predefinito.
		this(dim, 4);
	}

	public ArrayLogico() throws Exception {//richiamo al primo costruttore con entrambi i valori predefiniti.
		this(10, 4);
	}

	public int length() {//dimensione effettivamente utilizzata.
		return length;
	}

	public Object get(int pos) {
		if (pos >= 0 && pos < length) {
			return array[pos];
		} else {
			throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'get'");
		}
	}

	public void set(int pos, int valore) {
		if (pos >= 0 && pos < length) {
			array[pos] = valore;
		} else {
			throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'set'");
		}
	}

	public void add(Object valore) {
		if (length == dim) {
			Object[] temp = new Object[dim + step];
			for (int i = 0; i < dim; i++) {
				temp[i] = array[i];
			}
			array = temp;
			dim += step;
		}
		array[length] = valore;
		length++;
	}

	public Object remove(int pos) {
		Object val = 0;
		if (pos >= 0 && pos < length) {
			val = array[pos];
			for (int i = pos + 1; i < length; i++) {
				array[i - 1] = array[i];
			}
			length--;
			if (dim - length > step + step / 2) {
				Object[] temp = new Object[dim - step];
				for (int i = 0; i < length; i++) {
					temp[i] = array[i];
				}
				array = temp;
				dim -= step;
			}
			return val;
		}
		throw new ArrayIndexOutOfBoundsException("Remove sbagliato");
	}
	public int ricerca(T elemento){
		int pos=0;
		for (;pos<length && !elemento.equals(array[pos]);pos++);
		return (pos<length)?pos:-1;
	}
	
}
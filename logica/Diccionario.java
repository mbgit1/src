package logica;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class Diccionario<K, V> {
	
	private Map<K, V> mapa;
	
	public Diccionario() {
		mapa = new TreeMap<K, V>();
	}
	
	public void poner(K clave, V valor) {
		mapa.put(clave, valor);
	}
	
	public V quitar(K clave) {
		return mapa.remove(clave);
	}
	
	public V obtener(K clave) {
		return mapa.get(clave);
	}
	
	public boolean contiene(K clave) {
		return mapa.containsKey(clave);
	}
	
	protected Iterator<V> iterador() {
		return mapa.values().iterator();
	}
	
	public int tamanio() {
		return mapa.size();
	}
}

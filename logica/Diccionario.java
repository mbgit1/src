package logica;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import configuracion.Configuracion;

@SuppressWarnings("serial")
public abstract class Diccionario<K, V> implements Serializable {
	
	private Map<K, V> mapa;
	
	public Diccionario() {
		mapa = new TreeMap<K, V>();
	}
	
	public void poner(K clave, V valor) {
		mapa.put(clave, valor);
		if( Configuracion.debug() ) {
			System.out.println( "Modificar alumno cedula: " + clave + ", domicilio: " + valor.toString() );
		}
	}
	
	public void ponerTodos(Diccionario<K, V> diccionario) {
		mapa.putAll( diccionario.mapa );
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

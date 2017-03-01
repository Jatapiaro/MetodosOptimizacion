import java.util.*;

public class Grafo{

	private HashMap<Key,Adyacencia> adyacencias;
	private HashMap<String,Nodo> nodos;

	public Grafo(){
		adyacencias = new HashMap<Key,Adyacencia>();
		nodos = new HashMap<String,Nodo>();
	}

	public void addDobleAdyacencia(String a,String b,float peso){
		this.addAdyacencia(a,b,peso);
		this.addAdyacencia(b,a,peso);
	}

	public void addAdyacencia(String a,String b,float peso){
		if(nodos.containsKey(a) && nodos.containsKey(b)){
			nodos.get(a).addAdyacencia(b);
			Key k = new Key(a,b);
			Adyacencia ad = new Adyacencia(a,b,peso);
			adyacencias.put(k,ad);
		}
	}

	public void addNodo(String nombreCiudad){
		Nodo n = new Nodo(nombreCiudad);
		nodos.put(nombreCiudad,n);
	}

	public String optimizacionHormiga(){

	}

}
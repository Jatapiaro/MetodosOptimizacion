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

	public String optimizacionHormiga(int numeroIteraciones,int numeroHormigas,String origen){
		if(nodos.containsKey(origen)){
			return optimizacion(numeroIteraciones,numeroHormigas,origen);
		}else{
			return "La ciudad que ingresaste no existe";
		}
	}

	private String optimizacion(int numeroIteraciones,int numeroHormigas,String origen){
		/*
		* Se pasara el string como un camino.
		* Si se encuentra uno igual se añadira +1 al contador
		*/
		HashMap<String,Integer> mejoresCaminos = new HashMap<String,Integer>();

		for(int x = 0;x<numeroIteraciones;x++){
			for(int y=0;y<numeroHormigas;y++){
				
				Hormiga h = new Hormiga(origen);
				

			}
		}
		return "";
	}

}
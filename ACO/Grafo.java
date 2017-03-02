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
				while(true){
					String aux = getNextPath(h.getNodoActual());
					if(aux.equals(origen)){
						/*
						*Si regreso al origen
						*detente
						*/
						if(h.getNumeroVisitados() == this.nodos.size()){
							String s = h.caminoToString();
							if(mejoresCaminos.containsKey(s)){
								 
							}
						}
						break;
					}else if(!aux.equals("")){
						Key k = new Key(h.getNodoActual(),aux);
						Adyacencia ad = adyacencias.get(k);
						h.addAcumulado(ad);
					}else{
						/*
						*Es decir que se visito todo lo que se pudo
						*pero no hay forma de regresar o llegar al origen
						*/
						numeroHormigas--;
						break;
						/*
						*Es decir ponemos a la hormiga a buscar 
						*un nuevo camino
						*/
					}
				}
			}
		}
		return "";
	}


	private String getNextPath(String actual){

		HashSet<String> ady = nodos.get(actual).getAdyacencias();
		List<AdyacenciaAuxiliar> l = new ArrayList<AdyacenciaAuxiliar>();
		float acumulado = 0.0f;

		Iterator it = ady.iterator();
		while(it.hasNext()){
			Key k = new Key(actual,(String)it.next());
			Adyacencia a = adyacencias.get(k);
			acumulado+=a.getVisibilidadPorFeromona();
		}
		
		/*while(it.hasNext()){
			Key k = new Key(actual,(String)it.next());
			Adyacencia a = adyacencias.get(k);
			AdyacenciaAuxiliar au =
			 new AdyacenciaAuxiliar(
			 	a.getIdOrigen(),a.getIdDestino(),suma,(suma+a.getPeso()));
			suma+=a.getPeso();
			l.add(au);
		}*/


		float random = (float)Math.random();

		for(AdyacenciaAuxiliar au : l){
			if(au.isSelected(random)){
				return au.getB();
			}
		}

		return "";
	}

}
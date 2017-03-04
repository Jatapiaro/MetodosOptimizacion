import java.util.*;

public class Grafo{

	private HashMap<Key,Adyacencia> adyacencias;
	private HashMap<String,Nodo> nodos;

	public Grafo(){
		adyacencias = new HashMap<Key,Adyacencia>();
		nodos = new HashMap<String,Nodo>();
	}

	public void addNodos(String[] arr){
		for(String a : arr){
			this.addNodo(a);
		}
	}

	public void addNodo(String a){
		if(!nodos.containsKey(a)){
			nodos.put(a,new Nodo(a));
		}
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


	public String optimizacionHormiga(int numeroIteraciones,int numeroHormigas,String origen){
		this.reset();
		if(nodos.containsKey(origen)){
			return optimizacion(numeroIteraciones,numeroHormigas,origen);
		}else{
			return "La ciudad que ingresaste no existe";
		}
	}

	private void reset(){
		Iterator it = this.adyacencias.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry pair = (Map.Entry)it.next();
		    Adyacencia a = (Adyacencia)pair.getValue();
		    a.reset();
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

				/*
				*Mientras haya camino
				*/
				while(true){
					String aux = getNextPath(h);
					if(aux.equals(origen)){
					Key k = new Key(h.getNodoActual(),aux);
						Adyacencia ad = adyacencias.get(k);
						h.addAcumulado(ad);
						/*
						*Si regreso al origen
						*detente
						*/
						if(h.getNumeroVisitados() == this.nodos.size()){

							String s = h.caminoToString();
							if(mejoresCaminos.containsKey(s)){
								int veces = mejoresCaminos.get(s);
								veces++;
								mejoresCaminos.put(s,veces);
							}else{
								mejoresCaminos.put(s,1);
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

				/*
				*Procedemos a actualizar las feromonas
				*/
				//float totalCamino = h.getAcumuladoCamino();

				Iterator it = this.adyacencias.entrySet().iterator();
				while (it.hasNext()) {
				    Map.Entry pair = (Map.Entry)it.next();
				    Adyacencia a = (Adyacencia)pair.getValue();
				    if(h.usoAdyacencia(a)){
				    	a.actualizarFeromona(a.getPeso());
				    }else{
				    	a.actualizarFeromona();
				    }
				}
				
			}
		}

		StringBuilder sb = new StringBuilder("-----Adyacencias y sus feromonas-----\n");
		Iterator fer = adyacencias.entrySet().iterator();
		while (fer.hasNext()) {
		    Map.Entry pair = (Map.Entry)fer.next();
		    sb.append(pair.getValue()+"\n");
		}

		System.out.println(sb.toString());

		if(mejoresCaminos.isEmpty()){
			return "No hay forma de completar el recorrido";
		}else{
			Iterator it = mejoresCaminos.entrySet().iterator();
			int mayor = -1;
			String mejorCamino = "";
			while (it.hasNext()) {
			    Map.Entry pair = (Map.Entry)it.next();
			    if((int)pair.getValue()>mayor){
			    	mejorCamino = (String)pair.getKey(); 
			    }
			    //System.out.println(pair.getKey() + " = " + pair.getValue());
			}
			return mejorCamino;
		}

	}


	private String getNextPath(Hormiga h){


		HashSet<String> ady = nodos.get(h.getNodoActual()).getAdyacencias();
		//System.out.println("Adyacencias de "+h.getNodoActual()+": "+ady);
		List<AdyacenciaAuxiliar> l = new ArrayList<AdyacenciaAuxiliar>();
		float acumulado = 0.0f;

		Iterator it = ady.iterator();
		while(it.hasNext()){

			String next = (String)it.next();
			if(!h.visitoNodo(next)){
				Key k = new Key(h.getNodoActual(),next);
				Adyacencia a = adyacencias.get(k);
				acumulado+=a.getVisibilidadPorFeromona();
			}

		}

		float probabilidadAcumulada = 0.0f;
		Iterator it2 = ady.iterator();
		while(it2.hasNext()){

			String next = (String)it2.next();
			if(!h.visitoNodo(next)){
				Key k = new Key(h.getNodoActual(),next);

				Adyacencia a = adyacencias.get(k);

				float probabilidadAdyacencia = a.getVisibilidadPorFeromona() / acumulado;

				AdyacenciaAuxiliar au = new AdyacenciaAuxiliar(
					a.getIdOrigen(),a.getIdDestino(),
					probabilidadAcumulada,(probabilidadAdyacencia+probabilidadAcumulada));

				l.add(au);

				probabilidadAcumulada+=probabilidadAdyacencia;
			}

		}
		

		float random = (float)Math.random();

		for(AdyacenciaAuxiliar au : l){

			if(au.isSelected(random)){
				//System.out.println(au.getB());
				return au.getB();
			}

		}

		return "";
	}

}
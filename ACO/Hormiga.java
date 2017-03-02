import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Hormiga{
	
	private HashSet<String> visitados;
	private List<Adyacencia> adyacenciasUtilizadas;
	private List<String> camino;
	private String nodoActual;
	private String nodoInicial;
	private int acumuladoCamino;

	public Hormiga(String nodoInicial){
		this.visitados = new HashSet<String>();
		this.camino = new ArrayList<String>();
		this.adyacenciasUtilizadas = new ArrayList<Adyacencia>();
		this.acumuladoCamino = 0;
		this.nodoActual = nodoInicial;
		this.nodoInicial = nodoInicial;
		this.camino.add(nodoInicial+"/0");
	}

	/*public void addAdyacencia(Adyacencia a){
		String destino = a.getIdDestino();
		float peso = a.getPeso();
		Adyacencia aux = new Adyacencia(this.nodoActual,destino,peso);
		adyacenciasUtilizadas.add(aux);
		visitados.add(destino);
	}*/

	public void setNodoActual(String nodoActual){
		this.nodoActual = nodoActual;
	}

	public String getNodoActual(){
		return this.nodoActual;
	}

	public int getAcumulado(){
		return this.acumuladoCamino;
	}

	private void addAcumulado(float peso){
		this.acumuladoCamino+=peso;
	}

	public void addAcumulado(Adyacencia a){
		this.addAcumulado(a.getPeso());
		this.adyacenciasUtilizadas.add(a);
		this.visitados.add(a.getIdDestino());
		this.camino.add(a.getIdDestino()+"/"+this.acumuladoCamino);
	}

	public int getNumeroVisitados(){
		return this.visitados.size();
	}

	public void reset(){
		this.acumuladoCamino = 0;
		this.nodoActual = null;
		this.adyacenciasUtilizadas = new ArrayList<Adyacencia>();
		this.visitados = new HashSet<String>();
	}

	public String caminoToString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<this.camino.size();i++){
			if(i == this.camino.size()-1){
				sb.append(camino.get(i));
			}else{
				sb.append(camino.get(i)+"->");
			}
		}
		return sb.toString();
	}

}
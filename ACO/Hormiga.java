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

	public String getNodoInicial(){
		return this.nodoInicial;
	}

	public void setNodoActual(String nodoActual){
		this.nodoActual = nodoActual;
	}

	public String getNodoActual(){
		return this.nodoActual;
	}

	public int getAcumuladoCamino(){
		return this.acumuladoCamino;
	}

	private void addAcumulado(float peso){
		this.acumuladoCamino+=peso;
	}

	public void addAcumulado(Adyacencia a){
		this.addAcumulado(a.getPeso());
		this.adyacenciasUtilizadas.add(a);
		this.visitados.add(a.getIdDestino());
		//System.out.println("Destino: "+a.getIdDestino());
		this.camino.add(a.getIdDestino()+"/"+this.acumuladoCamino);
		this.nodoActual = a.getIdDestino();
	}

	public List<Adyacencia> getAdyacenciasUtilizadas(){
		return this.adyacenciasUtilizadas;
	}

	public boolean usoAdyacencia(Adyacencia a){
		return (this.adyacenciasUtilizadas.contains(a))? true:false;
	}

	public boolean visitoNodo(String a){
		return (this.visitados.contains(a))? true:false;
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

	public HashSet<String> getVisitados(){
		return this.visitados;
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

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Adyacencia a : this.adyacenciasUtilizadas){
			sb.append(a+" : ");
		}
		return sb.toString();
	}

}
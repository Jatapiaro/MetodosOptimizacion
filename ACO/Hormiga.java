import java.util.List;
import java.util.ArrayList;

public class Hormiga{
	
	private List<String> visitados;
	private List<Adyacencia> caminosUtilizados;
	private String nodoActual;
	private String nodoInicial;
	private int acumuladoCamino;

	public Hormiga(String nodoInicial){
		this.visitados = new ArrayList<String>();
		this.caminosUtilizados = new ArrayList<Adyacencia>();
		this.acumuladoCamino = 0;
		this.nodoActual = null;
		this.nodoInicial = nodoInicial;
	}

	public void addAdyacencia(Adyacencia a){
		String destino = a.getIdDestino();
		float peso = a.getPeso();
		Adyacencia aux = new Adyacencia(this.nodoActual,destino,peso);
		caminosUtilizados.add(aux);
		visitados.add(destino);
	}

	public void setNodoActual(String nodoActual){
		this.nodoActual = nodoActual;
	}

	public int getAcumulado(){
		return this.acumuladoCamino;
	}

	public void addAcumulado(int peso){
		this.acumuladoCamino+=peso;
	}

	public void reset(){
		this.acumuladoCamino = 0;
		this.nodoActual = null;
		this.caminosUtilizados = new ArrayList<Adyacencia>();
		this.visitados = new ArrayList<String>();
	}

}
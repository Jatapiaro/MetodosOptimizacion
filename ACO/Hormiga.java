import java.util.List;
import java.util.ArrayList;

public class Hormiga{
	
	private List<Integer> visitados;
	private List<Adyacencias> caminosUtilizados;
	private int acumuladoCamino;

	public Hormiga(){
		this.visitados = new ArrayList<Integer>();
		this.caminosUtilizados = new ArrayList<Adyacencias>();
		this.acumuladoCamino = 0;
	}

	public int getAcumulado(){
		return this.acumuladoCamino;
	}

	public void addAcumulado(int peso){
		this.acumuladoCamino+=peso;
	}

}
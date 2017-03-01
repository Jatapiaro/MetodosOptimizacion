import java.util.HashSet;
public class Nodo{

	/*
	*nombre: Nombre de la ciudad
	*adyacencias: id del nodo adyacente y su peso
	*/

	private String nombre;
	private HashSet<String> adyacencias;

	public Nodo(String nombre){
		this.nombre = nombre;
		adyacencias = new HashSet<String>();
	}


	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void addAdyacencias(String[] ad){
		for(String a : ad){
			this.addAdyacencia(a);
		}
	}

	public void addAdyacencia(String a){
		this.adyacencias.add(a);
	}

	public HashSet<String> getAdyacencias(){
		return this.adyacencias;
	}

	@Override
	public boolean equals(Object other){
		return (((Nodo)other).getNombre().equals(this.nombre))? true:false;
	}

	@Override
	public String toString(){
		return this.nombre;
	}

}
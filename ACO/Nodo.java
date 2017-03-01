import java.util.HashMap;
public class Nodo{
	/*
	*id: ID del nodo
	*nombre: Nombre de la ciudad
	*adyacencias: id del nodo adyacente y su peso
	*/
	private int id;
	private String nombre;
	private HashMap<Integer,Double> adyacencias;

	public Nodo(int id,String nombre){
		this.id = id;
		this.nombre = nombre;
		adyacencias = new HashMap<Integer,Double>();
	}

	public int getId(){
		return this.id;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	public HashMap<Integer,Double> getAdyacencias(){
		return this.adyacencias;
	}

	@Override
	public boolean equals(Object other){
		return (((Nodo)other).getId() == this.id)? true:false;
	}

}
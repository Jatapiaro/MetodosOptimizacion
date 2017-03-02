public class Adyacencia{
	
	private String idOrigen,idDestino;
	private int constanteQ;
	private float peso,cantidadFeromona,tasaEvaporacion;

	public Adyacencia(String idOrigen,String idDestino,float peso){
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
		this.peso = peso;
		this.constanteQ = 1;
		this.cantidadFeromona = 0.1f;
		this.tasaEvaporacion = 0.01f;
	}

	public String getIdOrigen(){
		return this.idOrigen;
	}

	public String getIdDestino(){
		return this.idDestino;
	}

	public int getConstanteQ(){
		return this.constanteQ;
	}

	public void setConstanteQ(int constanteQ){
		this.constanteQ = constanteQ;
	}

	public float getCantidadFeromona(){
		return this.cantidadFeromona;
	}

	public void setTasaEvaporacion(float tasaEvaporacion){
		this.tasaEvaporacion = tasaEvaporacion;
	}

	public float getPeso(){
		return this.peso;
	}

	public float getVisibilidad(){
		return 1/this.peso;
	}

	public float getVisibilidadPorFeromona(){
		return this.getVisibilidad()*this.cantidadFeromona;
	}

	public void actualizarFeromona(float totalCamino){
		//(1-tasaEvaporacion)*cantidadFeromona
		float aux = (1-tasaEvaporacion)*this.cantidadFeromona;
		this.cantidadFeromona = aux + (float)(constanteQ/totalCamino);
	}

	public void actualizarFeromona(){
		/*
		*Este se usa cuando el recorrido no
		*utiliza esta adyacencia
		*/
		this.cantidadFeromona = (1-tasaEvaporacion)*this.cantidadFeromona;
	}

	public void reset(){
		this.cantidadFeromona = 0.1f;
		this.tasaEvaporacion = 0.01f;
	}

	@Override
	public boolean equals(Object o){
		Adyacencia other = (Adyacencia)o;
		if(other.getIdOrigen().equals(this.idOrigen) && 
			other.getIdDestino().equals(this.idDestino)){
			return true;
		}else{
			return false;
		}
	}

}
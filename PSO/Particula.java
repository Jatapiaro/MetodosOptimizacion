import java.util.Random;
public class Particula implements Comparable<Particula>{
	
	public Punto posicionActual,posicionMejor;
	public float velocidad;

	public Particula(float a,float b){
		Random r = new Random();
		posicionActual = new Punto(a,b);
		float x = posicionActual.getX();
		float y = posicionActual.getY();
		float z = posicionActual.getZ();
		posicionMejor = new Punto(x,y,z);
		velocidad = r.nextFloat();
	}

	public Punto getPosicionActual(){
		return this.posicionActual;
	}

	public Punto getPosicionMejor(){
		return this.posicionMejor;
	}

	@Override
	public String toString(){
		return ""+posicionActual;
	}

	@Override
	public int compareTo(Particula other){
		/*
		* si este es menor que el argumento -> -1
		* si este mayor que el argumento -> 1
		*/
		if(this.posicionActual.getEvaluacion() == other.getPosicionActual().getEvaluacion()){
			return 0;
		}else if(this.posicionActual.getEvaluacion() < other.getPosicionActual().getEvaluacion()){
			return -1;
		}else{
			return 1;
		}
	}

}
import java.util.Random;
public class Particula implements Comparable<Particula>{
	
	
	private Punto posicionActual,posicionMejor;

	public Particula(float a,float b){
		
		posicionActual = new Punto(a,b);
		float x = posicionActual.getX();
		float y = posicionActual.getY();
		float z = posicionActual.getZ();
		posicionMejor = new Punto(x,y,z);

	}

	public Punto getPosicionActual(){
		return this.posicionActual;
	}

	public Punto getPosicionMejor(){
		return this.posicionMejor;
	}

	public void updateData(Particula gBest){
		posicionActual.updateData(posicionMejor,gBest.getPosicionMejor());
	}

	public void updatePersonalBest(float evaluacion){
		if(evaluacion<this.posicionMejor.getEvaluacion()){
			float x = this.posicionActual.getX();
			float y = this.posicionActual.getY();
			float z = this.posicionActual.getZ();
			this.posicionMejor.setXYZ(x,y,z);
		}
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
		if(this.posicionMejor.getEvaluacion() == other.getPosicionMejor().getEvaluacion()){
			return 0;
		}else if(this.posicionMejor.getEvaluacion() < other.getPosicionMejor().getEvaluacion()){
			return -1;
		}else{
			return 1;
		}
	}

}
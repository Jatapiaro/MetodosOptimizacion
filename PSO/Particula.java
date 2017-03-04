import java.util.Random;
public class Particula implements Comparable<Particula>{
	
	private static Random r = new Random();
	private Punto posicionActual,posicionMejor;
	private float velocidad;

	public Particula(float a,float b){
		
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

	public void updateVelocity(Particula globalBest,int numeroIteracion){
		/*
		*vi = vi +r1(pi −xi)+r2(pg −xi)
		*/

		/*
		*  c1 = random*(mejorParticula-posicionActual)
		*  c2 = random*(mejorGlobal-posicionActual)
		* ¿Posición compuesta por 3 valores?, ¿Cómo se hace?
		*/
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
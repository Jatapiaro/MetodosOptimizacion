import java.util.*;
public class ParticleSwarmOptimization{

	private PriorityQueue<Particula> particulas;

	public ParticleSwarmOptimization(){
		particulas = new PriorityQueue<Particula>();
	}

	public void PSO(int numeroIteraciones, int numeroParticulas,float a,float b){
		this.reset();
		this.crearParticulas(numeroParticulas,a,b);
		//System.out.println(particulas.peek());
	}

	private void crearParticulas(int numeroParticulas,float a,float b){
		for (int i=0;i<numeroParticulas;i++){
			Particula p = new Particula(a,b);
			float eval = funcionObjetivo(p);
			p.getPosicionActual().setEvaluacion(eval);
			p.getPosicionMejor().setEvaluacion(eval);
			//System.out.println(p);
			particulas.add(p);
		}
	}

	private void reset(){
		particulas = new PriorityQueue<Particula>();
	}

	private float funcionObjetivo(Particula particula){
		Punto p = particula.getPosicionActual();
		return -(funcionObjetivo(p.getX()) + funcionObjetivo(p.getY()) + funcionObjetivo(p.getZ()));
	}

	private float funcionObjetivo(float x){
		return x * (float)Math.sin(Math.sqrt(Math.abs(x)));
	}

}
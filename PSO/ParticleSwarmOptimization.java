import java.util.*;
public class ParticleSwarmOptimization{

	private PriorityQueue<Particula> particulas;

	public ParticleSwarmOptimization(){
		particulas = new PriorityQueue<Particula>();
	}

	public void PSO(int numeroIteraciones, int numeroParticulas,float a,float b){
		this.reset();
		this.crearParticulas(numeroParticulas,a,b);
		Particula lider = this.particulas.peek();
		for(int x=0;x<numeroIteraciones;x++){

			//System.out.println("Líder: "+lider);

			Iterator<Particula> it = particulas.iterator();
			while (it.hasNext()) {
			    Particula p = it.next();
			    p.updateData(lider);
			    float eval = funcionObjetivo(p);
			    p.updatePersonalBest(eval);
			}
			lider = this.particulas.peek();
		}

		/*Iterator<Particula> it = particulas.iterator();
		while (it.hasNext()) {
		    Particula p = it.next();
		    System.out.println(p);
		}*/

		System.out.println(particulas.peek());

	}

	private void crearParticulas(int numeroParticulas,float a,float b){
		for (int i=0;i<numeroParticulas;i++){
			Particula p = new Particula(a,b);
			float eval = funcionObjetivo(p);
			p.getPosicionActual().setEvaluacion(eval);
			p.getPosicionMejor().setEvaluacion(eval);
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
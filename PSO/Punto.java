import java.util.Random;
public class Punto implements Comparable<Punto>{

	private float x,y,z,evaluacion;
	
	public Punto(float a,float b){

		Random random = new Random();
		this.x = a + (random.nextFloat() * (b - a));
		this.y = a + (random.nextFloat() * (b - a));
		this.z = a + (random.nextFloat() * (b - a));
		this.evaluacion = 0.0f;

	}

	public void setEvaluacion(float evaluacion){
		this.evaluacion = evaluacion;
	}

	public float getEvaluacion(){
		return this.evaluacion;
	}

	public Punto(float x,float y,float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}

	public float getZ(){
		return this.z;
	}

	@Override
	public String toString(){
		return "[ "+this.x+" , "+this.y+" , "+this.z+" ] -> "+this.evaluacion;
	}

	@Override
	public int compareTo(Punto other){
		if(this.evaluacion == other.getEvaluacion()){
			return 0;
		}else if(this.evaluacion < other.getEvaluacion()){
			return -1;
		}else{
			return 1;
		}
	}

}
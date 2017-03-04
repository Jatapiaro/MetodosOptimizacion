import java.util.Random;
public class Punto implements Comparable<Punto>{

	private static Random random = new Random();
	private float x,y,z,velocidadX,velocidadY,
	velocidadZ,evaluacion;
	private float a,b,vmin,vmax;
	
	public Punto(float a,float b){

		this.x = a + (random.nextFloat() * (b - a));
		this.y = a + (random.nextFloat() * (b - a));
		this.z = a + (random.nextFloat() * (b - a));

		this.vmin = a*0.10f;
		this.vmax = b*0.10f;

		this.velocidadX = (random.nextFloat() * (vmax - vmin));
		this.velocidadY = (random.nextFloat() * (vmax - vmin));
		this.velocidadZ = (random.nextFloat() * (vmax - vmin));

		this.evaluacion = 0.0f;

		this.a = a;
		this.b = b;

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

	public void updateData(Punto pbest,Punto gbest){
		updateVelocity(pbest,gbest);
		updatePosition();
	}

	private void updateVelocity(Punto pbest, Punto gbest){
		
		float uX = random.nextFloat()*(pbest.getX()-this.x);
		float uX2 = random.nextFloat()*(gbest.getX()-this.x);
		velocidadX+=uX+uX2;

		if(!velocityOnRange(velocidadX)){
			velocidadX = checkRangeV(velocidadX);
		}

		float uY = random.nextFloat()*(pbest.getY()-this.y);
		float uY2 = random.nextFloat()*(gbest.getY()-this.y);
		velocidadY+=uY+uY2;

		if(!velocityOnRange(velocidadY)){
			velocidadY = checkRangeV(velocidadY);
		}

		float uZ = random.nextFloat()*(pbest.getZ()-this.z);
		float uZ2 = random.nextFloat()*(gbest.getZ()-this.z);
		velocidadZ+=uZ+uZ2;

		if(!velocityOnRange(velocidadZ)){
			velocidadZ = checkRangeV(velocidadZ);
		}

	}

	private void updatePosition(){
		this.x+=velocidadX;
		this.y+=velocidadY;
		this.z+=velocidadZ;
		if(!onRange(this.x)){
			this.x = checkRange(this.x);
			this.velocidadX*=-1;
		}
		if(!onRange(this.y)){
			this.y = checkRange(this.y);
			this.velocidadY*=-1;
		}
		if(!onRange(this.z)){
			this.z = checkRange(this.z);
			this.velocidadZ*=-1;
		}
	}

	private float checkRange(float t){
		if(t<a && t<=b){
			return a + Math.abs(t-a);
		}else if(t>b && t>=a){
			return b + Math.abs(t-b);
		}
		return 0;
	}

	private boolean onRange(float t){
		return (t>=a && t<=b);
	}

	private boolean velocityOnRange(float t){
		return (t>=this.vmin && t<=this.vmax);
	}

	private float checkRangeV(float t){
		if(t<this.vmin && t<=this.vmax){
			return vmin;
		}else if(t>this.vmax && t>=this.vmin){
			return vmax;
		}
		return 0;
	}



	public void setXYZ(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
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
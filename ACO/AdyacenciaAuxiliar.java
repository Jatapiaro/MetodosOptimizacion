/*
*Solo se usa para mantener control
*de la probabilidad acumulada
*cuando se toma una desición de camino
*/
public class AdyacenciaAuxiliar{
	
	private String a,b;
	private float pA,pB;

	public AdyacenciaAuxiliar(String a,String b,float pA,float pB){
		this.a = a;
		this.b = b;
		this.pA = pA;
		this.pB = pB;
	}

	public boolean isSelected(float p){
		if(p>pA && p<=pB){
			return true;
		}else{
			return false;
		}
	}

	public String getB(){
		return this.b;
	}

	@Override
	public String toString(){
		return ""+this.a+"->"+this.b;
	}

}
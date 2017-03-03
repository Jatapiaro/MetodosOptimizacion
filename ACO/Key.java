/**
*Clase para poder
*usar una clave doble 
*en un hashmap
*/
public class Key{

	private final String a,b;

	public Key(String a,String b){
		this.a = a;
		this.b = b;
	}

	public String getA(){
		return this.a;
	}

	public String getB(){
		return this.b;
	}

	@Override
	public String toString(){
		return "["+this.a+","+this.b+"]";
	}

	@Override
	public boolean equals(Object o) {
	    Key key = (Key) o;
	    return this.a.equals(key.getA()) && this.b.equals(key.getB());
	}

	@Override
	public int hashCode() {
		return (a+b).hashCode();
	}
}
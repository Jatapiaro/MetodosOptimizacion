import java.util.*;
public class Test{
	public static void main(String[] args) {
		String s = "Caballo";
		String r = "Loco";

		HashSet<Nodo> hs = new HashSet<Nodo>();
		Nodo n = new Nodo(s);
		Nodo o = new Nodo(r);
		Nodo d = new Nodo("CaBaLlo");
		Nodo t = new Nodo("loco");
		hs.add(n);
		hs.add(o);
		hs.add(d);
		hs.add(t);
		Iterator iterator = hs.iterator(); 
		   
		// check values
		while (iterator.hasNext()){
			System.out.println("Value: "+iterator.next() + " ");  
		}
	}
}
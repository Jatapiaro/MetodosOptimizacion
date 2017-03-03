import java.util.*;
public class Test{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Grafo gf = new Grafo();
		String[] arr = {"A","B","C","D","E","F","G"};
		gf.addNodos(arr);

		gf.addDobleAdyacencia("A","B",15.0f);
		gf.addDobleAdyacencia("A","D",15.0f);

		gf.addDobleAdyacencia("D","E",7.0f);

		gf.addDobleAdyacencia("E","B",12.0f);
		gf.addDobleAdyacencia("E","F",50.0f);

		gf.addDobleAdyacencia("B","C",10.0f);

		gf.addDobleAdyacencia("C","G",20.0f);

		gf.addDobleAdyacencia("G","F",5.0f);

		while(true){
			int nIteraciones,nHormigas;
			String origen;
			System.out.println(
				"Ingresa (#Iteraciones #Hormigas NombreNodo) separados por un espacio:\n");
			nIteraciones = sc.nextInt();
			nHormigas = sc.nextInt();
			origen = sc.next();
			if(nIteraciones+nHormigas != 0){
				System.out.println("Camino: "+gf.optimizacionHormiga(nIteraciones,nHormigas,origen)+"\n");
			}else{
				break;
			}
		}

	}
}
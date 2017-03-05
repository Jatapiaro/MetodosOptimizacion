import java.util.*;
public class Test{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Grafo gf = new Grafo();
		/*String[] arr = {
			"C1","C2","C3","C4","C5","C6","C7","C8","C9","C10",
			"C11","C12","C13","C14","C15","C16","C17","C18","C19","C20",
			"C21","C22","C23","C24","C25","C26","C27","C28","C29","C30",
			"C31","C32","C33","C34","C35","C36","C37","C38","C39","C40"
			};
		gf.addNodos(arr);

		gf.addDobleAdyacencia("C1","C2",10.0f);
		gf.addDobleAdyacencia("C1","C3",32.0f);
		gf.addDobleAdyacencia("C1","C4",44.0f);
		gf.addDobleAdyacencia("C1","C5",12.0f);
		gf.addDobleAdyacencia("C1","C6",64.0f);

		gf.addDobleAdyacencia("C2","C3",10.24f);
		gf.addDobleAdyacencia("C2","C7",12.0f);
		gf.addDobleAdyacencia("C2","C8",11.0f);
		gf.addDobleAdyacencia("C2","C9",9.0f);
		gf.addDobleAdyacencia("C2","C6",70.0f);

		gf.addDobleAdyacencia("C3","C10",1.0f);
		gf.addDobleAdyacencia("C3","C4",3.0f);

		gf.addDobleAdyacencia("C4","C10",58.0f);
		gf.addDobleAdyacencia("C4","C5",58.0f);

		gf.addDobleAdyacencia("C5","C11",23.0f);

		gf.addDobleAdyacencia("C6","C12",14.02f);
		gf.addDobleAdyacencia("C6","C13",12.0f);
		gf.addDobleAdyacencia("C6","C14",15.02f);

		gf.addDobleAdyacencia("C7","C8",12.02f);
		gf.addDobleAdyacencia("C8","C9",12.24f);

		gf.addDobleAdyacencia("C9","C10",12.24f);

		gf.addDobleAdyacencia("C10","C11",14.2f);
		gf.addDobleAdyacencia("C10","C15",14.2f);

		gf.addDobleAdyacencia("C11","C20",10.0f);
		gf.addDobleAdyacencia("C11","C12",13.4f);

		gf.addDobleAdyacencia("C12","C13",7.0f);

		gf.addDobleAdyacencia("C13","C14",8.0f);

		gf.addDobleAdyacencia("C15","C16",3.0f);
		gf.addDobleAdyacencia("C15","C17",4.0f);
		gf.addDobleAdyacencia("C15","C18",5.0f);
		gf.addDobleAdyacencia("C15","C19",6.0f);

		gf.addDobleAdyacencia("C16","C17",4.0f);

		gf.addDobleAdyacencia("C17","C18",8.0f);

		gf.addDobleAdyacencia("C18","C19",7.0f);

		gf.addDobleAdyacencia("C19","C20",15.0f);

		gf.addDobleAdyacencia("C20","C21",10.0f);
		gf.addDobleAdyacencia("C20","C22",12.0f);
		gf.addDobleAdyacencia("C20","C23",14.0f);
		gf.addDobleAdyacencia("C20","C24",22.0f);
		gf.addDobleAdyacencia("C20","C25",22.0f);
		gf.addDobleAdyacencia("C20","C26",14.0f);
		gf.addDobleAdyacencia("C20","C27",12.0f);
		gf.addDobleAdyacencia("C20","C28",15.0f);
		gf.addDobleAdyacencia("C20","C29",22.0f);
		gf.addDobleAdyacencia("C20","C30",15.0f);

		gf.addDobleAdyacencia("C30","C31",23.0f);
		gf.addDobleAdyacencia("C30","C29",13.0f);

		gf.addDobleAdyacencia("C29","C32",12.0f);
		gf.addDobleAdyacencia("C29","C28",13.0f);


		gf.addDobleAdyacencia("C28","C33",12.0f);
		gf.addDobleAdyacencia("C28","C27",14.0f);

		gf.addDobleAdyacencia("C27","C34",12.0f);
		gf.addDobleAdyacencia("C27","C26",21.0f);

		gf.addDobleAdyacencia("C26","C35",12.0f);
		gf.addDobleAdyacencia("C26","C25",11.0f);

		gf.addDobleAdyacencia("C25","C24",2.0f);
		gf.addDobleAdyacencia("C25","C36",4.0f);

		gf.addDobleAdyacencia("C24","C23",11.0f);
		gf.addDobleAdyacencia("C24","C37",11.0f);


		gf.addDobleAdyacencia("C23","C22",2.0f);
		gf.addDobleAdyacencia("C23","C38",11.0f);

		gf.addDobleAdyacencia("C22","C21",11.0f);
		gf.addDobleAdyacencia("C22","C39",11.0f);

		gf.addDobleAdyacencia("C40","C21",2.0f);

		gf.addDobleAdyacencia("C40","C39",3.0f);

		gf.addDobleAdyacencia("C39","C38",3.0f);

		gf.addDobleAdyacencia("C38","C37",4.0f);

		gf.addDobleAdyacencia("C37","C36",4.0f);

		gf.addDobleAdyacencia("C36","C35",1.0f);

		gf.addDobleAdyacencia("C35","C34",2.0f);

		gf.addDobleAdyacencia("C34","C33",4.0f);

		gf.addDobleAdyacencia("C33","C32",4.0f);

		gf.addDobleAdyacencia("C32","C31",4.0f);*/


		//System.out.println(gf.optimizacionHormiga(10,50,"A"));


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

		System.out.println(gf.optimizacionHormiga(100,50,"A"));

	}
}
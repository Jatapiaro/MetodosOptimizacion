import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class Main{
	public static void main(String[] args) {

		Grafo gf = new Grafo();

		HashMap<Character,Integer> heuristic = new HashMap<Character,Integer>();
		heuristic.put('A',0);
		heuristic.put('B',0);
		heuristic.put('C',0);
		heuristic.put('D',0);
		heuristic.put('E',0);
		heuristic.put('F',0);
		heuristic.put('G',0);

		//gf.setHeuristic(heuristic);

		Nodo a = new Nodo('A');
		Nodo b = new Nodo('B');
		Nodo c = new Nodo('C');
		Nodo d = new Nodo('D');
		Nodo e = new Nodo('E');
		Nodo f = new Nodo('F');
		Nodo g = new Nodo('G');

		Nodo[] nodos = {a,b,c,d,e,f,g};

		gf.addNodos(nodos);


		gf.addAdyacenteBi('A','B',10);
		gf.addAdyacenteBi('A','D',15);

		gf.addAdyacenteBi('D','E',7);

		gf.addAdyacenteBi('E','B',12);
		gf.addAdyacenteBi('E','F',50);

		gf.addAdyacenteBi('B','C',10);

		gf.addAdyacenteBi('C','G',20);

		gf.addAdyacenteBi('G','F',5);

		System.out.println(gf.aStar('A',heuristic));
	}

}
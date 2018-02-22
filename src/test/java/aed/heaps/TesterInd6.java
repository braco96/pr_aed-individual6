package aed.heaps;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

import net.datastructures.ArrayListCompleteBinaryTree;
import net.datastructures.BinaryTree;
import net.datastructures.Position;

/**
 * @author Guillermo Roman
 *
 */

public class TesterInd6 {

	public static void main(String[] args) {

		try {
			String[] ids = ManagementFactory.getRuntimeMXBean().getName()
					.split("@");
			BufferedWriter bw = new BufferedWriter(new FileWriter("pid"));
			bw.write(ids[0]);
			bw.close();
		} catch (Exception e) {
			System.out.println("Avisa al profesor de fallo sacando el PID");
			throw new Error (e); 
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,2,3,4,5,6});
			boolean expected = true;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {6,2,3,4,5,1});
			boolean expected = false;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,1,1,1,1,1});
			boolean expected = true;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {6,5,4});
			boolean expected = false;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {});
			boolean expected = true;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,2,2,2,5,6});
			boolean expected = true;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,2,3,4,5,6,7,8});
			boolean expected = true;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,4,3,2,5,6,7,8});
			boolean expected = false;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,2,3,8,5,6,7,4});
			boolean expected = false;
			doCheck(tree, expected);
		}

		{
			MyHeap<Integer> tree = new MyHeap<Integer>(new Integer[] {1,2,3,4,5,6,7,4});
			boolean expected = true;
			doCheck(tree, expected);
		}

		System.out.println("\n TesterInd6: Test finalizado correctamente.");
	}




	/**
	 * Método que prueba el resultado obtenido con el resultado esperado
	 * @param tree Árbol de entrada
	 * @param expected Resultado esperado
	 * @param exception ¿debe lanzar una excepción?
	 */
	static void doCheck(BinaryTree<Integer> tree, boolean expected) {

		try {
			int size = tree.size(); 
			boolean result = HeapOrderChecker.satisfiesHeapOrderProperty(tree); 
			if (expected != result) {
				throw new Exception ("ERROR: Resultado recibido " + result + " cuando se esperaba " + expected); 
			}

			if (tree.size() != size) {
				throw new Error("Se ha cambiado el tamaño del árbol de entrada!!!");		
			}
		} catch (Exception exc) {
			System.out.println("ERROR: Con el árbol");
			System.out.println(tree);
			System.out.println("\n*** TesterInd5 Error: devuelve la siguiente excepcion \n");
			exc.printStackTrace();

			throw new Error("Error en test: resultado incorrecto");		
		}
	}

}

class MyHeap<E> extends ArrayListCompleteBinaryTree<E> {

	public MyHeap (E [] data) {
		super(); 
		for (E e: data) {
			add(e); 
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer (); 

		toString(this.root(),"",false,buffer);
		return buffer.toString();
	}
	public void toString(Position<E> c, 
			String prefix, 
			boolean isTail,
			StringBuffer buffer) {

		buffer.append(prefix + (isTail ? "|-- " : "|-- ") + c.element() + "\n");
		Iterator<Position<E>> it = this.children(c).iterator();
		Position<E> child = null; 
		while(it.hasNext()) {
			child = it.next(); 
			if (it.hasNext()) // Si no es el último hijo
				this.toString(child,prefix + (isTail ? "    " : "|   "), false, buffer);

		}
		if (!isExternal(c)) {
			this.toString(child,prefix + (isTail ?"    " : "|   "), true, buffer);
		}

	}

}
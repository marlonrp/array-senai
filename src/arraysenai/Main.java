package arraysenai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		ArraySenai a = new ArraySenai();
		List<Integer> b = new ArrayList<Integer>();
		
		System.out.println("Tamanho inicial");
		System.out.println("A: " + a.size());
		System.out.println("B: " + b.size());
		System.out.println("-----------------------------------");
		
		a.add(0);
//		a.add(9, 99); // erro
		a.add(1);
		a.add(1, 2);
		a.add(3, 3);
		a.add(0, 4);
		
		b.add(0);
//		b.add(9, 10); // erro
		b.add(1);
		b.add(1, 2);
		b.add(3, 3);
		b.add(0, 4);

		// Inserção de bloco
		int val = 4;
		int aux = -1;		
		for (int i = 0; i < aux; i++) {
			++val;
			a.add(val);
			b.add(val);
		}
//		a.add(20);

		int sizeA = a.size();
		System.out.println("Size A = " + sizeA);
		System.out.println("-------");
		
		for (int i = 0; i < sizeA; i++) {
			System.out.println(i + " - " + a.get(i));
			System.out.println("-------");
		}
		
		System.out.println("-----------------------------------");
		
		int sizeB = b.size();
		System.out.println("Size B = " + sizeB);
		System.out.println("-------");
		
		for (int i = 0; i < sizeB; i++) {
			System.out.println(i + " - " + b.get(i));
			System.out.println("-------");
		}
	}

}

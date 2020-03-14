package arraysenai;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		ArraySenai<Integer> a = new ArraySenai<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		System.out.println("Tamanho inicial");
		System.out.println("A: " + a.size());
		System.out.println("B: " + b.size());
		System.out.println("-----------------------------------");
		
		a.add(0);
		a.add(1);
		a.add(1, 2);
		a.add(3, 3);
		a.add(0, 4);
		a.add(5);
//		a.add(6);
//		a.add(7);
		a.add(44);
		a.add(9);
//		a.add(10); // erro se resizable false
//		a.clear();
//		System.out.println("clear-size - " + a.size());
		System.out.println(a.isEmpty()); // false
		System.out.println(a.isFull()); // true
		a.set(0, 44);
		System.out.println(a.get(7)); // 7
		System.out.println(a.indexOf(44)); // 0
		System.out.println(a.indexOf(444)); // -1
		System.out.println(a.contains(444)); // false
		System.out.println(a.contains(44)); // true
		System.out.println(a.lastIndexOf(44)); // 8
		System.out.println(a.lastIndexOf(444)); // -1
		b.add(0);
//		b.add(9, 10); // erro
		b.add(1);
		b.add(1, 2);
		b.add(3, 3);
		b.add(0, 4);

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
		
		System.out.println("-----------------------------------");
		System.out.println(a.toArray());
		for (Object x : a.toArray()) {
			System.out.println(x);
		}
//		Integer[] c = a.toArray();
//		for (Integer f : c) {
//			System.out.println(f);
//		}
	}

}

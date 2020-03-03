package arraysenai;

public class Main {

	public static void main(String[] args) throws Exception {
		ArraySenai a = new ArraySenai();
		
		System.out.println(a.getSize());
		System.out.println("-------");
		
		a.add(5);
//		a.add(2, 10);
//		a.add(15);
//		a.add(20);
//		a.add(3, 25);
//		for (int i = 0; i < 5; i++) {
//			a.add(i);
//		}
		a.add(15, 99);
		
		for (int i = 0; i < a.getSize(); i++) {
			System.out.println(i + " - " + a.get(i));
			System.out.println("-------");
		}
	}

}

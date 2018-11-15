
public class MainClass {

	public static void main(String[] args) {
		Board b1 = new Board();
		while (b1.line('X')== false || b1.line('O')== false) {
		System.out.println(b1.toString());
		b1.shoot();
		System.out.println(b1.toString());
		}
		System.out.println("You win");
	}

}

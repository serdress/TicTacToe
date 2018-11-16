
public class MainClass {

	public static void main(String[] args) {
		Board b1 = new Board();
		
		while (b1.line(b1.getPlayerSymbol())== false) {
		System.out.println("TURN: " + b1.getTurn());
		b1.shoot();
		System.out.println(b1.toString());
		}
		System.out.println("You win");
	}
}

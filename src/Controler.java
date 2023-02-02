/* Fråga1
 * Om vi har bitrate 3 och packet storlek 4bits. tar det två cyklar
 * skicka den eller kan vi skicka 2 bits av nästa packet på samma 
 * cykel?
 * 
 * Fråga2
 * Om en node har fått ett packet på en klock cykel kan den skicka 
 * vidare den på samma klockcykel?
 * 
 * */


public class Controler {
	
	static Node a = new NodeFCFS(10);
	static Node b = new NodeEDF(5);
	static Node c = new NodeSave(0,"dataFile");
	static Generator g = new Generator(a,2,20,10);

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			g.update(i);
			a.send(b,i);
			b.send(c,i);
			System.out.println("time:" + i + "  " + a);
			System.out.println("time:" + i + "  " + b);
			System.out.println("time:" + i + "  " + c);
			System.out.println();

		}
	}
}

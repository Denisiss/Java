import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String args[]) {
		Cont c = new Cont("123RO",150);
		Random r = new Random();
		ArrayList<Client> l = new ArrayList<>();
		int n = 2+r.nextInt(10);
		for(int i=1;i<n;i++) {
			l.add(new Client("client " + i, c));
		}
		for(Client something:l) {
			Thread t =new Thread(something);
			t.start();
		}
		
		Cuvant cuv = new Cuvant("abcdefg");
		Thread t1 = new Thread(new Consumator(1,cuv));
		
		Thread t2 = new Thread(new Consumator(2,cuv));
		
		t1.start();
		t2.start();
		
		while(t1.isAlive());
		while(t2.isAlive());
		
		System.out.println("End main");
	}
}

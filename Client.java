import java.util.Random;

public class Client implements Runnable {

	String nume;
	Cont Cont_Client;
	static final Random r = new Random();

	public Client(String nume, Cont c) {
		this.nume = nume;
		this.Cont_Client = c;
	}

	public void run() {
		while (Cont_Client.get_Sum() > 0) {
			if (r.nextInt() % 2 == 0) {
				int d = r.nextInt(10);
				try {
					Cont_Client.retragere(d);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Clientul: " + this.nume + " a depus " + d + " RON in cont. Suma actualizata: "
						+ Cont_Client.get_Sum());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int d = r.nextInt(10);
				try {
					Cont_Client.depune(d);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Clientul: " + this.nume + " a retras " + d + " RON din cont. Suma actualizata: "
						+ Cont_Client.get_Sum());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

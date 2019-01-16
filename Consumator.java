

public class Consumator implements Runnable {

	int type;
	String c = " ";
	Cuvant cuv;

	public void run() {
		// TODO Auto-generated method stub
		Character x;
		while((x = cuv.getChar(type))!=null) {
			c+=x;
		}
		display();
		
	}
	
	public Consumator(int type,Cuvant cuv) {
		this.type=type;
		this.cuv=cuv;
	}

	public void display() {
		System.out.println("Cuvant " + c);
	}
}


public class Cont {
	double Sum_Exist;
	String IBAN;
	boolean accesibil=true;
	
	private synchronized void acces() {
		try {
			while(!accesibil) {
				wait();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
			accesibil=false;
		}
	}
	
	private synchronized void elibereazaAcces() {
		accesibil=true;
		notifyAll();
	}
	
	public Cont(String IBAN,double sum) {
		this.IBAN=IBAN;
		this.Sum_Exist=sum;
		System.out.println("S-a creat contul.");
	}
	
	public double get_Sum() {
		return this.Sum_Exist;
	}
	
	void depune(double s) throws Exception {
		if(s<0)
			throw new Exception("Suma negativa.");
		acces();
		this.Sum_Exist+=s;
		elibereazaAcces();
	}
	
	void retragere(double s)throws Exception{
		if(s>this.Sum_Exist || s<0)
			throw new Exception("Nu se poate retrage o suma negativa.//Nu sunt destui bani.");
		acces();
		this.Sum_Exist-=s;
		elibereazaAcces();
	}
}


public class Cuvant {
	String cuvant;
	int first, last;

	public synchronized Character getChar(int something) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (first > last && first < cuvant.length())
			return null;
		if (something == 1) {
			first++;
			System.out.println("first " + first);
			return cuvant.charAt(first);
		} else {
			last--;
			System.out.println("last " + last);
			
			return cuvant.charAt(last);
		}
	}

	public Cuvant(String cuvant) {
		this.cuvant = cuvant;
		first = -1;
		last = cuvant.length();
	}
}

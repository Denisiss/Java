
public class Student {
	String nume,Prenume;
	Grupa grupa_student;
	
	public Student(String Nume,String Prenume, Grupa a) {
		this.nume=Nume;
		this.Prenume=Prenume;
		grupa_student = a;
	}
	public Student(String Nume,String Prenume) {
		this.nume=Nume;
		this.Prenume=Prenume;
	}
	@Override
	public String toString() {
		return "Student [nume=" + nume + ", Prenume=" + Prenume + "]";
	}
	
	String get_nume() {
		return nume;
	}
	String get_prenume() {
		return Prenume;
	}
	Grupa get_grupa() {
		return grupa_student;
	}
	
}

import java.util.ArrayList;
import java.util.List;

public class Grupa {
	String nume;
	List<Student> Lista_Studenti = new ArrayList<>();

	void Add_Student(Student a) {
		Lista_Studenti.add(a);
	}

	void Remove_Student(Student a) {
		for (Student i : Lista_Studenti) {
			if (i.equals(a)) {
				Lista_Studenti.remove(a);
			}
		}
	}
	public Grupa(String a) {
		this.nume=a;
	}
	String get_Nume() {
		return nume;
	}

	@Override
	public String toString() {
		return "Grupa [nume=" + nume + "]";
	}

	public List<Student> getLista_Studenti() {
		return Lista_Studenti;
	}

	public void setLista_Studenti(List<Student> lista_Studenti) {
		Lista_Studenti = lista_Studenti;
	}
}

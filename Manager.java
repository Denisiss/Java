import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manager {
	private static Manager instance = null;
	List<Grupa> Grupe = new ArrayList<>();
	List<Student> Studenti = new ArrayList<>();
	List<Student> StudentiNeasignati = new ArrayList<>();

	public List<Grupa> get_grupa(){
		return Grupe;
	}
	
	public List<Student> get_Studenti() {
		return Studenti;
	}
	
	public List<Student> get_StudentiN(){
		return StudentiNeasignati;
	}
	
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	public void Read_File(String path) throws FileNotFoundException {
		Scanner _Scanner = new Scanner(new File(path));
		_Scanner.nextLine();
		String line = null;
		while (_Scanner.hasNextLine()) {
			line=_Scanner.nextLine();
			String[] wowie = line.split(";");
			if (wowie.length<3 || wowie[2] == null) {
				Student ss = new Student(wowie[0], wowie[1], null);
				StudentiNeasignati.add(ss);
			}else {
				Grupa gg = null;
				for(Grupa g:Grupe) {
					if(g.get_Nume().equals(wowie[2])) {
						gg=g;
						break;
					}
				}
				
				if(gg==null){
					gg=new Grupa(wowie[2]);
					Student ss = new Student(wowie[0],wowie[1],gg);
					gg.Add_Student(ss);
					Grupe.add(gg);
				}
			}
			

		}
		_Scanner.close();
	}
	public void writeFle(String path) {
		Collections.sort(Grupe,(g1, g2)-> g1.get_Nume().compareTo(g2.get_Nume()));
		try(PrintWriter pr = new PrintWriter(path)){
			pr.write("Nume;Prenume;Grupa\n");
			for(Grupa g:Grupe) {
				for(Student s:g.getLista_Studenti())
					pr.write(g.get_Nume()+ ";" + s.get_nume()+ ";" + s.get_prenume());
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

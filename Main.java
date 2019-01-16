import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main extends JFrame implements KeyListener {

	public static void main(String[] args) throws FileNotFoundException {
		SwingUtilities.invokeLater(() -> new Main());
	}

	DefaultListModel<Student> stm;
	DefaultListModel<Student> vlm;
	JComboBox<Grupa> cb;
	Manager mng;

	public Main() {
		super("Gestionare Grupa");

		try {
			Manager.getInstance().Read_File("Fisier.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buildGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	//@SuppressWarnings("deprecation")
	public void buildGUI() {
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new JLabel("GRUPE"), BorderLayout.WEST);
		cb = new JComboBox<>();
		for (Grupa q : Manager.getInstance().get_grupa()) {
			cb.addItem(q);
		}
		p1.add(cb);
		add(p1, BorderLayout.NORTH);
		JPanel p2 = new JPanel();
		p2.add(new JLabel("Studenti neasignati"), new BoxLayout(p2, BoxLayout.Y_AXIS));
		stm = new DefaultListModel<>();
		for (Student s : Manager.getInstance().get_Studenti()) {
			stm.addElement(s);
		}
		JList<Student> sl = new JList<>(stm);
		p2.add(new JScrollPane(sl));
		add(p2);
		add(p2, BorderLayout.EAST);
		JPanel p3 = new JPanel();
		p3.add(new JLabel("Studenti Asignati"), new BoxLayout(p2, BoxLayout.X_AXIS));
		vlm = new DefaultListModel<Student>();
		for (Student s : Manager.getInstance().get_StudentiN()) {
			vlm.addElement(s);
		}
		JList<Student> vl = new JList<>(vlm);
		p3.add(new JScrollPane(vl));
		add(p3);
		add(p3, BorderLayout.WEST);
		cb.addItemListener((ae) -> {
			Grupa g = (Grupa) cb.getSelectedItem();
			vlm.clear();
			for (Student s : g.Lista_Studenti) {
				vlm.addElement(s);
			}
		});
		JMenuBar Bar = new JMenuBar();
		JMenu file = new JMenu("FILE");
		JMenuItem open = new JMenuItem("OPEN");
		JMenuItem save = new JMenuItem("SAVE");
		file.add(open);
		file.add(save);
		Bar.add(file);
		setJMenuBar(Bar);
		JPanel butoane = new JPanel();
		JButton b = new JButton("<<");
		JButton f = new JButton(">>");
		butoane.add(b);butoane.add(f);
		add(butoane);
		JList<Student> lista = new JList<>(vlm);
	/*	b.addActionListener((ae)->{
			
			for(Student s:lista) {
				s.grupa_student=null;
				stm.addElement(s);
				vlm.removeElement(s);
				Grupa g = s.get_grupa();
				g.getLista_Studenti().remove(s);
			}
			
		});
		*/
		save.addActionListener((ae)->{
			JFileChooser fc = new JFileChooser();
			int ret = fc.showSaveDialog(this);
			//File f = new File();
			if(ret==JFileChooser.APPROVE_OPTION);
			{
				//File f = fc.getSelectedFile();
				
			}
		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

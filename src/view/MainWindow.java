package view;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private FileChooser chooser;
	
	public MainWindow() {
		setTitle("N-Ary Files");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		chooser = new FileChooser();
	}
	
	public File getPath(){
		return chooser.chooseFolder();
	}
	
	public int getTotalSize(){
		return Integer.parseInt(JOptionPane.showInputDialog("Introduza un tamaño"));
	}
}

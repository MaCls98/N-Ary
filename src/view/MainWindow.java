package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.Events;
import model.Node;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private FileChooser chooser;
	private JButton btnLoadFiles;
	private JTreeFiles treeFiles;
	
	public MainWindow(Controller controller) {
		setTitle("N-Ary Files");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		chooser = new FileChooser();
		
		btnLoadFiles = new JButton("Seleccionar Carpeta");
		btnLoadFiles.addActionListener(controller);
		btnLoadFiles.setActionCommand(Events.CHOOSE_FOLDER.toString());
		add(btnLoadFiles, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void showTree(Node root){
		treeFiles = new JTreeFiles();
		treeFiles.showTree(root);
		add(new JScrollPane(treeFiles), BorderLayout.CENTER);
		repaint();
	}
	
	public File getPath(){
		return chooser.chooseFolder();
	}
	
	public int getTotalSize(){
		return Integer.parseInt(JOptionPane.showInputDialog("Introduza un tamaño en KB"));
	}
}

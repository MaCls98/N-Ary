package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
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
	private ImageIcon icon;
	
	public MainWindow(Controller controller) {
		setTitle("N-Ary Files");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		chooser = new FileChooser();
		icon = new ImageIcon(getClass().getResource("/img/folder.png"));
		setIconImage(icon.getImage());
		
		btnLoadFiles = new JButton("Seleccionar Carpeta");
		btnLoadFiles.addActionListener(controller);
		btnLoadFiles.setActionCommand(Events.CHOOSE_FOLDER.toString());
		btnLoadFiles.setIcon(icon);
		btnLoadFiles.setFont(new Font("Arial", Font.BOLD, 20));
		btnLoadFiles.setBackground(Color.WHITE);
		add(btnLoadFiles, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void showTree(Node root){
		treeFiles = new JTreeFiles();
		treeFiles.cleanTree();
		treeFiles.showTree(root);
		add(new JScrollPane(treeFiles), BorderLayout.CENTER);
	}
	
	public File getPath(){
		return chooser.chooseFolder();
	}
	
	public int getTotalSize(){
		return Integer.parseInt(JOptionPane.showInputDialog("Introduza un tamaño en KB"));
	}
}

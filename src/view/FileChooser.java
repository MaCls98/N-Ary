package view;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser extends JFileChooser{
	
	private static final long serialVersionUID = 1L;

	public File chooseFolder(){
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(getRootPane());
		return chooser.getSelectedFile();
	}
}

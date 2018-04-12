package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FileManager;
import view.MainWindow;

public class Controller implements ActionListener{
	
	private FileManager manager;
	private MainWindow window;
	
	public Controller() {
		window = new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case CHOOSE_FOLDER:
			loadFiles();
			break;

		default:
			break;
		}
	}
	
	private void loadFiles(){
		manager = new FileManager(window.getPath().getName(), window.getTotalSize());
		manager.showTree();
	}

}

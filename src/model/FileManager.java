package model;

import java.io.File;

public class FileManager {
	
	private File father;
	private TreeFiles files;
	
	public FileManager(String pathFather, int totalSize){
		father = new File(pathFather);
		files = new TreeFiles();
	}
	
}

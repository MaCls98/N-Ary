package model;

import java.io.File;

public class FileManager {
	
	private File father;
	private TreeFiles files;
	
	public FileManager(String pathFather, int totalSize){
		father = new File(pathFather);
		files = new TreeFiles();
	}
	
	public FileManager(){
		files = new TreeFiles();
	}
	
	public void fillTree(){
		fillTree(father);
	}
	
	private void fillTree(File actualFile){
		files.addToTreeFiles(actualFile);
		if (actualFile.isDirectory()) {
			for (File file : actualFile.listFiles()) {
				fillTree(file);
			}
		}
	}
	
	public void showInfoFile(){
		showInfoFile(father, " ");
	}

	private void showInfoFile(File actualFile, String space) {
		System.out.println(space + actualFile.getName());
		if (actualFile.isDirectory()) {
			for (File file : actualFile.listFiles()) {
				showInfoFile(file, space + "             |"); 
			}
		}
	}
	
	public void showTree(){
		files.showTree();
	}

	public File getFather() {
		return father;
	}

	public TreeFiles getFiles() {
		return files;
	}
	
	public void setFileFather(File father){
		this.father = father;
		files = new TreeFiles(father);
		fillTree();
	}
	
	public void setTotalSize(int totalSize){
		files.clearTree();
		files.setTotalSize(totalSize);
		fillTree();
	}
	
	public Node getRootTree(){
		return files.getRoot();
	}
}

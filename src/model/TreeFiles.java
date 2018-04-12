package model;

import java.io.File;

public class TreeFiles {
	
	private Node root;
	private int totalSize;
	
	public TreeFiles(File father, int totalSize){
		this.totalSize = totalSize;
		if (father.isDirectory()) {
			root = new Node(father.getName());
		}else {
			throw new NullPointerException("Seleccion no valida");
		}
	}
	
	public TreeFiles(){
	}
	
	public TreeFiles(File father){
		if (father.isDirectory()) {
			root = new Node(father.getName());
		}else {
			throw new NullPointerException("Seleccion no valida");
		}
	}
	
	
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
}

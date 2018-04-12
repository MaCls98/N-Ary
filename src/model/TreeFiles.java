package model;

import java.io.File;

public class TreeFiles {
	
	private Node root;
	private int totalSize;
	
	public TreeFiles(File father, int totalSize){
		this.totalSize = totalSize;
		System.out.println(father);
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
	
	public void addToTreeFiles(File file){
		if (!file.isDirectory()) {
			String fileExtension = "";
			fileExtension = file.getName().substring(file.getName().lastIndexOf("."));
			Node nodeExtension = searchExtension(fileExtension);
			if (nodeExtension == null) {
				createFileExtension(fileExtension);
				nodeExtension = searchExtension(fileExtension);
			}
			addFileToExtension(nodeExtension, file);
		}
	}
	
	private Node searchExtension(String fileExtension) {
		for (Node actual : root.getNodeList()) {
			if (actual.getInfo().equals(fileExtension)) {
				return actual;
			}
		}
		return null;
	}
	
	private void createFileExtension(String extension){
		Node newExtension = new Node(extension);
		newExtension.getNodeList().add(new Node("Menor Tama�o"));
		newExtension.getNodeList().add(new Node("Mayor Tama�o"));
		root.getNodeList().add(newExtension);
	}
	
	public void addFileToExtension(Node nodeExtension, File file){
		Node nodeSize;
		if (file.length() < totalSize) {
			nodeSize = nodeExtension.getNodeList().get(0);
		}else {
			nodeSize = nodeExtension.getNodeList().get(1);
		}
		nodeSize.getNodeList().add(new Node(file.getName()));
	}
	
	public void showTree(){
		showTree(root, " ");
	}

	private void showTree(Node actual, String space) {
		System.out.println(space + actual.getInfo());
		for (Node node : actual.getNodeList()) {
			showTree(node, space + "                  |");
		}
	}
	
	public void clearTree(){
		root.getNodeList().clear();
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

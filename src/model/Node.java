package model;

import java.util.ArrayList;

public class Node {
	
	private String pathFather;
	private ArrayList<Node> nodeList;
	
	public Node(String info) {
		this.pathFather = info;
		nodeList = new ArrayList<>();
	}

	public String getInfo() {
		return pathFather;
	}

	public void setInfo(String info) {
		this.pathFather = info;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}
}

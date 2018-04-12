package model;

import java.util.ArrayList;

public class Node {
	
	private String info;
	private ArrayList<Node> nodeList;
	
	public Node(String info) {
		this.info = info;
		nodeList = new ArrayList<>();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}
}

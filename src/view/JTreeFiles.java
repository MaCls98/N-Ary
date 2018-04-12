package view;

import java.awt.BorderLayout;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Node;

public class JTreeFiles extends JTree{

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode mutableTreeNode;
	private DefaultTreeModel defaultTreeModel;
	
	public JTreeFiles() {
		setSize(500, 500);
		setLayout(new BorderLayout());
		
		mutableTreeNode = new DefaultMutableTreeNode();
		defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
		setModel(defaultTreeModel);
	}
	
	public void showTree(Node root){
		if (root != null) {
			mutableTreeNode = new DefaultMutableTreeNode(root.getInfo());
			defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
			setModel(defaultTreeModel);
			for (Node actual : root.getNodeList()) {
				showTree(actual, mutableTreeNode);
			}
		}
	}

	private void showTree(Node root, DefaultMutableTreeNode jRoot) {
		if (root != null) {
			DefaultMutableTreeNode jNode = new DefaultMutableTreeNode(root.getInfo());
			jRoot.add(jNode);
			for (Node actual : root.getNodeList()) {
				showTree(actual, jNode);
			}
		}
	}
}

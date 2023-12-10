package datastructs.linkedlist;

public class BinarySearchTree {

	private Node root;
	
	public class Node {
		Node left;
		Node right;
		int  value;

		public Node(int val) {
			this.value = val;
		}
	}

	public void insertNode(int val) {
		insertNode(root, val);
	}
	
	
	private Node insertNode(Node currNode, int val) {
		
		if(currNode == null) return new Node(val);
		
		if(val < currNode.value) {
			currNode.left = insertNode(currNode.left, val);
		}else if(val > currNode.value) {
			currNode.right = insertNode(currNode.right, val);
		}else {
			return currNode;
		}
		
		return currNode;
		
	}
	
	
	public void deleteNode(int val) {
		
		 deleteNode(root, val);
		
	}
	
	private Node deleteNode(Node currNode, int val) {
		
		if(currNode == null) return null;
		
		if(val < currNode.value) {
			currNode.left = deleteNode(currNode.left, val);
		}else if(val > currNode.value) {
			currNode.right = deleteNode(currNode.right, val);
		}else { //Found the node
			Node tmpNode = currNode;
			 if(currNode.left == null) {
				 currNode = null;
				 return tmpNode.right;
			 }else if(currNode.right == null) { 
				 currNode = null;
				 return tmpNode.left; 
			 }else { //both child not null
				 int min = minValue(currNode.right);
				 currNode.value =  min;
				 currNode.right =  deleteNode(currNode.right, min);
			 }
			
		}
		
		return currNode;
	}
	
	
	
	public int minValue(Node currNode) {
	     if(currNode == null) return  -1;
	     if(currNode.left == null) {
	    	 return currNode.value;
	     }else {
	    	 return minValue(currNode.left);
	     }
	}
}

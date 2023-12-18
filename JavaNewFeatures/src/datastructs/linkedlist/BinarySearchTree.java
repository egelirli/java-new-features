package datastructs.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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

	public static void main(String[] args) {
	      BinarySearchTree myBST = new BinarySearchTree();

	        myBST.insert(47);
	        myBST.insert(21);
	        myBST.insert(76);
	        myBST.insert(18);
	        myBST.insert(27);
	        myBST.insert(52);
	        myBST.insert(82);

	        System.out.println("BST Contains 52:");
	        System.out.println(myBST.contains(52));
	        
	        
//	        System.out.println("Breadth First Search:");
//	        System.out.println( myBST.traverseTreeBreadthFirst() );
//
//	        System.out.println("\nDepth First Search - Pre Order:");
//	        System.out.println( myBST.traverseTreeDepthFirst_PreOrder() );
//
	        System.out.println("\nDepth First Search - Post Order:");
	        System.out.println( myBST.traverseTreeDepthFirst_PostOrder() );
	        
	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            Breadth First Search:
	            [47, 21, 76, 18, 27, 52, 82]

	        */	
		 
		
	}
	
	


	public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
	
//	public void insert(int val) {
//		insertNode(root, val);
//	}
//	
//	
//	private Node insertNode(Node currNode, int val) {
//		
//		System.out.println("In inserting " + val);
//		if(currNode == null) return new Node(val);
//		
//		if(val < currNode.value) {
//			currNode.left = insertNode(currNode.left, val);
//		}else if(val > currNode.value) {
//			currNode.right = insertNode(currNode.right, val);
//		}else {
//			return currNode;
//		}
//		
//		return currNode;
//		
//	}
	
	
	
    private boolean contains(int num) {
		boolean ret = false;
    	
		Node curNode = root;
		while(curNode != null) {
		     if(curNode.value == num) {
				 ret = true;
				 break;
			 }else if(num < curNode.value){
			     curNode = curNode.left;
			 }else {
				 curNode = curNode.right; 
			 }
		}
    	
    	return ret;
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
	
	
	public List traverseTreeBreadthFirst(){
		
		List<Integer> retList = new ArrayList<>();
		Queue<Node>  queue = new LinkedList<>();
		queue.add(root);
		traverseTreeBreadthFirst(queue, retList);
		
		return retList;
		//System.out.printf("List : %s ", retList.toString());
		
	}


	private void traverseTreeBreadthFirst(Queue<Node>  queue,   List<Integer> retList) {
		   
		   if(queue.isEmpty()) return;
		   Node currNode = queue.remove();
		   if(currNode == null) {
			   System.out.println("Return");
				return;
			}

			if(currNode.left != null) {
				queue.add(currNode.left);
			}
			if(currNode.right != null) {
				queue.add(currNode.right);
			}
            
			retList.add(currNode.value);
			//System.out.println(currNode.value);
			
			traverseTreeBreadthFirst( queue, retList);
		
	}


	public List traverseTreeDepthFirst_PreOrder(){
		
		List<Integer> retList = new ArrayList<>();
		traverseTreeDepthFirst_PreOrder(root,retList);
		
		return retList;
		//System.out.printf("List : %s ", retList.toString());
		
	}


	private void traverseTreeDepthFirst_PreOrder(
			           Node currNode, List<Integer> retList) {
		   
		   if(currNode == null) {
			   System.out.println("Return");
				return;
			}
		    retList.add(currNode.value);
		    
			if(currNode.left != null) {
				traverseTreeDepthFirst_PreOrder(currNode.left,retList);
			}
			if(currNode.right != null) {
				traverseTreeDepthFirst_PreOrder(currNode.right,retList);
			}
            
		
	}


	
	public List traverseTreeDepthFirst_PostOrder(){
		
		List<Integer> retList = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		//traverseTreeDepthFirst_PostOrder(stack, retList);
		traverseTreeDepthFirst_PostOrder(root, retList);
		return retList;
		//System.out.printf("List : %s ", retList.toString());
		
	}


	private void traverseTreeDepthFirst_PostOrder(
					   Stack<Node> stack,
			           List<Integer> retList) {
	   
	   Node currNode = stack.peek();
	   System.out.println("currNode : " + currNode.value );
	   
		
	   if(currNode.left == null) {
		   retList.add(currNode.value);
		   stack.pop();
	   }else {
		   stack.push(currNode.left);
		   traverseTreeDepthFirst_PostOrder(stack, retList);
	   }
		   
	   if(currNode.right != null) {
		   stack.push(currNode.right);
		   traverseTreeDepthFirst_PostOrder(stack, retList);
	   }

	   if(currNode.left != null) {
		   retList.add(currNode.value); 
	   }
	   
	}

	private void traverseTreeDepthFirst_PostOrder(Node currNode, 
												  List<Integer> retList) {

		
		if(currNode == null) return;
		System.out.println("currNode : " + currNode.value);

		
		if (currNode.left != null) {
			traverseTreeDepthFirst_PostOrder(currNode.left, retList);
		} 

		if (currNode.right != null) {
			traverseTreeDepthFirst_PostOrder(currNode.right, retList);
		}
		
		retList.add(currNode.value);
		
	}	
	

}

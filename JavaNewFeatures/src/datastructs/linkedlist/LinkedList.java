package datastructs.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

	
	
	public static void main(String[] args) {

	        LinkedList myLinkedList = new LinkedList(1);
	        myLinkedList.append(2);
//	        myLinkedList.append(3);
//	        myLinkedList.append(4);
	        
	        
	       // testReverse(myLinkedList);
	        testRemoveLast(myLinkedList);

	}

	public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
	}

	public void printList() {
	    Node temp = head;
	    while (temp != null) {
	        System.out.println(temp.value);
	        temp = temp.next;
	    }
	}
	
	public void getHead() {
	    if (head == null) {
	        System.out.println("Head: null");
	    } else {
	        System.out.println("Head: " + head.value);
	    }
	}
	
	public void getTail() {
	    if (head == null) {
	        System.out.println("Tail: null");
	    } else {
	        System.out.println("Tail: " + tail.value);
	    }
	}
	
	public void getLength() {
	    System.out.println("Length: " + length);
	}

	private void append(int i) {
		Node temp = tail; 
		
		Node node = new Node(i);
		node.next = null;
		tail.next = node;
		tail = node;
		
	}
	
	
	private void removeLast() {
		Node temp = head;
		
		if(head == tail) {
			 head = null;
			 tail = null;
			 return;
		}
		
		while(temp.next != tail) {
			temp = temp.next;
		}
		
		temp.next = null;
		tail = temp;
	    
	}

	private void reverse() {
		if(head == null) {
			return;
		}
		
		if(head == tail) {
			return;
		}
		
		
		Node prev = head;
		Node cur = head.next;
		Node next = cur;
		head.next = null;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur =  next;
		}
		
	    Node tmp = tail;
	    tail = head;
	    head =  tmp;
		
	}

	
	
	private void partitionList(LinkedList myll, int x) {
		
		if(myll.head == null  ) {
			return;
		}
		
		if(myll.head.next == null  ) {
			return;
		}
		
		Node prev = myll.head;
		Node cur = myll.head.next;
		
		while(cur != null) {
			 if(prev.value > cur.value) {
				  int tmp = prev.value;
				  prev.value = cur.value;
				  cur.value = tmp;
				  prev = prev.next;
				  cur = cur.next;
			 }else {
				 cur = cur.next;
			 }
			
		}
		
		
		
	}
	
	private static void testRemoveLast(LinkedList myLinkedList) {
        System.out.println("LL before testRemoveLast():");
        myLinkedList.printList();

        myLinkedList.removeLast();;

        System.out.println("\nLL after testRemoveLast():");
        myLinkedList.printList();
		
		
	}


	private static void testReverse( LinkedList myLinkedList) {
        System.out.println("LL before reverse():");
        myLinkedList.printList();

        myLinkedList.reverse();

        System.out.println("\nLL after reverse():");
        myLinkedList.printList();
        

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before reverse():
            1
            2
            3
            4
            
            LL after reverse():
            4
            3
            2
            1

        */
		
	}

	
	
	private static void testSplit(LinkedList myLinkedList, int x ) {
	       System.out.println("LL before split() - x: " + x);
	        myLinkedList.printList();

	        myLinkedList.split(myLinkedList, x);

	        System.out.println("\nLL after split():");
	        myLinkedList.printList();
		
		
	}

	private void split(LinkedList myLinkedList, int x) {
		
		  Node prev =   myLinkedList.head;
		  Node next =   myLinkedList.head;
		  
		   
		
	}


	
}

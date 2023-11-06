package LinkedList;

// THIS CODE GOES IN YOUR LINKEDLIST CLASS:
// ----------------------------------------

public class LinkedList {

	// CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    private Node head;
    private Node tail;
    private int length;

    class Node {   //Node class will be inner class inside of the class
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

	//////////////////////////////////////////////////////////////
	
	
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

    //Append:
    public void append(int value) {
        Node newNode = new Node(value); //create new node
        
    }

}

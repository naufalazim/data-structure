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

    //Empty:
    public void makeEmpty(int value) {
        head = null;
        tail = null;
        length = 0;
    }

    //Append:
    public void append(int value) {
        Node newNode = new Node(value); //create new node
        //If empty Linked List:
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //Remove Last:
    public Node removeLast() {
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;

        while(temp.next !=null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    //Prepend:
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Remove First
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    //Get menthod:
    public Node get(int index) {
        if(index < 0 || index >= length){
            return null; //if index below 0 and more than index have
        }

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    //INSERT:
    public boolean insert(int index, int value) {
        //error exception:
        if(index < 0 || index > length) return false;

        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value); //create node
        Node temp = get( index -1); //node one before the index;
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    //Remove
    public Node remove(int index, int value) {
        if(index < 0 || index > length) return null;

        if(index == 0) return removeFirst(); //remove first item
        if(index == length - 1) return removeLast(); //remove last item

        Node prev = get(index - 1);  
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
  

    //Reverse:
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}

package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
        // TODO: implement, see exercise P-4.9
    	Node newNode = new Node(element);
    	//Reassigning the reference to the next node of the node in front of the one to be added.
    	Node p = getNode(index - 1);
    	newNode.next = p.next;
    	p.next = newNode;
    	//Reassigning the reference to the previous node of the node behind of the one to be added.
    	Node b = getNode(index + 1);
    	newNode.previous = b.previous;
    	b.previous = newNode;
    	size = size + 1;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        // TODO: implement, see exercise P-4.9
    	//Reassigning the reference to the next node of the node in front of the one to be removed.
    	Node p = getNode(index - 1);
    	p.next = p.next.next;
    	//Reassigning the reference to the previous node of the node behind of the one to be removed.
    	Node b = getNode(index + 1);
    	b.previous = b.previous.previous;
    	size = size - 1;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}

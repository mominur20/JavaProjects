package SinglyLinkList;

public class SingleLinkList {
    private Node first;

    public SingleLinkList(){

    }

    public boolean isEmpty(){
        return (first == null);
    }

    // used to insert at the beginning of the list
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }
    // Insert Last
    public void insertLast(int data){
        Node current = first;
        while (current.next !=null){
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }


    public Node deleteFirst(){
        Node temp = first;
        return temp;
    }

    public void displayList(){
        System.out.println("List(First --> Last) ");
        Node current = first;
        while (current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
}

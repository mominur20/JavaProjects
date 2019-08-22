public class LinkedList {

    // store only single node in list
    private Node head;
    private int size;  // number of element stored in the linked list

    public LinkedList()
    {

    }

    public void add (Object newElement)
    {
        // is list empty?
        if (head == null)
        {
            // assign a new node object
            head = new Node(newElement, null);
        }

        else {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }

            // add new node at the end of the list
            current.next = new Node(newElement, null);

        }
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return isEmpty();
    }

    public void clear()
    {
        // remove all elements in the linked list
        head = null;
        size = 0;
    }

    // remove element form list
    public boolean remove (Object newElement)
    {
        // if list is empty
        if(head == null)

        {
            return false;
        }
        else if (head.data.equals(newElement))
        {
            head = head.next;
            size--;
            return true;

        }

        else {
            Node current = head;

            while (current.next != null && !current.next.data.equals(newElement))
            {
                // move to next node
                current = current.next;
            }

            // if not find in list
            if(current.next == null)
            {
                return false;
            }
            else
            {
                // remove the elsement
                current.next = current.next.next;
                size--;
                return true;
            }
        }
    }


    public String toString()
    {
        // print out the list
        String result = "";

        // show the list
        Node current = head;
        while (current != null)
        {
            // have a node then print
            result += current.data + "----> ";

            // mode to next node
            current = current.next;
        }
        result += null;

        return result;
    }

    private static class Node
    {
        private Object data;
        private Node next; // Reference to naoter node object


        public Node(Object data, Node next )
        {
            this.data = data;
            this.next = next;
        }

        /*
        // printing the list element
        public String toString()
        {
            String nextElement = "null";
            if (next != null)
            {
                nextElement = next.data.toString();
            }

            return data + "-->" + nextElement;
        }
        */

    }
}

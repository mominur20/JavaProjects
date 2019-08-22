import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinarySerchList <T extends Comparable<T>> implements Iterable<T>{

    //field
    private Node main;
    private int size;

    // constractor
    public BinarySerchList(){

    }
    // Method
    public void add(T element)
    {
        // is List empty?
        if (main == null)
        {
            main = new Node(element);
            size++;
        }
        else
        {
            // recursively find the position of new element
            main = add(element,main);
        }
    }

    private Node add(T element, Node current)
    {
        // if have a null current node, then found the open spot
        if (current == null)
        {
            size++;
            return new Node(element);
        }

        // Search Left or right position
        int compare = current.data.compareTo(element);

            if(compare < 0)
            {
                current.right = add(element,current.right);
                return current;
            }
            else if (compare> 0)
            {
                current.left = add(element,current.left);
                return current;
            }

            else {
                return current; // do not add new element, for duplicate
            }
        }



    public boolean contains(T element)
    {
       return contains(element,main);
    }

    private boolean contains(T element, Node current)
    {
        // base case
        if(current == null)
        {
            return false;
        }
        int compare = current.data.compareTo(element);

        if (compare < 0 ) // current small
        {
            return contains(element,current.right);
        }

        if (compare > 0 ) // current large
        {
            return contains(element,current.left);
        }
        else {
            return true;
        }
    }

    public void remove(T element)
    {
       main = remove(element, main);
    }

    private  Node remove(T element, Node current)
    {
        // base case
        if(current == null)
        {
            return null;
        }
        int compare = current.data.compareTo(element);

        if (compare < 0 ) // current small
        {
             current.right = remove(element,current.right);
        }

        if (compare > 0 ) // current large
        {
            current.left = remove(element,current.left);
        }
        else {
             if(current.left != null && current.right != null)
             {
                 // replase the data on current data
                 Node maxLeft = findMax(current.left);
                 current.data = maxLeft.data;

                 // remove the larg element in left tree
                 current.left = remove(maxLeft.data, current.left);
             }
             else if (current.left !=null)
             {
                 current = current.left;
                 size--;
             }
             else if (current.right !=null)
             {
                 current = current.right;
                 size--;
             }

             else {
                 current = null;
                 size --;
             }
        }
        return current;
    }

    private  Node findMax(Node current)
    {
        if(current.right !=null)
        {
            return findMax(current.right);
        }
        return current;
    }
    public int size()
    {
         return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    public void clear()
    {
        main = null;
        size = 0;
    }


    public void inOrder()
    {
        inOrder(main);
    }

    private void inOrder(Node current)
    {
       if (current != null)
       {
           inOrder(current.left);
           System.out.println(current.data);
           inOrder(current.right);


       }
    }
    public void postOrder()
    {
     postOrder(main);
    }
    private void postOrder(Node current)
    {
        if (current != null)
        {
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data);

        }
    }



    public void preOrder()
    {
      preOrder(main);
    }

    private void preOrder(Node current)
    {
        if (current != null)
        {
            System.out.println(current.data);
            preOrder(current.left);
            preOrder(current.right);
        }
    }






    public List<T> tolist()
    {
        List<T> result = new ArrayList<>();
        toList(main,result);

        return result;
    }

    private void toList(Node current, List<T> result)
    {
        if (current != null)
        {
            inOrder(current.left);
            result.add(current.data);
            inOrder(current.right);
        }
    }



    @Override

    public Iterator<T> iterator() {
        return new NewIterator(this);
    }


    private class NewIterator implements Iterator<T>
    {

        private Object[] data;
        private int position;
        public NewIterator(BinarySerchList<T> search)
        {
            data = search.tolist().toArray();
        }

        @Override
        public boolean hasNext()
        {
            return position < data.length;
        }

        @Override
        public T next() {
            return (T)data[position++];
        }
    }



    private class AnotherErator implements Iterator<T>
    {
        private Stack<Node> nodeStack = new Stack<>();

        public AnotherErator(Node current)
        {
            while (current != null)
            {
                nodeStack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext()
        {
            return !nodeStack.isEmpty();
        }

        @Override
        public T next()
        {
            Node next = nodeStack.pop();
            if(next.right != null)
            {
                //add right list
                nodeStack.push(next.right);

                //add Left list
                Node current = next.right;
                while (current.left != null);
                {
                    nodeStack.push(current.left);
                    current = current.left;
                }
            }

            return next.data;
        }
    }


    // binary tree node
    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node (T data)
        {
            this.data = data;
        }

        public String toString(){
            String dataString = (data == null) ? "Null" : data.toString();
            String leftOption = (data == null) ? "Null" : left.data.toString();
            String rightOption = (data == null) ? "Null" : right.data.toString();

            return leftOption + "<--" + dataString + "-->" + rightOption;
        }
    }
}

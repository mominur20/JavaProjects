import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Bag implements Iterable<Object>
{
    // field
    private static final int DEFAULT_BAG_SIZE = 10;
    private Object[] data;
    private int currentNumberOfElement = 0;

    // Modification count variable: increment or decrement when ther is change (add, remve)
    private int modCount = 0;

    //Constructors
    public Bag()
    {
        data = new Object[DEFAULT_BAG_SIZE];
    }

    public Bag(int sizeOfBag)
    {
        data = new Object[sizeOfBag];
    }

    // methods
    public boolean add(Object newElement)
    {
        // search for a new element
        for (int i = 0; i < data.length; i++)
        {
            // is the current spot empty?
            if(data[i] == null)
            {
                //add the element and exit the method
                data[i] = newElement;
                currentNumberOfElement++;
                modCount++;
                return true;
            }
        }
        // the Bag is full
        return false;
    }

    // bag size
    public int size()
    {
      return   currentNumberOfElement;
    }

    public String toString()
    {
        return Arrays.toString(data);
    }

    // This method declares that class has an iterator and
    // it returns iterator
    @Override
    public Iterator<Object> iterator()
    {
        return new BagIterator(data, this);
    }
    // ***************** *************
    // inner classes
    public static class BagIterator implements Iterator<Object>
    {
        private Object[] outerClassData;
        private int currentPosition = 0;
        private Bag mainBag;
        private int currentModCount;

        public BagIterator(Object[] outerClassData, Bag mainBag)
        {
            this.outerClassData = outerClassData;
            this.mainBag = mainBag;

            // save the current object of the bag
            currentModCount = mainBag.modCount;
        }
        @Override
        public boolean hasNext()
        {
            // Data has not change while iterating
            if(mainBag.modCount != currentModCount)
            {
                throw  new ConcurrentModificationException("Can not change a bag while iterating ");
            }
            // checking a valid index and the current element is not empty(null)
            return  currentPosition < outerClassData.length && outerClassData[currentPosition] != null;
        }

        @Override
        public Object next()
        {
            // Data has not change while iterating
            if(mainBag.modCount != currentModCount)
            {
                throw  new ConcurrentModificationException("Can not change a bag while iterating ");
            }
            // return the current element, and increment
            // the currentPosition points to the next element
            Object nextElement = outerClassData[currentPosition];
            currentPosition++;

            return nextElement;
        }
    }

}

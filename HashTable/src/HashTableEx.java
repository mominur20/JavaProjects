import java.util.*;

public class HashTableEx<T> implements Set<T> {

    // constants . initial table size, 
    private static final int DEFAULT_SIZE = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.6;
    
    private HashTableElement[] table;

    private double loadFactor;
    private int initialSize;

    private int size;
    private int usedSpace;
    private int modCount = 0; // keep track of change in the hashtable

    // constructors
    public HashTableEx()
    {
        // use the Default
        this(DEFAULT_SIZE,DEFAULT_LOAD_FACTOR);
    }

    public HashTableEx(int initialSize, double loadFactor)
    {
       table = new HashTableElement[initialSize];

       this.loadFactor = loadFactor;
       this.initialSize = initialSize;
    }
    
    @Override
    public boolean add(T element) {


        if((double)usedSpace / table.length >= loadFactor)

        {
            rehash();
        }
        // space for element
        int index = Math.abs(element.hashCode()) % table.length;

        // search for the element
        HashTableElement current = table[index];
        while (current != null)
        {
            if(current.element.equals(element) && !current.isEmpty)
            {
                return false;
            }

            // search end of the table
            index = (index + 1) % table.length;
            current = table[index];
        }
        table[index] = new HashTableElement(element,false);
        size++;
        usedSpace++;
        modCount++;
        return true;
    }

    private void rehash()
    {
        HashTableElement[] oldTable = table;
        table = new HashTableElement[oldTable.length * 2];
        size = 0;

        for (int i = 0; i < oldTable.length; i++)
        {
            if(oldTable[i] !=null && !oldTable[i].isEmpty)
            {
                add((T)oldTable[i].element); // place in the new table base on hash code.
            }
        }
    }


    @Override
    public boolean remove(Object element)
    {
        int index = Math.abs(element.hashCode()) % table.length;
        HashTableElement current = table[index];

        //search for the element
        while (current != null)
        {
            if (current.element.equals(element) && !current.isEmpty)
            {
                current.isEmpty = true;
                size--;
                modCount++;
                return true;
            }

            index = (index + 1) % table.length;
            current = table[index];
        }


        return false;
    }


    @Override
    public boolean contains(Object element)

    {
        int index = Math.abs(element.hashCode()) % table.length;
        HashTableElement current = table[index];

        //search for the element
        while (current != null)
        {
            if (current.element.equals(element) && !current.isEmpty)
            {
                return true;
            }

            index = (index + 1) % table.length;
            current = table[index];
        }

        return false;
    }



    @Override
    
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void clear()
    {
      size = 0;
      table = new  HashTableElement[initialSize];
      modCount++;
    }


    @Override
    public Iterator iterator() {
        return new HashTableIterator(table, modCount);
    }






    
    @Override
    public String toString()
    {
        String result = "";
        for (int i = 0; i < table.length; i++)
        {
            if (i != 0)
            {
                result += ", ";
            }

            if (table[i] != null)
            {
                result += table[i].toString();
            }
            else
            {
                result += "Null";
            }
        }

        return result;
    }
    
    

    
    
// Extra code ...............

    


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

 

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

   

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
    

    private class HashTableIterator implements Iterator<T>
    {
        private HashTableElement[] table;
        private int nextIndex = -1;
        private int modeCountStore;

        public HashTableIterator(HashTableElement[] table, int modeCountStore)
        {
            this.table = table;
            findNextIndex(); // find first valid element
        }

        @Override
        public boolean hasNext() {
            if(modeCountStore != HashTableEx.this.modCount)
            {
                throw new ConcurrentModificationException("You can not change the hash table while using a Iterator");
            }
            return nextIndex != -1;
        }

        @Override
        public T next() {

            if (!hasNext())
            {
                throw new NoSuchElementException("There are no element to return");
            }

            Object nextElement = table[nextIndex].element;
            findNextIndex(); // get the next valid index;
            return (T) nextElement;
        }


        private void findNextIndex()
        {
            // not empty, not void
            for (int i = nextIndex + 1; i <table.length; i++)
            {
                if (table[i] != null && !table[i].isEmpty)
                {
                    nextIndex = i;
                    return; // Exit
                }
            }

            nextIndex = -1; // invalid index (stop)
        }
    }
    
    
    
    // inner Class
    private static class HashTableElement
    {
        private Object element;
        private boolean isEmpty;


        public HashTableElement(Object element, boolean isEmpty) {
            this.element = element;
            this.isEmpty = isEmpty;
        }
        
        public String toString()
        {
            if(isEmpty)
            {
                return "empty";
            }
            return element.toString();
        }
    }
    
    
    
    
}

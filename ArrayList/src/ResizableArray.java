public class ResizableArray {

    private static final int DEFAULT_CAPACITY = 10;

    // Interanla resizable array
    private Object[] data;

    // number of used spots in the internal array
    private int size = 0;

    public ResizableArray(int initialCapacity)
    {
        // Precondition check
        data = new Object[initialCapacity];
    }

    public void add(Object newElement) {

        // if size == data.length? ( Exceeded the capacity of data array )
        if(size == data.length)
        {
            resize();
        }

        // assign the next available index
        data[size] = newElement;
        size++;

    }

    public void remove (Object toBeRemove) {
        // Remove the first occurrence of to
        for (int i = 0; i < size; i++) {
            if (data[i].equals(toBeRemove)) {
                // shift all the elements above the current element down one index
                for (int j = i; j < size - 1; j++) {
                    // move the element in the next position down one index
                    data[j] = data[j + 1];
                }
                // remove first index
                data[size - 1] = null;
                size--;
                break;
            }
        }
    }
    public void printList()
    {
        for (int i=0; i < data.length; i++)
        {
            if( i != 0)
            {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println("]");
    }

    // increase internal Array
    private void resize()
    {
        //create new array
        Object[] newData = new Object[data.length * 2];

        // copy across all elements from the old to new array
        for (int i = 0; i < data.length; i++)
        {
            newData[i] = data[i];
        }

        // replace internal array with the new one
        data = newData;
    }

}

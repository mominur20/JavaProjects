import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderBag<T extends Comparable<T>>
{
    private T[] data;
    private int nextOpenIndex;

    public OrderBag(int size)
    {
        data = (T[]) new Comparable[size];
    }

    public boolean add(T element)
    {
        if (nextOpenIndex == data.length)
        {
            return false; // no space in the Bag
        }
        data[nextOpenIndex] = element;
        nextOpenIndex++;
        return true;
    }

    public void sort()
    {
        Arrays.sort(data,0,5);
    }

    public T findMinimum()
    {
        if(nextOpenIndex == 0)
        {
            return null; // The Bag is empty
        }
        T min = data[0];
        for (int i= 1; i <data.length; i++)
        {
            if(data[i] !=null && data[i].compareTo(min) < 0)
            {
                min = data[i];
            }
        }
        return  min;
    }

    public String toString()
    {
        return "Ordeer bag: " + Arrays.toString(data);
    }
}

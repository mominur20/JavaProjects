import java.util.Iterator;
import java.util.NoSuchElementException;


    public class BagSet<T> implements Iterable<T>
    {
        private Object[] data;
        private int size;




        public BagSet(int capacity)
        {
            // precondition
            if(capacity <= 0)
            {
                throw new IllegalArgumentException("A BagSet must have a positive capacity");
            }
            data = new Object[capacity];
        }

        /**
         * Add a new element to the BasSet given that there is room within the capacity
         * of the bag and also that the element is not already present in the structer.
         * @param element the new element to add to my BagSet
         * @return true if the element is added to the BagSet, otherwise false
         */

        public boolean add(T element)
        {
            if(size == data.length)
            {
                return  false;
            }

            // no duplicates
            if (contains(element))
            {
                return false;
            }
            // find a spot for the new element
            for (int i = 0; i < data.length; i++)
            {
                if(data[i] == null)
                {
                    data[i] = element;
                    size++;
                    return  true;
                }
            }
            return  true;
        }


        public boolean contains(T element)
        {
            // search for the element
            for (int i = 0; i <data.length; i++)
            {
                // data[i] can be null
                //if(data[i].equals(element))
                if (data[i] != null && data[i].equals(element))
                {
                    return  true; // found
                }

            }
            return  false; // not found
        }

        public boolean remove (T element)
        {
            // search for the element
            for (int i = 0; i <data.length; i++)
            {
                if (data[i] != null && data[i].equals(element))
                {
                    data[i] = null;
                    size--;
                    return true; // found
                }
            }
            return false; // not found
        }



        public int size()
        {
            return size;
           // return 0;
        }

        // return number of element in the bagset
        public Iterator<T> iterator()
        {
            return new BagSetIterator(data);
        }

        // Internal iterator class
        private class BagSetIterator implements Iterator<T>
        {
            private Object[] daata;
            private int current = 0;

            public BagSetIterator(Object[] data)

            {
                this.daata = data;
            }


            @Override
            public boolean hasNext()
            {
                // save to index
                int checkIndex = current;

                // find the next non-null element
                while (checkIndex < data.length)
                {
                    if(daata[checkIndex] != null)
                    {
                        return true;
                    }
                    else {
                        checkIndex++;
                    }
                }
                return false; // not found

            }


            @SuppressWarnings("unchecked")
            @Override
            public T next()
            {
                //save index
                int checkIndex = current;

                // find the next non-null element
                while (checkIndex <daata.length)
                {
                    if (daata[checkIndex] != null)
                    {
                        // move the iterator to the next position and return curent valu
                        current = checkIndex + 1;
                        return (T)daata[checkIndex];
                    }
                    else
                        {
                        checkIndex++;
                        }
                }
                // none foundn
                throw new NoSuchElementException("Element not found");
            }


        }



    }


package hashing;
import entities.Book;

public class BookLookupTable
{
    private static final int INIT_SIZE = 10;
    private Book[] table;
    private int size;

    public BookLookupTable()
    {
        table = new Book[INIT_SIZE];
    }


    public void addBook(Book newBook)
    {

        // have a room for another book
        if(size == table.length)
        {
            return; // exit
        }

        // use hashcode to find the place for the newBook
        int index = Math.abs(newBook.hashCode() % table.length);
        // open spot in the table
        while (table[index] !=null)
        {
            // could be duplicate element
            if(table[index].equals(newBook))
            {
                return;
            }

            // move to the next index and check
            index = (index + 1) % table.length;
        }

        table[index] = newBook;
        size++;


    }

    public boolean contains(Book book)
    {
        return getBook(book) != null;
    }

    public Book getBook(Book book)
    {
        int index = Math.abs(book.hashCode() % table.length);

        while (table[index] != null)
        {
            // could be duplicate element
            if(table[index].equals(book))
            {
                return table[index];  // find the element
            }

            // move to the next index and check
            index = (index + 1) % table.length;
        }

        return null;   // did not find the element
    }



}

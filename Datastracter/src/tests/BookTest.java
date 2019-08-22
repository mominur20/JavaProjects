package tests;

import entities.Book;
import hashing.BookLookupTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private BookLookupTable table;


    @Before
    public void setup()
    {
        table = new BookLookupTable();
    }
    @Test
    public void testAddingElements()
    {
        Book gatbyBook = new Book("Monir","school teacher",Book.BookType.SOFTCOVER);
        Book phpBook = new Book("M","Code writing Book",Book.BookType.SOFTCOVER);

        table.addBook(gatbyBook);

        // test find the existen field
        Assert.assertTrue("Cannot find a book",table.contains(gatbyBook));
        // test find the existen field
        Assert.assertFalse("non-existent element in the table",table.contains(phpBook));

    }


}

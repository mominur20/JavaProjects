package launch;

import entities.Book;
import entities.Book.BookType;
import hashing.BookLookupTable;

public class TestLookupTable
{
    public static void main(String[] args)
    {
        Book gatby = new Book("Monir","school teacher",BookType.HARDCOVER);

        Book winterc = new Book("Rasel","winter time use jacket",BookType.SOFTCOVER);

        Book sumert = new Book("Sumon","new Busines",BookType.HARDCOVER);


        // store a few in table
        BookLookupTable table = new BookLookupTable();
        table.addBook(gatby);
        table.addBook(winterc);
        table.addBook(sumert);

        // see if can find the books in table
        Book gatbyBook = new Book("Monir","school teacher",BookType.SOFTCOVER);
        Book retriveBook = table.getBook(gatbyBook);
        System.out.println(retriveBook);

        System.out.println("Contains(gatsby): " + table.contains(gatbyBook));

        System.out.println("Contains(Another): " + table.contains(new Book ("Kamal","Vilage town",BookType.SOFTCOVER)));
    }
}

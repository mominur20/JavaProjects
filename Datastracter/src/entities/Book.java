package entities;

public class Book {

    private String author;
    private String title;
    private BookType type;

    public Book(String author, String title, BookType type) {
        this.author = author;
        this.title = title;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public BookType getType() {
        return type;
    }
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        else if (other == this) // same memory address

        {
            return true;
        }

        else if (!(other.getClass().equals(this.getClass())))
        {
            return false;
        }
        else
        {
            // find the Book and compare field
            Book otherBook = (Book) other;
            return this.author.equals(otherBook.author) && this.title.equals(otherBook.author);
        }
    }

    @Override
    public int hashCode()
    {
        return this.author.hashCode() + this.title.hashCode();
    }


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    public enum BookType
    {
        HARDCOVER,
        SOFTCOVER
    }



}

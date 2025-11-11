package library;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor() + "\n");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.\n");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + "\n");
            }
        }
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
}

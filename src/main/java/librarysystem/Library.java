
package librarysystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String title) {
        Book bookToRemove = findBookByTitle(title);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove.getTitle());
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

   public Book findBookByTitle(String title) {
       for (Book book : books) {
           if (book.getTitle().equalsIgnoreCase(title)) {
               return book;
           }
       }
       return null;
   }

    public void displayAllBooks() {
        System.out.println("All Books in Library:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " (Available: " + book.isAvailable() + ")");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}





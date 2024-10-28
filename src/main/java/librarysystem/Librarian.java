package librarysystem;
public class Librarian extends User {
    public Librarian(String name, int userId) {
        super(name, userId);
    }

    @Override
    public void borrowBook(Library library, Book book) throws BookNotAvailableException {
        System.out.println("Librarian " + name + " borrowed the book: " + book.getTitle());
    }

    @Override
    public void returnBook(Library library, Book book) {
        System.out.println("Librarian " + name + " returned the book: " + book.getTitle());
        book.setAvailable(true);
    }

    public void addBook(Library library, Book book) {
        if (library.findBookByTitle(book.getTitle()) != null || library.findBookByISBN(book.getISBN()) != null) {
            System.out.println("This book is already in the library!");
        } else {
            library.addBook(book);
            System.out.println("Book added successfully: " + book.getTitle());
        }
    }

    public void removeBook(Library library, String title) {
        library.removeBook(title);
    }
}



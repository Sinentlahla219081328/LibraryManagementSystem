package librarysystem;
public class Member extends User {
    public Member(String name, int userId) {
        super(name, userId);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    @Override
    public void borrowBook(Library library, Book book) throws BookNotAvailableException {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Member " + name + " borrowed the book: " + book.getTitle());
        } else {
            throw new BookNotAvailableException("Book " + book.getTitle() + " is currently not available.");
        }
    }

    @Override
    public void returnBook(Library library, Book book) {
        System.out.println("Member " + name + " returned the book: " + book.getTitle());
        book.setAvailable(true);
    }

}





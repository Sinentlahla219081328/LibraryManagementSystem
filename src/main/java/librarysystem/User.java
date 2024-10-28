package librarysystem;

public abstract class User {
    protected String name;
    protected int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public abstract void borrowBook(Library library, Book book) throws BookNotAvailableException;

    public abstract void returnBook(Library library, Book book);
}



package librarysystem;

public abstract class User {
    //used protected  access modifier to allow subclasses and classes with in the same package name to access these variables
    protected String name;
    protected int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }
  //These abstract methods must be overrided/implemented in subclasses of User
    public abstract void borrowBook(Library library, Book book) throws BookIsUnavaliable;

    public abstract void returnBook(Library library, Book book);
}



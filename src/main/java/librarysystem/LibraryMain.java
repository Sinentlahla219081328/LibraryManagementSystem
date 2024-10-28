package librarysystem;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", 1);
        Scanner scanner = new Scanner(System.in);

        // Create members
        Member member1 = new Member("Sinentlahla", 1);
        Member member2 = new Member("John Doe", 2);
        Member member3 = new Member("Jane Smith", 3);
        Member selectedMember = null; // Declare selectedMember here

        // Welcome message
        System.out.println("Welcome to the Library Management System!");

        // Prepopulate the library with some books
        librarian.addBook(library, new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"));
        librarian.addBook(library, new Book("1984", "George Orwell", "978-0-452-28423-4"));
        librarian.addBook(library, new Book("Pride and Prejudice", "Jane Austen", "978-0-19-953556-9"));
        librarian.addBook(library, new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5"));
        librarian.addBook(library, new Book("Moby-Dick", "Herman Melville", "978-0-14-243724-7"));
        librarian.addBook(library, new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0"));
        librarian.addBook(library, new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0-618-00222-8"));
        librarian.addBook(library, new Book("Jane Eyre", "Charlotte Brontë", "978-0-14-144114-6"));
        librarian.addBook(library, new Book("Brave New World", "Aldous Huxley", "978-0-06-085052-4"));
        librarian.addBook(library, new Book("The Hobbit", "J.R.R. Tolkien", "978-0-618-00221-1"));
        librarian.addBook(library, new Book("Java Programming", "John Doe", "1234567890"));
        librarian.addBook(library, new Book("Data Structures", "Jane Smith", "0987654321"));

        // Interactive console loop
        boolean running = true;

        while (running) {
            System.out.println("\n1. Display all books\n2. Select member\n3. Borrow book\n4. Return book\n5. Remove book\n6. Add book\n7. Display borrowed books\n8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    // Choose member to borrow the book
                    System.out.println("Choose a member:");
                    System.out.println("1. " + member1.getName());
                    System.out.println("2. " + member2.getName());
                    System.out.println("3. " + member3.getName());
                    System.out.print("Select member number: ");
                    int memberChoice = scanner.nextInt();

                    // Set the selected member based on the user input
                    switch (memberChoice) {
                        case 1:
                            selectedMember = member1;
                            break;
                        case 2:
                            selectedMember = member2;
                            break;
                        case 3:
                            selectedMember = member3;
                            break;
                        default:
                            System.out.println("Invalid member selection.");
                            continue; // Skip to the next iteration of the loop
                    }
                    System.out.println("Selected member: " + selectedMember.getName());
                    break;
                case 3:
                    if (selectedMember == null) {
                        System.out.println("No member selected. Please select a member first.");
                        break; // Exit the case if no member is selected
                    }

                    // Display available books before borrowing
                    System.out.println("Available books:");
                    library.displayAllBooks();

                    // Proceed to borrow a book
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine().trim(); // Get user input
                    Book bookToBorrow = library.findBookByTitle(borrowTitle);

                    if (bookToBorrow != null) {
                        try {
                            selectedMember.borrowBook(library, bookToBorrow);
                            System.out.println("You have successfully borrowed: " + bookToBorrow.getTitle());
                        } catch (BookNotAvailableException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Book not found: " + borrowTitle);
                    }
                    break;
                case 4:
                    if (selectedMember == null) {
                        System.out.println("No member selected. Please select a member first.");
                        break; // Exit the case if no member is selected
                    }
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine().trim();
                    Book bookToReturn = library.findBookByTitle(returnTitle);
                    if (bookToReturn != null) {
                        selectedMember.returnBook(library, bookToReturn);
                    } else {
                        System.out.println("Book not found: " + returnTitle);
                    }
                    break;
                case 5:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine().trim();
                    librarian.removeBook(library, removeTitle);
                    break;
                case 6:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine().trim();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    librarian.addBook(library, new Book(title, author, isbn));
                    System.out.println("Book added successfully!");
                    break;
                case 7:
                    library.displayBorrowedBooks();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Library Management System!");
    }
}

# LibraryManagementSystem

## Project Description

The **Library Management System** is a console-based application that enables users to manage a library. This includes options to borrow and return books, manage library members, and maintain the book inventory. The system provides a straightforward interface for librarians and members to interact with the library's resources efficiently.

## Features

- View all available books in the library
- Select a member to borrow or return books
- Borrow books
- Return books
- Add new books to the library
- Remove books from the library
- Display borrowed books

## Classes Used

The application consists of the following main classes:

1. **Library**  
   Manages the collection of books and provides methods to add, remove, and find books.

2. **Book**  
   Represents a book in the library, containing attributes like title, author, and ISBN.

3. **Member**  
   Represents a library member who can borrow and return books.

4. **Librarian**  
   Manages library operations, such as adding and removing books.

5. **LibraryMain**  
   The main class that serves as the application's entry point, handling user interactions through a console interface.

6. **BookIsUnavailable**  
   A custom exception thrown when a member attempts to borrow a book that is not available.
   When a librarian atteps to add a book that is already added in the library.

## How to Run the Application

1. **Tools and Resources**  
   - **Java Development Kit (JDK)**: Ensure you have JDK (version 8 or later) installed.
   - **Integrated Development Environment (IDE)**: Use an IDE like IntelliJ IDEA, Eclipse, or NetBeans to write and run your Java code.

2. **Clone the Repository**  
   - Create a new repository and clone it to your local machine.
   - Open the project in your IDE.

3. **Run the Application**  
   - Locate the `LibraryMain` class in the project.
   - Right-click on `LibraryMain` and select the **Run** option to start the application.

---

This README provides clear instructions for setting up and running the project. Enjoy managing your library!

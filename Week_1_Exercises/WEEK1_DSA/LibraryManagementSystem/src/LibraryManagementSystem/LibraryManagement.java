package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        List<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));

        int left = 0, right = sortedBooks.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = sortedBooks.get(mid);
            int cmp = midBook.getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return midBook;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagement lm = new LibraryManagement();

        while (true) {
            System.out.println("Choose an option: add, search (linear), search (binary), display, exit");
            String option = scanner.nextLine();
            switch (option.toLowerCase()) {
                case "add":
                    System.out.println("Enter book ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    lm.addBook(book);
                    break;
                case "search (linear)":
                    System.out.println("Enter book title to search (linear):");
                    String searchTitleLinear = scanner.nextLine();
                    Book foundLinear = lm.linearSearchByTitle(searchTitleLinear);
                    if (foundLinear != null) {
                        System.out.println("Book found: " + foundLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case "search (binary)":
                    System.out.println("Enter book title to search (binary):");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBinary = lm.binarySearchByTitle(searchTitleBinary);
                    if (foundBinary != null) {
                        System.out.println("Book found: " + foundBinary);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case "display":
                    System.out.println("Displaying all books:");
                    lm.displayBooks();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

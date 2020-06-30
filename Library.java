import java.util.ArrayList;

public class Library {

private String address;
private static String openingHours = "Libraries are open daily from 9am to 5pm.";
private ArrayList<Book> libraryBooks = new ArrayList<Book>();
private ArrayList<String> borrowBook = new ArrayList<String>();

public Library(String address) {
	this.address = address;
}

public static void printOpeningHours()  {
	System.out.println(openingHours);
}

public void printAddress() {
	System.out.println(address);
}

public void addBook(Book book) {
	libraryBooks.add(book);
}

public String borrowBook(String bookTitle) {		
	Book libraryBook;
	String libraryBookTitle;
	
	for(int i = 0; i < libraryBooks.size(); i+=1) {
		libraryBook = libraryBooks.get(i);
		libraryBookTitle = libraryBook.getTitle();
		
		if(libraryBookTitle.equals(bookTitle)) {
			if(!(libraryBook.isBorrowed())) {
				libraryBook.borrowed();
				System.out.println("You successfully borrowed " + libraryBookTitle);
				return null;
			}
			else {
				System.out.println("Sorry, this book is already borrowed.");
				return null;
			}
		}
	}
	
	System.out.println("Sorry, this book is not in our catalog.");
	return null;
}

public void printAvailableBooks() {
	Book libraryBook;
	boolean libraryIsEmpty = true;
	
	for(int i = 0; i < libraryBooks.size(); i+=1) {
		libraryBook = libraryBooks.get(i);
		
		if(!(libraryBook.isBorrowed())) {
			System.out.println(libraryBook.getTitle());
			libraryIsEmpty = false;
		}
	}
	
	if(libraryIsEmpty) {
		System.out.println("No books in catalog.");
	}
}

public void returnBook(String bookTitle) {
	Book libraryBook;
	String libraryBookTitle;
	Boolean found = false;
	
	for(int i = 0; i < libraryBooks.size(); i+=1) {
		libraryBook = libraryBooks.get(i);
		libraryBookTitle = libraryBook.getTitle();
		
		if(libraryBookTitle.equals(bookTitle)) {
			if(libraryBook.isBorrowed()) {
				libraryBook.returned();
				System.out.println("You successfully returned " + libraryBookTitle);
				found = true;
				break;
			}
		}
	}
	
	if(!found) {
		System.out.println("Your book was not fond in the library catalog.");
	}
}
	public static void main(String[] args) {
		
	        // Create two libraries
	        Library firstLibrary = new Library("10 Main St.");
	        Library secondLibrary = new Library("228 Liberty St.");

//	         Add four books to the first library
	        firstLibrary.addBook(new Book("The Da Vinci Code"));
	        firstLibrary.addBook(new Book("Le Petit Prince"));
	        firstLibrary.addBook(new Book("A Tale of Two Cities"));
	        firstLibrary.addBook(new Book("The Lord of the Rings"));
	        

//	         Print opening hours and the addresses
	        System.out.println("Library hours:");
	        printOpeningHours();
	        System.out.println();

	        System.out.println("Library addresses:");
	        firstLibrary.printAddress();
	        secondLibrary.printAddress();
	        System.out.println();

//	         Try to borrow The Lords of the Rings from both libraries
	        System.out.println("Borrowing The Lord of the Rings:");
	        firstLibrary.borrowBook("The Lord of the Rings");
	        firstLibrary.borrowBook("The Lord of the Rings");
	        secondLibrary.borrowBook("The Lord of the Rings");
	        System.out.println();

	        // Print the titles of all available books from both libraries
	        System.out.println("Books available in the first library:");
	        firstLibrary.printAvailableBooks();
	        System.out.println();
	        System.out.println("Books available in the second library:");
	        secondLibrary.printAvailableBooks();
	        System.out.println();

	        // Return The Lords of the Rings to the first library
	        System.out.println("Returning The Lord of the Rings:");
	        firstLibrary.returnBook("The Lord of the Rings");
	        System.out.println();

	        // Print the titles of available from the first library
	        System.out.println("Books available in the first library:");
	        firstLibrary.printAvailableBooks();
	    }

}

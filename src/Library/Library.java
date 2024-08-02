package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Library {
   private final List<Book> booksList = new ArrayList<>();

   public Library() {
   }

   public List<Book> getBooksList() {
      return booksList;
   }

   public void addBook(
           Integer isbn, String author, String title, String publishingCompany, LocalDate publicationYear,
           LiteraryGenre literaryGenre, Double price, Integer quantity
   ) {
         Book book = new Book(
                 isbn, author, title, publishingCompany, publicationYear, literaryGenre, price, quantity
         );
         if(this.booksList.contains(book)) {
            Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
            System.out.println("You already have this book in the library, one more will be added to your quantity");
            bookExists.quantity++;
         } else {
            this.booksList.add(book);
         }
   }

   public void removeBook(Book book) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to remove");
      } else {
         this.booksList.remove(book);
      }
   }

   public void editAuthorName(Book book, String authorName) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.
      }

   }

}

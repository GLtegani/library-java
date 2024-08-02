package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
   private final List<Book> booksList = new ArrayList<>();
   private Double priceBook;
   private int bookQuantity;

   public Library() {
   }

   public void addBook(String author, String title, String publishingCompany, LocalDate publicationYear, LiteraryGenre literaryGenre) {
      this.booksList.add(new Book(author, title, publishingCompany, publicationYear, literaryGenre));
   }

   public void removeBook(Book book) {
      if(book == null) {
         throw new LibraryException("This book doesn't exists in Library to remove");
      } else {
         this.booksList.remove(book);
      }
   }

}

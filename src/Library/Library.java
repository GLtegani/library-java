package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
   private final List<Book> booksList = new ArrayList<>();

   public Library() {
   }

   public List<Book> getBooksList() {
      return booksList;
   }

   public final void addBook(
           Integer isbn, String author, String title, String publishingCompany, LocalDate publicationYear,
           LiteraryGenre literaryGenre, Double price, Integer quantity
   ) {
         Book book = new Book(
                 isbn, author, title, publishingCompany, publicationYear, literaryGenre, price, quantity
         );
         if(this.booksList.contains(book)) {
            Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
            System.out.println("You already have this book in the library, so will be added to your quantity");
            bookExists.addQuantity(quantity);
         } else {
            this.booksList.add(book);
         }
   }

   public final void removeBook(Book book, Integer quantity) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to remove");
      } else {
         if(book.getQuantity() - quantity <= 0) {
            this.booksList.remove(book);
         } else {
            book.removeQuantity(quantity);
         }
      }
   }

   public final void editAuthorName(Book book, String authorName) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setAuthor(authorName);
      }
   }

   public final void editTitle(Book book, String title) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setTitle(title);
      }
   }

   public final void editPublishedCompany(Book book, String publishedCompany) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setPublishingCompany(publishedCompany);
      }
   }

   public final void editPublicationYear(Book book, LocalDate publicationYear) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setPublicationYear(publicationYear);
      }
   }

   public final void editLiteraryGenre(Book book, LiteraryGenre literaryGenre) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setLiteraryGenre(literaryGenre);
      }
   }

   public final void editPrice(Book book, Double price) {
      if(!this.booksList.contains(book)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         Book bookExists = (Book) this.booksList.stream().filter(book1 -> book1 == book);
         bookExists.setPrice(price);
      }
   }
}

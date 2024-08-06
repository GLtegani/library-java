package Library;


import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
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
      if(
         isbn == null || isbn == 0 || author == null || title == null || publishingCompany == null || publicationYear == null ||
            literaryGenre == null || price == null || quantity == null
      ) {
         throw new LibraryException("Put the correct information");
      } else {
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

   }

   public final void removeBook(Integer isbn, Integer quantity) {
      if(this.booksList.isEmpty()) {
         throw new LibraryException("You don't have any book in your library");
      } else if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exist in your library");
      } else {
         Iterator<Book> iterator = this.booksList.iterator();
         while (iterator.hasNext()) {
            Book book = iterator.next();
            if (isbn.equals(book.getIsbn())) {
               if (book.getQuantity() - quantity <= 0) {
                  iterator.remove();  // Remove book safely using iterator
               } else {
                  book.removeQuantity(quantity);  // Adjust quantity if sufficient
               }
               return;  // Exit after processing the book
            }
         }
      }
   }

   public final boolean isbnAlreadyExist(Integer isbn) {
      if(isbn == null || isbn == 0) {
         throw new InputMismatchException("Invalid value");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               return true;
            }
         }
         return false;
      }
   }

   public final void editAuthorName(Integer isbn, String authorName) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setAuthor(authorName);
               break;
            }
         }
      }
   }

   public final void editTitle(Integer isbn, String title) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setTitle(title);
               break;
            }
         }
      }
   }

   public final void editPublishingCompany(Integer isbn, String publishingCompany) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setPublishingCompany(publishingCompany);
               break;
            }
         }
      }
   }

   public final void editPublicationYear(Integer isbn, LocalDate publicationYear) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setPublicationYear(publicationYear);
               break;
            }
         }
      }
   }

   public final void editLiteraryGenre(Integer isbn, LiteraryGenre literaryGenre) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setLiteraryGenre(literaryGenre);
               break;
            }
         }
      }
   }

   public final void editPrice(Integer isbn, Double price) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in Library to edit");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               book.setPrice(price);
               break;
            }
         }
      }
   }

   public final void showBook(Integer isbn) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exist to show");
      } else {
         for (Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               System.out.println(book);
            }
         }
      }
   }

   public final @Nullable Book getBook(Integer isbn) {
      if(!isbnAlreadyExist(isbn)) {
         throw new LibraryException("This book doesn't exists in your library");
      } else {
         for(Book book : this.booksList) {
            if(isbn.equals(book.getIsbn())) {
               return book;
            }
         }
      }
      return null;
   }

   @Override
   public final String toString() {
      if(this.booksList.isEmpty()) {
         throw new LibraryException("You don't have any book in your library");
      } else {
         StringBuilder sb = new StringBuilder();
         for(Book book : this.booksList) {
            sb.append("ISBN: ").append(book.getIsbn()).append("\n");
            sb.append("Author name: ").append(book.getAuthor()).append("\n");
            sb.append("Title: ").append(book.getTitle()).append("\n");
            sb.append("Publishing Company: ").append(book.getPublishingCompany()).append("\n");
            sb.append("Publication Year: ").append(book.getPublicationYear()).append("\n");
            sb.append("Literary Genre: ").append(book.getLiteraryGenre()).append("\n");
            sb.append("Price: ").append(String.format("%.2f", book.getPrice())).append("\n");
            sb.append("Quantity: ").append(book.getQuantity()).append("\n");
            sb.append("\n");
         }
         return sb.toString();
      }
   }
}

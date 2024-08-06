package application;

import Library.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import Library.LiteraryGenre;
import Library.LibraryException;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      Library library = new Library();

      int userAnswer = 0;

      while (userAnswer != 5) {
         try {
            System.out.println("Put what you wanna do in your Library");
            System.out.println("1- Add book (1)");
            System.out.println("2- Remove book (2)");
            System.out.println("3- Edit a book (3)");
            System.out.println("4- Show books (4)");
            System.out.println("5- Leave program (5)");
            System.out.print("Enter: ");
            userAnswer = sc.nextInt();
            sc.nextLine();

            switch (userAnswer) {
               case 1:
                  System.out.println("Add new book");
                  System.out.println();
                  System.out.print("ISBN: ");
                  Integer bookIsbn = sc.nextInt();
                  sc.nextLine();
                  if(library.isbnAlreadyExist(bookIsbn)) {
                     System.out.println("You already have this book in your library");
                     library.showBook(bookIsbn);
                     System.out.println();
                     System.out.print("Do you want to add more books like this (y/n)? ");
                     char addBooks = sc.nextLine().charAt(0);

                     if(addBooks == 'y' || addBooks == 'Y') {
                        System.out.print("Book quantity: ");
                        Integer bookQuantity = sc.nextInt();
                        sc.nextLine();
                        if(library.getBook(bookIsbn) != null) {
                           library.getBook(bookIsbn).addQuantity(bookQuantity);
                           System.out.println("Success");
                           System.out.println();
                        } else {
                           System.out.println();
                        }
                     } else {
                        System.out.println("Returning");
                        System.out.println();
                     }
                  } else {
                     System.out.print("Author: ");
                     String bookAuthor = sc.nextLine();
                     System.out.print("Title: ");
                     String bookTitle = sc.nextLine();
                     System.out.print("Publishing Company: ");
                     String bookPublishingCompany = sc.nextLine();
                     System.out.print("Publication Year (dd/mm/yyyy): ");
                     String publicationYear = sc.nextLine();
                     LocalDate bookPublicationYear = LocalDate.parse(publicationYear, formatter);
                     System.out.print("Literary Genre: ");
                     String literaryGenre = sc.nextLine().toUpperCase();
                     LiteraryGenre bookLiteraryGenre = LiteraryGenre.valueOf(literaryGenre);
                     System.out.print("Book price: ");
                     Double bookPrice = sc.nextDouble();
                     System.out.print("Book quantity: ");
                     Integer bookQuantity = sc.nextInt();
                     sc.nextLine();

                     library.addBook(
                        bookIsbn, bookAuthor, bookTitle, bookPublishingCompany, bookPublicationYear, bookLiteraryGenre,
                        bookPrice, bookQuantity
                     );
                     System.out.println("Success");
                     System.out.println();
                  }
                  break;
               case 2:
                  if(library.getBooksList().isEmpty()) {
                     throw new LibraryException("You don't have any book to remove from your library");
                  } else {
                     System.out.println("Which book do you want to remove?");
                     System.out.print("ISBN OF BOOK: ");
                     int isbn = sc.nextInt();
                     sc.nextLine();
                     if(!library.isbnAlreadyExist(isbn)) {
                        String tryOrExit = null;
                        while (!library.isbnAlreadyExist(isbn)  || !tryOrExit.equals("exit") || !tryOrExit.equals("EXIT")) {
                           System.out.println("This book doesn't exist in your library, try again or exit");
                           System.out.print("Type (try) to try again or type (exit) to return: ");
                           tryOrExit = sc.nextLine();
                           if(tryOrExit.equals("try") || tryOrExit.equals("TRY")) {
                              System.out.print("ISBN OF BOOK: ");
                              isbn = sc.nextInt();
                              sc.nextLine();
                              if(library.isbnAlreadyExist(isbn)) {
                                 library.showBook(isbn);
                                 System.out.println();
                                 System.out.print("Enter how many you want to remove: ");
                                 int quantityToRemove = sc.nextInt();
                                 sc.nextLine();
                                 library.removeBook(isbn, quantityToRemove);
                                 System.out.println("Success");
                                 break;
                              }
                           } else if(tryOrExit.equals("exit") || tryOrExit.equals("EXIT")) {
                              System.out.println("Returning");
                              break;
                           }
                        }
                     } else {
                        library.showBook(isbn);
                        System.out.println();
                        System.out.print("Enter how many you want to remove: ");
                        int quantityToRemove = sc.nextInt();
                        sc.nextLine();
                        library.removeBook(isbn, quantityToRemove);
                        System.out.println("Success");
                     }
                  }
                  System.out.println();
                  break;
               case 3:
                  if(library.getBooksList().isEmpty()) {
                     throw new LibraryException("You don't have any book in your library to edit");
                  } else {
                     System.out.println("Edit Book");
                     System.out.println();
                     System.out.println("1- Edit author name (1)");
                     System.out.println("2- Edit title (2)");
                     System.out.println("3- Edit publishing company (3)");
                     System.out.println("4- Edit publication year (4)");
                     System.out.println("5- Edit literary genre (5)");
                     System.out.println("6- Edit price (6)");
                     System.out.print("Enter: ");
                     int fieldToEdit = sc.nextInt();
                     sc.nextLine();
                     Integer isbnToEdit = null;
                     switch (fieldToEdit) {
                        case 1:
                           System.out.print("Enter ISBN of book you want to edit author name or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new author name to this book: ");
                              String newAuthorName = sc.nextLine();
                              library.editAuthorName(isbnToEdit, newAuthorName);
                              System.out.println("Success");
                           }
                           break;
                        case 2:
                           System.out.print("Enter ISBN of book you want to edit title or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new title to this book: ");
                              String newTitle = sc.nextLine();
                              library.editTitle(isbnToEdit, newTitle);
                              System.out.println("Success");
                           }
                           break;
                        case 3:
                           System.out.print("Enter ISBN of book you want to edit publishing company or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new publishing company to this book: ");
                              String newPublishingCompany = sc.nextLine();
                              library.editPublishingCompany(isbnToEdit, newPublishingCompany);
                              System.out.println("Success");
                           }
                           break;
                        case 4:
                           System.out.print("Enter ISBN of book you want to edit publication year or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new publication year to this book (dd/mm/yyyy): ");
                              String publicationYear = sc.nextLine();
                              LocalDate newPublicationYear = LocalDate.parse(publicationYear, formatter);
                              library.editPublicationYear(isbnToEdit, newPublicationYear);
                              System.out.println("Success");
                           }
                           break;
                        case 5:
                           System.out.print("Enter ISBN of book you want to edit literary genre or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new literary genre to this book: ");
                              String literaryGenre = sc.nextLine().toUpperCase();
                              LiteraryGenre newLiteraryGenre = LiteraryGenre.valueOf(literaryGenre);
                              library.editLiteraryGenre(isbnToEdit, newLiteraryGenre);
                              System.out.println("Success");
                           }
                           break;
                        case 6:
                           System.out.print("Enter ISBN of book you want to edit price or 0 to return:  ");
                           isbnToEdit = sc.nextInt();
                           sc.nextLine();
                           if(isbnToEdit == 0) {
                              System.out.println("Returning");
                           } else {
                              library.showBook(isbnToEdit);
                              System.out.print("Enter new price to this book: ");
                              double newPrice = sc.nextDouble();
                              library.editPrice(isbnToEdit, newPrice);
                              System.out.println("Success");
                           }
                           break;
                     }
                     System.out.println();
                     break;
                  }
               case 4:
                  if(library.getBooksList().isEmpty()) {
                     throw new LibraryException("You don't have any book in your library to show");
                  } else {
                     System.out.println("Books list");
                     System.out.println();
                     System.out.println(library);
                     System.out.println();
                  }
                  break;
               case 5:
                  System.out.println("End");
                  System.out.println();
                  break;
               default:
                  System.out.println("This option doesn't exists, try again");
                  System.out.println();
                  break;
            }
         } catch (LibraryException e) {
            System.err.println(e.getMessage());
            System.out.println();
         } catch (InputMismatchException | DateTimeParseException | IllegalArgumentException e) {
            System.err.println("The argument doesn't match, try again");
            sc.nextLine();
            System.out.println();
         }
      }

      sc.close();
   }
}
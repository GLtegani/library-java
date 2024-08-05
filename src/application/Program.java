package application;

import Library.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import Library.LiteraryGenre;
import Library.LibraryException;

public class Program {
   public static void main(String[] args) {
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
            System.out.print("Type: ");
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
                     String literaryGenre = sc.nextLine();
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
                     System.out.println();
                  }
                  break;
               case 2:
                  System.out.println("Remove Book");
                  System.out.println();
                  System.out.println();
                  break;
               case 3:
                  System.out.println("Edit Book");
                  System.out.println();
                  System.out.println();
                  break;
               case 4:
                  System.out.println("Books list");
                  System.out.println();
                  System.out.println(library);
                  System.out.println();
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
            System.err.println(e);
            System.out.println();
         } catch (InputMismatchException | DateTimeParseException e) {
            System.err.println("The argument doesn't match, try again");
            sc.nextLine();
            System.out.println();
         }
      }

      sc.close();
   }
}
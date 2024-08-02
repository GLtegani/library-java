package application;

import Library.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Book book = new Book();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String date = sc.nextLine();
      LocalDate date1 = LocalDate.parse(date, formatter);



      sc.close();
   }
}
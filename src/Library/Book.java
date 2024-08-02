package Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
   protected String author;
   protected String title;
   protected String publishingCompany;
   protected LocalDate publicationYear;
   private LiteraryGenre literaryGenre;
   private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   protected Book() {
   }

   protected Book(String author, String title, String publishingCompany, LocalDate publicationYear, LiteraryGenre literaryGenre) {
      this.author = author;
      this.title = title;
      this.publishingCompany = publishingCompany;
      this.publicationYear = publicationYear;
      this.literaryGenre = literaryGenre;
   }

   public final String getAuthor() {
      return author;
   }

   public final String getTitle() {
      return title;
   }

   public final String getPublishingCompany() {
      return publishingCompany;
   }

   public final String getPublicationYear() {
      return this.publicationYear.format(this.formatter);
   }

}

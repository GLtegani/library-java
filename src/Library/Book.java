package Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
   private Integer isbn;
   private String author;
   private String title;
   private String publishingCompany;
   private LocalDate publicationYear;
   private LiteraryGenre literaryGenre;
   private Double price;
   private Integer quantity;
   private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   protected Book() {
   }

   protected Book(
           Integer isbn, String author, String title, String publishingCompany, LocalDate publicationYear,
           LiteraryGenre literaryGenre, Double price, Integer quantity
   ) {
      this.isbn = isbn;
      this.author = author;
      this.title = title;
      this.publishingCompany = publishingCompany;
      this.publicationYear = publicationYear;
      this.literaryGenre = literaryGenre;
      this.price = price;
      this.quantity = quantity;
   }

   public final Integer getIsbn() {
      return isbn;
   }

   public final void setIsbn(Integer isbn) {
      this.isbn = isbn;
   }

   public final String getAuthor() {
      return author;
   }

   public final void setAuthor(String author) {
      this.author = author;
   }

   public final String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPublishingCompany() {
      return publishingCompany;
   }

   public void setPublishingCompany(String publishingCompany) {
      this.publishingCompany = publishingCompany;
   }

   public LocalDate getPublicationYear() {
      return publicationYear;
   }

   public void setPublicationYear(LocalDate publicationYear) {
      this.publicationYear = publicationYear;
   }

   public Library.LiteraryGenre getLiteraryGenre() {
      return literaryGenre;
   }

   public void setLiteraryGenre(Library.LiteraryGenre literaryGenre) {
      this.literaryGenre = literaryGenre;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
}

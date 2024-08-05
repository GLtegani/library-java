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

   protected final void setIsbn(Integer isbn) {
      this.isbn = isbn;
   }

   public final String getAuthor() {
      return author;
   }

   protected final void setAuthor(String author) {
      this.author = author;
   }

   public final String getTitle() {
      return title;
   }

   protected final void setTitle(String title) {
      this.title = title;
   }

   public final String getPublishingCompany() {
      return publishingCompany;
   }

   protected final void setPublishingCompany(String publishingCompany) {
      this.publishingCompany = publishingCompany;
   }

   public final String getPublicationYear() {
      return this.formatter.format(this.publicationYear);
   }

   protected final void setPublicationYear(LocalDate publicationYear) {
      this.publicationYear = publicationYear;
   }

   public final LiteraryGenre getLiteraryGenre() {
      return literaryGenre;
   }

   protected final void setLiteraryGenre(LiteraryGenre literaryGenre) {
      this.literaryGenre = literaryGenre;
   }

   public final Double getPrice() {
      return price;
   }

   protected final void setPrice(Double price) {
      this.price = price;
   }

   public final Integer getQuantity() {
      return quantity;
   }

   public final void addQuantity(Integer quantity) {
      this.quantity += quantity;
   }

   public final void removeQuantity(Integer quantity) {
      this.quantity -= quantity;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Book \n");
      sb.append("ISBN: " + getIsbn() + "\n");
      sb.append("Author name: " + getAuthor() + "\n");
      sb.append("Title: " + getTitle() + "\n");
      sb.append("Publishing Company: " + getPublishingCompany() + "\n");
      sb.append("Publication Year: " + getPublicationYear() + "\n");
      sb.append("Literary Genre: " + getLiteraryGenre() + "\n");
      sb.append("Price: " + String.format("%.2f", getPrice()) + "\n");
      sb.append("Quantity: " + getQuantity() + "\n");

      return sb.toString();
   }
}

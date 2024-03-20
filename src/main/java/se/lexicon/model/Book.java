package se.lexicon.model;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;
    //private Person borrower;

    public Book(String title, String author) {
        this.id = generateBookId();
        setTitle(title);
        setAuthor(author);
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        this.borrower = borrower;
        this.available = false;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return this.id;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public String getTitle() {
        return title;
    }

    private String generateBookId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getBookInformation() {
        String result = "Book: " + getTitle() +
                ", Id: " + getId() +
                ", Is Available: " + isAvailable();
        if (borrower == null) {
            result += ", Borrower: not borrowed";
        } else {
            result += ", Borrower: " + borrower.getFirstName() + " " + borrower.getLastName();
        }

        return result;

    }
}
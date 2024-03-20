package se.lexicon.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Person {
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Book[] borrowedBooks = new Book[0];

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    private static int getNextId() {
        return ++sequencer;
    }

    public void loanBook(Book book) {
        if (book.isAvailable()){
            borrowedBooks = Arrays.copyOf(borrowedBooks, borrowedBooks.length+1);
            borrowedBooks[borrowedBooks.length-1] = book;
            book.setBorrower(this);
        }
    }


    public void returnBook(Book book) { // book2
        if (book == null) throw new IllegalArgumentException("BOok should not be null.");
        int index = -1; // 1
        for (int i = 0; i < borrowedBooks.length; i++) { // [book1,book2,book3 ]
            if (borrowedBooks[i].getId().equals(book.getId())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Book data does not found.");
        } else {
            Book[] newArrays = Arrays.copyOf(borrowedBooks, borrowedBooks.length - 1);// [null,null ]
            for (int i = 0; i < borrowedBooks.length; i++) { // [book1,book2,book3 ]
                if (i == index) continue;
                newArrays[i] = borrowedBooks[i];// [book1,book2 ]
            }
            borrowedBooks = newArrays;
            book.setBorrower(null);
        }


    }
    //check if book is available
    //if not available then

    public String getPersonInformation() {
        return "Person: " + getFirstName() + " " + getLastName() + ", Id:" + getId() + ", BorrowedBooks.length: " + borrowedBooks.length;
    }
}
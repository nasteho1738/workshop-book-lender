package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        Person erik = new Person("Erik", "Lengyel");
        System.out.println(erik.getPersonInformation());

        Book javaFullStack = new Book("Java Full Stack", "Mehrdad Javan");
        System.out.println(javaFullStack.getBookInformation());

        erik.loanBook(javaFullStack); // todo: implement the loanBook

        System.out.println(erik.getPersonInformation()); // 1
        System.out.println(javaFullStack.getBookInformation()); // Erik Lengyel

        erik.returnBook(javaFullStack);


        System.out.println(erik.getPersonInformation()); // 0
        System.out.println(javaFullStack.getBookInformation()); // not borrowed



    }

}
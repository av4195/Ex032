package com.example.ex032;

import java.io.Console;

public class Book extends LibraryItem implements Searchable, Displayable{
    private int numOfPages;
    private String author;

    public Book(String title, int yearPublished, int numOfPages, String author){
        super(title, yearPublished);
        this.numOfPages=numOfPages;
        this.author=author;
    }

    @Override
    public double calculateLateFee(int daysPastDue){
        return (0.5*daysPastDue);
    }

    public boolean matches(String query){
        return ((getTitle().contains(query)) || this.author.contains(query));
    }

    public void displayFullDetails(){
        System.out.println(toString() + ", numOfPages= " + numOfPages + ", author= " + author);
    }

}

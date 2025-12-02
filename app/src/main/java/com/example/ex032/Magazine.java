package com.example.ex032;

public class Magazine extends LibraryItem implements Searchable, Displayable {
    private int issueNumber;
    private String editorName;

    public Magazine(String title, int yearPublished, int issueNumber, String editorName) {
        super(title, yearPublished);
        this.issueNumber = issueNumber;
        this.editorName = editorName;
    }

    @Override
    public double calculateLateFee(int daysPastDue) {
        return (2.0* daysPastDue);
    }

    public boolean matches(String query){
        return ((getTitle().contains(query)) || this.editorName.contains(query));
    }

    public void displayFullDetails(){
        System.out.println(toString() + ", issueNumber= " + issueNumber + ", editorName= " + editorName);
    }
}
package com.example.ex032;

import java.util.UUID;

public abstract class LibraryItem {
    private final UUID itemId;
    private String title;
    private int yearPublished;
    private boolean isBorrowed;

    public LibraryItem(String title, int yearPublished){
        this.itemId=UUID.randomUUID();
        this.title= title;
        this.yearPublished = yearPublished;
        this.isBorrowed = false;
    }

    public UUID getItemId(){
        return this.itemId;
    }
    public String getTitle(){
        return this.title;
    }
    public int getYearPublished(){
        return this.yearPublished;
    }
    public boolean getIsBorrowed(){
        return this.isBorrowed;
    }

    public void borrow(){
        if(this.isBorrowed == false){
            this.isBorrowed=true;
        }
    }

    public void returnItem(){
        this.isBorrowed=false;
    }

    public abstract double calculateLateFee(int daysPastDue);

    @Override
    public String toString(){
        return "itemID= " + itemId + ", title= " + title + ", yearPublished= " + yearPublished + ", isBorrowed= " + isBorrowed;
    }


}

package com.example.ex032;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }
    public void main(){
        Map<UUID, LibraryItem> inventory = new HashMap<>();
        Book b = new Book("the selection",2012,352,"Kiera Cass");
        Book b2 = new Book("Herry potter",1998,223,"J. K. Rowling");
        Book b3 = new Book("k",5,5,"g");
        Magazine m = new Magazine("Velvet Vision",2025,12,"Emma Rothwell");
        Magazine m1= new Magazine("Urban Style Weekly",2027,7,"Jordan Hale");

        inventory.put(b.getItemId(),b);
        inventory.put(b2.getItemId(),b2);
        inventory.put(b3.getItemId(),b3);
        inventory.put(m.getItemId(),m);
        inventory.put(m1.getItemId(),m1);

        UUID rand = UUID.randomUUID();
        UUID b2UUID = b2.getItemId();
        if (inventory.get(b2UUID) instanceof Displayable) {
            ((Displayable) inventory.get(b2UUID)).displayFullDetails();
        }
        if (inventory.get(rand) instanceof Displayable) {
            ((Displayable) inventory.get(rand)).displayFullDetails();
        }else {
            System.out.println("Not working");
        }

        m1.borrow();
        b3.borrow();


        for (LibraryItem item : inventory.values()) {
            if(item.getIsBorrowed()){
                System.out.println(item.calculateLateFee(10));
            }
        }

        String search = "g";
        for(LibraryItem item : inventory.values()) {
            if(item instanceof Searchable){
                if(((Searchable) item).matches(search)){
                    System.out.println(item.toString());
                }
            }
        }

    }
}
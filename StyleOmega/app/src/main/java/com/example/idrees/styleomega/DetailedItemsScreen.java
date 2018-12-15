package com.example.idrees.styleomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailedItemsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_items_screen);
    }
    public void onClick(View v){

        startActivity(new Intent(DetailedItemsScreen.this,ShoppingCart.class));
    }
}

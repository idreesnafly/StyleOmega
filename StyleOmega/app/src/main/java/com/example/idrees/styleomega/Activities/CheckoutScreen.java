package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.idrees.styleomega.R;

public class CheckoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_screen);
    }
    public void onClick(View v){

        startActivity(new Intent(CheckoutScreen.this,Homepage.class));
    }
}

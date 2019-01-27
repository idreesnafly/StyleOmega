package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_screen);

        ListView ls=(ListView)findViewById(R.id.buylistview);

        Intent in=getIntent();
        Long ID=in.getLongExtra("UID",10);

        final Product product=Product.findById(Product.class,ID);
        String prodname=product.getProductName();
        String prodprice=product.getProductPrice().toString();






    }
    public void onClick(View v){

        startActivity(new Intent(CheckoutScreen.this,Homepage.class));
    }
}

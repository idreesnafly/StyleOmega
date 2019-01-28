package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_screen);

        TextView prodnametxt=(TextView)findViewById(R.id.checknametxt);
        TextView prodpricetxt=(TextView)findViewById(R.id.checkprice);
        TextView subtotal=(TextView)findViewById(R.id.subtotal);
        TextView total=(TextView)findViewById(R.id.total);

        Intent in=getIntent();
        Long ID=in.getLongExtra("UID",10);

        double priceprod=in.getLongExtra("PRICE",10);
        int quantity=in.getIntExtra("QUANTITY",10);



        final Product product=Product.findById(Product.class,ID);
        String prodname=product.getProductName();
        String prodprice=product.getProductPrice().toString();

        prodnametxt.setText("Product Name"+String.valueOf(prodname));
        prodpricetxt.setText("LKR "+String.valueOf(prodprice));

        subtotal.setText("LKR "+String.valueOf(prodprice));
        total.setText("LKR "+String.valueOf(prodprice));








    }
    public void onClick(View v){

        startActivity(new Intent(CheckoutScreen.this,Homepage.class));
    }
}

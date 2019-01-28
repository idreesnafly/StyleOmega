package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_screen);

        setTitle("Checkout");
        TextView prodnametxt=(TextView)findViewById(R.id.checknametxt);
        TextView prodpricetxt=(TextView)findViewById(R.id.checkprice);
        TextView subtotal=(TextView)findViewById(R.id.subtotal);
        TextView total=(TextView)findViewById(R.id.total);
        Button placeorder=(Button)findViewById(R.id.placeOrderBtn);

        SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        final Long userID=sp.getLong("ID",10);

        final List <Cart> orders=Cart.find(Cart.class,"user=?",userID.toString());
        final Cart cart=orders.get(0);
        Long CartID=cart.getId();

        final List<CartItem> cartit=CartItem.find(CartItem.class,"cartorder=?",CartID.toString());


        Intent in=getIntent();
        Long ID=in.getLongExtra("UID",10);
        double priceprod=in.getLongExtra("PRICE",10);
        final int quantity=in.getIntExtra("QUANTITY",10);

        final Product product=Product.findById(Product.class,ID);
        String prodname=product.getProductName();
        String prodprice=product.getProductPrice().toString();


        subtotal.setText("LKR "+String.valueOf(prodprice));
        total.setText("LKR "+String.valueOf(prodprice));


        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Cart cart=orders.get(0);
                cart.setStatus("Confirmed");


                CartItem cartItem=cartit.get(0);
                int quan=cartItem.getQuantity();
                int newquantity=quantity-quan;
                cartItem.setQuantity(newquantity);
                cart.save();
                cartItem.save();
                Toast.makeText(getApplicationContext(),"Your order has been successfully placed",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CheckoutScreen.this,Homepage.class));

            }
        });






    }
    public void onClick(View v){

        startActivity(new Intent(CheckoutScreen.this,Homepage.class));
    }
}

package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.idrees.styleomega.Adapter.cartadapter;
import com.example.idrees.styleomega.Model.CartItem;

import com.example.idrees.styleomega.R;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        Long userID=sp.getLong("ID",10);

        ListView cartlistview=(ListView)findViewById(R.id.cartList);
        List<CartItem> orditem=CartItem.listAll(CartItem.class);


        //List <Orders> orders=Orders.findWithQuery(Orders.class,"Select * from Orders where user=? and status=?",userID.toString(),"Pending");
        cartadapter cartadap=new cartadapter(getApplicationContext(),R.layout.customcartview,orditem);
        //productAdapter pro=new productAdapter(getApplicationContext(),R.layout.customcartview,orditem);

        cartlistview.setAdapter(cartadap);

    }

    public void onClick(View v){

        startActivity(new Intent(ShoppingCart.this,CheckoutScreen.class));
    }

}

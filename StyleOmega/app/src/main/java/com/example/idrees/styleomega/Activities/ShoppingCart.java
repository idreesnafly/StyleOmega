package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Adapter.cartadapter;
import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.Model.User;
import com.example.idrees.styleomega.R;



import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    private double price;
    private int quantity1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
          setTitle("My Cart");
        SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        Long userID=sp.getLong("ID",10);

        ListView cartlistview=(ListView)findViewById(R.id.cartList);
        TextView noofitems=(TextView)findViewById(R.id.noofitems);
        TextView totalprice=(TextView)findViewById(R.id.textView18);


        List <Cart> orders=Cart.find(Cart.class,"user=?",userID.toString());
        Cart cart=orders.get(0);
        Long CartID=cart.getId();

        List<CartItem> cartit=CartItem.find(CartItem.class,"cartorder=?",CartID.toString());
        //List<CartItem> orditem=CartItem.listAll(CartItem.class);

        Intent in=getIntent();
        String size=in.getStringExtra("SIZE");
        String color=in.getStringExtra("COLOR");
        int quantity=in.getIntExtra("QUANTITY",0);

        for(CartItem ct: cartit ){
            double price1=(ct.getProduct().getProductPrice())*(ct.getQuantity());
            price+=price1;
            quantity1+=ct.getQuantity();
        }

        noofitems.setText("No.of Items: "+String.valueOf(quantity1));
        totalprice.setText("Total: LKR "+String.valueOf(price));

        cartadapter cartadap=new cartadapter(getApplicationContext(),R.layout.cartitem,cartit,size,color,quantity);
        cartlistview.setAdapter(cartadap);

    }

    public void onClick(View v){
        Bundle bun=new Bundle();
        bun.putDouble("PRICE",price);
        bun.putInt("QUANTITY",quantity1);
        startActivity(new Intent(ShoppingCart.this,CheckoutScreen.class));
    }

}

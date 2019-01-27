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

        SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        Long userID=sp.getLong("ID",10);

        ListView cartlistview=(ListView)findViewById(R.id.cartList);
        TextView noofitems=(TextView)findViewById(R.id.noofitems);
        TextView totalprice=(TextView)findViewById(R.id.textView18);


//        final int count = cartlistview.getAdapter().getCount();


        //noofitems.setText(String.valueOf(count));

        List <Cart> orders=Cart.find(Cart.class,"user=?",userID.toString());

        /*List <Cart> cartttt=Cart.listAll(Cart.class);
        List <CartItem> cartitrm=CartItem.listAll(CartItem.class);
        List <User> userr=User.listAll(User.class);
        List <Product> prod=Product.listAll(Product.class);*/


        List<CartItem> cartit=CartItem.find(CartItem.class,"cartorder=?",orders.toString());
        //List <CartItem> aaa=CartItem.findWithQuery(CartItem.class,"Select * from CartItem where cartorder=?",String.valueOf(orders));
        List<CartItem> orditem=CartItem.listAll(CartItem.class);

        Intent in=getIntent();
        String size=in.getStringExtra("SIZE");
        String color=in.getStringExtra("COLOR");
        int quantity=in.getIntExtra("QUANTITY",0);


        for(CartItem ct: orditem ){
            double price1=(ct.getProduct().getProductPrice())*(ct.getQuantity());
            price+=price1;
            quantity1+=ct.getQuantity();
        }

        noofitems.setText(String.valueOf(quantity1));
        totalprice.setText(String.valueOf(price));


        cartadapter cartadap=new cartadapter(getApplicationContext(),R.layout.customcartview,orditem,size,color,quantity);
        //productAdapter pro=new productAdapter(getApplicationContext(),R.layout.customcartview,orditem);

        cartlistview.setAdapter(cartadap);

    }

    public void onClick(View v){


        startActivity(new Intent(ShoppingCart.this,CheckoutScreen.class));
    }

}

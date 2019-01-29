package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Adapter.reviewAdapter;
import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.Model.Reviews;
import com.example.idrees.styleomega.Model.User;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class DetailedItemsScreen extends AppCompatActivity {


    Long prodID;
    User user;
    int quantity1;
    Date date;
    float ratingval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product_detail_screen);

        setTitle("Product Details");
        TextView pName=(TextView)findViewById(R.id.prodNameTxt);
        TextView pPrice=(TextView)findViewById(R.id.priceTxt);
        TextView pDesc=(TextView)findViewById(R.id.descriptionTxt);
        ImageView img=(ImageView)findViewById(R.id.prodImage);
        Button buynowBtn=(Button)findViewById(R.id.buynowBtn);
        Button addBtn=(Button)findViewById(R.id.addtoCartBtn);
        ImageView sharbtn=(ImageView)findViewById(R.id.share);
        final Spinner size=(Spinner)findViewById(R.id.spinnersize);
        final Spinner quantity = (Spinner)findViewById(R.id.spinnerquantity);
        final Spinner color=(Spinner)findViewById(R.id.spinnercolour);

        Button reviewBtn=(Button)findViewById(R.id.reviewBtn);
        RatingBar rating=(RatingBar)findViewById(R.id.ratingBar);
        final EditText comment=(EditText)findViewById(R.id.commenttxt);
        final ListView ls=(ListView)findViewById(R.id.commentlist);
        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailedItemsScreen.this,ShoppingCart.class));
            }
        });


        final Long ID=getIntent().getLongExtra("PRODUCTID",0);
        Toast.makeText(getApplicationContext(),ID.toString(),Toast.LENGTH_SHORT).show();

        date=new Date();

        // List<Product> prodlist=Product.listAll(Product.class);

        final Product product=Product.findById(Product.class,ID);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingval=rating;
            }
        });

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getApplicationContext().getSharedPreferences
                        (SignIn.mypreference,Context.MODE_PRIVATE);
                final long USERID=sp.getLong("ID",10);
                User currentUser=User.findById(User.class,USERID);
                String commentTxt=comment.getText().toString();
                Reviews rr=new Reviews(currentUser,product,ratingval,commentTxt);
                rr.save();
                comment.setText("");

            }
        });

        List <Reviews> reviews=Reviews.findWithQuery(Reviews.class,
                "Select * from Reviews where product=?",product.getId().toString());
        final reviewAdapter reviewAdapter=new reviewAdapter(getApplicationContext(),reviews);
        ls.setAdapter(reviewAdapter);

        pName.setText(product.getProductName());
        pPrice.setText("LKR "+product.getProductPrice());
        pDesc.setText(product.getDescription());

        Picasso.get().load(product.getProductImage()).fit().into(img);

        sharbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product prod=product;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String Shareimg=product.getProductImage().toString();
                String sharename=product.getProductName();
                String shareprice=product.getProductPrice().toString();
                share.putExtra(Intent.EXTRA_SUBJECT, Shareimg);
                share.putExtra(Intent.EXTRA_TEXT, Shareimg);
                startActivity(Intent.createChooser(share, "Share Via"));
            }
        });

        buynowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bun=new Bundle();
                bun.putLong("UID",ID);
                startActivity(new Intent(DetailedItemsScreen.this,CheckoutScreen.class));

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final int quantity1=Integer.parseInt(quantity.getSelectedItem().toString());
                final String size1=size.getSelectedItem().toString();
                final String color1=color.getSelectedItem().toString();

                Bundle bundle=new Bundle();
                bundle.putString("SIZE",size1);
                bundle.putString("COLOR",color1);
                bundle.putInt("QUANTITY",quantity1);

                SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
                final Long UserID=sp.getLong("ID",10);
                User user=User.findById(User.class,UserID);
                Long id=user.getId();

                List<Cart> order=Cart.find(Cart.class,"user=? and status=?",id.toString(),"Pending");
                if(order.size()>0){
                    Cart cart = order.get(0);
                    List <CartItem> od=CartItem.find(CartItem.class,"cartorder=? and products=?",cart.getId().toString(),ID.toString());
                    if(od.size()==0){
                        CartItem orditem=new CartItem(quantity1,date,cart,product);
                        orditem.save();
                        Toast.makeText(getApplicationContext(),"Product added to your existing cart",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        CartItem cart1=od.get(0);
                        cart1.setQuantity(quantity1);
                        cart1.save();
                        Toast.makeText(getApplicationContext(),"Product updated in Cart",Toast.LENGTH_SHORT).show();
                    }
                }else if (order.size()==0){
                    Cart order1 = new Cart(product.getProductPrice(),"Pending",user);//add the variables
                    order1.save();

                    CartItem orderitem=new CartItem(quantity1,date,order1,product);//add
                    orderitem.save();
                    Toast.makeText(getApplicationContext(),"Product Added to your Order",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

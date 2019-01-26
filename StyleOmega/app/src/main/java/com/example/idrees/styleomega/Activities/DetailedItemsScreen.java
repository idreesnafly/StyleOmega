package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product_detail_screen);

        TextView pName=(TextView)findViewById(R.id.prodNameTxt);
        TextView pPrice=(TextView)findViewById(R.id.priceTxt);
        TextView pDesc=(TextView)findViewById(R.id.descriptionTxt);
        ImageView img=(ImageView)findViewById(R.id.prodImage);
        Button buynowBtn=(Button)findViewById(R.id.buynowBtn);
        Button addBtn=(Button)findViewById(R.id.addtoCartBtn);
        ImageView sharbtn=(ImageView)findViewById(R.id.share);
        Spinner size=(Spinner)findViewById(R.id.spinnersize);
        final Spinner quantity = (Spinner)findViewById(R.id.spinnerquantity);
        Spinner color=(Spinner)findViewById(R.id.spinnercolour);


//        final Spinner finalQuantity = quantity;
//        quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                quantity1=(Integer) quantity.getItemAtPosition(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


        /*String size1=size.getSelectedItem().toString();
        String color1=color.getSelectedItem().toString();*/

        //Bundle bundle=getIntent().getExtras();
        final Long ID=getIntent().getLongExtra("PRODUCTID",0);
        Toast.makeText(getApplicationContext(),ID.toString(),Toast.LENGTH_SHORT).show();

        date=new Date();

       // List<Product> prodlist=Product.listAll(Product.class);

        final Product product=Product.findById(Product.class,ID);

        pName.setText(product.getProductName());
        pPrice.setText("RS: "+product.getProductPrice());
        pDesc.setText(product.getDescription());

        Picasso.get().load(product.getProductImage()).fit().into(img);

        sharbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product prod=product;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String Shareimg=product.getProductImage().toString();
                share.putExtra(Intent.EXTRA_SUBJECT, Shareimg);
                share.putExtra(Intent.EXTRA_TEXT, Shareimg);
                startActivity(Intent.createChooser(share, "Share Via"));
            }
        });

        buynowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailedItemsScreen.this,ShoppingCart.class));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                final int quantity1=Integer.parseInt(quantity.getSelectedItem().toString());

                SharedPreferences sp=getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
                final Long UserID=sp.getLong("ID",10);
                User user=User.findById(User.class,UserID);
                //Product prod=Product.findById(Product.class,prodID);
               // User user1=User.findById(User.class,UserID);
                //user=user1;

                List<Cart> order=Cart.find(Cart.class,"user=? and status=?",UserID.toString(),"Pending");
                if(order.size()>0){
                    Cart cart = order.get(0);
                    List <CartItem> od=CartItem.find(CartItem.class,"order=? and product=?",cart.getId().toString(),ID.toString());
                    if(od.size()==0){
                        CartItem orditem=new CartItem(quantity1,date,cart,product);
                        orditem.save();
                        Toast.makeText(getApplicationContext(),"Cart Updated",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        CartItem cart1=od.get(0);
                        cart1.setQuantity(quantity1);
                        cart1.save();
                        Toast.makeText(getApplicationContext(),"Product updated in Cart",Toast.LENGTH_SHORT).show();

                    }

                    //order number and product number
                    //check that list if 0
                    //if not 0 take the first item and change quantity
                    //if 0 create create new order item pass the ordeer num
                }else{
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

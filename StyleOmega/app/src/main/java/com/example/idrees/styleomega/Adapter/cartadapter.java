package com.example.idrees.styleomega.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class cartadapter extends ArrayAdapter <CartItem> {

    Context context;

    String size,color;;
    int quantity;

    public cartadapter(Context context, int resource,List<CartItem> cartit,String size,String color,int quantity) {
        super(context, resource,cartit);
        this.context=context;
        this.size=size;
        this.color=color;
        this.quantity=quantity;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        final CartItem orditem=getItem(position);


        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.cartitem,parent,false);

        }
        ImageView prodImg=(ImageView)convertView.findViewById(R.id.cartpic);
        TextView name=(TextView)convertView.findViewById(R.id.cartprodname);
        TextView size1=(TextView)convertView.findViewById(R.id.cartsize);
        TextView price=(TextView)convertView.findViewById(R.id.cartprice);
        TextView color1=(TextView)convertView.findViewById(R.id.cartcolor);
        TextView quantity1=(TextView)convertView.findViewById(R.id.cartquan);






        Product prod=orditem.getProduct();
        name.setText(prod.getProductName());
        price.setText("LKR "+prod.getProductPrice().toString());
        Picasso.get().load(prod.getProductImage()).fit().into(prodImg);
        size1.setText("Size: "+size);
        color1.setText("Color: "+color);
        quantity1.setText("Quantity: "+String.valueOf(quantity));


        return convertView;
    }
}


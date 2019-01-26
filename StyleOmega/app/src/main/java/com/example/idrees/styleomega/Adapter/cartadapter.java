package com.example.idrees.styleomega.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class cartadapter extends ArrayAdapter <CartItem> {

    Context context;

    public cartadapter(Context context, int resource,List<CartItem> orderitem) {
        super(context, resource,orderitem);
        this.context=context;

    }

    public View getView(int position, View convertView, ViewGroup parent){

        final CartItem orditem=getItem(position);


        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.customcartview,parent,false);

        }
        ImageView prodImg=(ImageView)convertView.findViewById(R.id.cartimg);
        ImageView deleteimg=(ImageView)convertView.findViewById(R.id.deletimg);
        TextView name=(TextView)convertView.findViewById(R.id.cartprodname);
        TextView size=(TextView)convertView.findViewById(R.id.cartsize);
        TextView price=(TextView)convertView.findViewById(R.id.cartprice);
        TextView color=(TextView)convertView.findViewById(R.id.cartcolor);


        Product prod=orditem.getProduct();
        name.setText(prod.getProductName());
        price.setText(prod.getProductPrice().toString());
        Picasso.get().load(prod.getProductImage()).fit().into(prodImg);




        return convertView;
    }
}


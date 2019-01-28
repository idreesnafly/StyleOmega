package com.example.idrees.styleomega.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.idrees.styleomega.Activities.DetailedItemsScreen;
import com.squareup.picasso.Picasso;

import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.List;
public class productAdapter extends ArrayAdapter<Product> {
    public productAdapter(Context context, int resource, List <Product> prodlist) {
        super(context, resource, prodlist);
        this.context = context;
    }
Context context;


    public View getView(int position, View convertView, ViewGroup parent){

        final Product prod=getItem(position);


        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.customlistview,parent,false);

        }
        ImageView prodImg=(ImageView)convertView.findViewById(R.id.imageView3);
        TextView prodname=(TextView)convertView.findViewById(R.id.nametxt1);
        TextView prodnprice=(TextView)convertView.findViewById(R.id.pricetxt1);
        TextView prodavailability=(TextView)convertView.findViewById(R.id.availabilityTxt);
        ListView ls=(ListView)convertView.findViewById(R.id.listview1);
        ConstraintLayout con=(ConstraintLayout)convertView.findViewById(R.id.productView);

        prodname.setText(prod.getProductName());
        prodnprice.setText("Rs: "+prod.getProductPrice().toString());
        prodavailability.setText(prod.getAvailability().toString());
        Picasso.get().load(prod.getProductImage()).fit().into(prodImg);


        if (prod.getQuantity()==0){
            prod.setAvailability(false);
        }
        if(prod.getAvailability()==true){
            prodavailability.setText("IN STOCK");
            prodavailability.setTextColor(Color.parseColor("#006600"));
        }
        else
        {
            prodavailability.setText("OUT OF STOCK");
            prodavailability.setTextColor(Color.parseColor("#cd2626"));
        }

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long ID=prod.getId();

                Intent myIntent = new Intent(getContext(), DetailedItemsScreen.class);
                myIntent.putExtra("PRODUCTID",ID);
                context.startActivity(myIntent);
            }
        });
        return convertView;
    }
}

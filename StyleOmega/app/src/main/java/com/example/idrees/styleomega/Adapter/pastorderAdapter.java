package com.example.idrees.styleomega.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class pastorderAdapter extends ArrayAdapter <CartItem> {

    public pastorderAdapter(Context context, int resource, List<CartItem> objects) {
        super(context, resource, objects);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final CartItem orditem = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pastorderitem, parent, false);

        }

        Product prod=orditem.getProduct();

        TextView name=(TextView)convertView.findViewById(R.id.psname);
        TextView date=(TextView)convertView.findViewById(R.id.psdate);
        TextView price=(TextView)convertView.findViewById(R.id.psprice);
        ImageView img=(ImageView)convertView.findViewById(R.id.psimg);

        name.setText(prod.getProductName());
        date.setText("Purchased On: "+orditem.getPurchaseDate().toString());
        price.setText("LKR "+prod.getProductPrice().toString());

        Picasso.get().load(prod.getProductImage()).fit().into(img);


        return convertView;
    }

}

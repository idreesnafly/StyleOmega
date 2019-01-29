package com.example.idrees.styleomega.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.idrees.styleomega.Activities.SignIn;
import com.example.idrees.styleomega.Adapter.pastorderAdapter;
import com.example.idrees.styleomega.Model.Cart;
import com.example.idrees.styleomega.Model.CartItem;
import com.example.idrees.styleomega.R;

import java.util.List;


public class PastOrders extends Fragment {


    public PastOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_past_orders, container, false);

        ListView ls=(ListView)v.findViewById(R.id.pastrderlistview);
        SharedPreferences sp=getActivity().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        Long userID=sp.getLong("ID",10);

        List<Cart> orders=Cart.find(Cart.class,"user=? and status=?",userID.toString(),"Confirmed");

        Cart ct=orders.get(0);
        Long ctID=ct.getId();
        List<CartItem> cartit=CartItem.find(CartItem.class,"cartorder=?",ctID.toString());

        pastorderAdapter pst=new pastorderAdapter(getContext(),R.layout.pastorderitem,cartit);
        ls.setAdapter(pst);

        return v;
    }

}

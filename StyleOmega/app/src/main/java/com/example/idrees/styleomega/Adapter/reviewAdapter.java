package com.example.idrees.styleomega.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.Reviews;
import com.example.idrees.styleomega.R;

import java.util.List;

public class reviewAdapter extends ArrayAdapter <Reviews> {


    public reviewAdapter(Context context,List<Reviews> reviews) {
        super(context, R.layout.reviewitem,reviews);


    }


    public View getView (int position, View view, ViewGroup parent){
        final Reviews reviews=getItem(position);


        if(view==null){
            view=LayoutInflater.from(getContext()).inflate(R.layout.reviewitem,parent,false);
        }

        TextView userName=(TextView)view.findViewById(R.id.username);
        TextView cmnt=(TextView)view.findViewById(R.id.comment);
        RatingBar rb=(RatingBar)view.findViewById(R.id.ratingBar2);

        rb.setRating(reviews.getRating());
        cmnt.setText(reviews.getReview());
        userName.setText(reviews.getUser().getUsername());

        rb.setFocusable(false);
        rb.setIsIndicator(true);

        return view;
    }
}

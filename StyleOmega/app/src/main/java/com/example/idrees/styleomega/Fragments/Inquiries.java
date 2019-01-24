package com.example.idrees.styleomega.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.idrees.styleomega.Activities.SignUp;
import com.example.idrees.styleomega.R;

public class Inquiries extends Fragment {


    public Inquiries() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_inquiries, container, false);
        // Inflate the layout for this fragment




        return  v;
    }



    public void onClick(View v){
        Toast.makeText(getContext(), "Inquiry Successfully submitted!", Toast.LENGTH_SHORT).show();

    }
}

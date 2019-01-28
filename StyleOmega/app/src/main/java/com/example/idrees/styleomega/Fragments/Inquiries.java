package com.example.idrees.styleomega.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

        EditText sub=(EditText)v.findViewById(R.id.subtxt);
        EditText msg=(EditText)v.findViewById(R.id.msgtxt);
        Button snd=(Button)v.findViewById(R.id.submitbtn);

        final String subject=sub.getText().toString();
        final String message=msg.getText().toString();
        final String email="idreesnafly@gmail.com";

        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,email);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an email Client"));
                //Toast.makeText(getContext(), "Inquiry Successfully submitted!", Toast.LENGTH_SHORT).show();
            }
        });

        return  v;
    }

}

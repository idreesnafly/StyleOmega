package com.example.idrees.styleomega.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.idrees.styleomega.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFrag extends Fragment {


    public ContactUsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_contact_us, container, false);

        ImageView callimg=(ImageView)v.findViewById(R.id.callimg);
        ImageView locateimg=(ImageView)v.findViewById(R.id.locateimg);

        callimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String phoneNumber = String.format("tel: %s","+94772350944");

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0772350944"));
                startActivity(intent);
            }
        });

        locateimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://goo.gl/maps/TNpPZcETEQw"));
                startActivity(i);
            }
        });



        return v;

    }

}

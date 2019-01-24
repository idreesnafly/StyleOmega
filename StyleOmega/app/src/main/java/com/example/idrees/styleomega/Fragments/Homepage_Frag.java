package com.example.idrees.styleomega.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.idrees.styleomega.Activities.Homepage;
import com.example.idrees.styleomega.Activities.productpage;
import com.example.idrees.styleomega.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Homepage_Frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Homepage_Frag extends Fragment {

    private OnFragmentInteractionListener mListener;
    ImageView newArrival,mensCloth,womensCloth,mensAcc,womensAcc;
    public Homepage_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.homepagefrag, container, false);

         newArrival=(ImageView)v.findViewById(R.id.newArrivalimageView);
         mensCloth=(ImageView)v.findViewById(R.id.mensimageView4);
         mensAcc=(ImageView)v.findViewById(R.id.mensaccimageView6);
         womensAcc=(ImageView)v.findViewById(R.id.girlsaccimageView9);
         womensCloth=(ImageView)v.findViewById(R.id.girlsimageView8);

         mensCloth.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent=new Intent(getContext(),productpage.class);
                 intent.putExtra("ID","MEN");
                 startActivity(intent);
             }
         });

        mensAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),productpage.class);
                intent.putExtra("ID","MENACC");
                startActivity(intent);

            }
        });

        womensAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),productpage.class);
                intent.putExtra("ID","WOMENACC");
                startActivity(intent);
            }
        });

        womensCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),productpage.class);
                intent.putExtra("ID","WOMEN");
                startActivity(intent);
            }
        });

        newArrival.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getContext(),productpage.class);
                 intent.putExtra("ID","newArrival");
                 startActivity(intent);
             }
         });

         return v;

    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }


}

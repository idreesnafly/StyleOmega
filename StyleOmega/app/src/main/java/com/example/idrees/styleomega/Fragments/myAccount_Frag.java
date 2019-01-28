package com.example.idrees.styleomega.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.idrees.styleomega.Activities.SignIn;
import com.example.idrees.styleomega.Activities.SignUp;
import com.example.idrees.styleomega.Model.User;
import com.example.idrees.styleomega.R;
import com.orm.SugarRecord;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link myAccount_Frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class myAccount_Frag extends Fragment {

    private OnFragmentInteractionListener mListener;
    EditText txtname,txtemail,txtpass,txtaddress;
    Button saveedit;
    Context context;

    public myAccount_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_my_account_, container, false);

        txtname=(EditText)v.findViewById(R.id.nameTxt);
        txtemail=(EditText)v.findViewById(R.id.emailTxt);
        txtpass=(EditText)v.findViewById(R.id.passwordTxt);
        //txtaddress=(EditText)v.findViewById(R.id.DelAddTxt);
        saveedit=(Button)v.findViewById(R.id.editsaveBtn);

        ImageView img=(ImageView)v.findViewById(R.id.myprofImage);
        Picasso.get().load("https://i.dailymail.co.uk/i/newpix/2018/09/21/15/507A804900000578-6193727-image-a-16_1537540777441.jpg").fit().into(img);

        SharedPreferences sharedpref=this.getActivity().getApplicationContext().getSharedPreferences(SignIn.mypreference,Context.MODE_PRIVATE);
        User user= User.findById(User.class,sharedpref.getLong("ID",10));
        final Long ID=user.getId();

        List<User> users=User.findWithQuery(User.class,"Select * from User where Username=?",sharedpref.getString("Username","username"));
        txtname.setText(user.getUsername());
        txtemail.setText(user.getEmail());
        txtpass.setText(user.getPassword());


        saveedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=SugarRecord.findById(User.class,ID);
                user.setUsername(txtname.getText().toString());
                user.setEmail(txtemail.getText().toString());
                user.setPassword(txtpass.getText().toString());
                user.save();
                Toast.makeText(getContext(),"Account information successfully updated!",Toast.LENGTH_SHORT).show();

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

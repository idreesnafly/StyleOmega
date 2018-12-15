package com.example.idrees.styleomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void onClick(View v){

        startActivity(new Intent(SignIn.this,HomeScreen.class));
        finish();
    }

    public void onClick1(View v){

        startActivity(new Intent(SignIn.this,SignUp.class));
        finish();
    }
}

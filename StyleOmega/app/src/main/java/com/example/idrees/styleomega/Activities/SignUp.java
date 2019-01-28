package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.User;
import com.example.idrees.styleomega.R;

import java.util.List;

public class SignUp extends AppCompatActivity {
    EditText emailTxt,usernameTxt,passwordTxt,confirmpassTxt;
    String useremail,userusername,userpassword,confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameTxt=(EditText)findViewById(R.id.usernameField);
        emailTxt=(EditText)findViewById(R.id.emailField);
        passwordTxt=(EditText)findViewById(R.id.passwordField);
        confirmpassTxt=(EditText)findViewById(R.id.ConfirmpassField);

    }
    public void onClickLgn(View v){

        startActivity(new Intent(SignUp.this,SignIn.class));
        finish();
    }



    public void onSignupBtnClick(View v){
        useremail=emailTxt.getText().toString();
        userusername=usernameTxt.getText().toString();
        userpassword=passwordTxt.getText().toString();
        confirmpassword=confirmpassTxt.getText().toString();


        List<User> createdUsers=User.listAll(User.class);

        for(User user:createdUsers){
            if(user.getEmail().equals(useremail)){
                Toast.makeText(SignUp.this, "Email you entered already Exists!", Toast.LENGTH_SHORT).show();

            }
        }

        if(useremail.isEmpty()||userusername.isEmpty()||userpassword.isEmpty()){
            Toast.makeText(SignUp.this, "Fill empty fields!", Toast.LENGTH_SHORT).show();
        }
        else if(Patterns.EMAIL_ADDRESS.matcher(useremail).equals(true)){
            Toast.makeText(SignUp.this, "Enter a valid Email Address!", Toast.LENGTH_SHORT).show();
        }
        else if (!confirmpassword.equals(userpassword)){
            Toast.makeText(SignUp.this, "Passwords entered does not match!", Toast.LENGTH_SHORT).show();
        }
        else {

            User user=new User(userusername,useremail,userpassword);
            user.save();
            Toast.makeText(SignUp.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
            //testing purpose
            Log.i("User Count",Integer.toString(createdUsers.size()));

            startActivity(new Intent(SignUp.this,SignIn.class));
            finish();

        }




    }
}

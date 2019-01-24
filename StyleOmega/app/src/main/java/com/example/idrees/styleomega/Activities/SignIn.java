package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.User;
import com.example.idrees.styleomega.R;

import java.util.List;

public class SignIn extends AppCompatActivity {

    EditText usernameTxt,passwordTxt;
    Long UserID;

    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        usernameTxt=(EditText)findViewById(R.id.usernameField);
        passwordTxt=(EditText)findViewById(R.id.passwordField);
        Button lgn=(Button)findViewById(R.id.loginbutton);



        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fieldusername = usernameTxt.getText().toString();
                String Fieldpassword = passwordTxt.getText().toString();

                //List<User> users = User.findWithQuery(User.class,"SELECT * FROM User WHERE Username = ? && Password=?",Fieldusername,Fieldpassword);

                boolean isValid=false;
                List <User>user=User.listAll(User.class);

                for(User user1:user){
                    if((Fieldusername.equals(user1.getUsername().toString()))&&(Fieldpassword.equals(user1.getPassword().toString()))){
                        isValid=true;
                        UserID=user1.getId();
                        break;

                    }

                }

                if (isValid){

                    sharedpreferences=getApplicationContext().getSharedPreferences(mypreference,Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putString("Username",Fieldusername);
                    editor.putLong("ID",UserID);
                    editor.commit();
                    startActivity(new Intent(SignIn.this,Homepage.class));
                    usernameTxt.setText("");
                    passwordTxt.setText("");

                }
                else if (user.size()==0){
                    Toast.makeText(SignIn.this, "User not registered. Please register to Sign in!", Toast.LENGTH_SHORT).show();
                }
                else  if(Fieldpassword.isEmpty()||Fieldusername.isEmpty()){
                    Toast.makeText(SignIn.this, "Fill all empty fields.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignIn.this, "Username or password Incorrect!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void onClick1(View v){

        startActivity(new Intent(SignIn.this,SignUp.class));
        finish();

    }

}

package com.example.idrees.styleomega.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idrees.styleomega.Fragments.ContactUsFrag;
import com.example.idrees.styleomega.Fragments.Homepage_Frag;
import com.example.idrees.styleomega.Fragments.Inquiries;
import com.example.idrees.styleomega.Fragments.PastOrders;
import com.example.idrees.styleomega.Fragments.myAccount_Frag;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

public class Homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Homepage_Frag()).commit();
            navigationView.setCheckedItem(R.id.nav_Home);
        }




    }

    public void home(){
        Fragment fragment=new Homepage_Frag();
        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
        setTitle("StyleOmega");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(fragment instanceof Homepage_Frag) {
                super.onBackPressed();
            }else{
                home();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuprofile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myAccount_Frag()).commit();
            setTitle("My Profile");
        }
        else if(id==R.id.menucart){
            startActivity(new Intent(Homepage.this,ShoppingCart.class));
            setTitle("My Cart");
        }else if(id==R.id.menulogout){
            SharedPreferences sharedpreferences =getSharedPreferences(SignIn.mypreference, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            finish();
            startActivity(new Intent(Homepage.this,SignIn.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment frag=null;

        if (id == R.id.nav_Home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Homepage_Frag()).commit();

        } else if (id == R.id.nav_Cart) {

            startActivity(new Intent(Homepage.this,ShoppingCart.class));
            setTitle("My Cart");

        } else if (id == R.id.nav_Account) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myAccount_Frag()).commit();
            setTitle("My Account");

        } else if (id == R.id.nav_PastOrders) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PastOrders()).commit();
            setTitle("Past Orders");

        } else if (id == R.id.ContactUS) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactUsFrag()).commit();
            setTitle("Contact Us");
        } else if (id == R.id.nav_Inquiries) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Inquiries()).commit();
            setTitle("Inquiries");
        } else if(id==R.id.nav_Signout){
            SharedPreferences sharedpreferences =getSharedPreferences(SignIn.mypreference, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            finish();
            startActivity(new Intent(Homepage.this,SignIn.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

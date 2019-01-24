package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idrees.styleomega.Model.Product;
import com.example.idrees.styleomega.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailedItemsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product_detail_screen);

        TextView pName=(TextView)findViewById(R.id.prodNameTxt);
        TextView pPrice=(TextView)findViewById(R.id.priceTxt);
        TextView pDesc=(TextView)findViewById(R.id.descriptionTxt);
        ImageView img=(ImageView)findViewById(R.id.prodImage);
        Button buynowBtn=(Button)findViewById(R.id.buynowBtn);
        Button addBtn=(Button)findViewById(R.id.addtoCartBtn);

        //Bundle bundle=getIntent().getExtras();
        Long ID=getIntent().getLongExtra("PRODUCTID",0);
        Toast.makeText(getApplicationContext(),ID.toString(),Toast.LENGTH_SHORT).show();


       // List<Product> prodlist=Product.listAll(Product.class);

        Product product=Product.findById(Product.class,ID);

        pName.setText(product.getProductName());
        pPrice.setText("RS: "+product.getProductPrice());
        pDesc.setText(product.getDescription());

        Picasso.get().load(product.getProductImage()).fit().into(img);

        buynowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailedItemsScreen.this,ShoppingCart.class));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Product Added to your Cart",Toast.LENGTH_SHORT).show();
            }
        });

    }

}

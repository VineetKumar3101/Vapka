package com.example.vaapkaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Selection extends AppCompatActivity {
ImageView i1,i2;
Button b5,b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        i1=(ImageView) findViewById(R.id.imageView);
        i2=(ImageView) findViewById(R.id.imageView2);
        b5=(Button)findViewById(R.id.button4);
        b6=(Button)findViewById(R.id.button5);
        b7=(Button)findViewById(R.id.button6);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Selection.this,Teacher.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Selection.this,Student2.class);
                startActivity(j);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z=new Intent(Selection.this,MainActivity.class);
                startActivity(z);
                finish();
            }
        });
    }
}
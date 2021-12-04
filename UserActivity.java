package com.example.vaapkaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaapkaaaaa.databinding.ActivityStudent2Binding;
import com.example.vaapkaaaaa.databinding.ActivityUserBinding;
import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {
ActivityUserBinding binding;
    Button b1;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null)
        {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String room = intent.getStringExtra("room");
            String email = intent.getStringExtra("email");

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(phone);
            binding.roomProfile.setText(room);
            binding.emailProfile.setText(email);

        }
        b1=(Button)findViewById(R.id.button8);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent i=new Intent(UserActivity.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }
}
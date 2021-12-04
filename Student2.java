package com.example.vaapkaaaaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.vaapkaaaaa.databinding.ActivityMainBinding;
import com.example.vaapkaaaaa.databinding.ActivityStudent2Binding;

import java.util.ArrayList;

public class Student2 extends AppCompatActivity {
    @NonNull ActivityStudent2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudent2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] name = {"Neeraj Khana","Vineet","Pawan","Kritish","Alok","Sumit","Pramod"};
        String[] phone = {"1111111","222222","333333","44444444","5555555","6666666","7777777"};
        String[] room = {"1111111","222222","333333","44444444","5555555","6666666","7777777"};
        String[] email = {"1111111@gmail.com","222222@gmail.com","333333@gmail.com","44444444@gmail.com","5555555@gmail.com","6666666@gmail.com","7777777@gmail.com"};

        ArrayList<Users> usersArrayList = new ArrayList<>();

        for(int i = 0;i< name.length;i++)
        {
            Users users = new Users(phone[i],room[i],email[i]);
            usersArrayList.add(users);
        }

        ListAdapter listAdapter= new ListAdapter(Student2.this,usersArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {

                Intent i = new Intent(Student2.this,UserActivity.class);
                i.putExtra("name",name[postion]);
                i.putExtra("phone",phone[postion]);
                i.putExtra("Room",room[postion]);
                i.putExtra("Email",email[postion]);
                startActivity(i);
            }
        });
    }
}
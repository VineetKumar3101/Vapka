package com.example.vaapkaaaaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Users> {

    public ListAdapter(Context context , ArrayList<Users> usersArrayList)
    {
        super(context,R.layout.list_item,usersArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        Users users = getItem(position);

        if(convertView == null)

        {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView =  convertView.findViewById(R.id.profile_pic);
        TextView username = convertView.findViewById(R.id.personName);

        imageView.setImageResource(users.imageid);
        username.setText(users.name);



        return convertView;
    }
}

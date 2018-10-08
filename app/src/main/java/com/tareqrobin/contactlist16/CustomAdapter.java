package com.tareqrobin.contactlist16;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    List<Model> userData=new ArrayList<Model>();
    public CustomAdapter(@Nullable Context context, List<Model> userData){
        super(context,R.layout.single_row,userData);
        this.userData=userData;
    }

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);

        TextView name=row.findViewById(R.id.tvsname);
        TextView phone=row.findViewById(R.id.tvsphone);

        name.setText(userData.get(position).getName());
        phone.setText(userData.get(position).getPhone());

        return row;
    }
}
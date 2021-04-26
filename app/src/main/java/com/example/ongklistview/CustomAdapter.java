package com.example.ongklistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private ArrayList<Contact> contacts;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> contacts) {
        super(context, resource, contacts);

        this.contacts = contacts;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvname = convertView.findViewById(R.id.tvName);
            viewHolder.tvemail = convertView.findViewById(R.id.tvEmail);
            viewHolder.tvphone =convertView.findViewById(R.id.tvSdt);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Contact contact = contacts.get(position);
        viewHolder.tvname.setText(contact.getName());
        viewHolder.tvemail.setText(contact.getEmail());
        viewHolder.tvphone.setText(contact.getPhone());
        return convertView;
    }


    public class ViewHolder {
        TextView tvname;
        TextView tvemail;
        TextView tvphone;
    }
}

package com.example.ongklistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgBnAdd;
    private ListView lvContact;
    private ArrayList<Contact> contacts;
    private CustomAdapter adapter;
    private static final int ADD = 999;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD){
            if (resultCode == RESULT_OK){
                Bundle bundle = data.getBundleExtra("add");
                Contact contact = (Contact) bundle.getSerializable("contact");
                        contacts.add(contact);
                        adapter.notifyDataSetChanged();

             }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.lv_contact) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.custom_menu,menu);
        }
    }


   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact=findViewById(R.id.lv_contact);
        imgBnAdd = findViewById(R.id.imageButton);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));
        contacts.add(new Contact("Quan","quan@gmail.com", "0920232421"));

        adapter = new CustomAdapter(MainActivity.this,R.layout.custom_listview,contacts);
        lvContact.setAdapter(adapter);


        imgBnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                startActivityForResult(intent,ADD);
            }
        });




        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Contact contact = contacts.get(i);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", contact);
                intent.putExtra("detail",bundle);
                startActivity(intent);
            }
        });

        registerForContextMenu(lvContact);



}}
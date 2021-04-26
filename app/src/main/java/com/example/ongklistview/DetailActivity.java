package com.example.ongklistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView tvName,tvEmail,tvPhone;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_Name);
        tvEmail = findViewById(R.id.tv_Email);
        tvPhone = findViewById(R.id.tv_Phone);
        btnBack = findViewById(R.id.btn_Back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("detail");
        Contact contact = (Contact) bundle.getSerializable("contact");
        tvName.setText(contact.getName());
        tvEmail.setText(contact.getEmail());
        tvPhone.setText(contact.getPhone());
    }
}
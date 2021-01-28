package com.example.friendszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {


    EditText etId, etName, etEmail;
    Button btnAdd;

    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);

        btnAdd = findViewById(R.id.btn_add);


        dbHelper = new DBhelper(Details.this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Web Page");


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                if (id.isEmpty()) {
                    etId.setError("Please input your id");
                    etId.requestFocus();
                } else if (name.isEmpty()) {
                    etName.setError("Please input your name");
                    etName.requestFocus();
                } else if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
                    etEmail.setError("Please input valid email");
                    etEmail.requestFocus();
                } else {
                    boolean check = dbHelper.insertData(id, name, email);
                    if (check == true) {
                        Toast.makeText(Details.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Details.this, "Data insert fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

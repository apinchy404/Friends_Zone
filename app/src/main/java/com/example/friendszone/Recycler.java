package com.example.friendszone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        recyclerView=findViewById(R.id.recyclerview);
        GridLayoutManager gridlayoutManager=new GridLayoutManager(Recycler.this,2);
        recyclerView.setLayoutManager(gridlayoutManager);


        DBhelper dBhelper=new DBhelper(Recycler.this);

//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent=new Intent(Recycler.this,UpdateDelete.class);
//                startActivity(intent);
//            }
//        });


//        get data from db;
        List<HashMap<String,String>> data=dBhelper.getData();
        if(data.size()==0)
        {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Adapter adapter=new Adapter(Recycler.this,data);
            recyclerView.setAdapter(adapter);
        }





    }


}

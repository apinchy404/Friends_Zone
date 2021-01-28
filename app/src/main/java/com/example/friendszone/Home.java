package com.example.friendszone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    CardView cardAdd,cardView,cardAbout,cardExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardAdd=findViewById(R.id.card_add);
        cardAbout=findViewById(R.id.card_about);
        cardView=findViewById(R.id.card_view);
        cardExit=findViewById(R.id.card_exit);

        cardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Home.this,Details.class);
                startActivity(intent);

            }
        });



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        Intent intent=new Intent(Home.this,Recycler.class);
        startActivity(intent);




            }
        });
        cardAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,About.class);
                startActivity(intent);



            }
        });

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });




    }
}
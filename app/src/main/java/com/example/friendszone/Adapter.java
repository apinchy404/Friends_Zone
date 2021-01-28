package com.example.friendszone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public static final String EXTRA_id="id";
    public static final String EXTRA_name="name";
    public static final String EXTRA_email="email";



    private List<HashMap<String,String>>data;
    private Context context;


    public Adapter(Context context, List<HashMap<String,String>>data)
    {
        this.context=context;
        this.data=data;

    }





    @NonNull
    @Override


    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder vh= new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, final int position) {


        String id=data.get(position).get("id");

        String name=data.get(position).get("name");
        String email=data.get(position).get("email");

        holder.txtId.setText("ID:"+id);
        holder.txtName.setText("Name:"+name);
        holder.txtEmail.setText("Email:"+email);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, countryList[position],Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,UpdateDelete.class);
                intent.putExtra("id","ID:"+EXTRA_id);
                intent.putExtra("name","Name"+EXTRA_name);
                intent.putExtra("email","Email"+EXTRA_email);


                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView txtId,txtName,txtEmail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);




            txtId= itemView.findViewById(R.id.txt_id);
            txtName=itemView.findViewById(R.id.txt_name);
            txtEmail=itemView.findViewById(R.id.txt_email);


        }
    }
}

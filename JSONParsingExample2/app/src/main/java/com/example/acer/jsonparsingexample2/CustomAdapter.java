package com.example.acer.jsonparsingexample2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Acer on 4/16/2019.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    ArrayList<String> empNames;
    ArrayList<String> emailIds;
    ArrayList<String> mobileNumbers;
    ArrayList<String> salarys;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> empNames, ArrayList<String> emailIds,
                         ArrayList<String> mobileNumbers, ArrayList<String> salarys) {
        this.context = context;
        this.empNames = empNames;
        this.emailIds = emailIds;
        this.mobileNumbers = mobileNumbers;
        this.salarys = salarys;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //inflate the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        //set he data in items
        holder.name.setText(empNames.get(position));
        holder.email.setText(emailIds.get(position));
        holder.mobileNo.setText(mobileNumbers.get(position));
        holder.salary.setText(salarys.get(position));
        //implement setONClickListemner event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, empNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return empNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, mobileNo,salary;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            email = (TextView) itemView.findViewById(R.id.emailTextView);
            mobileNo = (TextView) itemView.findViewById(R.id.mobileTextView);
            salary = (TextView) itemView.findViewById(R.id.salaryTextView);
        }
    }
}

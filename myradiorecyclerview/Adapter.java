package com.raju.myradiorecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
  ArrayList<String> list;
  int lastSelectedPosition = -1;
    int tempPosition;
    private RadioButton lastCheckedRB = null;
    static ItemClickListener itemClickListener;
    Context context;
    public Adapter(ArrayList<String> arrayList, Context context) {
        list=arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setIsRecyclable(true);
        holder.tv.setText(list.get(position));

        holder.rb.setChecked(position == lastSelectedPosition);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastSelectedPosition = position;
                notifyDataSetChanged();
                Log.e("rbrbrbrbrbrrbbrb", list.get(position));
                itemClickListener.itemClick(list.get(position));
            }
        };
        holder. rb.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tv;
         RadioButton rb;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.textView);
            rb= itemView.findViewById(R.id.radioButton);

        }


    }

    public static void setListener(ItemClickListener listener1){
        itemClickListener = listener1;
    }

}

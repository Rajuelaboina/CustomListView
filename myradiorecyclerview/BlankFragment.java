package com.raju.myradiorecyclerview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BlankFragment extends Fragment {
    RecyclerView recyclerView;

    ItemClickListener listener;
    ArrayList<DataUser> List = new ArrayList<>();
    public BlankFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> arrayList = new ArrayList<>();
      /*  List = getArguments().getParcelableArrayList("DATA");
        for (int i=0 ;i<List.size();i++){
            Log.e("DAAAAAAAAAAAAA",List.get(i).name);
        }*/


        // Use for loop
        for (int i = 1; i < 15; i++) {
            // add values in array list
            arrayList.add(String.valueOf(i));
        }
        recyclerView =view.findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(arrayList,getContext());
        recyclerView.setAdapter(adapter);

        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("BroadcastReceiver","BroadcastReceiver");
                Log.e("BroadcastReceiver",intent.getStringExtra("Id"));
            }
        };
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter("phy"));
    }
}
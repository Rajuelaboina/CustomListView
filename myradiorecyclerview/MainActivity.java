package com.raju.myradiorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ItemClickListener, NetworkCheckConn {
    ArrayList<DataUser> list = new ArrayList<>();
    TextView tv;
    TextView tv2;
    int count = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textTotal);

        Adapter.setListener(this);



        Fragment f =new BlankFragment();
        Fragment f2 =new BlankFragment2();


        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame1,f,"one");
        fragmentTransaction.replace(R.id.frame3,f2,"two");
        fragmentTransaction.commit();


        // checkInterNetConnection();
       // Log.e("NetworkInfo1","<><><><><><><><><>: "+ checkInterNetConnection());
        registerReceiver(new MyReceiver(),new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        MyReceiver.setListener(this);

         // startService(new Intent(this,MyIntentService.class));


       // getSupportFragmentManager().beginTransaction().add(R.id.frame1,f).commit();
        Toolbar toolbar = findViewById(R.id.toolBar);
         tv2 = toolbar.findViewById(R.id.toolBarText);
        tv2.setText("Total:"+String.valueOf(count));
       
    }

    private boolean checkInterNetConnection() {
        ConnectivityManager connect = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfos = connect.getActiveNetworkInfo();

        /*networkInfos.getExtraInfo();
        networkInfos.isConnectedOrConnecting();
        Log.e("NetworkInfo2","<><><><><><><><><>: "+ networkInfos.isConnected());
        Log.e("NetworkInfo3","<><><><><><><><><>: "+ networkInfos.isAvailable());
      */ // Log.e("NetworkInfo","<><><><><><><><><>: "+networkInfos.getExtraInfo());
      //  Log.e("NetworkInfo","<><><><><><><><><>: "+ networkInfos.isConnectedOrConnecting());
        if (networkInfos!=null &&  networkInfos.isConnectedOrConnecting())
        {
            return true;
        }else{
        return false;
        }

    }

    @Override
    public void itemClick(String s) {
        int id= Integer.parseInt(s);
        count = count +id;
        Log.e("TTTTTTTTTTTT",""+count);
        tv.setText(String.valueOf(count));
        tv2.setText("Total:"+String.valueOf(count));
    }

    @Override
    public void onConnection(boolean connectedOrConnecting) {
        Toast.makeText(getApplicationContext(),"HHHHHHHHHHHHH",Toast.LENGTH_SHORT).show();
    }
}
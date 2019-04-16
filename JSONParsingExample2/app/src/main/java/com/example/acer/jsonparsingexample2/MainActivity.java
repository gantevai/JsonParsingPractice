package com.example.acer.jsonparsingexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // ArrayList for person names, email Id's and mobile numbers
    ArrayList<String> empNames = new ArrayList<>();
    ArrayList<String> emailIds = new ArrayList<>();
    ArrayList<String> mobileNumbers = new ArrayList<>();
    ArrayList<String> salarys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.employeeRecyclerView);
        //set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            //get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            //fetch JSONArray name users
            JSONArray empArray = obj.getJSONArray("employees");

            for (int i =0;i<empArray.length();i++){
                //create a JSONObject for fetching single user data
                JSONObject empDetail = empArray.getJSONObject(i);
                //fetch email,name,mobile no,. and salary and store in arraylist
                empNames.add(empDetail.getString("name"));
                emailIds.add(empDetail.getString("email"));
                mobileNumbers.add(empDetail.getString("mobileno."));
                salarys.add(empDetail.getString("salary"));
                //create a object for getting contact data from JSONObject

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //call the constructor of Custom Adapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,empNames,emailIds,mobileNumbers,salarys);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

    }

    public String loadJSONFromAsset(){
        String json = null;
        try{
            InputStream is = getAssets().open("emp_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}

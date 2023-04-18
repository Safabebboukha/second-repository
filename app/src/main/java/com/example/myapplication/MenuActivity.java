package com.example.myapplication;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MenuActivity extends SumActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        PAGE= "menu.php";
        Map<String,String> params = new HashMap<>();
        params.put("id","1");
        send(params);
    }

    @Override
    protected void responseReceived(String response, Map<String, String> params) {

    }

}
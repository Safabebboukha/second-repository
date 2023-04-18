package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public abstract class SumActivity extends AppCompatActivity {

    protected final String ADDRESS="http://192.168.39.31:80/";
    protected String PAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
    }
    protected void send( Map<String,String> params){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,this.ADDRESS+this.PAGE,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                responseReceived(response,params);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error occurred, show error message
                        Toast.makeText(SumActivity.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return params;
            }
        };
        // Add request to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    protected abstract void responseReceived(String response, Map<String, String> params);
}
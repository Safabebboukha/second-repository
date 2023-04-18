package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends SumActivity {
    private EditText emailEditText;
    private EditText addressEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        PAGE= "signup.php";
        setContentView(R.layout.activity_sign_up);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        ageEditText = findViewById(R.id.age);
        addressEditText = findViewById(R.id.adress);
        Button signUpButton = findViewById(R.id.signup_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Map<String,String> params = new HashMap<>();
                params.put("email",emailEditText.getText().toString());
                params.put ("password",passwordEditText.getText().toString());
                params.put("age",ageEditText.getText().toString());
                params.put("address",addressEditText.getText().toString());
                send(params);
            }

        });
    }


    protected void responseReceived(String response, Map<String, String> params) {
        System.out.println("php response:"+response.trim().toString() );

        System.out.println(response.trim().equals("success"));
        if (response.trim().equals("success")){
            Toast.makeText(SignUpActivity.this,"Sign Up Success",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(SignUpActivity.this,"Sign Up Failed",Toast.LENGTH_SHORT).show();}

    }
}



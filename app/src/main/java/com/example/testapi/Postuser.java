package com.example.testapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Postuser extends AppCompatActivity {
    API api;
    private TextView textshow;
    ArrayList<Infor> array = new ArrayList<>();

    private EditText mEmail;
    private EditText mPassword;
    private EditText mPhone;
    private EditText mName;
    private String emails;
    private String pass;
    private String phone;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postuser_activity);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mPhone = (EditText) findViewById(R.id.phone);
        mName = (EditText) findViewById(R.id.username);
        textshow = (TextView) findViewById(R.id.textshow);

        //try {
        //getinfor();//拿取資料
        //postinfor();//新增資料
        //deleteinfor();
        //changeinfor();
        //} catch (Exception e) {
        //mtextshow.setText(e.toString()+ " hello");
        //Log.e("MainActivity", e.getMessage());
        //}

        Button mCreateResAccountsButton = findViewById(R.id.signin);
        mCreateResAccountsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                postinfor();
            }
        });
    }

    public void postinfor() {
        api = RetrofitManager.getInstance().getAPI();
        final String einput = mEmail.getText().toString();
        final String pinput = mPassword.getText().toString();
        final String epinput = mPhone.getText().toString();
        final String ninput = mName.getText().toString();

        Call<Infor> call = api.postInfor(new Req(new fields(pinput, einput, epinput, ninput)));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                //text1_result.setText(response.body().getfieldsEmail());
                textshow.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                textshow.setText(t.getMessage());
            }
        });

    }

}

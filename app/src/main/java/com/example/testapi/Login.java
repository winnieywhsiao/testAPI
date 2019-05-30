package com.example.testapi;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    API api;
    ArrayList<Infor> arr = new ArrayList<>();

    private EditText mEmail;
    private EditText mPassword;
    private Button mlogin;
    private TextView mtextshow;
    private String e;
    private String emails;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mtextshow = (TextView) findViewById(R.id.textshow);

        //try {
            //getinfor();//拿取資料
            //postinfor();//新增資料
            //deleteinfor();
            //changeinfor();
        //} catch (Exception e) {
            //mtextshow.setText(e.toString()+ " hello");
            //Log.e("MainActivity", e.getMessage());
        //}


        Button mCreateResAccountsButton = findViewById(R.id.loginbutton);
        mCreateResAccountsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent=new Intent();intent.setClass(Login.this,MainActivity.class);
                //startActivity(intent);

                //EditText em = (EditText) findViewById(R.id.email);
                //String input = em.getText().toString();
                //TextView tv = (TextView) findViewById(R.id.textshow);
                //tv.setText(input);
                getinfor();
            }
        });
    }

    public void getinfor() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = api.getInfor();
        final String einput = mEmail.getText().toString();
        final String pinput = mPassword.getText().toString();

        call.enqueue(new Callback<Infor>() {//成功透過onresponse回傳 失敗用onfailure回傳
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                for(int i=0; i<response.body().getarr().length;i++){
                    //TextUtils.equals(e,emails);
                    emails = response.body().getfieldsEmail(i);
                    pass = response.body().getfieldsPassword(i);
                    //mtextshow.append(emails + "\n");
                    if(einput.equals(emails) && pinput.equals(pass)){
                        //mtextshow.setText("我成功了!!!" + "\n");
                        Intent intent=new Intent();intent.setClass(Login.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    else{
                       mtextshow.setText("失敗!!!" + "\n");
                    }
                }
                //response.body().getfieldsEmail(2);
                //mEmail.getText().toString();
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtextshow.setText(t.getMessage());
            }
        });
    }


}
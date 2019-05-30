package com.example.testapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    API api;
    private TextView text1_result;
    ArrayList<Infor> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1_result = (TextView) findViewById(R.id.text1);

        try {
            getinfor();//拿取資料
            //postinfor();//新增資料
            //deleteinfor();
            //changeinfor();
        } catch (Exception e) {
            text1_result.setText(e.toString()+ " hello");
            Log.e("MainActivity", e.getMessage());
        }


    }

    public void getinfor() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = api.getInfor();

        call.enqueue(new Callback<Infor>() {//成功透過onresponse回傳 失敗用onfailure回傳
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                text1_result.append(response.body().getfieldsEmail(2));
                //text1_result.setText(response.body().arr().length);

                //Infor infor = new Infor(response.body().getId(), response.body().getFields(), response.body().getCreateTime());
                //array.add(infor);
                //text1_result.setText(infor.getId()+"hi");
                //String content = "";
                 //for(Infor word: array) {
                     //text1_result.append(word.getfieldsEmail() + "\n");
                 //}
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                text1_result.setText(t.getMessage());
            }
        });
    }

    public void postinfor() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = api.postInfor(new Req(new fields("hahaha", "hahaha@gmail.com")));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                //text1_result.setText(response.body().getfieldsEmail());
                text1_result.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                text1_result.setText(t.getMessage());
            }
        });

    }

    public void deleteinfor() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = api.deleteInfor();
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                String em = response.body().getfieldsEmail(3);
                String pa = response.body().getfieldsPassword(3);
                text1_result.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                text1_result.setText(t.getMessage());
            }
        });
    }

    public void changeinfor() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = api.changeInfor(new Req(new fields("11111", "change@gmail.com")));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                //set
                text1_result.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                text1_result.setText(t.getMessage());
            }
        });
    }
}

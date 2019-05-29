package com.example.testapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface API {
    //資料表 / id名稱 ? api_key
    @GET("User?api_key=key5hoPQlXIf5ig6M")
    Call<Infor> getInfor();

    @POST("User?api_key=key5hoPQlXIf5ig6M") // 用@Body表示要傳送Body資料
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Infor> postInfor(@Body Req fields);

    @DELETE("User?api_key=key5hoPQlXIf5ig6M")//須給指定位置
    Call<Infor> deleteInfor();

    @PATCH("User?api_key=key5hoPQlXIf5ig6M")//須給指定位置
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Infor> changeInfor(@Body Req fields);
}

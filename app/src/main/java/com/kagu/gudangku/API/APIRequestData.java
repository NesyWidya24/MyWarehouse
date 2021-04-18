package com.kagu.gudangku.API;

import com.kagu.gudangku.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("getAllDataGudang.php")
    Call<ResponseModel> ardRetrieveData();
}

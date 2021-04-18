package com.kagu.gudangku.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.kagu.gudangku.API.APIRequestData;
import com.kagu.gudangku.API.RetroServer;
import com.kagu.gudangku.Adapter.AdapterData;
import com.kagu.gudangku.Model.DataModel;
import com.kagu.gudangku.Model.ResponseModel;
import com.kagu.gudangku.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rvWarehouse;
    private AdapterData adData;
    private List<DataModel> listData;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWarehouse = findViewById(R.id.rvWarehouse);
        srlData = findViewById(R.id.swl_data);
        pbData = findViewById(R.id.pb_data);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        rvWarehouse.setLayoutManager(linearLayoutManager);

        listData = new ArrayList<>();

//        retrieveData();

        srlData.setOnRefreshListener(() -> {
            srlData.setRefreshing(true);

            retrieveData();

            srlData.setRefreshing(false);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    private void retrieveData() {
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(MainActivity.this, "Kode: " + kode + " | Pesan: " + pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adData = new AdapterData(MainActivity.this, listData);
                rvWarehouse.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal menghubungi server: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });//antrikan perintah
    }
}
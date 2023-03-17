package com.example.countrynameapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.countrynameapp.model.CountryModel;
import com.example.countrynameapp.model.CountryResult;
import com.example.countrynameapp.serviceinterface.GetCountryDataService;
import com.example.countrynameapp.serviceinterface.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countries;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all Countries data
        GetCountryList();
    }

    private Object GetCountryList() {

        GetCountryDataService countryDataService = RetrofitInstance.getService();
        Call<CountryResult> resultCall = countryDataService.getCountryResult();

        resultCall.enqueue(new Callback<CountryResult>() {
            @Override
            public void onResponse(Call<CountryResult> call, Response<CountryResult> response) {
                CountryResult countryResult = response.body();

                if (countryResult != null && countryResult.getResult() != null) {
                    countries = (ArrayList<CountryModel>) countryResult.getResult();

                    ViewData();
                    
//                    for (CountryModel c : countries) {
//                        Log.i("TAG", "" + c.getName());
//                    }
                }
            }

            @Override
            public void onFailure(Call<CountryResult> call, Throwable t) {

            }
        });

        return countries;
    }

    private void ViewData() {

        // Initialize the Views
        // RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        // Adapter
        countryAdapter = new CountryAdapter(countries);
        // Layout manager for recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        // Set the adapter in RecyclerView
        recyclerView.setAdapter(countryAdapter);
    }
}
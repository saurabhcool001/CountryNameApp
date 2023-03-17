package com.example.countrynameapp.serviceinterface;

import com.example.countrynameapp.model.CountryResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    // Retrofit Interface
    @GET("countries")
    Call<CountryResult> getCountryResult();
}

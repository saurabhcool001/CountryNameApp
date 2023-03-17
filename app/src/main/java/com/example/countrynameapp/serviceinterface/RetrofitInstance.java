package com.example.countrynameapp.serviceinterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    // Variables
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.printful.com/";

    // Singleton Pattern is used to Create Retrofit Instance
    public static GetCountryDataService getService() {

        // Create Retrofit single time when app is lunched
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        // If instance is already created
        return retrofit.create(GetCountryDataService.class);
    }
}

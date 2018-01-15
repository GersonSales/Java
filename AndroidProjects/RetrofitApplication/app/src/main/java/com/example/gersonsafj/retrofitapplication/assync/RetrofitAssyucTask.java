package com.example.gersonsafj.retrofitapplication.assync;

import android.os.AsyncTask;

import com.example.gersonsafj.retrofitapplication.model.Repo;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gersonsafj on 1/15/18.
 */

public class RetrofitAssyucTask extends AsyncTask<String, String, List<Repo>>{
    @Override
    protected List<Repo> doInBackground(String... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("url")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return null;
    }
}

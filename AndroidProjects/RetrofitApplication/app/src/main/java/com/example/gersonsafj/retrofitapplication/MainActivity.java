package com.example.gersonsafj.retrofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gersonsafj.retrofitapplication.model.Repo;
import com.example.gersonsafj.retrofitapplication.service.GitHubServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "Begin");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubServices gitHubServices = retrofit.create(GitHubServices.class);
        Call<List<Repo>> repos = gitHubServices.listRepos("octocat");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> reposResponse = response.body();
                if (reposResponse != null) {
                    for (Repo repo : reposResponse) {
                        Log.i("GitHubServices", repo.getmName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        Log.i("MainActivity", "End");




    }
}

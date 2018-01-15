package com.example.gersonsafj.retrofitapplication.service;

import com.example.gersonsafj.retrofitapplication.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gersonsafj on 1/15/18.
 */

public interface GitHubServices {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}

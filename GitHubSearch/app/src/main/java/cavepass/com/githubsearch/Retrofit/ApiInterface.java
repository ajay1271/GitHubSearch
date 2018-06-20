package cavepass.com.githubsearch.Retrofit;


import java.util.List;

import cavepass.com.githubsearch.ModelClass.FollowersPojo;
import cavepass.com.githubsearch.ModelClass.FollowingPojo;
import cavepass.com.githubsearch.ModelClass.GitRepo;
import cavepass.com.githubsearch.ModelClass.GitUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.*;


public interface ApiInterface {

    @GET("search/users")
    Call<GitUser> getUsers(@Query("q") String user);

    @GET("users/{id}/repos")
    Call<List<GitRepo>> getrepos(@Path("id") String user);

    @GET("users/{id}/following")
    Call<List<FollowingPojo>> getFollowing(@Path("id") String user);

    @GET("users/{id}/followers")
    Call<List<FollowersPojo>> getFollowers(@Path("id") String user);

}
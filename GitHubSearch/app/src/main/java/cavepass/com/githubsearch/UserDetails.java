package cavepass.com.githubsearch;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowId;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cavepass.com.githubsearch.Adapters.ReposAdapter;
import cavepass.com.githubsearch.ModelClass.FollowersPojo;
import cavepass.com.githubsearch.ModelClass.FollowingPojo;
import cavepass.com.githubsearch.ModelClass.GitRepo;
import cavepass.com.githubsearch.Retrofit.ApiClient;
import cavepass.com.githubsearch.Retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 20-06-2018.
 */

public class UserDetails extends AppCompatActivity {

    String userName = "Details";
    ArrayList<GitRepo> repos;
    String profileUrl;
    ImageView image;
    String followers_count = "NA";
    String following_count = "NA";
    TextView followers;
    TextView following;
    TextView gitScore;
    String gitScore_count;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);


        image = findViewById(R.id.profile_image);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        final RecyclerView recyclerView = findViewById(R.id.repos_recycler_view);

        Call<List<GitRepo>> call2;
        Call<List<FollowersPojo>> callForFollowers;
        Call<List<FollowingPojo>> callForFollowing;


        userName = getIntent().getStringExtra("userName");
        profileUrl = getIntent().getStringExtra("profileImage");
        gitScore_count = getIntent().getStringExtra("gitScore");

        Log.e("User Name", " = " + userName);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(userName);


        call2 = apiService.getrepos(userName);
        callForFollowers = apiService.getFollowers(userName);
        callForFollowing = apiService.getFollowing(userName);

        call2.enqueue(new Callback<List<GitRepo>>() {
            @Override
            public void onResponse(Call<List<GitRepo>> call2, Response<List<GitRepo>> response2) {

                Glide.with(getBaseContext()).load(profileUrl).into(image);


                try {
                    repos = new ArrayList<>(response2.body());
                    recyclerView.setAdapter(new ReposAdapter(repos, getBaseContext()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                }
                catch (Exception e){
                    Log.e("URL REPOS",call2.request().url().toString());
                }
            }

            @Override
            public void onFailure(Call<List<GitRepo>> call, Throwable t) {

                Log.e("FAILURE", t.getMessage());

            }
        });

        callForFollowers.enqueue(new Callback<List<FollowersPojo>>() {
            @Override
            public void onResponse(Call<List<FollowersPojo>> call, Response<List<FollowersPojo>> response) {


                if (response.body()!= null) {
                    followers_count = ""+ response.body().size();
                }
                followers = findViewById(R.id.followers_count);
                followers.setText(followers_count);

                gitScore = findViewById(R.id.git_score_count);
                gitScore.setText("" + gitScore_count);

                /*


                Log.e("Followers", "is" + response.body().size());
                Log.e("GitScore", "is" + gitScore_count);

               */

            }

            @Override
            public void onFailure(Call<List<FollowersPojo>> call, Throwable t) {

            }
        });
        callForFollowing.enqueue(new Callback<List<FollowingPojo>>() {
            @Override
            public void onResponse(Call<List<FollowingPojo>> call, Response<List<FollowingPojo>> response) {

                if (response.body() != null) {
                    following_count = ""+response.body().size();
                }
                following = findViewById(R.id.following_count);
                following.setText(following_count);


            }

            @Override
            public void onFailure(Call<List<FollowingPojo>> call, Throwable t) {

            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
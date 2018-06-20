package cavepass.com.githubsearch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cavepass.com.githubsearch.Adapters.ReposAdapter;
import cavepass.com.githubsearch.ModelClass.FollowersPojo;
import cavepass.com.githubsearch.ModelClass.FollowingPojo;
import cavepass.com.githubsearch.ModelClass.GitRepo;
import cavepass.com.githubsearch.Retrofit.ApiClient;
import cavepass.com.githubsearch.Retrofit.ApiInterface;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 20-06-2018.
 */

public class UserDetails extends AppCompatActivity {

    String userName;
    ArrayList<GitRepo> repos;
    String profileUrl;
    String followers_count;
    String following_count;

    String gitScore_count;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.followers)
    TextView followers;
    @BindView(R.id.followers_count)
    TextView followersCount;
    @BindView(R.id.followers_layout)
    LinearLayout followersLayout;
    @BindView(R.id.following)
    TextView following;
    @BindView(R.id.following_count)
    TextView followingCount;
    @BindView(R.id.following_layout)
    LinearLayout followingLayout;
    @BindView(R.id.git_score)
    TextView gitScore;
    @BindView(R.id.git_score_count)
    TextView gitScoreCount;
    @BindView(R.id.git_score_layout)
    LinearLayout gitScoreLayout;
    @BindView(R.id.repos_recycler_view)
    RecyclerView reposRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);
        ButterKnife.bind(this);

        //Here we check if the internet connection is available or not
        if (CheckNetwork.isInternetAvailable(this)) {


            //If internet Connection is available the app will proceed

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<List<GitRepo>> call2;
            Call<List<FollowersPojo>> callForFollowers;
            Call<List<FollowingPojo>> callForFollowing;

            //Here we get the data which was sent from the previous main activity

            userName = getIntent().getStringExtra(getString(R.string.userName));
            profileUrl = getIntent().getStringExtra(getString(R.string.profileImage));
            gitScore_count = getIntent().getStringExtra(getString(R.string.gitScore));

            //Here we set the user profile image
            Glide.with(getBaseContext()).load(profileUrl).into(profileImage);


            //Here we set the action bar title to user name

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(userName);

            // Here we perform three network calls to fetch data
            //one for number of followers, one for number of people user following
            // In this app we only showing number of followers and number of people user following
            // one for user public git repositories

            call2 = apiService.getrepos(userName);
            callForFollowers = apiService.getFollowers(userName);
            callForFollowing = apiService.getFollowing(userName);

            // Here we perform network call to fetch user public git repositories

            call2.enqueue(new Callback<List<GitRepo>>() {
                @Override
                public void onResponse(Call<List<GitRepo>> call2, Response<List<GitRepo>> response2) {


                    try {
                        repos = new ArrayList<>(response2.body());
                        reposRecyclerView.setAdapter(new ReposAdapter(repos, getBaseContext()));
                        reposRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    } catch (Exception e) {
                        Log.e(getString(R.string.error), call2.request().url().toString());
                    }
                }

                @Override
                public void onFailure(Call<List<GitRepo>> call, Throwable t) {

                    Log.e(getString(R.string.error), t.getMessage());

                }
            });


            //Here we perform network call to fetch data about user followers

            callForFollowers.enqueue(new Callback<List<FollowersPojo>>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<List<FollowersPojo>> call, Response<List<FollowersPojo>> response) {


                    //If we received null or no data we chane the number of followers to NA
                    if (response.body() != null) {
                        followers_count = "" + response.body().size();
                    } else {
                        followers_count = getString(R.string.na);
                    }

                    followersCount.setText(followers_count);
                    gitScoreCount.setText("" + gitScore_count);


                }

                @Override
                public void onFailure(Call<List<FollowersPojo>> call, Throwable t) {

                }
            });

            //Here we fetch data of people user following
            callForFollowing.enqueue(new Callback<List<FollowingPojo>>() {
                @Override
                public void onResponse(Call<List<FollowingPojo>> call, Response<List<FollowingPojo>> response) {

                    //If we received null or no data we chane the number of people user following to NA

                    if (response.body() != null) {
                        following_count = "" + response.body().size();
                    } else {
                        following_count = getString(R.string.na);
                    }

                    followingCount.setText(following_count);


                }

                @Override
                public void onFailure(Call<List<FollowingPojo>> call, Throwable t) {

                }
            });
        } else {
            Intent i = new Intent(this, NoInternet.class);
            startActivity(i);
        }

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

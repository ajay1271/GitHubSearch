package cavepass.com.githubsearch;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cavepass.com.githubsearch.IdlingResource.SimpleIdlingResource;
import cavepass.com.githubsearch.ModelClass.GitRepo;
import cavepass.com.githubsearch.ModelClass.GitUser;
import cavepass.com.githubsearch.ModelClass.Item;
import cavepass.com.githubsearch.Retrofit.ApiClient;
import cavepass.com.githubsearch.Retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> users;
    ArrayList<GitRepo> repos;

    private SimpleIdlingResource mIdlingResource;

    EditText editText;
    TextView searchStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(CheckNetwork.isInternetAvailable(this)) {




            searchStatus = findViewById(R.id.search_status);


            editText = findViewById(R.id.edit_text);

            LinearLayout searchButton = findViewById(R.id.search_button);


            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mIdlingResource = getIdlingResource();
                    mIdlingResource.setIdleState(false);

                    Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();

                    searchStatus.setText(getString(R.string.searching));


            /*  FETCHING JSON USING RETROFIT */


                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    Call<GitUser> call;


                    call = apiService.getUsers(editText.getText().toString());


                    call.enqueue(new Callback<GitUser>() {
                        @Override
                        public void onResponse(Call<GitUser> call, Response<GitUser> response) {

                            users = new ArrayList<>(response.body().getItems());

                            searchStatus.setText(users.size()+getString(R.string.results_found));

                            mIdlingResource.setIdleState(true);

                            if(users.size()!=0) {




                                ItemFragment fragment = new ItemFragment();

                                Bundle uiBundle = new Bundle();
                                uiBundle.putParcelableArrayList(getString(R.string.object), users);


                                fragment.setArguments(uiBundle);

                                FragmentManager fm = getFragmentManager();

                                fm.beginTransaction().replace(R.id.search_items, fragment).commit();

                            }


                        }

                        @Override
                        public void onFailure(Call<GitUser> call, Throwable t) {

                            Log.e(getString(R.string.error), t.getMessage());

                        }
                    });

                }
            });


        }

        else{

            Intent i = new Intent(this,NoInternet.class);
            startActivity(i);

        }

    }

    @VisibleForTesting
    @NonNull
    public SimpleIdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}
package cavepass.com.githubsearch;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.input_layout_name)
    TextInputLayout inputLayoutName;
    @BindView(R.id.search_box)
    LinearLayout searchBox;
    @BindView(R.id.search_button)
    LinearLayout searchButton;
    @BindView(R.id.search_status)
    TextView searchStatus;
    @BindView(R.id.search_items)
    FrameLayout searchItems;

    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Here we check if the internet connection is available or not
        if (CheckNetwork.isInternetAvailable(this)) {
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
        } else {

            //If the internet connection is not available we show the error page
            Intent i = new Intent(this, NoInternet.class);
            startActivity(i);

        }

    }

    //Here we use the idling resource to check the user interface of the app using espresso
    @VisibleForTesting
    @NonNull
    public SimpleIdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }


    // Once the search button is clicked from the main page this method will be invoked
    @OnClick(R.id.search_button)
    public void onViewClicked() {

        if(TextUtils.isEmpty(editText.getText())){
            Toast.makeText(this,getString(R.string.enterName),Toast.LENGTH_SHORT).show();
        }

        else {

            //we set the idle state of the idling resource to false to make ui test to wait till fetching data from json
            mIdlingResource = getIdlingResource();
            mIdlingResource.setIdleState(false);
            searchStatus.setText(getString(R.string.searching));


            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<GitUser> call;
            call = apiService.getUsers(editText.getText().toString());

            //Here we start to fetch the data using Retrofit
            call.enqueue(new Callback<GitUser>() {
                @Override
                public void onResponse(Call<GitUser> call, Response<GitUser> response) {

                    //once the data is successfully received we set the idling state of idling resource to true
                    // we also get the data and store it into the arraylist

                    users = new ArrayList<>(response.body().getItems());
                    searchStatus.setText(users.size() + getString(R.string.results_found));
                    mIdlingResource.setIdleState(true);


                    // this condition is to make sure we didn't received null or no data
                    // if we received null or no data and proceeded without checking the app will crash
                    if (users.size() != 0) {

                        // Here we use fragment to dynamically change data ain recycler view as per the search
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

    }
}
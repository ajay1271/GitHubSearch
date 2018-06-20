package cavepass.com.githubsearch;

import android.app.FragmentManager;
import android.content.Intent;
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

                    Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();

                    searchStatus.setText("Searching...");


            /*  FETCHING JSON USING RETROFIT */


                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    Call<GitUser> call;


                    call = apiService.getUsers(editText.getText().toString());


                    call.enqueue(new Callback<GitUser>() {
                        @Override
                        public void onResponse(Call<GitUser> call, Response<GitUser> response) {

                            users = new ArrayList<>(response.body().getItems());

                            searchStatus.setText(users.size()+" Results found");

                            if(users.size()!=0) {


                                Toast.makeText(MainActivity.this, "" + users.get(0).getLogin(), Toast.LENGTH_SHORT).show();
                                Log.e("URL", call.request().url().toString());


                                ItemFragment fragment = new ItemFragment();

                                Bundle uiBundle = new Bundle();
                                uiBundle.putParcelableArrayList("object", users);


                                fragment.setArguments(uiBundle);

                                FragmentManager fm = getFragmentManager();

                                fm.beginTransaction().replace(R.id.search_items, fragment).commit();

                            }


                        }

                        @Override
                        public void onFailure(Call<GitUser> call, Throwable t) {

                            Log.e("FAILURE", t.getMessage());

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
}
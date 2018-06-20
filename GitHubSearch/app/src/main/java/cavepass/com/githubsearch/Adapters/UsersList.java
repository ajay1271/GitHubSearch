package cavepass.com.githubsearch.Adapters;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import cavepass.com.githubsearch.ModelClass.Item;
import cavepass.com.githubsearch.R;
import cavepass.com.githubsearch.UserDetails;

public class UsersList extends RecyclerView.Adapter<UsersList.ViewHolder> {

    private  ArrayList<Item> item = new ArrayList<>();
    private Context context;



    public class ViewHolder extends RecyclerView.ViewHolder {




        TextView user_id;
        ImageView profileImage;
        TextView gitScore;
        RelativeLayout search_item;


        public ViewHolder(View v) {
            super(v);

            search_item = v.findViewById(R.id.search_result_box);
            user_id = v.findViewById(R.id.user_id);

            profileImage=v.findViewById(R.id.user_profile_image);


        }

    }

    public UsersList(ArrayList<Item> items, Context context) {

        item = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_list,parent,false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


       Glide.with(context).load(item.get(position).getAvatarUrl() ).into(holder.profileImage);




        holder.user_id.setText("@"+item.get(position).getLogin());

        holder.search_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DecimalFormat df = new DecimalFormat("#.##");

                df.setRoundingMode(RoundingMode.FLOOR);

                double score = new Double(df.format(item.get(position).getScore()));

                Intent i =  new Intent(context, UserDetails.class);
                i.putExtra(context.getString(R.string.userName),item.get(position).getLogin());
                i.putExtra(context.getString(R.string.profileImage),item.get(position).getAvatarUrl());
                i.putExtra(context.getString(R.string.gitScore),""+score);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

        return item.size();
    }
}
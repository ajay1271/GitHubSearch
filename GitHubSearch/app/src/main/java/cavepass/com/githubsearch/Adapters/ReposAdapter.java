package cavepass.com.githubsearch.Adapters;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import cavepass.com.githubsearch.ModelClass.GitRepo;
import cavepass.com.githubsearch.ModelClass.Item;
import cavepass.com.githubsearch.R;
import cavepass.com.githubsearch.UserDetails;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private ArrayList<GitRepo> item = new ArrayList<>();
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView repoTitle;
        TextView languageUsed;
        TextView lastUpdatedTime;
        ImageView dot;
        LinearLayout repoCard;


        public ViewHolder(View v) {
            super(v);

            repoCard = v.findViewById(R.id.repo_card);
            repoTitle = v.findViewById(R.id.repo_name);
            languageUsed = v.findViewById(R.id.repo_language);
            lastUpdatedTime = v.findViewById(R.id.repo_last_updated_time);
            dot = v.findViewById(R.id.dot);


        }

    }

    public ReposAdapter(ArrayList<GitRepo> items, Context context) {

        item = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_repos, parent, false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        String languageUSed = item.get(position).getLanguage();

        if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.CPP))){

            holder.dot.setImageResource(R.drawable.dot_c_plus_plus);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.Java))){

            holder.dot.setImageResource(R.drawable.dot_java);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.C))){

            holder.dot.setImageResource(R.drawable.dot_c);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.C_Sharp))){

            holder.dot.setImageResource(R.drawable.dot_c_sharp);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.Python))){

            holder.dot.setImageResource(R.drawable.dot_python);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.HTML))){

            holder.dot.setImageResource(R.drawable.dot_html);

        }
        else if(languageUSed!=null&&languageUSed.equals(context.getString(R.string.CSS))){

            holder.dot.setImageResource(R.drawable.dot_css);

        }

        else {


            holder.dot.setImageResource(R.drawable.circle);
        }



        holder.languageUsed.setText("" + item.get(position).getLanguage());
        holder.repoTitle.setText("" + item.get(position).getName());
        holder.lastUpdatedTime.setText("" + item.get(position).getPushedAt());

        holder.repoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = item.get(position).getHtmlUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {

        return item.size();
    }
}
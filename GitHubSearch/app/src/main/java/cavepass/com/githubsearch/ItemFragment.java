package cavepass.com.githubsearch;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cavepass.com.githubsearch.Adapters.UsersList;
import cavepass.com.githubsearch.ModelClass.Item;

import java.util.ArrayList;

public class ItemFragment extends Fragment {

    ArrayList<Item> ar;

    public ItemFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            ar = getArguments().getParcelableArrayList(getString(R.string.object));


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setAdapter(new UsersList(ar, getActivity().getBaseContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        return view;

    }
}

package com.ariefhirmanto.moovia_3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private Button btnDesc;
    private RecyclerView rvData;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        final FragmentActivity fragmentActivity = getActivity();
        rvData = view.findViewById(R.id.rv_data);
        rvData.setHasFixedSize(true);
        MovieData movieData = new MovieData(fragmentActivity);
        list.addAll(movieData.getListData());
        showRecyclerView(fragmentActivity);

        return view;
    }

    private void showRecyclerView(FragmentActivity fragmentActivity) {
        rvData.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        MovieViewAdapter movieViewAdapter = new MovieViewAdapter(list, fragmentActivity);
        rvData.setAdapter(movieViewAdapter);
    }
}

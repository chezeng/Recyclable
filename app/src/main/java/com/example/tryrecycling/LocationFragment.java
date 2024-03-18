package com.example.tryrecycling;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LocationFragment extends Fragment {

    private RecyclerView.Adapter adapter;

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        EditText searchBar = view.findViewById(R.id.search_bar);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        // Initialize the list of recycling stations
        List<RecyclingStation> stationList = new ArrayList<>();
        // Add some stations to the list
        // You should replace this with your actual data
        stationList.add(new RecyclingStation("Blundell Return-It Centre", "8180 No 2 Rd Unit 130, Richmond, BC V7C 5K1", R.drawable.blundell));
        stationList.add(new RecyclingStation("Iron Wood Return It Centre", "11020 Horseshoe Way, Richmond, BC V7A 4V5", R.drawable.ironwood));
        stationList.add(new RecyclingStation("Regional Recycling Richmond Bottle Depot","13300 Vulcan Way, Richmond, BC V6V 1K2", R.drawable.regional));
        stationList.add(new RecyclingStation("Richmond Recycling Depot","5555 Lynas Ln, Richmond, BC V7C 5B2", R.drawable.richmond_recycling));
        stationList.add(new RecyclingStation("OK Bottle","5751 Cedarbridge Way #145, Richmond, BC V6X 2A8", R.drawable.ok_bottle));
        stationList.add(new RecyclingStation("Vancouver Zero Waste Center","8588 Yukon St, Vancouver, BC V5X 2Y9", R.drawable.vancouver_zero));
        stationList.add(new RecyclingStation("South Van Bottle Depot","34 E 69th Ave, Vancouver, BC V5X 4K6", R.drawable.south_van));
        stationList.add(new RecyclingStation("Return-It Express Yaletown","1387 Richards Street, Vancouver, BC  V6B 3G7", R.drawable.return_it_express));
        stationList.add(new RecyclingStation("Powell Street Return-It Bottle Depot","1856 Powell St, Vancouver, BC V5L 1H9", R.drawable.powell_street));
        stationList.add(new RecyclingStation("Go Green Bottle Depot & Recycling","2286 Ontario St, Vancouver, BC V5T 2X2", R.drawable.go_green));
        stationList.add(new RecyclingStation("Mount Pleasant Return-It Express Depot","501 E Broadway, Vancouver, BC V5T 1X5", R.drawable.mount_pleasant));
        stationList.add(new RecyclingStation("Regional Recycling Vancouver Bottle Depot","960 Evans Ave, Vancouver, BC V6A 2L2", R.drawable.regional_recycling));
        stationList.add(new RecyclingStation("Express & Go - UBC","2465 Health Sciences Mall, Vancouver, BC V6T 1Z3", R.drawable.express___go));
        stationList.add(new RecyclingStation("United We Can Bottle Depot","449 Industrial Ave, Vancouver, BC V6A 2P8", R.drawable.united_we_can));

        // ...

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclingStationAdapter(stationList);
        recyclerView.setAdapter(adapter);

        // Add a text change listener to the search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filter the list based on the search term
                ((RecyclingStationAdapter) adapter).filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}
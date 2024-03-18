package com.example.tryrecycling;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RecyclingFragment extends Fragment {

    public RecyclingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycling, container, false);

        view.findViewById(R.id.btn_plastic).setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                        .replace(R.id.fragment_container, new PlasticFragment())
                        .addToBackStack(null)
                        .commit();
            }

        });

        view.findViewById(R.id.btn_organic).setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                        .replace(R.id.fragment_container, new OrganicFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        view.findViewById(R.id.btn_paper).setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                        .replace(R.id.fragment_container, new PaperFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        view.findViewById(R.id.btn_other).setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                        .replace(R.id.fragment_container, new OtherFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        // do the same for other buttons




        return view;
    }
}
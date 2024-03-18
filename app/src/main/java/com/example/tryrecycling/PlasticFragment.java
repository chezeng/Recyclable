package com.example.tryrecycling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlasticFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plastic, container, false);

        // Find the button and set the click listener
        view.findViewById(R.id.plastic_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToRecycling(view);
            }
        });

        return view;
    }

    public void goBackToRecycling(View view) {
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                    .replace(R.id.fragment_container, new RecyclingFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}

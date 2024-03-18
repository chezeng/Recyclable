package com.example.tryrecycling;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SurveyFragment extends Fragment {

    public SurveyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        Button submitBtn = view.findViewById(R.id.submit_button);
        submitBtn.setOnClickListener(v -> {
            submitForm(view);
        });

        return view;
    }

    public void submitForm(View view) {
        // Get the EditText views
        EditText nameEditText = view.findViewById(R.id.editTextName);
        EditText streetEditText = view.findViewById(R.id.editTextStreet1);
        EditText postalCodeEditText = view.findViewById(R.id.editTextPostalCode);
        EditText townEditText = view.findViewById(R.id.editTextTown);
        EditText phoneNumberEditText = view.findViewById(R.id.editPhoneNumber);
        EditText emailEditText = view.findViewById(R.id.editEmail);
        EditText additionalEditText = view.findViewById(R.id.editAdditional);

        // ... get the other EditText views ...

        // Check if the required fields are filled
        boolean isValid = true;
        if (TextUtils.isEmpty(nameEditText.getText().toString())) {
            nameEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            nameEditText.setBackground(null);
        }

        if (TextUtils.isEmpty(streetEditText.getText().toString())) {
            streetEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            streetEditText.setBackground(null);
        }

        if (TextUtils.isEmpty(postalCodeEditText.getText().toString())) {
            postalCodeEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            postalCodeEditText.setBackground(null);
        }

        if (TextUtils.isEmpty(townEditText.getText().toString())) {
            townEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            townEditText.setBackground(null);
        }

        if (TextUtils.isEmpty(phoneNumberEditText.getText().toString())) {
            phoneNumberEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            phoneNumberEditText.setBackground(null);
        }

        if (TextUtils.isEmpty(emailEditText.getText().toString())) {
            emailEditText.setBackgroundResource(R.drawable.red_border);
            isValid = false;
        } else {
            emailEditText.setBackground(null);
        }


        // ... check the other EditText views ...

        if (isValid) {
            // Clear the EditText views
            nameEditText.setText("");
            streetEditText.setText("");
            postalCodeEditText.setText("");
            townEditText.setText("");
            phoneNumberEditText.setText("");
            emailEditText.setText("");
            additionalEditText.setText("");

            // if all the required fields are filled, then proceed to the submission page
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SubmissionFragment())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }


}

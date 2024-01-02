package com.example.gladiance.Navigation.MyProfile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gladiance.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreateProjectFragment extends Fragment {


    public CreateProjectFragment() {
        // Required empty public constructor
    }

    private Spinner customSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_project, container, false);

        Spinner customSpinner = view.findViewById(R.id.customSpinner);

        // Sample data for the spinner
        List<String> spinnerItems = Arrays.asList("Project 1", "Project 2", "Project 3");

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(requireContext(), spinnerItems);
        customSpinner.setAdapter(customSpinnerAdapter);

        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = (String) parentView.getItemAtPosition(position);
                Toast.makeText(requireContext(), "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected
            }
        });

        return view;
    }



}
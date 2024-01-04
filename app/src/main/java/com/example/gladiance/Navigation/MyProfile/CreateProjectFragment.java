package com.example.gladiance.Navigation.MyProfile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        Spinner dropdownSpinner = view.findViewById(R.id.customSpinner);

        // Create a list of items for the dropdown
        List<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");

        // Create a custom adapter with your custom layout for dropdown items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.dropdown_item1,
                R.id.text1,
                items
        );

        // Set the adapter for the dropdown spinner
        dropdownSpinner.setAdapter(adapter);
        return view;
    }



}
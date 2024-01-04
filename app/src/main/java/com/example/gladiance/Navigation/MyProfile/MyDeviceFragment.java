package com.example.gladiance.Navigation.MyProfile;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.gladiance.R;

import java.util.ArrayList;
import java.util.List;


public class MyDeviceFragment extends Fragment {



    public MyDeviceFragment() {
        // Required empty public constructor
    }
    Button AddDevice;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_device, container, false);

        AddDevice = view.findViewById(R.id.AddDevice);

        AddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AddDeviceFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.MyDeviceFragment, fragment).addToBackStack(null)
                        .commit();

            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
                Log.d(TAG, "handleOnBackPressed: ");
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        Spinner dropdownSpinner = view.findViewById(R.id.dropdownSpinner1);

        // Create a list of items for the dropdown
        List<String> items = new ArrayList<>();
        items.add("ABC");
        items.add("XYZ");
        items.add("ABC");

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
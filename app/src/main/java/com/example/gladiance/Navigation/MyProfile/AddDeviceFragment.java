package com.example.gladiance.Navigation.MyProfile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.gladiance.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;


public class AddDeviceFragment extends Fragment {


    public AddDeviceFragment() {
        // Required empty public constructor
    }

    Button myButton1, myButton2, scanButton;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);

        Spinner dropdownSpinner = view.findViewById(R.id.dropdownSpinner1);

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

        //Second DropDown
        Spinner dropdownSpinner2 = view.findViewById(R.id.dropdownSpinner2);

        // Create a list of items for the dropdown
        List<String> items2 = new ArrayList<>();
        items2.add("Item 1");
        items2.add("Item 2");
        items2.add("Item 3");

        // Create a custom adapter with your custom layout for dropdown items
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                requireContext(),
                R.layout.dropdown_item2,
                R.id.text2,
                items2
        );

        // Set the adapter for the dropdown spinner
        dropdownSpinner2.setAdapter(adapter2);

        //Third DropDown
        Spinner dropdownSpinner3 = view.findViewById(R.id.dropdownSpinner3);

        // Create a list of items for the dropdown
        List<String> items3 = new ArrayList<>();
        items3.add("Item 1");
        items3.add("Item 2");
        items3.add("Item 3");

        // Create a custom adapter with your custom layout for dropdown items
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(
                requireContext(),
                R.layout.dropdown_item3,
                R.id.text3,
                items2
        );

        // Set the adapter for the dropdown spinner
        dropdownSpinner3.setAdapter(adapter3);

        scanButton = view.findViewById(R.id.scanButton);

        view.findViewById(R.id.scanButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the QR code scanner on button click
                initiateQRCodeScan();
            }
        });

        return view;
    }

    private void initiateQRCodeScan() {
        // Initialize the ZXing IntentIntegrator
        IntentIntegrator integrator = IntentIntegrator.forSupportFragment(AddDeviceFragment.this);
        integrator.setOrientationLocked(false); // Optional: Allow rotation of the scanner
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan a QR Code");
        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Handle the result of the QR code scanning
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {


            } else {
                // QR code scanned successfully
                String scannedData = result.getContents();
                // Handle the scanned data as needed
                openNextFragment(scannedData);
            }
        }
    }

    private void openNextFragment(String scannedData) {
        // Create a new fragment and pass the scanned data as an argument
        WifiIntegrationFragment wifiIntegrationFragment = new WifiIntegrationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("scannedData", scannedData);
        wifiIntegrationFragment.setArguments(bundle);

        // Replace the current fragment with the new one
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_QR, wifiIntegrationFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package com.example.gladiance.Navigation.MyProfile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gladiance.R;


public class WifiIntegrationFragment extends Fragment {



    public WifiIntegrationFragment() {
        // Required empty public constructor
    }

    Button starButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wifi_integration, container, false);

        starButton = view.findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CheckConnectionFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.WifiConnection_fragment, fragment)
                        .commit();
            }
        });
        return view;
    }
}
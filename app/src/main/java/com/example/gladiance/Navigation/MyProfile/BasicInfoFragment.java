package com.example.gladiance.Navigation.MyProfile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gladiance.Login.LoginActivity;
import com.example.gladiance.R;

public class BasicInfoFragment extends Fragment {


    public BasicInfoFragment() {
        // Required empty public constructor
    }

    LinearLayout llChangePassword;
    LinearLayout llInviteUser;
    LinearLayout llJoinUser;
    LinearLayout llLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);

        llChangePassword = view.findViewById(R.id.llChangePassword);
        llChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ChangePasswordFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.basic_info_frameLayout, fragment)
                        .commit();
            }
        });

        llInviteUser = view.findViewById(R.id.llInviteUser);
        llInviteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new InviteUserFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.basic_info_frameLayout, fragment)
                        .commit();
            }
        });

        llJoinUser = view.findViewById(R.id.llJoinUser);
        llJoinUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new JoinUserFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.basic_info_frameLayout, fragment)
                        .commit();
            }
        });

        llLogout = view.findViewById(R.id.llLogout);
        llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
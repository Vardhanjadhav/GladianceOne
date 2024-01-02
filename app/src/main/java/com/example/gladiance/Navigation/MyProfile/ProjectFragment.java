package com.example.gladiance.Navigation.MyProfile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gladiance.R;


public class ProjectFragment extends Fragment {

    LinearLayout MyProject;
    LinearLayout CreateProject;


    public ProjectFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project, container, false);

        MyProject = view.findViewById(R.id.MyProject);

        MyProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MyProjectFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.Project_frameLayout, fragment)
                        .commit();

            }
        });

        CreateProject = view.findViewById(R.id.CreateProject);

        CreateProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CreateProjectFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.Project_frameLayout, fragment)
                        .commit();

            }
        });



        return view;
    }
}
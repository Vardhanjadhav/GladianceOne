package com.example.gladiance.Navigation.ControlBouquet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gladiance.R;


public class DoorLockFragment extends Fragment {



    public DoorLockFragment() {
        // Required empty public constructor
    }

    ImageView imageViewLock;
    TextView textViewlock;
    private boolean contentChanged = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_door_lock2, container, false);

        imageViewLock = view.findViewById(R.id.imglock);
        textViewlock = view.findViewById(R.id.tv_unlock_lock);


        imageViewLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentChanged) {
                    imageViewLock.setImageResource(R.drawable.doorlock);
                    textViewlock.setText("Tab to unlock");

                } else {
                    imageViewLock.setImageResource(R.drawable.doorunlock);
                    textViewlock.setText("Tab to lock");


                }
                contentChanged = !contentChanged;
            }
        });

        return view;
    }
}
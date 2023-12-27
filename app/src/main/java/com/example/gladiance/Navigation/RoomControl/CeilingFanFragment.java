package com.example.gladiance.Navigation.RoomControl;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gladiance.R;

import hiennguyen.me.circleseekbar.CircleSeekBar;


public class CeilingFanFragment extends Fragment  implements CircleSeekBar.OnSeekBarChangedListener {



    public CeilingFanFragment() {
        // Required empty public constructor
    }
    EditText point;
    Button change;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ceiling_fan, container, false);


        final CircleSeekBar circleSeekBar = view.findViewById(R.id.circular);
        circleSeekBar.setSeekBarChangeListener(this);
//        point = view.findViewById(R.id.txt_point);
//        change = view.findViewById(R.id.change_button);
        circleSeekBar.setProgressDisplayAndInvalidate(1);

//        change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(point.getText().length() != 0) {
//                    circleSeekBar.setProgressDisplayAndInvalidate(Integer.valueOf(point.getText().toString()));
//
//                }
//            }
//        });
        return view;
    }
    @Override
    public void onPointsChanged(CircleSeekBar circleSeekBar, int points, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(CircleSeekBar circleSeekBar) {

    }

    @Override
    public void onStopTrackingTouch(CircleSeekBar circleSeekBar) {
        Log.v(TAG, String.valueOf(circleSeekBar.getProgressDisplay()));
//      circleSeekBar.setProgressDisplayAndInvalidate(circleSeekBar.getProgressDisplay()));
    }


}
package com.example.gladiance.Navigation.RoomControl;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gladiance.R;

import java.util.ArrayList;
import java.util.List;


public class MoodsFragment extends Fragment {

    public MoodsFragment() {
        // Required empty public constructor
    }
    //RecyclerView recyclerViewRoomControl;

    //AdapterItemRoomControl adapterItemRoomControl;

    //private List<String> titlesRoomControl;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_moods, container, false);



        return view;
    }



}
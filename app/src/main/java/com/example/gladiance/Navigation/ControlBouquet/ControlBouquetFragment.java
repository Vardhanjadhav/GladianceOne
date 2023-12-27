package com.example.gladiance.Navigation.ControlBouquet;

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


public class ControlBouquetFragment extends Fragment {

    public ControlBouquetFragment() {
        // Required empty public constructor
    }

    private RecyclerView rvcontrolbouquet;
    private ControlBouquetAdapter adapter;
    private List<String> titles;
    private List<Integer> mImages;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_control_bouquet, container, false);

        //recycle view controlBouquet

        rvcontrolbouquet = view.findViewById(R.id.rv_control_bouquet);

        adapter = new ControlBouquetAdapter(requireContext(),titles,mImages);

        titles = new ArrayList<>();
        mImages = new ArrayList<>();


        mImages.add(R.drawable.housekeeping2);
        mImages.add(R.drawable.foodservice);
        mImages.add(R.drawable.laundryservice);
        mImages.add(R.drawable.bill_view);
        mImages.add(R.drawable.feedback);
        mImages.add(R.drawable.hotel_info);
        mImages.add(R.drawable.promotion);
        mImages.add(R.drawable.messaging);
      //  mImages.add(R.drawable.doorlockcb);
        mImages.add(R.drawable.emergency);
        mImages.add(R.drawable.doorcamera);
        mImages.add(R.drawable.security);

        titles.add("Housekeeping");
        titles.add("Room Service");
        titles.add("Laundry");
        titles.add("Bill View");
        titles.add("Feedback");
        titles.add("Hotel Info");
        titles.add("Promotion");
        titles.add("Messaging");
       // titles.add("Door Camera");
        titles.add("Emergency");
        titles.add("Door Camera");
        titles.add("Security");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL,false);
        rvcontrolbouquet.setLayoutManager(gridLayoutManager);
        rvcontrolbouquet.setHasFixedSize(true);
        rvcontrolbouquet.setAdapter(new ControlBouquetAdapter(requireContext(),titles,mImages));

        return view;

    }
}
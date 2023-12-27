package com.example.gladiance.Navigation.MyProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.gladiance.R;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter<MyProfileSpinnerItem> {
    public CustomSpinnerAdapter(@NonNull Context context, ArrayList<MyProfileSpinnerItem> customSpinnerItemArrayList) {
        super(context, 0, customSpinnerItemArrayList);
    }


    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        return customView(position,convertView,parent);
    }

    public View getDropDownView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        return customView(position,convertView,parent);
    }

    public View customView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_layout,parent,false);
        }
        MyProfileSpinnerItem item = getItem(position);
        TextView spinnerName = convertView.findViewById(R.id.tvCustomSpinner);
        if (item != null){
            spinnerName.setText(item.getSpinnerText());
        }
        return convertView;
    }
}

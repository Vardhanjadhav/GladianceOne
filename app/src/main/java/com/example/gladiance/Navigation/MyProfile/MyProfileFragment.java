package com.example.gladiance.Navigation.MyProfile;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gladiance.R;

import java.util.ArrayList;
import java.util.Objects;


public class MyProfileFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

    public MyProfileFragment() {
        // Required empty public constructor
    }

    TextView tv_view_more;
    LinearLayout Project;
    LinearLayout Automation;
    LinearLayout AddDevice;
    LinearLayout subscription;
    LinearLayout Integration;
    LinearLayout Help;
    LinearLayout AboutUs;
    LinearLayout Setting;
    GridLayout gridLayout3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);


        tv_view_more = view.findViewById(R.id.tv_view_more);

        tv_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BasicInfoFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();

            }
        });

        Project = view.findViewById(R.id.Project);
        Project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ProjectFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();

//                Fragment fragment = new ProjectFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        Automation = view.findViewById(R.id.Automation);
        Automation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AutomationFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new AutomationFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

            }
        });

        AddDevice = view.findViewById(R.id.AddDevice);
        AddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AddDeviceFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new AddDeviceFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        subscription = view.findViewById(R.id.subscription);
        subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SubscriptionFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new SubscriptionFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        Integration = view.findViewById(R.id.Integration);
        Integration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new IntegrationFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new IntegrationFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        Help = view.findViewById(R.id.Help);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new HelpFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new HelpFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        AboutUs = view.findViewById(R.id.AboutUs);
        AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AboutUsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();
            }
        });

        Setting = view.findViewById(R.id.Setting);
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SettingFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.container, fragment).addToBackStack(null)
                        .commit();


//                Fragment fragment = new SettingFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });




//        btn_hide_show = view.findViewById(R.id.btn_add_user);
//        layout_hide_show = view.findViewById(R.id.layout_hide_show);
//        btn_setting = view.findViewById(R.id.btn_setting);
//        layout_hide_show1 = view.findViewById(R.id.layout_hide_show1);
//        btn_logout = view.findViewById(R.id.btn_logout);
//        btn_logout = view.findViewById(R.id.btn_logout);
//
//        btn_hide_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int isvisible = layout_hide_show.getVisibility();
//                if (isvisible == View.VISIBLE) {
//                    layout_hide_show.setVisibility(View.GONE);
//                } else {
//                    layout_hide_show.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        btn_setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int isvisible = layout_hide_show1.getVisibility();
//                if (isvisible == View.VISIBLE) {
//                    layout_hide_show1.setVisibility(View.GONE);
//                } else {
//                    layout_hide_show1.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        //Dialog bo code
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String message = "Are you sure you want to log out from gladiance";
//                showCustomDialogBox(message);
//            }
//
//            private void showCustomDialogBox(String message) {
//
//                final Dialog dialog = new Dialog(requireContext());
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setCancelable(false);
//                dialog.setContentView(R.layout.layout_custom_dailog);
//                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//                tvMessage = dialog.findViewById(R.id.tvMessage);
//                btnYes = dialog.findViewById(R.id.btn_Yes);
//                btnNo = dialog.findViewById(R.id.btn_No);
//
//                tvMessage.setText(message);
//
//                btnYes.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(getContext(), "Clicked on Yes", Toast.LENGTH_LONG).show();
//                        dialog.dismiss();
//                    }
//                });
//
//                btnNo.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//
//                dialog.show();
//            }
//
//        });
//
//        //Spinner code
//        customSpinner = view.findViewById(R.id.customSpinner);
//        //create spinneritemlist for spinner
//        ArrayList<MyProfileSpinnerItem> customList = new ArrayList<>();
//        customList.add(new MyProfileSpinnerItem("Regular"));
//        customList.add(new MyProfileSpinnerItem("Suite"));
//        customList.add(new MyProfileSpinnerItem("Presidential Suite"));
//        customList.add(new MyProfileSpinnerItem("Regular"));
//
//        //Custom Adapter for spinner
//        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(requireContext(),customList);
//
//
//        if (customSpinner != null){
//            customSpinner.setAdapter(customSpinnerAdapter);
//            customSpinner.setOnItemSelectedListener(this);
//        }
//
//
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
//
//
//        @Override
//        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
//
//        }
//
//        @Override
//        public void onNothingSelected (AdapterView < ? > parent){
//
//        }


}
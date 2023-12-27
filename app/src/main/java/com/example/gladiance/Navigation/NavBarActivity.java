package com.example.gladiance.Navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.gladiance.Navigation.ControlBouquet.ControlBouquetFragment;
import com.example.gladiance.Navigation.ControlBouquet.ControlBouquetHorizontalParentFragment;
import com.example.gladiance.Navigation.DoNotDistrub.DoNotDisturbFragment;
import com.example.gladiance.Navigation.Home.HomeFragment;
import com.example.gladiance.Navigation.MyProfile.MyProfileFragment;
import com.example.gladiance.Navigation.RoomControl.RoomControlFragment;
import com.example.gladiance.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class NavBarActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        bottomNavigation = findViewById(R.id.bottomNavigation);


        replace(new HomeFragment());



        bottomNavigation.show(3, true);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.privacy));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.smartphone));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.temperature_control));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.my_profile));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()) {
                    case 1:
                        replace(new DoNotDisturbFragment());
                        break;
                    case 2:
                        replace(new RoomControlFragment());
                        break;
                    case 3:
                        replace(new HomeFragment());
                        break;
                    case 4:
                        replace(new ControlBouquetHorizontalParentFragment());
                        break;
                    case 5:
                        replace(new MyProfileFragment());
                        break;
                }

                return null;
            }
        });

    }//

    private void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.commit();
    }
}
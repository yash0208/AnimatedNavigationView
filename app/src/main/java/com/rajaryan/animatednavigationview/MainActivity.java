package com.rajaryan.animatednavigationview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SNavigationDrawer sNavigationDrawer;
    public static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment=new Fragment1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home",R.drawable.w11));
        menuItems.add(new MenuItem("Second Fragment",R.drawable.w11));
        menuItems.add(new MenuItem("Third Fragment",R.drawable.w11));
        sNavigationDrawer.setMenuItemList(Collections.<com.shrikanthravi.customnavigationdrawer2.data.MenuItem>unmodifiableList((List<? extends com.shrikanthravi.customnavigationdrawer2.data.MenuItem>) menuItems));
        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position) {
                    case 0: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment1();
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();

                        break;
                    }
                    case 1: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment2();
                        Bundle bundle = new Bundle();

// set Fragmentclass Arguments

                        fragment.setArguments(bundle);
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
                        break;
                    }
                    case 2: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment3();
                        Bundle bundle = new Bundle();

// set Fragmentclass Arguments

                        fragment.setArguments(bundle);
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
                        break;
                    }


                }}
        });
    }
}

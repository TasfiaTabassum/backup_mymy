package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class navigation_drawer_activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

       drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer , R.string.CloseDrawer
        );

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        loadFragment(new DFragment());
        //Menu menu = navigationView.getMenu();
        /*MenuItem item1 = menu.getItem(0);
        Log.d("frag" , "frag a1 te ashe ") ;
        item1.setChecked(true);
        naviagtionDrawer();*/

        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.aboutUs){
                    loadFragment(new AFragment());
                    Log.d("frag" , "frag a te ashe ") ;
                }
                else if(id == R.id.timeslottingactivity){
                    loadFragment(new BFragment());
                    Log.d("frag" , "frag b te ashe ") ;
                }
                else{
                    loadFragment(new CFragment());
                    Log.d("frag" , "frag c te ashe ") ;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });*/




        /*


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer , R.string.CloseDrawer
        );

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        loadFragment(new DFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.aboutUs){
                    loadFragment(new AFragment());
                    Log.d("frag" , "frag a te ashe ") ;
                }
                else if(id == R.id.timeslottingactivity){
                    loadFragment(new BFragment());
                    Log.d("frag" , "frag b te ashe ") ;
                }
                else{
                    loadFragment(new CFragment());
                    Log.d("frag" , "frag c te ashe ") ;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

         */




    }

    /*
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //  fm.beginTransaction().remove(getCurrentFragment()).commit();
        ft.add(R.id.container, fragment);
        ft.commit();
        //ft.commitNow();
    }
    */






    private void loadFragment(Fragment fragment) {
        if(getCurrentFragment() != fragment){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
​
            if(getCurrentFragment()!=null)
            {
                fm.beginTransaction().remove(getCurrentFragment()).commit();
            }
​
            ft.replace(R.id.container, fragment);
            //ft.commit();
            ft.commitNow();
        }
    }

    public Fragment getCurrentFragment() {
        return this.getSupportFragmentManager().findFragmentById(R.id.container);
    }

    private void naviagtionDrawer() {
        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        //navigationView.setCheckedItem(R.id.nav_home);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int it = -1;
                Menu menu = navigationView.getMenu();
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.isChecked()) {

                        it = item.getItemId();
                        item.setChecked(false);
                    }
                }
                menuItem.setChecked(false);
                int id = menuItem.getItemId();
                if(it==id)
                {
                    menuItem.setChecked(true);
                    return false;
                }
                else
                {
                    switch (id) {
                        case R.id.home:

                            navigationView.setCheckedItem(R.id.home);
                            loadFragment(new DFragment());
                            break;
                        case R.id.aboutUs:

                            navigationView.setCheckedItem(R.id.aboutUs);
                            loadFragment(new AFragment());
                            break;
                        case R.id.timeslottingactivity:

                            navigationView.setCheckedItem(R.id.timeslottingactivity);
                            loadFragment(new UpdateEmailAddress());
                            break;
                        case R.id.nav_user_home:
                            navigationView.setCheckedItem(R.id.nav_user_home);
                            startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
                            break;

                        default:
                            break;
                    }
                    menuItem.setChecked(true);
                    setTitle(menuItem.getTitle());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }






package com.example.petemuan3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //memanggil drawer_layout dari activity_main.xml
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =
                findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //membuat hamburger icon pada toolbar dan animasinya
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //membuat default navigation menu select
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new fragment_profile()).commit();
            navigationView.setCheckedItem(R.id.nav_profile);
        }
    }


    //drawer menu fragment handler
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_profile()).commit();
                break;
            case R.id.nav_catalog:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_catalog()).commit();
                break;
            case R.id.nav_keranjang:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_keranjang()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void back1(View view) {
        Intent a = new Intent(MainActivity.this, fragment_catalog.class);
        startActivity(a);
    }
    public void appart1(View view) {
        Intent a = new Intent(MainActivity.this, apart1.class);
        startActivity(a);
    }

    public void appart2(View view) {
        Intent a = new Intent(MainActivity.this, apart2.class);
        startActivity(a);
    }

    public void appart3(View view) {
        Intent a = new Intent(MainActivity.this, apart3.class);
        startActivity(a);
    }

    public void appart4(View view) {
        Intent a = new Intent(MainActivity.this, apart4.class);
        startActivity(a);
    }
    //on back press behavior
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
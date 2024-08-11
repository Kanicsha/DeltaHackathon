package com.example.xnyl;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.d_xnyl.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        MyNavigationItemListener listener = new MyNavigationItemListener();
        navigationView.setNavigationItemSelectedListener(listener);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
       /* if (savedInstanceState == null) {

            CalenderViewActivity fragment = new CalenderViewActivity();
            Bundle bundle = new Bundle();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,);
            navigationView.setCheckedItem(R.id.nav_home);

        }*/
    }

    private class MyNavigationItemListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId()==R.id.calender){
                Intent intent=new Intent(HomeActivity.this,CalenderViewActivity.class);
                startActivity(intent);
            }
            HomeActivity.this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    }
}
package com.piyush004.projectfirst.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.piyush004.projectfirst.MainActivity;
import com.piyush004.projectfirst.R;
import com.piyush004.projectfirst.owner.home.HomeOwnerFragment;
import com.piyush004.projectfirst.owner.messdetails.MessDetailsActivity;
import com.piyush004.projectfirst.owner.messmenu.MessMenuActivity;
import com.piyush004.projectfirst.owner.profile.ProfileOwnerFragment;

public class OwnerDashboard extends AppCompatActivity {

    private TextView textViewName, textViewEmail;
    private String login_name, login_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);

        textViewName = findViewById(R.id.DashboardHeaderName);
        textViewEmail = findViewById(R.id.DashboardHeaderEmail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            login_name = bundle.getString("login_name_mess_Dashboard");
            login_email = bundle.getString("EmailID");
        }

        final DrawerLayout drawerLayout = findViewById(R.id.drawer);
        findViewById(R.id.menuIconId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navmenu);
        navigationView.setItemIconTintList(null);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeOwnerFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.menu_home:

                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeOwnerFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_profile:
                        Toast.makeText(getApplicationContext(), "Profile Panel is Open", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ProfileOwnerFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_mess_details:
                        Toast.makeText(getApplicationContext(), "mess Details Panel is Open", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(OwnerDashboard.this, MessDetailsActivity.class);
                        intent.putExtra("LoginNameMessDetails", login_name);
                        intent.putExtra("LoginEmailMessDetails", login_email);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_messMenu:
                        Toast.makeText(getApplicationContext(), "mess Menu Panel is Open", Toast.LENGTH_SHORT).show();
                        Intent intentmenu = new Intent(OwnerDashboard.this, MessMenuActivity.class);
                        startActivity(intentmenu);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_schadule:
                        Toast.makeText(getApplicationContext(), "mess Schadule Panel is Open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_messLocation:
                        Toast.makeText(getApplicationContext(), "mess Location Panel is Open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_share:
                        Toast.makeText(getApplicationContext(), "Share Panel is Open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_help:
                        Toast.makeText(getApplicationContext(), "Help Panel is Open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), "Setting Panel is Open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:
                        Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intentlogout = new Intent(OwnerDashboard.this, MainActivity.class);
                        startActivity(intentlogout);
                        break;
                }

                return true;
            }
        });
    }
}
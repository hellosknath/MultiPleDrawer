package com.sriidea.multipledrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle barDrawerToggle;
    ImageButton imageLeft, imageRight;
    GridView main_grid, drawer_left, drawer_right;
    LinearLayout drawer_right_main, drawer_left_main;

    CustomAdapter ca1, ca2, ca3;
    int[] img;
    String[] name;
    String j;
    Context con = this;

    static MainActivity instance;

    public MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.activity_main);

        main_grid = findViewById(R.id.main_grid);
        drawer_left = findViewById(R.id.drawer_left);
        drawer_right = findViewById(R.id.drawer_right);
        imageLeft = findViewById(R.id.imageLeft);
        imageRight = findViewById(R.id.imageRight);
        drawer_right_main = findViewById(R.id.drawer_right_main);
        drawer_left_main = findViewById(R.id.drawer_left_main);

        drawerLayout.addDrawerListener(barDrawerToggle);

        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(drawer_left_main)) {
                    drawerLayout.closeDrawer(drawer_left_main);
                } else if (!drawerLayout.isDrawerOpen(drawer_left_main)) {
                    drawerLayout.openDrawer(drawer_left_main);
                }
                if (drawerLayout.isDrawerOpen(drawer_right_main)) {
                    drawerLayout.closeDrawer(drawer_right_main);
                }
            }
        });

        imageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(drawer_right_main)) {
                    drawerLayout.closeDrawer(drawer_right_main);
                } else if (!drawerLayout.isDrawerOpen(drawer_right_main)) {
                    drawerLayout.openDrawer(drawer_right_main);
                }
                if (drawerLayout.isDrawerOpen(drawer_left_main)) {
                    drawerLayout.closeDrawer(drawer_left_main);
                }
            }
        });

        getData();

    }

    public void hideDrawer() {
        if (drawerLayout.isDrawerOpen(drawer_left_main)) {
            drawerLayout.closeDrawer(drawer_left_main);
        }
        if (drawerLayout.isDrawerOpen(drawer_right_main)) {
            drawerLayout.closeDrawer(drawer_right_main);
        }
    }

    private void getData() {
        j = "Child, Commute, Corporate, Deck";
        name = j.split(",");
        img = new int[]{R.drawable.ic_baseline_child_friendly_24,
                R.drawable.ic_baseline_commute_24,
                R.drawable.ic_baseline_corporate_fare_24,
                R.drawable.ic_baseline_deck_24};
        ca1 = new CustomAdapter(name, con, img);
        main_grid.setAdapter(ca1);
        ca2 = new CustomAdapter(name, con, img);
        drawer_left.setAdapter(ca2);
        ca3 = new CustomAdapter(name, con, img);
        drawer_right.setAdapter(ca3);
    }
}
package com.example.saiful.codemeals;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.saiful.codemeals.adapter.HomeAdapter;
import com.example.saiful.codemeals.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeAdapter.ItemListener {

    WifiManager wifiManager;
    private RecyclerView recyclerView;
    private ArrayList<Item> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        arrayList = new ArrayList<>();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();
            }
        });*/
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        final View view = findViewById(android.R.id.content);
        if (info == null) {
            Snackbar snackbar = Snackbar.make(view, "No internet", Snackbar.LENGTH_INDEFINITE).setAction("CONNECT", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Snackbar snackbar1=Snackbar.make(view,"undo successful",Snackbar.LENGTH_SHORT);
                    snackbar1.show();*/
                    Toast.makeText(MainActivity.this, "is connected", Toast.LENGTH_SHORT).show();
                    wifiManager.setWifiEnabled(true);
                }
            }).setActionTextColor(Color.GREEN);
            snackbar.show();

        }

            arrayList.add(new Item("Item 1", R.drawable.seven, "#09A9FF"));
            arrayList.add(new Item("Item 2", R.drawable.seven, "#3E51B1"));
            arrayList.add(new Item("Item 3", R.drawable.seven, "#673BB7"));
            arrayList.add(new Item("Item 4", R.drawable.seven, "#4BAA50"));
            arrayList.add(new Item("Item 5", R.drawable.seven, "#F94336"));
            arrayList.add(new Item("Item 6", R.drawable.seven, "#0A9B88"));

            arrayList.add(new Item("Item 1", R.drawable.seven, "#09A9FF"));
            arrayList.add(new Item("Item 2", R.drawable.seven, "#3E51B1"));
            arrayList.add(new Item("Item 3", R.drawable.seven, "#673BB7"));
            arrayList.add(new Item("Item 4", R.drawable.seven, "#4BAA50"));
            arrayList.add(new Item("Item 5", R.drawable.seven, "#F94336"));
            arrayList.add(new Item("Item 6", R.drawable.seven, "#0A9B88"));

            HomeAdapter adapter = new HomeAdapter(this, arrayList, this);
            recyclerView.setAdapter(adapter);


            /**
             AutoFitGridLayoutManager that auto fits the cells by the column width defined.
             **/

        /*AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);*/


            /**
             Simple GridLayoutManager that spans two columns
             **/
            GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onItemClick(Item item) {
        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

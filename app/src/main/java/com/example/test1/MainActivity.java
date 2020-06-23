package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.arr_video);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
navigationView.setNavigationItemSelectedListener(this);
list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
intent.putExtra("category", category_index);
intent.putExtra("position", position);
startActivity(intent);
    }
});


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_videos);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.menu_videos){
            // Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT).show();
            toolbar.setTitle(R.string.menu_videos);
            array = getResources().getStringArray(R.array.arr_video);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 0;
        } else if (id == R.id.menu_pob){
            toolbar.setTitle(R.string.menu_pob);
            array = getResources().getStringArray(R.array.arr_pob);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 1;
        } else if (id == R.id.menu_about){
            toolbar.setTitle(R.string.menu_about);
            array = getResources().getStringArray(R.array.arr_about);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 2;
        } else if (id == R.id.menu_leveling){
            toolbar.setTitle(R.string.menu_leveling);
            array = getResources().getStringArray(R.array.arr_lvl);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 3;
        } else if (id == R.id.menu_passive){
            toolbar.setTitle(R.string.menu_passive);
            array = getResources().getStringArray(R.array.arr_asc);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 4;
        } else if (id == R.id.menu_gem){
            toolbar.setTitle(R.string.menu_gem);
            array = getResources().getStringArray(R.array.arr_gem);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 5;
        } else if (id == R.id.menu_gear){
            toolbar.setTitle(R.string.menu_gear);
            array = getResources().getStringArray(R.array.arr_gear);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 6;
        } else if (id == R.id.menu_mapping) {
            toolbar.setTitle(R.string.menu_mapping);
            array = getResources().getStringArray(R.array.arr_map);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 7;
        }
drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
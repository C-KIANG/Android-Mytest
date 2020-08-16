package com.edu.hzuapps.androidlabs.mytoolbox.Module;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.edu.hzuapps.androidlabs.mytoolbox.R;
import com.edu.hzuapps.androidlabs.mytoolbox.MyToolboxActivity;

public class SecondFunctionActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_function);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int item_id = item.getItemId();

        switch (item_id)
        {
            case R.id.nav_home:

                Intent intent0 = new Intent();

                intent0.setClass(SecondFunctionActivity.this, MyToolboxActivity.class);

                startActivity(intent0);

                /*MyToolboxActivity.this.finish();*/
                break;
            case R.id.nav_media:

                Intent intent1 = new Intent();

                intent1.setClass(SecondFunctionActivity.this, MediaModuleActivity.class);

                startActivity(intent1);
                break;
            case R.id.nav_wallpaper:

                Intent intent2 = new Intent();

                intent2.setClass(SecondFunctionActivity.this, WallpaperModuleActivity.class);

                startActivity(intent2);
                break;
            case R.id.nav_tool:

                Intent intent3 = new Intent();

                intent3.setClass(SecondFunctionActivity.this, ToolModuleActivity.class);

                startActivity(intent3);
                break;
            case R.id.nav_emoji:

                Intent intent4 = new Intent();

                intent4.setClass(SecondFunctionActivity.this, EmojiModuleActivity.class);

                startActivity(intent4);
                break;

        }
        return true;
    }


}

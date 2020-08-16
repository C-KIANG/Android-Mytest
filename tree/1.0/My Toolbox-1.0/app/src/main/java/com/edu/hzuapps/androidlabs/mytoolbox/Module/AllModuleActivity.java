package com.edu.hzuapps.androidlabs.mytoolbox.Module;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.edu.hzuapps.androidlabs.mytoolbox.Module.Function.CatGame.SleepCatActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.Function.Notepad.NotepadActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.Function.Wallpaper.ListViewShowPicActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.R;

public class  AllModuleActivity extends AppCompatActivity {
    private Button button0;
    private Button button01;
    private Button button02;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_module);
        Button button0 = findViewById(R.id.function01);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllModuleActivity.this, NotepadActivity.class);
                startActivity(intent);
            }
        });
        Button button01 = findViewById(R.id.function02);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllModuleActivity.this, ListViewShowPicActivity.class);
                startActivity(intent);
            }
        });
        Button button02 = findViewById(R.id.function03);

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllModuleActivity.this, SleepCatActivity.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 给左上角图标的左边加上一个返回的图标 。
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}

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
import com.edu.hzuapps.androidlabs.mytoolbox.R;

public class GameModuleActivity extends AppCompatActivity {
    private Button button0;
    private Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_module);
            Button button0 = findViewById(R.id.function13);

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(GameModuleActivity.this, SleepCatActivity.class);
                    startActivity(intent);
                }
            });
            Button button01 = findViewById(R.id.function14);

            button01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(GameModuleActivity.this, SecondFunctionActivity.class);
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

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            return super.onOptionsItemSelected(item);
        }

}

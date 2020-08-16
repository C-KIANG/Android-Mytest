package com.edu.hzuapps.androidlabs.mytoolbox.Module.Function;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.hzuapps.androidlabs.mytoolbox.R;

public class Settings extends AppCompatActivity {
    private String data[] = {"关于","主题（待开发）","检查更新"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ListView listView = (ListView) findViewById(R.id.setting_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);//新建并配置ArrayAapeter
        listView.setAdapter(adapter);


        //设置列表项目点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                    about();
                        break;
                    case 1:
                        Toast.makeText(Settings.this,"正在开发中。。。",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Uri uri = Uri.parse("https://github.com/C-KIANG/Android-Mytest/releases");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(Settings.this,"目前仅支持github下载。。。",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }
    public void about()
    {
        AlertDialog myDialog = new AlertDialog.Builder(this).create();
        myDialog.show();
        myDialog.getWindow().setContentView(R.layout.about);
    }
}

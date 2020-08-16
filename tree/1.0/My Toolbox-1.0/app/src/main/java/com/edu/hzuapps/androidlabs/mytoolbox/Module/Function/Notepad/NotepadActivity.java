package com.edu.hzuapps.androidlabs.mytoolbox.Module.Function.Notepad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edu.hzuapps.androidlabs.mytoolbox.R;

import java.util.ArrayList;
import java.util.List;

public class NotepadActivity extends AppCompatActivity {

    public static DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private List<String> diary=new ArrayList<>();
    public static final int TAG_INSERT=1;
    public static final int TAG_UPDATE=0;
    private String select_item;
    private int Id;
    ListView listView;
    ArrayAdapter<String> adapter;

    private SwipeRefreshLayout swipeRefresh;

    public static DatabaseHelper getDbHelper(){
        return dbHelper;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_main);
        FloatingActionButton add=(FloatingActionButton)findViewById(R.id.add);

        swipeRefresh=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout
                .OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        dbHelper=new DatabaseHelper(NotepadActivity.this, DatabaseHelper.DB_NAME,null, DatabaseHelper.VERSION);
        dbHelper.getWritableDatabase();
        init();
        //添加笔记
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NotepadActivity.this, Detail.class);
                intent.putExtra("TAG",TAG_INSERT);
                startActivity(intent);

                finish();
            }
        });

        //设置列表项目点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=new Intent(NotepadActivity.this,Detail.class);
                Id=getDiaryId(position);
                //  Log.d("NotepadActivity",""+id);

                intent.putExtra("ID",Id);
                intent.putExtra("TAG",TAG_UPDATE);
                startActivity(intent);

                finish();
            }
        });
    }
    private void refresh(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        init();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {  if(resultCode == RESULT_OK)
        {
            refresh();
        }
    }

    private void init(){
        db=dbHelper.getWritableDatabase();
        diary.clear();
        //查询数据库，将title一列添加到列表项目中
        Cursor cursor=db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            String diary_item;
            do{
                diary_item=cursor.getString(cursor.getColumnIndex("title"));
                diary.add(diary_item);
            }while(cursor.moveToNext());
        }
        cursor.close();
        adapter=new ArrayAdapter<String>(
                NotepadActivity.this,android.R.layout.simple_list_item_1,diary);
        listView=(ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);
    }



    private int getDiaryId(int position){
        //获取所点击的日记的title
        int Id;
        select_item=diary.get(position);
        //获取id
        db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query(DatabaseHelper.TABLE_NAME,new String[]{"id"},"title=?",
                new String[]{select_item},null,null,null);
        cursor.moveToFirst();
        Id=cursor.getInt(cursor.getColumnIndex("id"));
        return Id;
    }
}

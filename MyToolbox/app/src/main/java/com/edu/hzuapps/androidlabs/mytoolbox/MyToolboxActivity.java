package com.edu.hzuapps.androidlabs.mytoolbox;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.edu.hzuapps.androidlabs.mytoolbox.Module.AllModuleActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.EmojiModuleActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.Function.Settings;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.GameModuleActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.MediaModuleActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.ToolModuleActivity;
import com.edu.hzuapps.androidlabs.mytoolbox.Module.WallpaperModuleActivity;

public class MyToolboxActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    // 要申请的权限
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private AlertDialog dialog;

    private ImageView imageView0;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageButton imageButtun6;
    private ImageButton imageButtun7;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView0 = findViewById(R.id.nav_all);

        imageView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, AllModuleActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView1 = findViewById(R.id.nav_tool);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, ToolModuleActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView2 = findViewById(R.id.nav_wallpaper);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, WallpaperModuleActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView3 = findViewById(R.id.nav_emoji);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, EmojiModuleActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView4 = findViewById(R.id.nav_media);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, MediaModuleActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView5 = findViewById(R.id.nav_game);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyToolboxActivity.this, GameModuleActivity.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                // i.setType("text/plain"); //模拟器请使用这行
                i.setType("message/rfc822"); // 真机上使用这行
                i.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { "1792803325@qq.com" });
                i.putExtra(Intent.EXTRA_SUBJECT, "您的建议");
                i.putExtra(Intent.EXTRA_TEXT, "我们很希望能得到您的建议！！！");
                startActivity(Intent.createChooser(i,
                        "Select email application."));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




// 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // 检查该权限是否已经获取
            int i = ContextCompat.checkSelfPermission(this, permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                showDialogTipUserRequestPermission();
            }
        }
    }

    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermission() {

        new AlertDialog.Builder(this)
                .setTitle("存储权限不可用")
                .setMessage("由于MyToolbox需要获取存储空间，用于保存数据资料；\n否则，您将无法正常使用MyToolbox")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermission();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    // 开始提交请求权限
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321);
    }

    // 用户权限 申请 的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 321) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                    boolean b = shouldShowRequestPermissionRationale(permissions[0]);
                    if (!b) {
                        // 用户还是想用我的 APP 的
                        // 提示用户去应用设置界面手动开启权限
                        showDialogTipUserGoToAppSettting();
                    } else
                        finish();
                } else {
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // 提示用户去应用设置界面手动开启权限

    private void showDialogTipUserGoToAppSettting() {

        dialog = new AlertDialog.Builder(this)
                .setTitle("存储权限不可用")
                .setMessage("请在-应用设置-权限-中，允许MyToolbox使用存储权限来保存用户数据")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 跳转到应用设置界面
                        goToAppSetting();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    // 跳转到当前应用的设置界面
    private void goToAppSetting() {
        Intent intent = new Intent();

        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);

        startActivityForResult(intent, 123);
    }

    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 检查该权限是否已经获取
                int i = ContextCompat.checkSelfPermission(this, permissions[0]);
                // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
                if (i != PackageManager.PERMISSION_GRANTED) {
                    // 提示用户应该去应用设置界面手动开启权限
                    showDialogTipUserGoToAppSettting();
                } else {
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

                intent0.setClass(MyToolboxActivity.this, MyToolboxActivity.class);

                startActivity(intent0);

                /*MyToolboxActivity.this.finish();*/
                break;
            case R.id.nav_media:

                Intent intent1 = new Intent();

                intent1.setClass(MyToolboxActivity.this, MediaModuleActivity.class);

                startActivity(intent1);
                break;
            case R.id.nav_wallpaper:

                Intent intent2 = new Intent();

                intent2.setClass(MyToolboxActivity.this, WallpaperModuleActivity.class);

                startActivity(intent2);
                break;
            case R.id.nav_tool:

                Intent intent3 = new Intent();

                intent3.setClass(MyToolboxActivity.this, ToolModuleActivity.class);

                startActivity(intent3);
                break;
            case R.id.nav_emoji:

                Intent intent4 = new Intent();

                intent4.setClass(MyToolboxActivity.this, EmojiModuleActivity.class);

                startActivity(intent4);
                break;
            case R.id.nav_share:

                AlertDialog myDialog = new AlertDialog.Builder(this).create();
                myDialog.show();
                myDialog.getWindow().setContentView(R.layout.share);
                break;
            case R.id.nav_contact:
                AlertDialog myDialog02 = new AlertDialog.Builder(this).create();
                myDialog02.show();
                Window win = myDialog02.getWindow();
                myDialog02.getWindow().setContentView(R.layout.contact);
                ImageButton imageButtun20 =(ImageButton)win.findViewById(R.id.qq); ;
                ImageButton imageButtun21 =(ImageButton)win. findViewById(R.id.github);
                imageButtun20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://qm.qq.com/cgi-bin/qm/qr?k=s-tPu2nbSNQRZ9afvup812qODD0lH4Np");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                imageButtun21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://github.com/C-KIANG/Android-Mytest");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.nav_settings:

                Intent intent5 = new Intent();

                intent5.setClass(MyToolboxActivity.this, Settings.class);

                startActivity(intent5);
                break;
        }

        return true;
    }


}

package com.example.toolbaartest;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//android.support.design.widget.NavigationView
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    //private static final String TAG = "MainActivity-----------";
    private Picture[] picture = {new Picture("月之女祭司", R.drawable.baihu),
            new Picture("矮人直升机", R.drawable.feiji),
            new Picture("鱼人守卫", R.drawable.fish),
                    new Picture("秀逗魔导师", R.drawable.huonv),
                            new Picture("矮人火枪手", R.drawable.huoqiang),
                            new Picture("矮人火枪手", R.drawable.huoqiang2),
                            new Picture("剑圣", R.drawable.jugg),
                            new Picture("召唤师", R.drawable.kaer),
                            new Picture("半人猛犸", R.drawable.mengma),
                            new Picture("痛苦女王", R.drawable.qop),
                            new Picture("影魔", R.drawable.sf),
                            new Picture("神灵武士", R.drawable.shenling),
                            new Picture("水元素", R.drawable.shuiren),
                            new Picture("幽鬼", R.drawable.ug),
                            new Picture("黑暗游侠", R.drawable.xiaohei),
                            new Picture("地精工程师", R.drawable.zhadanren)};
    private List<Picture>pictureList=new ArrayList<>();
    private PicAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "数据删除", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Data restored",
                                        Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.arrowright);
            // Log.d(TAG,"-----------------------------");
        }
//        navigationView.setCheckedItem(R.id.nav_call);
//        navigationView.setNavigationItemSelectedListener
//                (new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                drawer.closeDrawers();
//                return true;
//            }
//        });
        initPicture();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new PicAdapter(pictureList);
        recyclerView.setAdapter(adapter);

        swipeRefresh= (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.
        OnRefreshListener(){
            @Override
            public void onRefresh() {
                refreshPic();
            }
        });
    }
    private void refreshPic(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initPicture();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initPicture() {
        pictureList.clear();
        for(int i=0;i<30;i++){
            Random random=new Random();
            int index=random.nextInt(picture.length);
            pictureList.add(picture[index]);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
        //android.support.design.widget.NavigationView
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "你点击了下Backup，但是此功能暂未更新哈哈...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "你点击了下Delete，但是此功能暂未更新哈哈...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "你点击了下Setting，但是此功能暂未更新哈哈...", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }
}

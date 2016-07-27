package zx.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import zx.myapplication.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    public void getData() {

    }

    @Override
    public void setView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(listener);
    }

    @Override
    public void onBackPressed() {
        //点击back键如果抽屉是打开得则关闭抽屉，否则结束这个Activity；
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            finish();
        }
    }
     //替换framlayout布局
    public void changFragemnt(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();

    }
    private NavigationView.OnNavigationItemSelectedListener listener=new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(MenuItem item) {
          switch (item.getItemId()){
              case R.id.github_hot_repo:
                  break;
              case R.id.github_hot_coder:
              break;
              case R.id.github_trend:
              break;
              case R.id.arsenal_my_repo:
              break;
              case R.id.arsenal_recommend:
              break;
              case R.id.tips_daily:
              break;
              case R.id.tips_share:
              break;
          }
          //是否将当前选中，改变为下次进入程序选中
          return false;
      }
  };
}

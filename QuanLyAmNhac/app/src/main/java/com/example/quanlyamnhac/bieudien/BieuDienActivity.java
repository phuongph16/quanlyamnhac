package com.example.quanlyamnhac.bieudien;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.quanlyamnhac.MainActivity;
import com.example.quanlyamnhac.R;
import com.example.quanlyamnhac.baihat.AddBaiHatFragment;
import com.example.quanlyamnhac.baihat.BaiHatActivity;
import com.example.quanlyamnhac.baihat.BaiHatFragment;
import com.example.quanlyamnhac.casi.CaSiActivity;
import com.google.android.material.navigation.NavigationView;

public class BieuDienActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    Button bieudien_back;
    Button bieudien_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieu_dien);

        bieudien_back = findViewById(R.id.bieudien_back);
        bieudien_fab = findViewById(R.id.bieudien_fab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navmenu);
        navigationView.setItemIconTintList(null);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();

        BieuDienFragment main = new BieuDienFragment();
        FragmentManager FragManager = getSupportFragmentManager();
        FragmentTransaction FragTrans = FragManager.beginTransaction();
        FragTrans.replace(R.id.bieudien_fragment, main);
        FragTrans.commit();

        setEvent();
    }

    private void setEvent() {
        bieudien_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBieuDienFragment fragment = new AddBieuDienFragment();
                FragmentManager FragManager = getSupportFragmentManager();
                FragmentTransaction FragTrans = FragManager.beginTransaction();
                FragTrans.replace(R.id.bieudien_fragment, fragment);
                FragTrans.commit();
                bieudien_fab.setEnabled(false);
                bieudien_back.setEnabled(true);
            }
        });

        bieudien_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BieuDienFragment main = new BieuDienFragment();
                FragmentManager FragManager = getSupportFragmentManager();
                FragmentTransaction FragTrans = FragManager.beginTransaction();
                FragTrans.replace(R.id.bieudien_fragment, main);
                FragTrans.commit();
                bieudien_fab.setEnabled(true);
                bieudien_back.setEnabled(false);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_baihat:
                Intent baihat = new Intent(BieuDienActivity.this, BaiHatActivity.class);
                baihat.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(baihat);
                break;
            case R.id.nav_bieudien:
                Intent bieudien = new Intent(BieuDienActivity.this, BieuDienActivity.class);
                bieudien.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(bieudien);
                break;
            case R.id.nav_nhacsi:
                Intent nhacsi = new Intent(BieuDienActivity.this, MainActivity.class);
                nhacsi.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(nhacsi);
                break;
            case R.id.nav_casi:
                Intent casi = new Intent(BieuDienActivity.this, CaSiActivity.class);
                casi.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(casi);
                break;
//            case R.id.nav_thongke:
//                Intent thongke = new Intent(BieuDienActivity.this, ThongKeActivity.class);
//                thongke.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(thongke);
//                break;
//            case R.id.nav_baocao:
//                Intent baocao = new Intent(BieuDienActivity.this, BaoCaoActivity.class);
//                baocao.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(baocao);
//                break;

        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
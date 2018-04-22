package com.wildan.coordinatorlayoutexample.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.wildan.coordinatorlayoutexample.R;
import com.wildan.coordinatorlayoutexample.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar
        setSupportActionBar(toolbar); // Memasang Toolbar pada Aplikasi

        //Menerapkan TabLayout dan ViewPager pada Activity
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        final ViewPager viewPager = findViewById(R.id.pager);

        //Memanggil dan Memasukan Value pada Class PagerAdapter(FragmentManager dan JumlahTab)
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Memasang Adapter pada ViewPager
        viewPager.setAdapter(pagerAdapter);

        /*
         Menambahkan Listener yang akan dipanggil kapan pun halaman berubah atau
         bergulir secara bertahap, sehingga posisi tab tetap singkron
         */
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Callback Interface dipanggil saat status pilihan tab berubah.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Dipanggil ketika tab memasuki state/keadaan yang dipilih.
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Dipanggil saat tab keluar dari keadaan yang dipilih.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Dipanggil ketika tab yang sudah dipilih, dipilih lagi oleh user.
            }
        });
    }

    //Code Program pada Method dibawah ini akan Berjalan saat Option Menu Dibuat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil/Memasang menu item pada toolbar dari layout menu_bar.xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Membuat event/kejadian saat salah satu item pada toolbar di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about :
                //Kode disini akan di eksekusi saat tombol about di klik
                Toast.makeText(this, "Developer By: Wildan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search :
                //Kode disini akan di eksekusi saat tombol search di klik
                Toast.makeText(this, "Cari Sesuatu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.essa10e.a31stapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);

        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mViewPager);

        // Set the images;
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_attachment_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_backup_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_comment_black_24dp);

        // taken from StackOverflow: to disable the animation at the bottom bar.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavViewHelper.disableShiftMode(bottomNavigationView);

        // We need to fix the icon highlight issue:
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        // Create a clickable icon for bottom nav. view bar:

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.ic_fullMoon :
                        Intent intent = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent);
                        break;
                    case R.id.ic_halfMoon :
                        Intent intent1 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_littleMoon :
                        Intent intent2 = new Intent(MainActivity.this, ActivityThree.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }

    public void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // add the fragments: Will inflate them automatically and it will be as in order we list them below:
        adapter.addFragment( new Tab1Fragment());
       // adapter.addFragment( new Tab2Fragment());
        adapter.addFragment( new Tab2CardView());

        adapter.addFragment( new Tab3Fragment());

        viewPager.setAdapter(adapter);
    }

    // Create this method so we can navigate from current frag. to another:
    public void setViewPager (int fragmentNum) {
        mViewPager.setCurrentItem(fragmentNum);
    }
}

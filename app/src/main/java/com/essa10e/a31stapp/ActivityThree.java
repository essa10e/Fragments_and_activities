package com.essa10e.a31stapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by essa10e on 8/7/17.
 */

public class ActivityThree extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        TextView title = (TextView)findViewById(R.id.activityTitle_3);
        title.setText("This is activity 3 :)");


        // taken from StackOverflow: to disable the animation at the bottom bar.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavViewHelper.disableShiftMode(bottomNavigationView);

        // We need to fix the icon highlight issue:
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        // Create a clickable icon for bottom nav. view bar:

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.ic_fullMoon :
                        Intent intent = new Intent(ActivityThree.this, ActivityOne.class);
                        startActivity(intent);
                        break;
                    case R.id.ic_halfMoon :
                        Intent intent1 = new Intent(ActivityThree.this, ActivityTwo.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_littleMoon :
//                        Intent intent2 = new Intent(MainActivity.this, ActivityThree.class);
//                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }
}

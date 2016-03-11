package com.imaginat.justhejist.jist.Activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.imaginat.justhejist.jist.R;
import com.imaginat.justhejist.jist.api.nyt.Section;
import com.imaginat.justhejist.jist.tabs.MyPageAdapter;

public class TabsActivity extends AppCompatActivity {
    Toolbar mToolbar;
    Window mWindow;
    String section = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(Section.getSections()[0]);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkerFrag1));
//        mToolbar.setTitle("Tab 1");

        mWindow = this.getWindow();
        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag1));


        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (String section : Section.getSections()) {
            tabLayout.addTab(tabLayout.newTab().setText(section));
        }
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkerFrag1));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final MyPageAdapter adapter = new MyPageAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        tabLayout.getTabAt(viewPager.getCurrentItem()).getText();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (viewPager.getCurrentItem()) {
                    case 6:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag1));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag1));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag1));
                        break;
                    case 7:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag2));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag2));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag2));
                        break;
                    case 8:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag3));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag3));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag3));
                        break;
                    case 9:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag4));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag4));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag4));
                        break;
                    case 10:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag5));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag5));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag5));
                        break;
                    case 0:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag6));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag6));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag6));
                        break;
                    case 1:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag7));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag7));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag7));
                        break;
                    case 2:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag8));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag8));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag8));
                        break;
                    case 3:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag9));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag9));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag9));
                        break;
                    case 4:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag10));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag10));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag10));
                        break;
                    case 5:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag11));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag11));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag11));
                        break;
                    case 11:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag12));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag12));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag12));
                        break;
                    case 12:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag13));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag13));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag13));
                        break;
                    case 13:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag14));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag14));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag14));
                        break;
                    case 14:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag15));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag15));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag15));
                        break;
                    case 15:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag16));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag16));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag16));
                        break;
                    case 16:
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag17));
                        mToolbar.setTitle(Section.getSections()[tab.getPosition()]);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkFrag17));
                        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkerFrag17));
                        break;
                    default:
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

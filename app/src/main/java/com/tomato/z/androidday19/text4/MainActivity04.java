package com.tomato.z.androidday19.text4;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tomato.z.androidday19.R;

public class MainActivity04 extends FragmentActivity {


    ViewPager viewpager;
    RadioGroup rg;

    public static final int  TAB_HOME=0;
    public static final int  TAB_CATACORY=1;
    public static final int  TAB_CAR=2;
    public static final int  TAB_BUY=3;
    public static final int  TAB_MORE=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);

        initView();
    }

    private void initView() {
        viewpager=(ViewPager)findViewById(R.id.viewpager);
        rg= (RadioGroup) findViewById(R.id.tab_group);

        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //radioGroup.
                RadioButton rb= (RadioButton) findViewById(i);
                switch(i){

                    case R.id.main_tab_home:
                        viewpager.setCurrentItem(TAB_HOME);
                        break;
                    case R.id.main_tab_catogory:
                        viewpager.setCurrentItem(TAB_CATACORY);
                        break;
                    case R.id.main_tab_buy:
                        viewpager.setCurrentItem(TAB_BUY);
                        break;
                    case R.id.main_tab_more:
                        viewpager.setCurrentItem(TAB_MORE);
                        break;
                    case R.id.main_tab_car:
                        viewpager.setCurrentItem(TAB_CAR);
                        break;

                }

            }
        });

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                  switch (position){
                      case TAB_HOME:
                          ((RadioButton)rg.getChildAt(TAB_HOME)).setChecked(true);
                          break;
                      case TAB_CATACORY:
                          ((RadioButton)rg.getChildAt(TAB_CATACORY)).setChecked(true);
                          break;
                      case TAB_BUY:
                          ((RadioButton)rg.getChildAt(TAB_BUY)).setChecked(true);
                          break;
                      case TAB_MORE:
                          ((RadioButton)rg.getChildAt(TAB_MORE)).setChecked(true);
                          break;
                      case TAB_CAR:
                          ((RadioButton)rg.getChildAt(TAB_CAR)).setChecked(true);
                          break;
                  }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

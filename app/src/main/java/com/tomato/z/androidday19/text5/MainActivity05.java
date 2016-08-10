package com.tomato.z.androidday19.text5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tomato.z.androidday19.R;

public class MainActivity05 extends FragmentActivity {

    RadioGroup rg;
    ViewPager pager;
    ImageView iv_indicator;
    HorizontalScrollView scorllView;

    LayoutInflater mInflater;
    int currentIndicatorLeft=0;


    int indicatorWidth;

    String[] titles={"标题一","标题二","标题三","标题四","标题五","标题六","标题七"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);

        initView();

    }

    private void initView() {

        pager= (ViewPager) findViewById(R.id.mViewPager);
        iv_indicator= (ImageView) findViewById(R.id.iv_nav_indicator);
        rg= (RadioGroup) findViewById(R.id.rg_nav_content);
        scorllView= (HorizontalScrollView) findViewById(R.id.scorllView);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        indicatorWidth=dm.widthPixels/4;
         ViewGroup.LayoutParams params=iv_indicator.getLayoutParams();
        params.width=  indicatorWidth;
        iv_indicator.setLayoutParams(params);
        //不滑动   响应不准确


        //布局填充器
        mInflater= (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        //初始化导航
        initNavTab();

        TabFragmentAdapter adapter=new TabFragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        setListener();

    }

    private void setListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                Log.i("被选中ID----------",i+"");
                if(rg.getChildAt(i)!=null){

                    RadioButton _rb=(RadioButton)rg.getChildAt(i);
                    TranslateAnimation animation=new TranslateAnimation(currentIndicatorLeft,_rb.getLeft(),0f,0f);
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setDuration(100);
                    animation.setFillAfter(true);
                    iv_indicator.startAnimation(animation);

                    pager.setCurrentItem(i);

                    //以下逻辑处理  滑动光标
                    //记录当前下标距最左测的距离
                    currentIndicatorLeft=_rb.getLeft();
                    int a=i>1?currentIndicatorLeft:0;
                    int b=((RadioButton)rg.getChildAt(2)).getLeft();
                    // 类似scrollTo
                    scorllView.smoothScrollTo(a-b,0);

                }




            }
        });

       pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当条件满足时，模拟人手点击
                // 模拟人手去触摸控件
                if(rg!=null && rg.getChildCount()>position){
                    ((RadioButton)rg.getChildAt(position)).performClick();
                }

                //获得到GroupButton ,checked

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initNavTab() {
        // radioGroup
        rg.removeAllViews();
        for(int i=0;i<titles.length;i++){
            RadioButton rb= (RadioButton) mInflater.inflate(R.layout.nav_radiobutton,null);
            rb.setId(i);
            rb.setText(titles[i]);
            rb.setLayoutParams(new ViewGroup.LayoutParams(indicatorWidth, ViewGroup.LayoutParams.MATCH_PARENT));
            rg.addView(rb);

        }
    }


    class TabFragmentAdapter  extends FragmentPagerAdapter {

        public TabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            CommonUIFragment fragment=new CommonUIFragment();
            Bundle bundle=new Bundle();

            bundle.putString("arg",titles[position]);
            fragment.setArguments(bundle);

            return fragment;
        }


        @Override
        public int getCount() {
            return 7;
        }
    }


}

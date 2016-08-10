package com.tomato.z.androidday19.text2;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.tomato.z.androidday19.R;

public class MainActivity02 extends FragmentActivity {

    private LayoutInflater layoutInflater;
    FragmentTabHost mTabHost;

    private Class fragmentArray[]={FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class,FragmentPage5.class};
    //定义 图片
    private int[] mIamgeViewArray={R.drawable.tab_home,R.drawable.tab_message,R.drawable.tab_selfinfo,R.drawable.tab_square,R.drawable.tab_more};
    // 定义 文字
    private String[] mTextViewArray ={"要闻","视频","河南","社会","NBA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        initView();
    }

    private void initView() {
        //实例化布局对象
        layoutInflater=LayoutInflater.from(this);
        mTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        //ViewGroup或其子类对象id,比如LinearLayout
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        //得到fragment的个数
        int count=fragmentArray.length;
        for(int i=0;i<count;i++){
            //为每个tab设置图标、文字。内容
            TabHost.TabSpec tabSpec=mTabHost.newTabSpec(mTextViewArray[i]);
            //setIndicator三种用法
            //只使用文字标识
            //tabSpec.setIndicator("aaa");
            //文字+图标 Drawable
            //tabSpec.setIndicator("aaa",图片);
            //使用自定义布局
            //文字，文字加图片，自定义
            tabSpec.setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec,fragmentArray[i],null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.home_btn_rb_bg);

        }
    }

    private View getTabItemView(int i) {
        View view=layoutInflater.inflate(R.layout.tab_item_view,null);
        ImageView iv= (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(mIamgeViewArray[i]);
        TextView tv= (TextView) view.findViewById(R.id.textView);
        tv.setText(mTextViewArray[i]);

        return view;
    }
}

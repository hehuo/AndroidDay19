package com.tomato.z.androidday19.text1;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tomato.z.androidday19.R;

import java.util.ArrayList;
import java.util.List;


//RadioGroup + Fragment  实现书签的效果
public class MainActivity01 extends FragmentActivity {

    RadioGroup rg;
    RadioButton rb;
    RadioButton[] rgs;
    List<Fragment> listFragment=new ArrayList<Fragment>();
    int currentTabIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        //RadioGroup + Fragment
        //初始化控件
        initView();
        //添加数据
        initData();
    }

    private void initData() {
        for(int i=0;i<rg.getChildCount();i++){
            //创建Fragment
            ShowFragment sf=ShowFragment.getInstance(i+1);

            listFragment.add(sf);
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,listFragment.get(0)).commit();
    }

    private void initView() {
        rg= (RadioGroup) findViewById(R.id.rg_main);
        String[] arrTabTitles=  getResources().getStringArray(R.array.arrTabTitle);
        rgs=new RadioButton[rg.getChildCount()];
        for(int i=0;i<rg.getChildCount();i++){
            RadioButton _rb=  (RadioButton) rg.getChildAt(i);
            _rb.setText(arrTabTitles[i]);
            rgs[i]=_rb;
         }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                for(int i=0;i<rg.getChildCount();i++){
                    if(rgs[i].getId()==checkedId){
                          //变换页面
                          switchFragment(i);
                    }
                }
            }
        });


    }

    // 利用hide和show可以大大节约加载碎片的性能消耗
    private void switchFragment(int targetTabIndex) {
        android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.push_right_enter,R.anim.push_left_exit);

        Fragment currentFragment=listFragment.get(currentTabIndex);
        Fragment targetFrament=listFragment.get(targetTabIndex);
        if(!targetFrament.isAdded()){
            transaction.hide(currentFragment).add(R.id.fl_container,targetFrament);
        }else{
            transaction.hide(currentFragment).show(targetFrament);
        }
        transaction.commit();
        currentTabIndex=targetTabIndex;

    }
}

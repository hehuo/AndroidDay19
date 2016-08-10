package com.tomato.z.androidday19.text4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/6/27.
 */
public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {

        switch(position){
            case MainActivity04.TAB_HOME:
                 return new HomeFragment();
                //break;
            case MainActivity04.TAB_CATACORY:
                return new CategoryFragment();
            case MainActivity04.TAB_BUY:
                return new BuyFragment();
            case MainActivity04.TAB_CAR:
                return new CarFragment();
            case MainActivity04.TAB_MORE:
                return new MoreFragment();

            default:
                return new MoreFragment();

        }
        //return new HomeFragment();

    }


    @Override
    public int getCount() {
        return 5;
    }
}

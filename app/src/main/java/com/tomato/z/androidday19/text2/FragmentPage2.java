package com.tomato.z.androidday19.text2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomato.z.androidday19.R;

/**
 * Created by Administrator on 2016/6/24.
 */
public class FragmentPage2 extends Fragment {

    private View rootView;//缓存View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        if(rootView ==null){
            rootView=inflater.inflate(R.layout.fragment_2,null);
        }

        /*ViewGroup parent= (ViewGroup) rootView.getParent();
        if(parent!=null){
            parent.removeView(rootView);
        }*/
       return rootView;

    }
}

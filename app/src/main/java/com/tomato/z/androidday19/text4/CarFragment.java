package com.tomato.z.androidday19.text4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomato.z.androidday19.R;

/**
 * Created by Administrator on 2016/6/27.
 */
public class CarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.car_layout,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}

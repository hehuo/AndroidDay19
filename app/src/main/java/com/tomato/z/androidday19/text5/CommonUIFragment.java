package com.tomato.z.androidday19.text5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tomato.z.androidday19.R;

/**
 * Created by Administrator on 2016/6/27.
 */
public class CommonUIFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


         View view=inflater.inflate(R.layout.fragment_ui,container,false);
                 Bundle bundle=getArguments();
       TextView view1= (TextView) view.findViewById(R.id.textContent);
        view1.setText(bundle.getString("arg"));
        return view;
    }
}

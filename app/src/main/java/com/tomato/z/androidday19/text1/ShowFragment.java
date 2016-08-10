package com.tomato.z.androidday19.text1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.tomato.z.androidday19.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ShowFragment extends ListFragment {


    //Fragment声明周期
    //onAttach()->onCreate->onCreateView()->onViewCreated()->
    //onActivityCreate()->onStart()->onResume()->onPause()->
    // onStop-> onDestroyView->onDestroy->onDetach

    int tabIndex;
    TextView tvInfo;
    List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
    public static ShowFragment getInstance(int tabIndex){
        ShowFragment showFragment=new ShowFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("tabIndex",tabIndex);
        showFragment.setArguments(bundle);
        return  showFragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvInfo.setText("您当前点击了第"+tabIndex+"个标签");


        // 数据 adapter
        SimpleAdapter adatper=new SimpleAdapter(getActivity(),mapList, R.layout.layout_item,new String[]{
                "icon","username","number"
        },new int[]{R.id.iv_icon,R.id.tv_name,R.id.tv_number});
        setListAdapter(adatper);
    }

    //初始化数据
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        tabIndex=bundle.getInt("tabIndex");
        //模拟从服务器上加载数据
        mapList=loadData();
    }

    private List<Map<String,Object>> loadData() {
        List<Map<String,Object>> mList=new ArrayList<Map<String,Object>>();
        for(int i=0;i<20;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("icon",R.mipmap.ic_launcher);
            map.put("username","username"+tabIndex+" "+i);
            map.put("number","1367339"+tabIndex+" "+ i);
            mList.add(map);
        }

        return  mList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_view,container,false);
        tvInfo= (TextView) view.findViewById(R.id.tv_index);
        return view;

    }
}

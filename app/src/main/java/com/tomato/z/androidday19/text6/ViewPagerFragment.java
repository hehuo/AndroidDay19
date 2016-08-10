package com.tomato.z.androidday19.text6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tomato.z.androidday19.R;

/**  
 * 
 */
@SuppressLint("ValidFragment")
public class ViewPagerFragment extends Fragment{

	private String   text;  
    private TextView tv = null;  
  
    @SuppressLint("ValidFragment")
	public ViewPagerFragment(String text){  
        super();  
        this.text = text;  
    }  
  
    /** 
     * 覆盖此函数，先通过inflater inflate函数得到view最后返回 
     */  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        
    	View v = inflater.inflate(R.layout.view_pager_fragment_demo1, container, false);
        tv = (TextView)v.findViewById(R.id.viewPagerText);  
        tv.setText(text);  
        return v;  
    }
}

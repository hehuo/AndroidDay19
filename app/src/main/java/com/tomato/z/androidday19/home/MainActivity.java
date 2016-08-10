package com.tomato.z.androidday19.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tomato.z.androidday19.R;
import com.tomato.z.androidday19.text1.MainActivity01;
import com.tomato.z.androidday19.text2.MainActivity02;
import com.tomato.z.androidday19.text3.MainActivity03;
import com.tomato.z.androidday19.text4.MainActivity04;
import com.tomato.z.androidday19.text5.MainActivity05;
import com.tomato.z.androidday19.text6.MainActivity07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    ArrayAdapter<String> adapter;
    List<String> data=new ArrayList<String>(
            Arrays.asList(
                    "RadioGroup+Fragment",
                    "FragmentActivity+FragmentTabHost",
                    "ViewPageIndicator",
                    "Fragment+RadioGroup+ViewPager",
                    "Fragment+ViewPager+HorizontalScrollView",
                    "Fragment+ViewPager+PagerTabStrp"

                    )
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.id_listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=null;
                switch (position){
                    case 0:
                        intent=new Intent(MainActivity.this,MainActivity01.class);
                        break;
                    case 1:
                        intent=new Intent(MainActivity.this,MainActivity02.class);
                        break;
                    case 2:
                        intent=new Intent(MainActivity.this,MainActivity03.class);
                        break;
                    case 3:
                        intent=new Intent(MainActivity.this,MainActivity04.class);
                        break;
                    case 4:
                        intent=new Intent(MainActivity.this,MainActivity05.class);
                        break;
                    case 5:
                        intent=new Intent(MainActivity.this,MainActivity07.class);
                        break;

                }

                startActivity(intent);
            }
        });

    }
}

package com.homer.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private Find_hotRecommendFragment hotRecommendFragment;              //热门推荐fragment
    private Find_hotCollectionFragment hotCollectionFragment;            //热门收藏fragment
//    private Find_hotMonthFragment hotMonthFragment;                      //本月热榜fragment
//    private Find_hotToday hotToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    /**
     * 初始化各控件
     *
     */
    private void initControls() {

        tab_FindFragment_title = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        hotRecommendFragment = new Find_hotRecommendFragment();
        hotCollectionFragment = new Find_hotCollectionFragment();
//        hotMonthFragment = new Find_hotMonthFragment();
//        hotToday = new Find_hotToday();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
//        list_fragment.add(hotRecommendFragment);
//        list_fragment.add(hotRecommendFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
//        list_title.add("本月热榜");
//        list_title.add("今日热榜");

        //设置TabLayout的模式
//        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        tab_FindFragment_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));

        fAdapter = new Find_tab_Adapter(getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }
}

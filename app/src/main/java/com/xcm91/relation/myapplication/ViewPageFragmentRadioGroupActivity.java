package com.xcm91.relation.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xcm91.relation.myapplication.fragment.FourFragment;
import com.xcm91.relation.myapplication.fragment.OneFragment;
import com.xcm91.relation.myapplication.fragment.ThreeFragment;
import com.xcm91.relation.myapplication.fragment.TwoFragment;
import com.xcm91.relation.myapplication.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 *每次fragment切换调用 懒加载的 lazyLoad
 */
public class ViewPageFragmentRadioGroupActivity extends BaseActivty implements OneFragment.OnFragmentInteractionListener{
    private RadioGroup group;
    private NoScrollViewPager viewpagercontainer;
    private android.widget.LinearLayout llmaincontent;
    private OneFragment mOneFragment;
    private TwoFragment mTwoFragment;
    private ThreeFragment mFragmentThree;
    private FourFragment mFragmentFour;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentAdapter homePageFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_fragment_group);
        this.viewpagercontainer = (NoScrollViewPager) findViewById(R.id.viewpager_container);
        this.llmaincontent = (LinearLayout) findViewById(R.id.ll_main_content);
        group = (RadioGroup) findViewById(R.id.group);

        mOneFragment = new OneFragment();
        mTwoFragment = new TwoFragment();
        mFragmentThree = new ThreeFragment();
        mFragmentFour = new FourFragment();
        mFragmentList.add(mOneFragment);
        mFragmentList.add(mTwoFragment);
        mFragmentList.add(mFragmentThree);
        mFragmentList.add(mFragmentFour);
        homePageFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragmentList);
        //决定初始化的时候加载fragment的个数 viewpager是默认预加载下一页的界面的。viewpager提供了一个设置预加载页面数量的方法，
        // 那就是setOffscreenPageLimit()。默认不设置数量的情况下预加载下一页
        viewpagercontainer.setOffscreenPageLimit(2);
        viewpagercontainer.setAdapter(homePageFragmentAdapter);
       //是否能滑动适合少量fragment
        viewpagercontainer.setScroll(true);

        viewpagercontainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        group.check(R.id.foot_bar_home);
                        break;
                    case 1:
                        group.check(R.id.foot_bar_im);
                        break;
                    case 2:
                        group.check(R.id.foot_bar_trading);
                        break;
                    case 3:
                        group.check(R.id.main_footbar_user);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.foot_bar_home:
                        viewpagercontainer.setCurrentItem(0, false);
                        break;
                    case R.id.foot_bar_im:
                        viewpagercontainer.setCurrentItem(1, false);
                        break;
                    case R.id.foot_bar_trading:
                        viewpagercontainer.setCurrentItem(2, false);
                        break;
                    case R.id.main_footbar_user:
                        viewpagercontainer.setCurrentItem(3, false);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    public void onFragmentInteraction(int type) {
        Toast.makeText(this, "触发：" + type, Toast.LENGTH_LONG).show();
    }
}

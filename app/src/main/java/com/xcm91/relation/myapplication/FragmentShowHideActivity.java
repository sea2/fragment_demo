package com.xcm91.relation.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.xcm91.relation.myapplication.fragment.FourFragment;
import com.xcm91.relation.myapplication.fragment.OneFragment;
import com.xcm91.relation.myapplication.fragment.ThreeFragment;
import com.xcm91.relation.myapplication.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 每次fragment切换调用 onHiddenChanged
 */
public class FragmentShowHideActivity extends BaseActivty {

    private android.widget.FrameLayout flcontent;
    private android.widget.LinearLayout llmaincontent;
    private RadioGroup group;
    private OneFragment mOneFragment;
    private TwoFragment mTwoFragment;
    private ThreeFragment mFragmentThree;
    private FourFragment mFragmentFour;
    private List<Fragment> mFragmentList = new ArrayList<>();
    String ONE_FRAGMENT_KEY = "one_fragment__key";
    String TWO_FRAGMENT_KEY = "two__fragment_key";
    String THREE_FRAGMENT_KEY = "three__fragment_key";
    String FOUR_FRAGMENT_KEY = "four__fragment_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_show_hide);
        this.llmaincontent = (LinearLayout) findViewById(R.id.ll_main_content);
        this.flcontent = (FrameLayout) findViewById(R.id.fl_content);
        group = (RadioGroup) findViewById(R.id.group);


        if (savedInstanceState != null) {
            *//*获取保存的fragment  没有的话返回null*//*
            mOneFragment = (OneFragment) getSupportFragmentManager().getFragment(savedInstanceState, ONE_FRAGMENT_KEY);
            mTwoFragment = (TwoFragment) getSupportFragmentManager().getFragment(savedInstanceState, TWO_FRAGMENT_KEY);
            mFragmentThree = (ThreeFragment) getSupportFragmentManager().getFragment(savedInstanceState, THREE_FRAGMENT_KEY);
            mFragmentFour = (FourFragment) getSupportFragmentManager().getFragment(savedInstanceState, FOUR_FRAGMENT_KEY);
        }
        if (mOneFragment == null) mOneFragment = new OneFragment();
        if (mTwoFragment == null) mTwoFragment = new TwoFragment();
        if (mFragmentThree == null) mFragmentThree = new ThreeFragment();
        if (mFragmentFour == null) mFragmentFour = new FourFragment();
        mFragmentList.add(mOneFragment);
        mFragmentList.add(mTwoFragment);
        mFragmentList.add(mFragmentThree);
        mFragmentList.add(mFragmentFour);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.foot_bar_home:
                        setPageFragment(1);
                        break;
                    case R.id.foot_bar_im:
                        setPageFragment(2);
                        break;
                    case R.id.foot_bar_trading:
                        setPageFragment(3);
                        break;
                    case R.id.main_footbar_user:
                        setPageFragment(4);
                        break;
                    default:
                        break;
                }
            }
        });

        setPageFragment(1);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /*fragment不为空时 保存*/
        if (mOneFragment != null) {
            getSupportFragmentManager().putFragment(outState, ONE_FRAGMENT_KEY, mOneFragment);
        }
        if (mTwoFragment != null) {
            getSupportFragmentManager().putFragment(outState, TWO_FRAGMENT_KEY, mTwoFragment);
        }
        if (mFragmentThree != null) {
            getSupportFragmentManager().putFragment(outState, THREE_FRAGMENT_KEY, mFragmentThree);
        }
        if (mFragmentFour != null) {
            getSupportFragmentManager().putFragment(outState, FOUR_FRAGMENT_KEY, mFragmentFour);
        }

        super.onSaveInstanceState(outState);
    }


    private void setPageFragment(int page) {
        int sizePage = mFragmentList.size();
        if (page <= sizePage && page > 0) {
            addOrShowFragment(mFragmentList.get(page - 1), R.id.fl_content, String.valueOf(page));
            for (int i = 1; i <= sizePage; i++) {
                if (i != page) {
                    hideFragment(mFragmentList.get(i - 1));
                }
            }
        }
    }


}

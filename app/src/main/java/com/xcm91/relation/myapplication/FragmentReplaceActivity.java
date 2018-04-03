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

public class FragmentReplaceActivity extends BaseActivty {

    private android.widget.FrameLayout flcontent;
    private android.widget.LinearLayout llmaincontent;
    private RadioGroup group;
    private OneFragment mOneFragment;
    private TwoFragment mTwoFragment;
    private ThreeFragment mFragmentThree;
    private FourFragment mFragmentFour;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_show_hide);
        this.llmaincontent = (LinearLayout) findViewById(R.id.ll_main_content);
        this.flcontent = (FrameLayout) findViewById(R.id.fl_content);
        group = (RadioGroup) findViewById(R.id.group);

        mOneFragment = new OneFragment();
        mTwoFragment = new TwoFragment();
        mFragmentThree = new ThreeFragment();
        mFragmentFour = new FourFragment();
        mFragmentList.add(mOneFragment);
        mFragmentList.add(mTwoFragment);
        mFragmentList.add(mFragmentThree);
        mFragmentList.add(mFragmentFour);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.foot_bar_home:
                       replaceFragment(R.id.fl_content,mOneFragment);
                        break;
                    case R.id.foot_bar_im:
                        replaceFragment(R.id.fl_content,mTwoFragment);
                        break;
                    case R.id.foot_bar_trading:
                        replaceFragment(R.id.fl_content,mFragmentThree);
                        break;
                    case R.id.main_footbar_user:
                        replaceFragment(R.id.fl_content,mFragmentFour);
                        break;
                    default:
                        break;
                }
            }
        });

        replaceFragment(R.id.fl_content,mOneFragment);

    }


}

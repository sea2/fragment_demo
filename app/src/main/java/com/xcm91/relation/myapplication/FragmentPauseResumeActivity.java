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
 *每次fragment切换调用 onHiddenChanged,和pause,resume
 */
public class FragmentPauseResumeActivity

        extends BaseActivty {

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
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, mFragmentList, R.id.fl_content, group);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener() {
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
                switch (checkedId) {
                    case 1:
                        break;
                }
            }
        });
    }


}

package com.xcm91.relation.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by lhy on 2017/8/30.
 */

public abstract class BaseActivty extends FragmentActivity {


    /**
     * 增加fragment
     *
     * @param fragment
     * @param res
     */
    public void addOrShowFragment(int res, Fragment fragment, String fragmentTag) {
        if (fragment != null) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //动画
            //  fragmentTransaction.setCustomAnimations(R.anim.activity_translate_right_into, R.anim.activity_translate_right_out);
            if (!fragment.isAdded()) {
                fragmentTransaction.add(res, fragment, fragmentTag);
                fragmentTransaction.addToBackStack(fragmentTag);
            } else {
                fragmentTransaction.show(fragment);
            }
            fragmentTransaction.commit();
        }
    }


    /**
     * 替换 Fragment
     *
     * @param containerViewId
     * @param fragment
     */
    protected void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * 替换 Fragment
     *
     * @param containerViewId
     * @param fragment
     */
    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            // 设置tag
            fragmentTransaction.replace(containerViewId, fragment, tag);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            // 这里要设置tag，上面也要设置tag
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        } else {
            // 存在则弹出在它上面的所有fragment，并显示对应fragment
            getSupportFragmentManager().popBackStack(tag, 0);
        }
    }


    /**
     * 增加fragment
     *
     * @param fragment
     * @param res
     */
    public void addOrShowFragment(Fragment fragment, int res, String fragmentTag) {
        if (fragment != null) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.setCustomAnimations(R.anim.activity_translate_right_into, R.anim.activity_translate_right_out);
            if (!fragment.isAdded()) {
                fragmentTransaction.add(res, fragment, fragmentTag);
            } else {
                fragmentTransaction.show(fragment);
            }
            fragmentTransaction.commit();
        }
    }

    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    public void hideFragment(Fragment fragment) {
        Log.e("hideFragment", fragment.isAdded() + "--" + fragment.isHidden());
        if (fragment != null && fragment.isAdded() && (!fragment.isHidden())) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.hide(fragment);
            ft.commit();
        }
    }


}

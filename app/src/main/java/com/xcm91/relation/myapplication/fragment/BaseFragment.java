package com.xcm91.relation.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lhy on 2017/8/31.
 */

public abstract class BaseFragment extends LazyFragment {
    protected String tag = this.getClass().getSimpleName();
    protected View rootView = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(tag, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(tag, "onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(tag, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(tag, "onActivityCreated");

    }

    @Override
    public void onStart() {
        Log.i(tag, "onStart");
        super.onStart();
    }


    @Override
    public void onResume() {
        Log.i(tag, "onResume");
        super.onResume();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(tag, "setUserVisibleHint" + isVisibleToUser);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i(tag, "onHiddenChanged" + hidden);
        super.onHiddenChanged(hidden);
    }


    @Override
    public void onPause() {
        Log.i(tag, "onPause");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(tag, "onSaveInstanceState"+outState);

    }

    @Override
    public void onStop() {
        Log.i(tag, "onStop");
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        Log.i(tag, "onDestroyView");
        if (rootView != null && rootView.getParent() != null)
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        Log.i(tag, "onDestroy");
        super.onDestroy();
    }


    @Override
    public void onDetach() {
        Log.i(tag, "onDetach");
        super.onDetach();
    }


}

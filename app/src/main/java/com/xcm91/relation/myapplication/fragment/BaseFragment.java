package com.xcm91.relation.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
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
    String tag = this.getClass().getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(tag, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(tag,  "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(tag, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(tag, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
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
        Log.i(tag, "setUserVisibleHint"+isVisibleToUser);
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
    public void onStop() {
        Log.i(tag, "onStop");
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        Log.i(tag, "onDestroyView");
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

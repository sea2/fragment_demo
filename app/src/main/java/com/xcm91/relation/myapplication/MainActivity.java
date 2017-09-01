package com.xcm91.relation.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends BaseActivty {

    private android.widget.FrameLayout flcontainer;
    private OnActivityListener mOnActivityListener;
    private Button btnstart1;
    private Button btnstart2;
    private Button btnstart3;
    private Button btnstart4;

    /**
     * 总结了几种fragment加载方式，目前来说viewpage消耗最小，比较合适
     * replace适合取代类型的，其他的显隐自己根据需求使用
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnstart4 = (Button) findViewById(R.id.btn_start4);
        this.btnstart3 = (Button) findViewById(R.id.btn_start3);
        this.btnstart2 = (Button) findViewById(R.id.btn_start2);
        this.btnstart1 = (Button) findViewById(R.id.btn_start1);
        this.flcontainer = (FrameLayout) findViewById(R.id.fl_container);


        btnstart1.setOnClickListener(view -> {
            Intent it = new Intent(MainActivity.this, ViewPageFragmentRadioGroupActivity.class);
            startActivity(it);
        });
        btnstart2.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, FragmentShowHideActivity.class);
            startActivity(it);
        });
        btnstart3.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, FragmentPauseResumeActivity.class);
            startActivity(it);
        });
        btnstart4.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, FragmentReplaceActivity.class);
            startActivity(it);
        });


    }


    public interface OnActivityListener {
        // TODO: Update argument type and name
        void OnActivityListener(int type);
    }


    public void setOnActivityListener(OnActivityListener mOnActivityListener) {
        this.mOnActivityListener = mOnActivityListener;
    }


}

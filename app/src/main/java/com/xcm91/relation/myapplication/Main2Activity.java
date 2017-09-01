package com.xcm91.relation.myapplication;

import android.os.Bundle;

public class Main2Activity extends BaseActivty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.push_up_in,0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.push_up_out);

    }
}

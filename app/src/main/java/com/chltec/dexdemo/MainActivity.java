package com.chltec.dexdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "Client-MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_install).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_install:
                openOtherApkActivity();
                break;
        }
    }

    private void openOtherApkActivity() {
        //宿主的activity，通过宿主activity来打开未安装的apk
        Intent intent = new Intent(this, ProxyActivity.class);
        intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/DynamicLoadHost/plugin.apk");
        startActivity(intent);
    }
}

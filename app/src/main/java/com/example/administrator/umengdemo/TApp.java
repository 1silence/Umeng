package com.example.administrator.umengdemo;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Administrator on 2018/2/28.
 */

public class TApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "5a9653f6a40fa35c0c000128", "umeng_demo", UMConfigure.DEVICE_TYPE_PHONE, "e8edbf9d1d9ceb22b64f5ad80ded67ec");
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("deviceToken", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }


}

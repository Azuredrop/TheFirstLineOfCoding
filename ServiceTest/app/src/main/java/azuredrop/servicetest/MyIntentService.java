package azuredrop.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/5/5.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MYINTENTSERVICE";
    
    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: " +Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}

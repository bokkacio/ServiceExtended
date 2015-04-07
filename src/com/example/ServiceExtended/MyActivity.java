package com.example.ServiceExtended;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import de.greenrobot.event.EventBus;

public class MyActivity extends Activity {
    final String LOG_TAG = "myLogs";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    //Called after onCreate(Bundle) — or after onRestart() when the activity had been stopped, but is now again being displayed to the user. It will be followed by onResume().
    @Override
    public void onStart() {
        startService(new Intent(this, FileService.class));
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        stopService(new Intent(this, FileService.class));
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    // Called in Android UI's main thread
    //MainThread: Subscriber will be called in Android's main thread (sometimes referred to as UI thread). If the posting thread is the main thread, event handler methods will be called directly. Event handlers using this mode must return quickly to avoid blocking the main thread.
    public void onEventMainThread(MessageEvent event){
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }

    public void saveFile(View v) {
        EventBus.getDefault().post(new AddFileEvent("test.txt", null));
    }
}

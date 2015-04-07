package com.example.ServiceExtended;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import de.greenrobot.event.EventBus;

/**
 * Created by sanea on 06.04.15.
 */
public class FileService extends Service {
    final String LOG_TAG = "myLogs";

    //Called by the system when the service is first created.
    public void onCreate() {
        super .onCreate();
        EventBus.getDefault().register(this);
        Log.d(LOG_TAG, "FileService onCreate");
    }

    //Called by the system to notify a Service that it is no longer used and is being removed.
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Log.d(LOG_TAG, "FileService onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Called in the background thread
    //BackgroundThread: Subscriber will be called in a background thread. If posting thread is not the main thread, event handler methods will be called directly in the posting thread. If the posting thread is the main thread, EventBus uses a single background thread that will deliver all its events sequentially. Event handlers using this mode should try to return quickly to avoid blocking the background thread.
    public void onEventBackgroundThread(AddFileEvent event){
        Log.d(LOG_TAG, String.format("FileService saveToDisk BackgroundThread. File: %s", event._fileName));
        EventBus.getDefault().post(new MessageEvent(String.format("Message after FileService saveToDisk BackgroundThread! File: %s", event._fileName)));
    }
}

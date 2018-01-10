package com.example.clover.introtoandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * When you create a service, be sure to add it to the AndroidManifest or it will not work
 */

public class MyService extends Service {
  /**
      This is invoked when another component wants to bind with your service.
      This interface must always be implemented, but if you don't want to allow binding, you should return null
   */
  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }


  /**
      This is invoked when another component (in our case the ServicesActivity) requests that the service be started
      When executed, the service is started and can run in the background indefinitely
      You are responsible for stopping the service when the work is complete
          This can be done by calling stopSelf() or stopService()
   */
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    // Let it continue running until it is stopped.
    Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
    return START_STICKY;
  }


  /**
      This is invoked when the service is no longer used and is being destroyed.
      This should be implemented to clean up any resources
      This is the last call that the service receives
   */
  @Override
  public void onDestroy() {
    super.onDestroy();
    Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
  }
}

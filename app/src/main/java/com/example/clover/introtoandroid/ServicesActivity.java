package com.example.clover.introtoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by rachel.antion on 12/18/17.
 */

public class ServicesActivity extends Activity {

  Button startService, stopService;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_services);

    startService = (Button) findViewById(R.id.StartServiceButton);
    stopService = (Button) findViewById(R.id.StopServiceButton);

    startService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startService(view);
      }
    });

    stopService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        stopService(view);
      }
    });

  }
 // Method to start the service
  public void startService(View view) {
    startService(new Intent(getBaseContext(), MyService.class));
  }

  // Method to stop the service
  public void stopService(View view) {
    stopService(new Intent(getBaseContext(), MyService.class));
  }


}

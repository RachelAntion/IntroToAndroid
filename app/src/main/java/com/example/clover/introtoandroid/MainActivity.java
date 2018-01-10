package com.example.clover.introtoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button listFragmentActivityButton, fragmentActivity, servicesActivityButton, implicitIntentActivityButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /**
     *
       this is where we are setting the layout file that corresponds with the activity
       you should include "Activity" at the end of all Activity classes
       typically the layout name is prefaced with the type (activity/fragment) followed by underscore and the class name
    */
    setContentView(R.layout.activity_main);

    fragmentActivity = (Button) findViewById(R.id.FragmentActivityButton);
    listFragmentActivityButton = (Button) findViewById(R.id.ListFragmentActivityButton);
    servicesActivityButton = (Button) findViewById(R.id.ServicesActivityButton);
    implicitIntentActivityButton = (Button) findViewById(R.id.ImplicitIntentActivity);

    /**
    There are two different ways to handle clicks
      1)With an OnClickListener
          This waits for the button to be clicked
          This can be better for more complex projects because it separates the action/behavior of the click event from the view
      2)Is by implementing onClick: in the layout xml
           Simple, No need to implement an interface
           ex. to use onClick in this instance I would just need to add
                  android:onClick="showFragmentActivity" to the FragmentActivityButton xml
          * to see an example of onClick, please look at FragmentActivity and activity_fragment
      Both function and perform in the same way
   */
    fragmentActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showFragmentActivity(view);
      }
    });
    listFragmentActivityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showListFragmentActivity(view);
      }
    });
    servicesActivityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showServicesActivity(view);
      }
    });
    implicitIntentActivityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showImplicitIntentActivity(view);
      }
    });
  }


  /**
      These are simple examples of using an explicit intents to switch to another activity
      1) We create a new intent explicitly using the Fragment/ListFragment/Services Activity classes
      2) we call startActivity() and pass it our new intent

      ** Something else to note, when you create a new Activity, make sure you add it to the AndroidManifest
   */
  public void showFragmentActivity(View view){
    Intent intent = new Intent(this, FragmentActivity.class);
    startActivity(intent);
  }

  public void showListFragmentActivity(View view){
    Intent intent = new Intent(this, ListFragmentActivity.class);
    startActivity(intent);
  }

  public void showServicesActivity(View view){
    Intent intent = new Intent(this, ServicesActivity.class);
    startActivity(intent);
  }

  public void showImplicitIntentActivity(View view){
    Intent intent = new Intent(this, ImplicitIntentActivity.class);
    startActivity(intent);
  }



}

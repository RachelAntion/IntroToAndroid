package com.example.clover.introtoandroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rachel.antion on 12/18/17.
 */

public class FragmentActivity  extends android.support.v4.app.FragmentActivity{

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment);

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    Fragment1 home = Fragment1.newInstance();
    fragmentTransaction.add(R.id.Fragment, home, "FRAGMENT_1");
    fragmentTransaction.commit();
  }

  /**
      These methods will be called via onClick set in the activity_fragment XML
      To see the OnClickListener way to handle clicks check out MainActivity
   */
  public void showFragment1(View view){
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    hideFragments(fragmentManager, fragmentTransaction);

    Fragment fragment = fragmentManager.findFragmentByTag("FRAGMENT_1");
    if (fragment == null) {
      fragment = Fragment1.newInstance();
      fragmentTransaction.add(R.id.Fragment, fragment, "FRAGMENT_1");
    } else {
      fragmentTransaction.show(fragment);
    }
    // adding to the back stack allows you to use the back button to navigate back through your fragment selection
    fragmentTransaction.addToBackStack("FRAGMENT_1");
    fragmentTransaction.commitAllowingStateLoss();
  }

  public void showFragment2(View view){
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    hideFragments(fragmentManager, fragmentTransaction);

    Fragment fragment = fragmentManager.findFragmentByTag("FRAGMENT_2");
    if (fragment == null) {
      fragment = Fragment2.newInstance();
      fragmentTransaction.add(R.id.Fragment, fragment, "FRAGMENT_2");
    } else {
      fragmentTransaction.show(fragment);
    }
    // adding to the back stack allows you to use the back button to navigate back through your fragment selection
    fragmentTransaction.addToBackStack("FRAGMENT_2");
    fragmentTransaction.commitAllowingStateLoss();
  }

  public void showFragment3(View view){
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    hideFragments(fragmentManager, fragmentTransaction);

    Fragment fragment = fragmentManager.findFragmentByTag("FRAGMENT_3");
    if (fragment == null) {
      fragment = Fragment3.newInstance();
      fragmentTransaction.add(R.id.Fragment, fragment, "FRAGMENT_3");
    } else {
      fragmentTransaction.show(fragment);
    }
    // adding to the back stack allows you to use the back button to navigate back through your fragment selection
    fragmentTransaction.addToBackStack("FRAGMENT_3");
    fragmentTransaction.commitAllowingStateLoss();
  }

  public void showFragment4(View view){
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    hideFragments(fragmentManager, fragmentTransaction);

    Fragment fragment = fragmentManager.findFragmentByTag("FRAGMENT_4");
    if (fragment == null) {
      fragment = Fragment4.newInstance();
      fragmentTransaction.add(R.id.Fragment, fragment, "FRAGMENT_4");
    } else {
      fragmentTransaction.show(fragment);
    }
    // adding to the back stack allows you to use the back button to navigate back through your fragment selection
    fragmentTransaction.addToBackStack("FRAGMENT_4");
    fragmentTransaction.commitAllowingStateLoss();
  }

  // this will hide all the fragments so that there are no rendering issues when attempting to view a new one
  private void hideFragments(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
    Fragment fragment = fragmentManager.findFragmentByTag("FRAGMENT_1");
    if (fragment != null) {
      fragmentTransaction.hide(fragment);
    }
    fragment = fragmentManager.findFragmentByTag("FRAGMENT_2");
    if (fragment != null) {
      fragmentTransaction.hide(fragment);
    }
    fragment = fragmentManager.findFragmentByTag("FRAGMENT_3");
    if (fragment != null) {
      fragmentTransaction.hide(fragment);
    }
    fragment = fragmentManager.findFragmentByTag("FRAGMENT_4");
    if (fragment != null) {
      fragmentTransaction.hide(fragment);
    }

  }
}

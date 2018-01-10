package com.example.clover.introtoandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rachel.antion on 12/18/17.
 */

public class Fragment4 extends Fragment{

  private View view;

  public static Fragment4 newInstance(){
    Fragment4 fragment = new Fragment4();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  public Fragment4(){

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.fragment_4, container, false);
    return view;
  }
}

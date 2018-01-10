package com.example.clover.introtoandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.clover.introtoandroid.models.SimpleItem;

/**
 * Created by rachel.antion on 12/18/17.
 */

public class Fragment1 extends Fragment {
  private View view;

  public static Fragment1 newInstance(){
    Fragment1 fragment = new Fragment1();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  public Fragment1(){

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.fragment_1, container, false);
    return view;
  }
}

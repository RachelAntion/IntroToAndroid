package com.example.clover.introtoandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.clover.introtoandroid.adapters.SimpleItemAdapter;
import com.example.clover.introtoandroid.models.SimpleItem;

/**
 * Created by rachel.antion on 12/15/17.
 */

public class ViewItemFragment extends Fragment {

  private View view;
  private SimpleItem item;
  private TextView title, description;

  public static ViewItemFragment newInstance(SimpleItem simpleItem){
    ViewItemFragment fragment = new ViewItemFragment();
    fragment.setItem(simpleItem);
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  public ViewItemFragment(){

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.fragment_view_item, container, false);

    title = (TextView) view.findViewById(R.id.ViewItemTitle);
    description = (TextView) view.findViewById(R.id.ViewItemDescription);


    if(item != null){
      title.setText(item.getTitle());
      description.setText(item.getDescription());
    }

    return view;
  }

  public void setItem(SimpleItem item) {
    this.item = item;
  }
}

package com.example.clover.introtoandroid;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.clover.introtoandroid.adapters.SimpleItemAdapter;
import com.example.clover.introtoandroid.models.SimpleItem;

import java.util.List;

/**
 * Created by rachel.antion on 12/15/17.
 */

public class SelectItemFragment extends Fragment {

  private View view;
  private List<SimpleItem> items;
  private ListView fragmentListView;
  private OnItemSelectedListener mListener;
  public static SelectItemFragment newInstance(List<SimpleItem> items){
    SelectItemFragment fragment = new SelectItemFragment();
    fragment.setItems(items);
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  public SelectItemFragment(){

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.fragment_select_item, container, false);
    fragmentListView = (ListView) view.findViewById(R.id.FragmentItemListView);
    // this constrains the user to choosing only one option, and then the selector sets the background of the selected item
    fragmentListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    fragmentListView.setSelector(android.R.color.holo_purple);
    /*
      Define a new Adapter
           parameters(Context, Layout to populate, array of data)
      Add adapter to ListView
    */
    SimpleItemAdapter simpleItemAdapter = new SimpleItemAdapter(view.getContext(), R.id.FragmentItemListView, items);
    fragmentListView.setAdapter(simpleItemAdapter);
    fragmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        SimpleItem simpleItem = (SimpleItem) fragmentListView.getItemAtPosition(position);
        mListener.onItemSelected(simpleItem, position);
      }
    });

    return view;
  }

  public List<SimpleItem> getItems() {
    return items;
  }

  public void setItems(List<SimpleItem> items) {
    this.items = items;
  }

  /**
   * Here we are defining a callback interface
   * ListFragmentActivity must implement this if it wants to respond to an ItemSelect event
   */
  public interface OnItemSelectedListener {
    public void onItemSelected(SimpleItem simpleItem, int position);
  }

  /**
   *  onAttach will be called by the system when the fragment is added to the activity
   *  This method ensures that the host activity implements this interface
   *    If the activity has not implemented the interface, the fragment throws a ClassCastException
   *
   *  Instantiates an instance of OnArticleSelectedListener by casting the Activity passed into onAttach()
   *  On success, the mListener member holds a reference to the activity's implementation of onItemSelectedListener
   *  so we can share the event with the activity by calling the onItemSelected method defined by the interface
   *
   *  Each time the user selects a list item, the system calls onItemSelected to share the event with the activity
   *
   */
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    try {
      mListener = (OnItemSelectedListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
    }
  }
}

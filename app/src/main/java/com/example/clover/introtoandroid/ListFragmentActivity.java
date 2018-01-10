package com.example.clover.introtoandroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ListView;
import com.example.clover.introtoandroid.models.SimpleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rachel.antion on 12/15/17.
 */

public class ListFragmentActivity extends Activity implements SelectItemFragment.OnItemSelectedListener{

  /**
   * This activity will show how to use a callback when an item is selected in SelectItemFragment
   *
   * Once an item is selected, the activity will be notified, and it can then populate the ViewItemFragment container
   *  with the correct ViewItemFragment, populated with the information from the selected item
   */

  private List<SimpleItem> items;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_fragment);
    createList();

    //begin new FragmentTransaction
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    //create new instance of selectItemFragment passing in the list of items
    //add the fragment to the fragment transaction
    //  passing in the id of where you want the fragment, the fragment, and a tag
    SelectItemFragment selectItemFragment = SelectItemFragment.newInstance(items);
    fragmentTransaction.add(R.id.SelectItemFragment, selectItemFragment, "SELECT_ITEM_FRAGMENT");
    fragmentTransaction.commit();

  }

  private void createList(){
        items = new ArrayList<SimpleItem>();
        items.add(new SimpleItem("Item 1", "Description 1"));
        items.add(new SimpleItem("Item 2", "Description 2"));
        items.add(new SimpleItem("Item 3", "Description 3"));
        items.add(new SimpleItem("Item 4", "Description 4"));
  }

  /**
   * Here we are implementing onItemSelected from the SelectItemFragment.OnItemSelectedListener
   *
   * When an item is selected in SelectItemFragment, it triggers an onItemSelectedEvent which passes through the selected item
   * We override this method so that we can respond to this event (by showing details for the selected item)
   *
   * Once onItemSelected is called, we create a new ViewItemFragment, passing in the item which will populate the view with the correct information
   * ViewItemFragment is then added to the container and will appear in the ViewItemFragment container
   */
  @Override
  public void onItemSelected(SimpleItem simpleItem, int position) {
    ListView fragmentListView = (ListView) findViewById(R.id.FragmentItemListView);
    fragmentListView.setSelection(position);
    ViewItemFragment viewItemFragment = (ViewItemFragment) getFragmentManager().findFragmentById(R.id.ViewItemFragment);
    if (viewItemFragment == null) {
      // Make new fragment to show this selection.
      viewItemFragment = ViewItemFragment.newInstance(simpleItem);

      // Execute a transaction, replacing any existing fragment
      // with this one inside the frame.
      FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
      fragmentTransaction.add(R.id.ViewItemFragment, viewItemFragment, "VIEW_ITEM_FRAGMENT");
      fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
      fragmentTransaction.commit();
    }
    else{
      viewItemFragment.setItem(simpleItem);
      // detaching and reattaching fragment causes it to refresh when the data changes
      Fragment currentFragment = getFragmentManager().findFragmentByTag("VIEW_ITEM_FRAGMENT");
      FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
      fragmentTransaction.detach(currentFragment);
      fragmentTransaction.attach(currentFragment);
      fragmentTransaction.commit();
    }
  }
}

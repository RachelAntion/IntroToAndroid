package com.example.clover.introtoandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.clover.introtoandroid.R;
import com.example.clover.introtoandroid.models.SimpleItem;

import java.util.List;
import java.util.Locale;

/**
 * Created by rachel.antion on 12/15/17.
 */

public class SimpleItemAdapter extends ArrayAdapter<SimpleItem> {

  public SimpleItemAdapter(Context context, int resource, List<SimpleItem> items) {
    super(context, resource, items);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    View v = convertView;

    if (v == null) {
      LayoutInflater vi;
      vi = LayoutInflater.from(getContext());
      v = vi.inflate(R.layout.simple_list_item, null);
    }

    // gets the item based off it's position in the list
    SimpleItem simpleItem = getItem(position);

    //if the simple item is not null, we populate the list item with the title and description from the object
    if (simpleItem != null) {
        TextView title = (TextView) v.findViewById(R.id.ItemTitle);
        TextView description  = (TextView) v.findViewById(R.id.ItemDescription);

        title.setText(simpleItem.getTitle());
        description.setText(simpleItem.getDescription());
    }
    return v;
  }
}

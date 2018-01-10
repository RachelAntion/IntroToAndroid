package com.example.clover.introtoandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by rachel.antion on 12/27/17.
 */

public class ImplicitIntentActivity extends Activity {

  /**
   *   For this Activity, we needed to add the following permission to the AndroidManifest:
   *        READ_EXTERNAL_STORAGE, this allows us to choose an image stored on external storage
   */

  private static final int CHOOSE_IMAGE= 100; // Request Code for Choose Image
  private static String TAG = ImplicitIntentActivity.class.getSimpleName();
  private Button selectPhoto;
  private ImageView displayImage;
  private Uri selectedImageUri;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_implicit_intent);

    displayImage = (ImageView) findViewById(R.id.DisplayImageView);
    selectPhoto = (Button) findViewById(R.id.SelectPhotoButton);
    selectPhoto.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        chooseImage();
      }
    });

    // this will set the imageUri of our ImageView if it has been previously saved
    if ((savedInstanceState != null) && (savedInstanceState.getString("imageUri") != null)) {
      Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        selectedImageUri = Uri.parse(savedInstanceState.getString("imageUri"));
        displayImage.setImageURI(selectedImageUri);

     }
  }

  /**
   * This is called when there is an event that causes the screen to change,
   * such as when the screen rotates, or when another activity completely or partially blocks it (for instance our image chooser)
   *
   * We are saving the imageUri of the image we're displaying in the ImageView so that it stays the same
   */
  @Override
  protected void onSaveInstanceState(Bundle state) {
    super.onSaveInstanceState(state);
    if(selectedImageUri != null) {
      Toast.makeText(this,"onSavedInstanceState", Toast.LENGTH_LONG);
      state.putString("imageUri", selectedImageUri.toString());
    }
  }


  /**
   * This is called after there is an event that causes the screen to change
   *
   * We are saving the imageUri of the image we're displaying in the ImageView so that it stays the same,
   * as well as setting it as the imageUri of the ImageView
   */
  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Toast.makeText(this,"onRestoreInstanceState", Toast.LENGTH_LONG);
    if(savedInstanceState != null && savedInstanceState.getString("imageUri") != null) {
      selectedImageUri = Uri.parse(savedInstanceState.getString("imageUri"));
      displayImage.setImageURI(selectedImageUri);
    }
  }


  public void chooseImage(){
    /**
     * Here is an example of an Implicit intent to choose an image
     * 1) We create a new intent
     * 2) We set the type to image
     * 3) We set the action to ACTION_GET_CONTENT, basically we want to get something
     * 4) Here we startActivityForResult, meaning we want to get something back at the end of our activity
     *      We're also saying createChooser which tells the system we want to choose between activities to complete our intent
     * CHOOSE_IMAGE is the request code for choosing an image
     *      if we had more than one kind of call to startActivityForResult, that is how we would differentiate the results
     */

      Intent intent = new Intent();
      intent.setType("image/*");
      intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(Intent.createChooser(intent, "Choose Image"), CHOOSE_IMAGE);
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    /**
     * Here we are making sure that our result is for CHOOSE_IMAGE,
     * Getting the Uri from the image we selected,
     * Then converting it to a path that the system can use to display that image in our ImageView
     */

    if (resultCode == RESULT_OK) {
      if (requestCode == CHOOSE_IMAGE) {
        // Get the url from data
        selectedImageUri = data.getData();
        if (null != selectedImageUri) {
          // Set the image in ImageView
          displayImage.setImageURI(selectedImageUri);
        }
      }
    }
  }



}

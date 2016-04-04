package com.example.selfreportrefactor;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.selfreportrefactor.Classes.Problem;
import com.example.selfreportrefactor.Fragments.SelectPictureDialogFragment;

public class SubmitProblemActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 20;
    private static int RESULT_LOAD_IMG = 1;
    private static int REQUEST_CODE = 2;

    private Spinner mBoroughSpinner;
    private ArrayAdapter<CharSequence> mBoroughAdapter;
    private Spinner mDevelopmentsSpinner;
    private ArrayAdapter<CharSequence> mDevelopmentsAdapter;
    private Button mSubmitButton;
    String imgDecodableString;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_problem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBoroughSpinner = (Spinner) findViewById(R.id.borough_spinner);
        mBoroughAdapter = ArrayAdapter.createFromResource(SubmitProblemActivity.this, R.array.boroughs_array, android.R.layout.simple_spinner_dropdown_item);
        mBoroughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBoroughSpinner.setAdapter(mBoroughAdapter);
        mDevelopmentsSpinner = (Spinner)findViewById(R.id.developments_spinner);
        mDevelopmentsAdapter = ArrayAdapter.createFromResource(SubmitProblemActivity.this, R.array.developments_array, android.R.layout.simple_spinner_dropdown_item);
        mDevelopmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDevelopmentsSpinner.setAdapter(mDevelopmentsAdapter);
        imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmFireMissiles();
            }
        });

        mSubmitButton = (Button) findViewById(R.id.problem_submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chronometer chronometer = new Chronometer(getApplication());
                chronometer.start();
                Problem problem = new Problem(mBoroughSpinner.getSelectedItem().toString(),
                        mDevelopmentsSpinner.getSelectedItem().toString(),
                        chronometer.getText().toString(),
                        imgView.getResources().getIdentifier("picture", "drawable", getPackageName()));
                Intent intent = new Intent(SubmitProblemActivity.this, MainActivity.class);
                intent.putExtra("PROBLEM"
                        , problem);
                startActivityForResult(intent, 1);
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("ASK FOR PERMISSION", "PERMISSION GRANTED");
                    loadImageFromGallery(imgView);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(SubmitProblemActivity.this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might reques
        }
    }

    public void confirmFireMissiles() {
        DialogFragment newFragment = new SelectPictureDialogFragment();
        newFragment.show(getSupportFragmentManager(), "missiles");
    }

    public void checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            Log.d("CHECKED SDK", "BUTTON CLICKED");
            if (ContextCompat.checkSelfPermission(SubmitProblemActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                Log.d("CONDITION TEST#1", "FAILED FIRST CONDITION");

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(SubmitProblemActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.
                    Log.d("ASK FOR PERMISSION", "ASKING FOR PERMISSION");
                    ActivityCompat.requestPermissions(SubmitProblemActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    Log.d("ASK FOR PERMISSION", "PERMISSION REQUESTED");
                    //loadImageFromGallery(imgView);
                }
            } else {
                loadImageFromGallery(imgView);
            }

        }
    }

    public void loadImageFromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    public void takePictureAndLoad() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == Activity.RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = SubmitProblemActivity.this.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                // Set the Image in ImageView after decoding the String

                Log.d("WHATS IN IMAGE FILE", imgDecodableString);
//                imgView.setImageBitmap(BitmapFactory
//                        .decodeFile("file:" + imgDecodableString));
                imgView.setImageURI(Uri.parse(imgDecodableString));

            } else {
                Toast.makeText(SubmitProblemActivity.this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(SubmitProblemActivity.this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }



}



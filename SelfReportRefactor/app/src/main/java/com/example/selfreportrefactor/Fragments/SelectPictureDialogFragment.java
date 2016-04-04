package com.example.selfreportrefactor.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.selfreportrefactor.SubmitProblemActivity;

/**
 * Created by User_1_Benjamin_Rosenthal on 3/31/16.
 */
public class SelectPictureDialogFragment extends DialogFragment {
    private static int RESULT_LOAD_IMG = 1;
    private static int REQUEST_CODE = 2;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("HELLO")
                        .setPositiveButton("Take photo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                if (checkSelfPermission(Manifest.permission.CAMERA)
//                                        != PackageManager.PERMISSION_GRANTED) {
//
//                                    requestPermissions(new String[]{Manifest.permission.CAMERA},
//                                            MY_REQUEST_CODE);
//                                }
                                ((SubmitProblemActivity) getActivity()).takePictureAndLoad();
                            }
                        })
                        .setNeutralButton("Pick a photo from gallery", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                              ((SubmitProblemActivity) getActivity()).checkPermissions();
//                              ((SubmitProblemActivity) getActivity()).
                            }
                        });
                // Create the AlertDialog object and return it
                return builder.create();
        }

}

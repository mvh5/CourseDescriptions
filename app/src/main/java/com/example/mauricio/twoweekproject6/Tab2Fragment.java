package com.example.mauricio.twoweekproject6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mauricio on 8/14/18.
 */

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";
    boolean denied = true;
    boolean firstTime = true;
    boolean snagBarOn = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        final ImageView FirstImage = (ImageView) view.findViewById(R.id.imageView);
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);


        textView.setText("Covered : " + seekBar.getProgress() + " / " + seekBar.getMax());
        FirstImage.setImageResource(R.drawable.lock1);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                        progress_value = progress;
                        textView.setText("Covered : " + progress + " / " +seekBar.getMax());

                        if (firstTime) {

                            dialogBoxAppear();
                            firstTime = false;
                        }
                        if (progress < 11 && !denied ) {
                            FirstImage.setImageResource(R.drawable.dc1);
                        } else if (progress<22 &&!denied ) {
                            FirstImage.setImageResource(R.drawable.dc2);
                        } else if (progress < 33 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc3);
                        } else if (progress < 44 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc4);
                        } else if (progress < 55 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc5);
                        } else if (progress < 66 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc6);
                        } else if (progress < 77 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc7);
                        } else if (progress < 88 && !denied) {
                            FirstImage.setImageResource(R.drawable.dc8);
                        } else if (!denied) {
                                FirstImage.setImageResource(R.drawable.dc9);

                        } else {
                            if (denied && !firstTime && !snagBarOn) {
                                snagBarOn = true;
                                Snackbar snackBar = Snackbar.make(getView(), "Please enable" +
                                        " storage permission",Snackbar.LENGTH_INDEFINITE).
                                        setAction("ok",new View.OnClickListener() {

                                            @Override
                                            public void onClick(View view) {
                                            dialogBoxAppear();
                                            }
                                        });
                                snackBar.show();
                            }

                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar2) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar2) {
                        //textView.setText("Covered : " + progress_value + " / " + seekBar.getMax());
                        //Toast.makeText(getContext(), "hhh", Toast.LENGTH_SHORT).show();
                        snagBarOn = false;

                    }
                }
        );




        return view;
    }

    public void dialogBoxAppear() {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(getContext());
        aBuilder.setMessage("Allow TwoWeekTestProjectPart2 to take pictures and record video").
                setCancelable(false).setPositiveButton("Allow", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                denied = false;

                dialogInterface.cancel();

            }
        })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        snagBarOn = false;
                        dialogInterface.cancel();


                    }
                });
        AlertDialog alert =  aBuilder.create();
        alert.setTitle("Alert!");
        alert.show();
    }

}

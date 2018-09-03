package com.example.mauricio.twoweekproject6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mauricio on 8/15/18.
 */

public class GalleryActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Button button;
    private EditText editText;
    private TextView textView2;

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");
        textView = (TextView)findViewById(R.id.image_description);
        textView2 = (TextView)findViewById(R.id.class_description);
        imageView = (ImageView)findViewById(R.id.image);
        Bundle bundle = this.getIntent().getExtras();
        String value = bundle.getString("val1");
        int value2 = bundle.getInt("val2");
        String classDescription = bundle.getString("val4");
        textView.setText(value);
        textView2.setText(classDescription);
        imageView.setImageResource(value2);

        editText = (EditText)findViewById(R.id.editText1);

        button = (Button)findViewById(R.id.button2);

        //Toast.makeText(this,value,Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text1 = "";
                Bundle bundle = new Bundle();
                bundle.putString("xyz1",editText.getText().toString());


                Intent returnIntent = new Intent(view.getContext(),MainActivity.class);
                returnIntent.putExtras(bundle);
                view.getContext().startActivity(returnIntent);
            }
        });
    }



}

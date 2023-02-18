package com.example.recyclerviewprojectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started: ");
        getData();


    }

    private void getData() {
        Log.d(TAG, "getData: checking for incoming intents. ");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("desc")) {
            Log.d(TAG, "getData: found intent extras");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String ddd = getIntent().getStringExtra("desc");

            setImage(imageUrl, imageName, ddd);


        }
    }

    private void setImage(String imageUrl, String imageName, String ddd) {
        Log.d(TAG, "setImage: setting image and name to widgets");
        TextView name = findViewById(R.id.imgDescription);
        TextView opis = findViewById(R.id.tvOpis);
        name.setText(imageName);
        opis.setText(ddd);

        ImageView imageView = findViewById(R.id.imageV);

        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageView);

    }
}

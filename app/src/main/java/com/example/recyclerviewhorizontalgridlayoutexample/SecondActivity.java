package com.example.recyclerviewhorizontalgridlayoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ImageView selectedImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );
        selectedImage = findViewById( R.id.selectedImage );
        Intent intent = getIntent();
        selectedImage.setImageResource( intent.getIntExtra( "image",0 ) );
    }
}

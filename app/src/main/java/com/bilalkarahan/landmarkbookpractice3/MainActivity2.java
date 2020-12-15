package com.bilalkarahan.landmarkbookpractice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    TextView landmarkNameText;
    TextView countryNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("name");
        String countryName = intent.getStringExtra("country");
        Singleton singleton = Singleton.getSingleton();

        landmarkNameText.setText(landmarkName);
        countryNameText.setText(countryName);
        imageView.setImageBitmap(singleton.getChosenImage());

    }

    public void backButton(View view) {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
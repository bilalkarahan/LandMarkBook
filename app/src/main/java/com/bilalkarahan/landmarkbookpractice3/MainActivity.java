package com.bilalkarahan.landmarkbookpractice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> landmarkNames = new ArrayList<>();
    ArrayList<String> countryNames = new ArrayList<>();
    ArrayList<Bitmap> landmarkImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        setLandmarkNames();
        setCountryNames();
        setLandmarkImages();
        listClick();


        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);


    }

    public void setLandmarkNames() {
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
    }

    public void setCountryNames() {
        countryNames.add("Italy");
        countryNames.add("France");
    }

    public void setLandmarkImages() {
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
    }

    public void listClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name", landmarkNames.get(position));
                intent.putExtra("country", countryNames.get(position));
                Singleton singleton = Singleton.getSingleton();
                singleton.setChosenImage(landmarkImages.get(position));
                startActivity(intent);
            }
        });
    }

}
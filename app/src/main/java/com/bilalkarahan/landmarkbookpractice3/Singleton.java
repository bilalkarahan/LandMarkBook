package com.bilalkarahan.landmarkbookpractice3;

import android.graphics.Bitmap;

public class Singleton {

    private static Singleton singleton = new Singleton();
    private Bitmap chosenImage;
    private Singleton() {

    }

    public static Singleton getSingleton() {

        if(singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public Bitmap getChosenImage() {
        return chosenImage;
    }
}

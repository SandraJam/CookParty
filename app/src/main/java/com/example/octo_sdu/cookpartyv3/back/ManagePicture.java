package com.example.octo_sdu.cookpartyv3.back;

import com.example.octo_sdu.cookpartyv3.R;

import java.util.ArrayList;
import java.util.List;

public class ManagePicture {
    public static List<Integer> givePictureCategoryList(){
        final ArrayList<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.vegetables);
        pictures.add(R.drawable.fruits);
        pictures.add(R.drawable.meat);
        pictures.add(R.drawable.spice);
        pictures.add(R.drawable.drink);
        pictures.add(R.drawable.grocery);
        pictures.add(R.drawable.meal);
        pictures.add(R.drawable.gratin);
        pictures.add(R.drawable.pizza);
        pictures.add(R.drawable.pastry);
        pictures.add(R.drawable.sauce);
        return pictures;
    }
}

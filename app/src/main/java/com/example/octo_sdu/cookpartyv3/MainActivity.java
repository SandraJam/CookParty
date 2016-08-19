package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.octo_sdu.cookpartyv3.back.FirstTime;
import com.example.octo_sdu.cookpartyv3.back.realm.MeasuresRepositoryRealmImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstTime firstTime = new FirstTime(new MeasuresRepositoryRealmImpl());
        firstTime.checkFirstTime();
        Intent intent = new Intent(MainActivity.this, CategoryIngredientActivity.class);
        startActivity(intent);
        finish();
    }
}

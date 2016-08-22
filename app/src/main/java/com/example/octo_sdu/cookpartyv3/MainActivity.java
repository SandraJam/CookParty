package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.octo_sdu.cookpartyv3.back.MainDependencies;
import com.example.octo_sdu.cookpartyv3.back.realm.MeasuresRepositoryRealmImpl;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());

        MainDependencies mainDependencies = new MainDependencies(new MeasuresRepositoryRealmImpl());
        mainDependencies.checkFirstTime(this.getApplicationContext());
        Intent intent = new Intent(MainActivity.this, CategoryIngredientActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.octo_sdu.cookpartyv3.back.MainDependencies;
import com.example.octo_sdu.cookpartyv3.back.realm.CategoryIngredientRepositoryRealm;
import com.example.octo_sdu.cookpartyv3.back.realm.CategoryRecipeRepositoryRealmImpl;
import com.example.octo_sdu.cookpartyv3.back.realm.IngredientsRepositoryRealmImpl;
import com.example.octo_sdu.cookpartyv3.back.realm.MeasuresRepositoryRealmImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button_ingredient)
    Button buttonIngredient;
    @BindView(R.id.button_recipe)
    Button buttonRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.setDefaultConfiguration(
                new RealmConfiguration
                        .Builder(MainActivity.this)
                        .deleteRealmIfMigrationNeeded()
                        .build());

        MainDependencies.executor.execute(new Runnable() {
            @Override
            public void run() {

                final MainDependencies mainDependencies = new MainDependencies(new MeasuresRepositoryRealmImpl(), new CategoryIngredientRepositoryRealm(), new IngredientsRepositoryRealmImpl(), new CategoryRecipeRepositoryRealmImpl());

                mainDependencies.checkFirstTime(MainActivity.this.getApplicationContext());
            }
        });

        ButterKnife.bind(this);

        buttonIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryIngredientActivity.class);
                startActivity(intent);
            }
        });

        buttonRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryRecipeActivity.class);
                startActivity(intent);
            }
        });
    }
}

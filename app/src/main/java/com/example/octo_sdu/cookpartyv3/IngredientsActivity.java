package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.back.realm.IngredientsRepositoryRealmImpl;
import com.example.octo_sdu.cookpartyv3.back.realm.MeasuresRepositoryRealmImpl;
import com.example.octo_sdu.cookpartyv3.ingredients.interactor.IngredientsInteractor;
import com.example.octo_sdu.cookpartyv3.ingredients.interactor.IngredientsInteractorImpl;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsPresenterImpl;
import com.example.octo_sdu.cookpartyv3.ingredients.view.IngredientsAdapter;
import com.example.octo_sdu.cookpartyv3.ingredients.view.IngredientsViewValidate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsActivity extends AppCompatActivity implements IngredientsViewValidate{

    public static final String IMAGE = "image";
    public static final String NAME = "name";

    private static final int SPAN_COUNT_PORTRAIT = 1;
    private static final int SPAN_COUNT_LANDSCAPE = 2;
    @BindView(R.id.image_category_in_ingredients)
    ImageView imageViewCategory;
    @BindView(R.id.text_category_in_ingredients)
    TextView textViewCategory;
    @BindView(R.id.recycler_ingredient)
    RecyclerView recyclerView;
    @BindView(R.id.text_no_ingredient)
    TextView textViewNoIngredient;
    @BindView(R.id.image_no_ingredient)
    ImageView imageViewNoIngredient;
    @BindView(R.id.fab_add_ingredient)
    FloatingActionButton fabAddIngredient;

    private IngredientsAdapter ingredientsAdapter;
    private IngredientsInteractor ingredientsInteractor;
    private MaterialDialog materialDialog;
    private String nameCategory;
    private String nameIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        ButterKnife.bind(this);

        final Intent intent = getIntent();
        nameCategory = intent.getStringExtra(NAME);
        imageViewCategory.setImageDrawable(ResourcesCompat.getDrawable(getResources(), intent.getIntExtra(IMAGE, 0), null));
        textViewCategory.setText(nameCategory);

        ingredientsInteractor = new IngredientsInteractorImpl(new IngredientsPresenterImpl(this), new IngredientsRepositoryRealmImpl(), new MeasuresRepositoryRealmImpl());

        ingredientsAdapter = new IngredientsAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerView.setAdapter(ingredientsAdapter);

        ingredientsInteractor.allIngredientsByCategory(nameCategory);

    }

    private int getSpanCount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return SPAN_COUNT_PORTRAIT;
        } else {
            return SPAN_COUNT_LANDSCAPE;
        }
    }

    @Override
    public void onEmpty() {
        imageViewNoIngredient.setVisibility(View.VISIBLE);
        textViewNoIngredient.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess(List<Ingredient> ingredients) {
        imageViewNoIngredient.setVisibility(View.GONE);
        textViewNoIngredient.setVisibility(View.GONE);
        ingredientsAdapter.setIngredientList(ingredients);
        recyclerView.setAdapter(ingredientsAdapter);
    }

    @Override
    public void addPossibility(final String[] namesMeasures) {
        fabAddIngredient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        makeDialog(namesMeasures);
                        materialDialog.show();
                    }
                }
        );
    }


    private void makeDialog(String[] namesMeasures) {
        final MaterialDialog materialDialogList = new MaterialDialog.Builder(this)
                .title("Add an Ingredient in " + nameCategory)
                .content("What's the measure unit of this ingredient?")
                .items(namesMeasures)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        ingredientsInteractor.addIngredient(nameIngredient, nameCategory, text.toString());
                        ingredientsInteractor.allIngredientsByCategory(nameCategory);
                        return false;
                    }
                }).build();

        materialDialog = new MaterialDialog.Builder(this)
                .title("Add an Ingredient in "+nameCategory)
                .content("What's the name to your Ingredient?")
                .inputRangeRes(2, 15, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("Ingredient Name", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, final CharSequence input) {
                        nameIngredient = input.toString();
                        materialDialogList.show();
                    }
                })
                .build();
    }
}

package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.back.realm.IngredientsRepositoryRealmImpl;
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
    public static final int MIN_LENGTH_WORD = 2;
    public static final int MAX_LENGTH_WORD = 15;
    @BindView(R.id.image_category_in_ingredients)
    ImageView imageViewCategory;
    @BindView(R.id.text_category_in_ingredients)
    TextView textViewCategory;
    @BindView(R.id.viewFlipper_ingredients)
    ViewFlipper viewFlipperIngredients;
    @BindView(R.id.recycler_ingredient)
    RecyclerView recyclerView;
    @BindView(R.id.fab_add_ingredient)
    FloatingActionButton fabAddIngredient;
    @BindView(R.id.toolbar_ingredients)
    Toolbar toolbar;
    @BindView(R.id.app_bar_ingredients)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar_layout_ingredients)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private IngredientsAdapter ingredientsAdapter;
    private IngredientsInteractor ingredientsInteractor;
    private String nameCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        nameCategory = intent.getStringExtra(NAME);
        imageViewCategory.setImageDrawable(ResourcesCompat.getDrawable(getResources(), intent.getIntExtra(IMAGE, 0), null));
        textViewCategory.setText(nameCategory);

        collapsingToolbarLayout.setTitle(nameCategory);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));

        ingredientsInteractor = new IngredientsInteractorImpl(new IngredientsPresenterImpl(this), new IngredientsRepositoryRealmImpl());

        ingredientsAdapter = new IngredientsAdapter(ingredientsInteractor, nameCategory);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerView.setAdapter(ingredientsAdapter);

        ingredientsInteractor.allIngredientsByCategory(nameCategory);
        addPossibility();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_ingredients, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                new MaterialDialog.Builder(this)
                        .title(R.string.are_you_sure)
                        .content(R.string.are_your_sure_content)
                        .positiveText(R.string.delete)
                        .negativeText(R.string.cancel)
                        .onAny(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                if (which.equals(DialogAction.POSITIVE)){
                                    ingredientsInteractor.deleteCategoryAndAllIngredients(nameCategory);
                                    finish();
                                } else if (which.equals(DialogAction.NEGATIVE)){
                                    dialog.dismiss();
                                }
                            }
                        })
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        viewFlipperIngredients.setDisplayedChild(1);
    }

    @Override
    public void onSuccess(List<Ingredient> ingredients) {
        viewFlipperIngredients.setDisplayedChild(0);
        ingredientsAdapter.setIngredientList(ingredients);
        recyclerView.setAdapter(ingredientsAdapter);
    }

    private void addPossibility() {
        final MaterialDialog materialDialog = new MaterialDialog.Builder(this)
                .title(getString(R.string.add_ingredient_in)+nameCategory)
                .content(R.string.question_name_ingredient)
                .inputRangeRes(MIN_LENGTH_WORD, MAX_LENGTH_WORD, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.name_ingredient), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, final CharSequence input) {
                        ingredientsInteractor.addIngredient(input.toString(), nameCategory);
                        ingredientsInteractor.allIngredientsByCategory(nameCategory);
                    }
                })
                .build();
        fabAddIngredient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        materialDialog.show();
                    }
                }
        );
    }
}

package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.ViewFlipper;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.Dependencies;
import com.example.octo_sdu.cookpartyv3.back.QuicksandTextView;
import com.example.octo_sdu.cookpartyv3.recipes.dagger.DaggerRecipesComponent;
import com.example.octo_sdu.cookpartyv3.recipes.decorate.RecipesViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesViewValidate;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModelView;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipesAdapter;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity implements RecipesViewValidate{
    private static final String NAME = "name";
    private static final String IMAGE = "image";
    private static final String NAMECATEGORY = "nameCategory";
    private static final int SPAN_COUNT_PORTRAIT = 1;
    private static final int SPAN_COUNT_LANDSCAPE = 2;
    @BindView(R.id.toolbar_recipes)
    Toolbar toolbar;
    @BindView(R.id.image_category_in_recipes)
    ImageView imageViewCategory;
    @BindView(R.id.text_category_in_recipes)
    QuicksandTextView quicksandTextView;
    @BindView(R.id.toolbar_layout_recipes)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.recycler_recipe)
    RecyclerView recyclerView;
    @BindView(R.id.viewFlipper_recipes)
    ViewFlipper viewFlipperRecipes;
    @BindView(R.id.fab_add_recipe)
    FloatingActionButton fabAddRecipe;
    @Inject
    RecipesInteractor recipesInteractor;
    @Inject
    RecipesViewValidateDecorate recipesViewValidateDecorate;
    private String nameCategory;
    private RecipesAdapter recipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        nameCategory = intent.getStringExtra(NAME);
        imageViewCategory.setImageDrawable(ResourcesCompat.getDrawable(getResources(), intent.getIntExtra(IMAGE, 0), null));
        quicksandTextView.setText(nameCategory);

        collapsingToolbarLayout.setTitle(nameCategory);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));

        DaggerRecipesComponent.builder().mainComponent(Dependencies.instance.mainComponent).build().inject(this);

        recipesAdapter = new RecipesAdapter(nameCategory);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerView.setAdapter(recipesAdapter);

        recipesInteractor.allRecipesByCategory(nameCategory);

        fabAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNameNewRecipe().show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipesViewValidateDecorate.recipesViewValidate = this;
    }

    @Override
    protected void onStop() {
        recipesViewValidateDecorate.recipesViewValidate = null;
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recipesInteractor.allRecipesByCategory(nameCategory);
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
                                    recipesInteractor.deleteCategoryAndAllRecipes(nameCategory);
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

    private MaterialDialog dialogNameNewRecipe() {
        return new MaterialDialog.Builder(this)
                .title(R.string.add_new_recipe)
                .content(R.string.question_title_recipe)
                .inputRangeRes(2, 15, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.name_recipe_category), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        recipesInteractor.addRecipe(input.toString(), nameCategory);
                    }
                })
                .build();
    }

    @Override
    public void onEmpty() {
        viewFlipperRecipes.setDisplayedChild(1);
    }

    @Override
    public void onSuccess(List<RecipeModelView> recipeModelViewList) {
        viewFlipperRecipes.setDisplayedChild(0);
        recipesAdapter.setRecipeModelViewList(recipeModelViewList);
        recyclerView.setAdapter(recipesAdapter);
    }

    @Override
    public void addIsOkay() {
        Intent intent = new Intent(RecipesActivity.this, RecipeActivity.class);
        intent.putExtra(NAMECATEGORY, nameCategory);
        startActivity(intent);
    }
}

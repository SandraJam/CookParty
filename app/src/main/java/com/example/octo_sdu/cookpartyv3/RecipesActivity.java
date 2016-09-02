package com.example.octo_sdu.cookpartyv3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.Dependencies;
import com.example.octo_sdu.cookpartyv3.back.QuicksandTextView;
import com.example.octo_sdu.cookpartyv3.recipes.dagger.DaggerRecipesComponent;
import com.example.octo_sdu.cookpartyv3.recipes.decorate.RecipesViewValidateDecorate;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractorImpl;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesPresenterImpl;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModelView;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipesAdapter;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesViewValidate;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity implements RecipesViewValidate{
    private static final String NAME = "name";
    private static final String IMAGE = "image";
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
    @BindView(R.id.image_no_recipe)
    ImageView imageViewNoRecipe;
    @BindView(R.id.text_no_recipe)
    TextView textViewNoRecipe;
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

        recipesAdapter = new RecipesAdapter(recipesInteractor, nameCategory);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerView.setAdapter(recipesAdapter);
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

    @Override
    public void onEmpty() {
        recyclerView.setVisibility(View.GONE);
        imageViewNoRecipe.setVisibility(View.VISIBLE);
        textViewNoRecipe.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess(List<RecipeModelView> recipeModelViewList) {
        recyclerView.setVisibility(View.VISIBLE);
        imageViewNoRecipe.setVisibility(View.GONE);
        textViewNoRecipe.setVisibility(View.GONE);
        recipesAdapter.setRecipeModelViewList(recipeModelViewList);
        recyclerView.setAdapter(recipesAdapter);
    }
}

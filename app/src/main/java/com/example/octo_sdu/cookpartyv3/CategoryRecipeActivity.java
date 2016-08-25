package com.example.octo_sdu.cookpartyv3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.MainDependencies;
import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.back.realm.CategoryRecipeRepositoryRealmImpl;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.interactor.CategoryRecipeInteractor;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.interactor.CategoryRecipeInteractorImpl;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipePresenterImpl;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.view.CategoryRecipeImageAdapter;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.view.CategoryRecipeViewAdapter;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.view.CategoryRecipeViewValidate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryRecipeActivity extends AppCompatActivity implements CategoryRecipeViewValidate{
    private static final int SPAN_COUNT_PORTRAIT = 1;
    private static final int SPAN_COUNT_LANDSCAPE = 2;

    @BindView(R.id.recycler_category_recipe)
    RecyclerView recyclerViewCategoryRecipe;
    @BindView(R.id.fab_category_recipe_add)
    FloatingActionButton fabCategoryRecipe;
    private CategoryRecipeViewAdapter categoryRecipeViewAdapter;
    private CategoryRecipeInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_recipe);

        ButterKnife.bind(this);

        interactor = new CategoryRecipeInteractorImpl(new CategoryRecipeRepositoryRealmImpl(), new CategoryRecipePresenterImpl(this));

        categoryRecipeViewAdapter = new CategoryRecipeViewAdapter();
        recyclerViewCategoryRecipe.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerViewCategoryRecipe.setAdapter(categoryRecipeViewAdapter);

        interactor.allCategoryRecipe();

        fabCategoryRecipe.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createDialogForCategory().show();
                    }
                }
        );
    }

    private int getSpanCount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return SPAN_COUNT_PORTRAIT;
        } else {
            return SPAN_COUNT_LANDSCAPE;
        }
    }

    @Override
    public void onSuccess(List<CategoryRecipe> categoryRecipe) {
        categoryRecipeViewAdapter.setCategoryRecipeList(categoryRecipe);
        recyclerViewCategoryRecipe.setAdapter(categoryRecipeViewAdapter);
    }

    private MaterialDialog createDialogForCategory() {
        final MainDependencies mainDependencies = new MainDependencies();
        final MaterialDialog.Builder materialDialogGallery = new MaterialDialog.Builder(this)
                .title(R.string.choose_picture)
                .content(R.string.choose_picture_category_recipe);

        return new MaterialDialog.Builder(this)
                .title(R.string.add_recipe_category)
                .content(R.string.question_name_recipe_category)
                .inputRangeRes(2, 15, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.name_recipe_category), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        final CategoryRecipeImageAdapter categoryRecipeImageAdapter = new CategoryRecipeImageAdapter(mainDependencies.givePictureCategoryList(), input.toString(), interactor);
                        final MaterialDialog dialogGallery = materialDialogGallery
                                .adapter(categoryRecipeImageAdapter, null).build();
                        categoryRecipeImageAdapter.setDialog(dialogGallery);
                        dialogGallery.show();
                    }
                })
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.allCategoryRecipe();
    }
}

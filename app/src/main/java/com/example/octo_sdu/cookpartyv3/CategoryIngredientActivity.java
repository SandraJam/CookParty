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
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.back.realm.CategoryIngredientRepositoryRealm;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor.CategoryIngredientInteractor;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor.CategoryIngredientInteractorImpl;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientPresenterImpl;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientAdapter;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientImageAdapter;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientViewValidate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CategoryIngredientActivity extends AppCompatActivity implements CategoryIngredientViewValidate {
    private static final int SPAN_COUNT_PORTRAIT = 1;
    private static final int SPAN_COUNT_LANDSCAPE = 2;
    @BindView(R.id.recycler_category_ingredient)
    RecyclerView recyclerViewCategoryIngredient;
    @BindView(R.id.fab_category_ingredient_add)
    FloatingActionButton fabCategoryIngredient;
    @BindView(R.id.image_no_category_ingredient)
    ImageView imageViewNoCategoryIngredient;
    @BindView(R.id.text_no_category_ingredient)
    TextView textViewNoCategoryIngredient;

    CategoryIngredientAdapter categoryIngredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_ingredient);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());

        ButterKnife.bind(this);

        final CategoryIngredientInteractor interactor = new CategoryIngredientInteractorImpl(new CategoryIngredientRepositoryRealm(), new CategoryIngredientPresenterImpl(this)); //;

        categoryIngredientAdapter = new CategoryIngredientAdapter(interactor);
        recyclerViewCategoryIngredient.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerViewCategoryIngredient.setAdapter(categoryIngredientAdapter);

        interactor.allCategoryIngredient();

        // Create Dialog for add a new Category
        final MaterialDialog.Builder materialDialogGallery = new MaterialDialog.Builder(this)
                .title("Choose your image")
                .content("Choose a picture about your Ingredient Category:");

        final MaterialDialog materialDialog = new MaterialDialog.Builder(this)
                .title("Add an Ingredient Category")
                .content("What's the name to your Ingredient Category?")
                .inputRangeRes(2, 15, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("Ingredient Category Name", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        final CategoryIngredientImageAdapter categoryIngredientImageAdapter = new CategoryIngredientImageAdapter(input.toString(), interactor);
                        final MaterialDialog dialogGallery = materialDialogGallery
                                .adapter(categoryIngredientImageAdapter, null).build();
                        categoryIngredientImageAdapter.setDialog(dialogGallery);
                        dialogGallery.show();
                    }
                })
                .build();

        fabCategoryIngredient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        materialDialog.show();
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
    public void onSuccess(List<CategoryIngredient> categoryIngredientList) {
        imageViewNoCategoryIngredient.setVisibility(View.GONE);
        textViewNoCategoryIngredient.setVisibility(View.GONE);
        categoryIngredientAdapter.setCategoryIngredients(categoryIngredientList);
        recyclerViewCategoryIngredient.setAdapter(categoryIngredientAdapter);
    }

    @Override
    public void onEmptyCategory() {
        imageViewNoCategoryIngredient.setVisibility(View.VISIBLE);
        textViewNoCategoryIngredient.setVisibility(View.VISIBLE);
    }
}

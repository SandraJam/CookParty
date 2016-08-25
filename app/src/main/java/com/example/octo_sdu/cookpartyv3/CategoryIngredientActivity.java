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
import com.example.octo_sdu.cookpartyv3.back.ManagePicture;
import com.example.octo_sdu.cookpartyv3.back.realm.CategoryIngredientRepositoryRealm;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientInteractor;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientInteractorDecorate;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientPresenterImpl;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientViewValidate;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientAdapter;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientImageAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryIngredientActivity extends AppCompatActivity implements CategoryIngredientViewValidate {
    private static final int SPAN_COUNT_PORTRAIT = 1;
    private static final int SPAN_COUNT_LANDSCAPE = 2;

    @BindView(R.id.recycler_category_ingredient)
    RecyclerView recyclerViewCategoryIngredient;
    @BindView(R.id.fab_category_ingredient_add)
    FloatingActionButton fabCategoryIngredient;

    CategoryIngredientAdapter categoryIngredientAdapter;
    private CategoryIngredientInteractor interactorDecorated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_ingredient);

        ButterKnife.bind(this);

        interactorDecorated = new CategoryIngredientInteractorDecorate(
                new CategoryIngredientRepositoryRealm(),
                new CategoryIngredientPresenterImpl(
                        new CategoryIngredientViewValidateDecorate(this)
                )
        );

        categoryIngredientAdapter = new CategoryIngredientAdapter(interactorDecorated);
        recyclerViewCategoryIngredient.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
        recyclerViewCategoryIngredient.setAdapter(categoryIngredientAdapter);

        interactorDecorated.allCategoryIngredient();

        fabCategoryIngredient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createDialogForCategory().show();
                    }
                }
        );
    }

    @Override
    public void onSuccess(List<CategoryIngredient> categoryIngredientList) {
        categoryIngredientAdapter.setCategoryIngredients(categoryIngredientList);
        recyclerViewCategoryIngredient.setAdapter(categoryIngredientAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactorDecorated.allCategoryIngredient();
    }

    private MaterialDialog createDialogForCategory() {
        final MaterialDialog.Builder materialDialogGallery = new MaterialDialog.Builder(this)
                .title(R.string.choose_picture)
                .content(R.string.choose_picture_category_ingredient);

        return new MaterialDialog.Builder(this)
                .title(R.string.add_ingredient_category)
                .content(R.string.question_name_ingredient_category)
                .inputRangeRes(2, 15, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.name_ingredient_category), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        final CategoryIngredientImageAdapter categoryIngredientImageAdapter = new CategoryIngredientImageAdapter(ManagePicture.givePictureCategoryList(), input.toString(), interactorDecorated);
                        final MaterialDialog dialogGallery = materialDialogGallery
                                .adapter(categoryIngredientImageAdapter, null).build();
                        categoryIngredientImageAdapter.setDialog(dialogGallery);
                        dialogGallery.show();
                    }
                })
                .build();
    }

    private int getSpanCount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return SPAN_COUNT_PORTRAIT;
        } else {
            return SPAN_COUNT_LANDSCAPE;
        }
    }
}

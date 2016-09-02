package com.example.octo_sdu.cookpartyv3.categoryRecipe.view;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.RecipesActivity;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryRecipeViewHolder extends RecyclerView.ViewHolder {
    private static final String IMAGE = "image";
    private static final String NAME = "name";
    @BindView(R.id.text_category_recipe)
    TextView textViewCategoryRecipe;
    @BindView(R.id.image_category_recipe)
    ImageView imageViewCategoryRecipe;

    private CategoryRecipeInteractor categoryRecipeInteractor;
    private MaterialDialog materialDialog;

    public CategoryRecipeViewHolder(View itemView, CategoryRecipeInteractor categoryRecipeInteractor, MaterialDialog materialDialog) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.categoryRecipeInteractor = categoryRecipeInteractor;
        this.materialDialog = materialDialog;
    }

    public void bind(final String title, final int draw) {
        textViewCategoryRecipe.setText(title);
        imageViewCategoryRecipe.setImageDrawable(ResourcesCompat.getDrawable(imageViewCategoryRecipe.getResources(), draw, null));
        imageViewCategoryRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (materialDialog != null) {
                    categoryRecipeInteractor.addCategoryRecipe(title, draw);
                    categoryRecipeInteractor.allCategoryRecipe();
                    materialDialog.dismiss();
                } else {
                    Intent intent = new Intent(imageViewCategoryRecipe.getContext(), RecipesActivity.class);
                    intent.putExtra(IMAGE, draw);
                    intent.putExtra(NAME, title);
                    imageViewCategoryRecipe.getContext().startActivity(intent);
                }
            }
        });
    }
}

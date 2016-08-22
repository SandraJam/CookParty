package com.example.octo_sdu.cookpartyv3.categoryIngredient.view;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.IngredientsActivity;
import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor.CategoryIngredientInteractor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryIngredientViewHolder extends RecyclerView.ViewHolder {
    public static final String IMAGE = "image";
    public static final String NAME = "name";
    @BindView(R.id.text_category_ingredient)
    TextView textViewCategoryIngredient;
    @BindView(R.id.image_category_ingredient)
    ImageView imageViewCategoryIngredient;

    private CategoryIngredientInteractor categoryIngredientInteractor;
    private MaterialDialog add;

    public CategoryIngredientViewHolder(View itemView, CategoryIngredientInteractor categoryIngredientInteractor, MaterialDialog add) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.categoryIngredientInteractor = categoryIngredientInteractor;
        this.add = add;
    }

    public void bind(final String name, final int draw) {
        textViewCategoryIngredient.setText(name);
        imageViewCategoryIngredient.setImageDrawable(ResourcesCompat.getDrawable(imageViewCategoryIngredient.getResources(), draw, null));
        imageViewCategoryIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (add != null) {
                    categoryIngredientInteractor.saveCategoryIngredient(name, draw);
                    categoryIngredientInteractor.allCategoryIngredient();
                    add.dismiss();
                } else {
                    Intent intent = new Intent(imageViewCategoryIngredient.getContext(), IngredientsActivity.class);
                    intent.putExtra(IMAGE, draw);
                    intent.putExtra(NAME, name);
                    imageViewCategoryIngredient.getContext().startActivity(intent);
                }
            }
        });
    }
}

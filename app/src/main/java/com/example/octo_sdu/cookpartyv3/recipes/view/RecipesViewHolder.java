package com.example.octo_sdu.cookpartyv3.recipes.view;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.RecipeActivity;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesViewHolder extends RecyclerView.ViewHolder {
    private static final String NAMECATEGORY = "nameCategory";
    @BindView(R.id.text_recipe)
    TextView textViewRecipe;
    @BindView(R.id.card_recipes)
    CardView cardRecipes;

    private String nameCategory;

    public RecipesViewHolder(View itemView, String nameCategory) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        this.nameCategory = nameCategory;
    }

    public void bind(String title) {
        textViewRecipe.setText(title);

        cardRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardRecipes.getContext(), RecipeActivity.class);
                intent.putExtra(NAMECATEGORY, nameCategory);
                cardRecipes.getContext().startActivity(intent);
            }
        });
    }
}
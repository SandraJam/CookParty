package com.example.octo_sdu.cookpartyv3.recipes.view;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.recipes.interactor.RecipesInteractor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_recipe)
    TextView textViewRecipe;
    @BindView(R.id.imageButton_recipe)
    ImageButton imageButtonRecipe;

    private RecipesInteractor interactor;
    private String nameCategory;

    public RecipesViewHolder(View itemView, RecipesInteractor interactor, String nameCategory) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.interactor = interactor;
        this.nameCategory = nameCategory;
    }

    public void bind(String title) {
        textViewRecipe.setText(title);
        imageButtonRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUpMenu(view, interactor, nameCategory);
            }
        });
    }

    private void showPopUpMenu(View view, final RecipesInteractor interactor, final String name) {
        PopupMenu popup = new PopupMenu(view.getContext(),view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card_recipe, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_delete_recipe:
                        interactor.deleteRecipe(name, nameCategory);
                        interactor.allRecipesByCategory(nameCategory);
                }
                return false;
            }
        });
        popup.show();
    }
}
package com.example.octo_sdu.cookpartyv3.ingredients.view;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.ingredients.interactor.IngredientsInteractor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_ingredient)
    TextView textViewIngredient;
    @BindView(R.id.imageButton_ingredient)
    ImageButton imageButtonIngredient;

    IngredientsInteractor interactor;
    String nameCategory;

    public IngredientsViewHolder(View itemView, IngredientsInteractor interactor, String nameCategory) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.interactor = interactor;
        this.nameCategory = nameCategory;
    }

    public void bind(final String name){
        textViewIngredient.setText(name);
        imageButtonIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUpMenu(view, interactor, name);
            }
        });
    }

    private void showPopUpMenu(View view, final IngredientsInteractor interactor, final String name) {
        PopupMenu popup = new PopupMenu(view.getContext(),view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card_ingredient, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_delete_ingredient:
                        interactor.deleteIngredient(name, nameCategory);
                        interactor.allIngredientsByCategory(nameCategory);
                }
                return false;
            }
        });
        popup.show();
    }
}

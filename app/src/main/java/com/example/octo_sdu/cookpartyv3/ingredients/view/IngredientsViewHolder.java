package com.example.octo_sdu.cookpartyv3.ingredients.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.octo_sdu.cookpartyv3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_ingredient)
    TextView textViewIngredient;

    public IngredientsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String name){
        textViewIngredient.setText(name);
    }
}

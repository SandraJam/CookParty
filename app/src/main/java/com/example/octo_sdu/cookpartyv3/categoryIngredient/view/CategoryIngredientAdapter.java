package com.example.octo_sdu.cookpartyv3.categoryIngredient.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

import java.util.ArrayList;
import java.util.List;

public class CategoryIngredientAdapter extends RecyclerView.Adapter<CategoryIngredientViewHolder>{
    private List<CategoryIngredient> categoryIngredients = new ArrayList<>();

    public void setCategoryIngredients(List<CategoryIngredient> categoryIngredients) {
        this.categoryIngredients = categoryIngredients;
    }

    @Override
    public CategoryIngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryIngredientViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_ingredient, parent, false), null, null);
    }

    @Override
    public void onBindViewHolder(CategoryIngredientViewHolder holder, int position) {
        holder.bind(categoryIngredients.get(position).getName(), categoryIngredients.get(position).getDrawable());
    }

    @Override
    public int getItemCount() {
        return categoryIngredients.size();
    }
}

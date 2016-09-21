package com.example.octo_sdu.cookpartyv3.recipes.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.cookpartyv3.R;

import java.util.ArrayList;
import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesViewHolder> {
    List<RecipeModelView> recipeModelViewList = new ArrayList<>();
    String nameCategory;

    public RecipesAdapter(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_recipes, parent, false), nameCategory);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        holder.bind(recipeModelViewList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return recipeModelViewList.size();
    }

    public void setRecipeModelViewList(List<RecipeModelView> recipeModelViewList) {
        this.recipeModelViewList = recipeModelViewList;
    }
}

package com.example.octo_sdu.cookpartyv3.recipes.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.recipes.interactor.RecipesInteractor;

import java.util.ArrayList;
import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesViewHolder> {
    List<RecipeModel> recipeModelList = new ArrayList<>();
    RecipesInteractor recipesInteractor;
    String nameCategory;

    public RecipesAdapter(RecipesInteractor recipesInteractor, String nameCategory) {
        this.recipesInteractor = recipesInteractor;
        this.nameCategory = nameCategory;
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_recipes, parent, false), recipesInteractor, nameCategory);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        holder.bind(recipeModelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return recipeModelList.size();
    }

    public void setRecipeModelList(List<RecipeModel> recipeModelList) {
        this.recipeModelList = recipeModelList;
    }
}

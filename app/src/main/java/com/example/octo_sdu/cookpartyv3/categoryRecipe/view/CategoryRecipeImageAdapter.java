package com.example.octo_sdu.cookpartyv3.categoryRecipe.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.interactor.CategoryRecipeInteractor;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecipeImageAdapter  extends RecyclerView.Adapter<CategoryRecipeViewHolder> {
    private List<Integer> listImageDrawable= new ArrayList<>();
    private String name;
    private CategoryRecipeInteractor categoryRecipeInteractor;
    private MaterialDialog dialog = null;

    public CategoryRecipeImageAdapter(List<Integer> listImageDrawable, String name, CategoryRecipeInteractor categoryRecipeInteractor) {
        this.listImageDrawable = listImageDrawable;
        this.name = name;
        this.categoryRecipeInteractor = categoryRecipeInteractor;
    }

    @Override
    public CategoryRecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryRecipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_recipe, parent, false), categoryRecipeInteractor, dialog);
    }

    @Override
    public void onBindViewHolder(CategoryRecipeViewHolder holder, int position) {
        holder.bind(name, listImageDrawable.get(position));
    }

    @Override
    public int getItemCount() {
        return listImageDrawable.size();
    }

    public void setDialog(MaterialDialog dialog) {
        this.dialog = dialog;
    }
}

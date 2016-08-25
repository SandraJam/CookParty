package com.example.octo_sdu.cookpartyv3.categoryRecipe.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecipeViewAdapter extends RecyclerView.Adapter<CategoryRecipeViewHolder> {
    private List<CategoryRecipeRealm> categoryRecipeRealmList = new ArrayList<>();

    @Override
    public CategoryRecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryRecipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_recipe, parent, false), null, null);
    }

    @Override
    public void onBindViewHolder(CategoryRecipeViewHolder holder, int position) {
        holder.bind(categoryRecipeRealmList.get(position).getName(), categoryRecipeRealmList.get(position).getDraw());
    }

    @Override
    public int getItemCount() {
        return categoryRecipeRealmList.size();
    }

    public void setCategoryRecipeRealmList(List<CategoryRecipeRealm> categoryRecipeRealmList) {
        this.categoryRecipeRealmList = categoryRecipeRealmList;
    }
}

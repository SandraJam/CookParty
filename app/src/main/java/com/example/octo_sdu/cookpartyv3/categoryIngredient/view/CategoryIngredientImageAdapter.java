package com.example.octo_sdu.cookpartyv3.categoryIngredient.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientInteractor;

import java.util.ArrayList;
import java.util.List;

public class CategoryIngredientImageAdapter extends RecyclerView.Adapter<CategoryIngredientViewHolder> {
    private List<Integer> listImageDrawable= new ArrayList<>();
    private String name;
    private CategoryIngredientInteractor categoryIngredientInteractor;
    private MaterialDialog dialog;

    public CategoryIngredientImageAdapter(List<Integer> listImageDrawable, String name, CategoryIngredientInteractor categoryIngredientInteractor) {
        this.listImageDrawable = listImageDrawable;
        this.name = name;
        this.categoryIngredientInteractor = categoryIngredientInteractor;
    }

    @Override
    public CategoryIngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryIngredientViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_ingredient, parent, false), categoryIngredientInteractor, dialog);
    }

    @Override
    public void onBindViewHolder(CategoryIngredientViewHolder holder, int position) {
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

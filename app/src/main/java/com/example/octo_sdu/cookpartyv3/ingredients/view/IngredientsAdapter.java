package com.example.octo_sdu.cookpartyv3.ingredients.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientRealm;
import com.example.octo_sdu.cookpartyv3.ingredients.interactor.IngredientsInteractor;

import java.util.ArrayList;
import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {
    List<IngredientRealm> ingredientRealmList = new ArrayList<>();
    IngredientsInteractor ingredientsInteractor;
    String nameCategory;

    public IngredientsAdapter(IngredientsInteractor ingredientsInteractor, final String nameCategory) {
        this.ingredientsInteractor = ingredientsInteractor;
        this.nameCategory = nameCategory;
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IngredientsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_ingredient, parent, false), ingredientsInteractor, nameCategory);
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        holder.bind(ingredientRealmList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return ingredientRealmList.size();
    }

    public void setIngredientRealmList(List<IngredientRealm> ingredientRealmList) {
        this.ingredientRealmList = ingredientRealmList;
    }
}

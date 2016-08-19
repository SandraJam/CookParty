package com.example.octo_sdu.cookpartyv3.ingredients.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.back.pojo.Measure;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsPresenter;

import java.util.List;

public class IngredientsInteractorImpl implements IngredientsInteractor {
    private IngredientsPresenter ingredientsPresenter;
    private IngredientsRepository ingredientsRepository;
    private MeasuresRepository measuresRepository;

    public IngredientsInteractorImpl(IngredientsPresenter ingredientsPresenter, IngredientsRepository ingredientsRepository, MeasuresRepository measuresRepository) {
        this.ingredientsPresenter = ingredientsPresenter;
        this.ingredientsRepository = ingredientsRepository;
        this.measuresRepository = measuresRepository;
    }

    @Override
    public void allIngredientsByCategory(String category) {
        final List<Ingredient> ingredients = ingredientsRepository.allIngredientsByCategory(category);
        if (ingredients == null || ingredients.isEmpty()) {
            ingredientsPresenter.onEmpty();
        } else{
            ingredientsPresenter.onSuccess(ingredients);
        }
        final List<Measure> measures = measuresRepository.allMeasures();
        if (measures!= null) {
            String[] namesMeasures = new String[measures.size()];
            int i=0;
            for (Measure measure: measures) {
                namesMeasures[i]  = measure.getName();
                i++;
            }
            ingredientsPresenter.addPossibility(namesMeasures);
        }
    }

    @Override
    public void addIngredient(String name, String nameCategory, String nameMeasure) {
        ingredientsRepository.add(name, nameCategory, nameMeasure);
    }
}

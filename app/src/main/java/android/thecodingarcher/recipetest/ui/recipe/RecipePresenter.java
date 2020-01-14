package android.thecodingarcher.recipetest.ui.recipe;

import android.thecodingarcher.recipetest.data.local.RecipeStore;
import android.thecodingarcher.recipetest.data.model.Recipe;

public class RecipePresenter {

    private final RecipeStore store;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store) {
        this.store = store;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
    }
}

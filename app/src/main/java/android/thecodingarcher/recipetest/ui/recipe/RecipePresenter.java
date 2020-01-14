package android.thecodingarcher.recipetest.ui.recipe;

import android.thecodingarcher.recipetest.R;
import android.thecodingarcher.recipetest.data.local.RecipeStore;
import android.thecodingarcher.recipetest.data.model.Recipe;
import android.view.View;

public class RecipePresenter {

    private final RecipeStore store;
    private final RecipeContract.View view;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view) {
        this.store = store;
        this.view = view;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        }
    }
}

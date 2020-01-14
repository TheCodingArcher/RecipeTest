package android.thecodingarcher.recipetest.ui.recipe;

import android.thecodingarcher.recipetest.R;
import android.thecodingarcher.recipetest.data.local.Favorites;
import android.thecodingarcher.recipetest.data.local.RecipeStore;
import android.thecodingarcher.recipetest.data.model.Recipe;
import android.view.View;

public class RecipePresenter implements RecipeContract.Listener {

    private final RecipeStore store;
    private final RecipeContract.View view;
    private final Favorites favorites;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(recipe.id));
        }
    }

    public void toggleFavorite() {
        boolean result = favorites.toggle(recipe.id);
        view.setFavorite(result);
    }
}

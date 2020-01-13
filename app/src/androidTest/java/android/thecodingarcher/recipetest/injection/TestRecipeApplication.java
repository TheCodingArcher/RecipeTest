package android.thecodingarcher.recipetest.injection;

import android.thecodingarcher.recipetest.data.local.Favorites;
import android.thecodingarcher.recipetest.data.local.InMemoryFavorites;

import static org.junit.Assert.*;

public class TestRecipeApplication extends RecipeApplication {

    private final Favorites favorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
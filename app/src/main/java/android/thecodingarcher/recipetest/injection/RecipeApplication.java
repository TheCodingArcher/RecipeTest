package android.thecodingarcher.recipetest.injection;

import android.app.Application;
import android.thecodingarcher.recipetest.data.local.Favorites;
import android.thecodingarcher.recipetest.data.local.SharedPreferenceFavorites;

public class RecipeApplication extends Application {

    private Favorites favorites = null;

    public Favorites getFavorites() {
        if (favorites == null) {
            favorites = new SharedPreferenceFavorites(this);
        }
        return favorites;
    }
}

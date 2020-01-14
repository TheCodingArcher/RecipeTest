package android.thecodingarcher.recipetest.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.thecodingarcher.recipetest.R;
import android.thecodingarcher.recipetest.data.local.Favorites;
import android.thecodingarcher.recipetest.data.local.RecipeStore;
import android.thecodingarcher.recipetest.data.local.SharedPreferenceFavorites;
import android.thecodingarcher.recipetest.data.model.Recipe;
import android.thecodingarcher.recipetest.injection.RecipeApplication;
import android.view.View;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Step 1: Set up the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = findViewById(R.id.title);
        TextView descriptionView = findViewById(R.id.description);

        // Step 2: Load recipe from store
        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        RecipePresenter presenter = new RecipePresenter(store);
        presenter.loadRecipe(id);
//        final Recipe recipe = store.getRecipe(id);

        // Step 3: If recipe is null, show error
        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        // Step 4: If recipe is not null, show recipe
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites = app.getFavorites();
//        final SharedPreferenceFavorites favorites = new SharedPreferenceFavorites(this);
        boolean favorite = favorites.get(recipe.id);

        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        descriptionView.setText(recipe.description);

        // Step 5: When title is clicked, toggle favorites
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = favorites.toggle(recipe.id);
                titleView.setSelected(result);
            }
        });
    }
}

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

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {

    public static final String KEY_ID = "id";
    private TextView titleView;
    private TextView descriptionView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleView = findViewById(R.id.title);
        descriptionView = findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites = app.getFavorites();
        final RecipePresenter presenter = new RecipePresenter(store, this, favorites);
        presenter.loadRecipe(id);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.toggleFavorite();
            }
        });
    }

    @Override
    public void showRecipeNotFoundError() {
        titleView.setVisibility(View.GONE);
        descriptionView.setText(R.string.recipe_not_found);
    }

    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setDescription(String description) {
        descriptionView.setText(description);
    }

    @Override
    public void setFavorite(boolean favorite) {
        titleView.setSelected(favorite);
    }
}

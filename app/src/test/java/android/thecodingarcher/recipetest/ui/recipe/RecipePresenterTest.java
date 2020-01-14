package android.thecodingarcher.recipetest.ui.recipe;

import android.thecodingarcher.recipetest.data.local.Favorites;
import android.thecodingarcher.recipetest.data.local.RecipeStore;

import org.junit.Before;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RecipePresenterTest {

    private RecipeStore store;
    private Favorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;

    @Before
    public void setup() {
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(Favorites.class);
        view = Mockito.mock(RecipeContract.View.class);
        presenter = new RecipePresenter(store, view, favorites);
    }
}
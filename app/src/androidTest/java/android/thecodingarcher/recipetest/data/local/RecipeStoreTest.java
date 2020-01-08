package android.thecodingarcher.recipetest.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.thecodingarcher.recipetest.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    @Test
    public void countRecipes() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());
    }

    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding", recipe.id);
        assertEquals("Chocolate Pudding", recipe.title);
    }
}
package android.thecodingarcher.recipetest.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.thecodingarcher.recipetest.R;
import android.thecodingarcher.recipetest.data.local.InMemoryFavorites;
import android.thecodingarcher.recipetest.injection.TestRecipeApplication;
import android.thecodingarcher.recipetest.test.RecipeRobot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class RecipeActivityTest {

    private static final String CARROT_ID = "creamed_carrots";

    @Rule
    public ActivityTestRule<RecipeActivity> activityRule = new ActivityTestRule<>(
            RecipeActivity.class, true, false
    );

    @Test
    public void recipeNotFound() {
        new RecipeRobot()
                .launch(activityRule)
                .noTitle()
                .description(R.string.recipe_not_found);

        /*activityRule.launchActivity(null);
        onView(withId(R.id.description))
                .check(matches(withText(R.string.recipe_not_found)));

        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));*/
    }

    @Test
    public void clickToFavorite() {
        launchRecipe(CARROT_ID);

        onView(withId(R.id.title))
                .check(matches(withText("Creamed Carrots")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));
    }

    @Test
    public void alreadyFavorite() {
        new RecipeRobot()
                .setFavorite(CARROT_ID)
                .launch(activityRule, CARROT_ID)
                .isFavorite();

        /*favorites.put(CARROT_ID, true);
        launchRecipe(CARROT_ID);

        onView(withId(R.id.title))
                .check(matches(isSelected()));*/
    }

    private void launchRecipe(String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        activityRule.launchActivity(intent);
    }
}
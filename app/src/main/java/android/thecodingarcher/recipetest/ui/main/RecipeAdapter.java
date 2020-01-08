package android.thecodingarcher.recipetest.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.thecodingarcher.recipetest.R;
import android.thecodingarcher.recipetest.data.local.RecipeStore;
import android.thecodingarcher.recipetest.data.model.Recipe;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {
        this.store = store;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {
        final Recipe recipe = store.recipes.get(position);
        recipeViewHolder.textView.setText(recipe.title);
    }

    @Override
    public int getItemCount() {
        return store.recipes.size();
    }
}

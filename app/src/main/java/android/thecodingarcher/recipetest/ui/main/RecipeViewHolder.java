package android.thecodingarcher.recipetest.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final TextView textView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}

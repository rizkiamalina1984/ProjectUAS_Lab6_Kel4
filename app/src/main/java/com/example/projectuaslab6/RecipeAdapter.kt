package com.example.projectuaslab6

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.recipeTitle)
        val description: TextView = view.findViewById(R.id.recipeDescription)
        val time: TextView = view.findViewById(R.id.recipeTime)
        val level: TextView = view.findViewById(R.id.recipeLevel)
        val image: ImageView = view.findViewById(R.id.recipeImage)
        val favoriteIcon: ImageView = view.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.title.text = recipe.title
        holder.description.text = recipe.description
        holder.time.text = recipe.time
        holder.level.text = recipe.level
        holder.image.setImageResource(recipe.imageResource)
        holder.favoriteIcon.setOnClickListener {
            // Handle favorite click
        }
    }

    override fun getItemCount() = recipes.size
}

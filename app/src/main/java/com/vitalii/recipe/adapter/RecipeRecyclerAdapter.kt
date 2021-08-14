package com.vitalii.recipe.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vitalii.recipe.R
import com.vitalii.recipe.pojo.Recipe

class RecipeRecyclerAdapter(private var recipeList:List<Recipe> = ArrayList<Recipe>()) : RecyclerView.Adapter<RecipeRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recipe_item_for_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val TAG = "asgsdgsdg"
        Log.i(TAG, "element: $position")
        holder.tvRecipe?.text = recipeList[position].title
        Glide.with(holder.ivRecipe as View)
            .load(recipeList[position].image)
            .thumbnail(0.33f)
            .centerCrop()
            .into(holder.ivRecipe!!)
    }

    override fun getItemCount(): Int {
        return recipeList.size;
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivRecipe: ImageView? = null
        var tvRecipe: TextView? = null

        init {
            ivRecipe = itemView.findViewById(R.id.iv_recipe)
            tvRecipe = itemView.findViewById(R.id.tv_recipe)
        }
    }

}
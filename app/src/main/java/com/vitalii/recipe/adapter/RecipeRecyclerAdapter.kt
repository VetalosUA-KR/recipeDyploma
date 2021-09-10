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
import com.vitalii.recipe.pojo.recipeList.Recipe

class RecipeRecyclerAdapter(
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<RecipeRecyclerAdapter.MyViewHolder>(){


    var TAG = "recipeRecyclerView"
    public var recipeList:MutableList<Recipe> = ArrayList<Recipe>()

    fun setData(list: MutableList<Recipe>) {
        //Log.i(TAG, "size:  ${list.size}")
        recipeList = list
        notifyDataSetChanged()
    }

    fun setData(recipe: Recipe) {
        Log.i(TAG, "size:  ${recipeList.size}")
        recipeList.add(recipe)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recipe_item_for_adapter, parent, false)
        return MyViewHolder(itemView, onItemClicked)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
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

    class MyViewHolder(itemView: View, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var ivRecipe: ImageView? = null
        var tvRecipe: TextView? = null


        init {
            ivRecipe = itemView.findViewById(R.id.iv_recipe)
            tvRecipe = itemView.findViewById(R.id.tv_recipe)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }

    }



}


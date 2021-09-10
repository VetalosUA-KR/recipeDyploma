package com.vitalii.recipe.db

import androidx.lifecycle.LiveData

class RecipeRepository(private val recipeDao: RecipeModelDao ) {

    val readAllData: LiveData<List<FavoriteRecipe>> = recipeDao.getAllData()

    suspend fun addRecipe(recipe: FavoriteRecipe) {
        recipeDao.addRecipe(recipe)
    }

    fun deleteRecipe(recipe: FavoriteRecipe) {
        recipeDao.deleteRecipe(recipe)
    }

    fun isRecipeExist(id: Int) : Boolean {
        return  recipeDao.isRecipeExist(id = id)
    }

    fun getRecipeById(id: Int) :FavoriteRecipe {
        return recipeDao.getRecipe(id)
    }

}



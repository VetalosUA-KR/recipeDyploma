package com.vitalii.recipe.db

import androidx.lifecycle.LiveData
import com.vitalii.recipe.pojo.recipeList.Recipe

class RecipeRepository(private val recipeDao: RecipeModelDao ) {

    val readAllData: LiveData<List<FavoriteRecipe>> = recipeDao.getAllData()


    suspend fun addRecipe(recipe: FavoriteRecipe) {
        recipeDao.addRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: FavoriteRecipe) {
        recipeDao.deleteRecipe(recipe)
    }

    fun getRecipe(id: Int) : FavoriteRecipe {
        return  recipeDao.getRecipeById(id = id)
    }

}
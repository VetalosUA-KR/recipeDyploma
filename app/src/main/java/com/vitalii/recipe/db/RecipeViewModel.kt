package com.vitalii.recipe.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<FavoriteRecipe>>
    private val repository: RecipeRepository

    init {
        val recipeDao = MyDatabase.getDatabase(application).recipeDAO()
        repository = RecipeRepository(recipeDao)
        readAllData = repository.readAllData
    }

    fun addRecipe(recipe: FavoriteRecipe) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRecipe(recipe)
        }
    }

    fun deleteRecipe(recipe: FavoriteRecipe) {
        repository.deleteRecipe(recipe)
    }

    fun isRecipeExist(id: Int): Boolean {
        return repository.isRecipeExist(id)
    }

}



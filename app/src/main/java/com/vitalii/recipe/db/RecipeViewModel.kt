package com.vitalii.recipe.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vitalii.recipe.pojo.recipeList.Recipe
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
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRecipe(recipe)
        }
    }

    fun getRecipe(id: Int): FavoriteRecipe {
        var recipe: FavoriteRecipe = repository.getRecipe(id);
        return recipe
    }

    /*suspend fun gr(id: Int): FavoriteRecipe {
        return withContext(Dispatchers.Default) {
            getRecipe(id)
        }
    }*/

    fun gr(id: Int): FavoriteRecipe {
        var fav = FavoriteRecipe(0);
        viewModelScope.launch(Dispatchers.IO) {
            fav = repository.getRecipe(id)
        }
        return fav
    }

}
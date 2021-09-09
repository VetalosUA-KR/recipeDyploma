package com.vitalii.recipe.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vitalii.recipe.pojo.recipeList.Recipe

@Dao
interface RecipeModelDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipe(rec: FavoriteRecipe)

    @Query("select * from FavoriteRecipe")
    fun getAllData():LiveData<List<FavoriteRecipe>>

    @Delete
    fun deleteRecipe(model: FavoriteRecipe)

    @Query("select * from FavoriteRecipe where recipe_id=:id")
    fun getRecipeById(id: Int): FavoriteRecipe


}
package com.vitalii.recipe.retrofit

import com.vitalii.recipe.pojo.recipeDetail.RecipeDetail
import com.vitalii.recipe.pojo.recipeList.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val API_KEY: String  = "f1ffc3656c524ce984c5876f60e3db52";

interface RetrofitServices {

    @GET("findByIngredients?apiKey=$API_KEY&number=30")
    fun getRecipeByIngredients(@Query("ingredients") aParam: String?) : Call<MutableList<Recipe>>

    @GET("{id}/information?apiKey=$API_KEY&")
    fun getRecipeByIDForDetail(@Path("id") id: Int) : Call<RecipeDetail>

    @GET("{id}/information?apiKey=$API_KEY&")
    fun getRecipeByIDForFavorite(@Path("id") id: Int) : Call<Recipe>

}



















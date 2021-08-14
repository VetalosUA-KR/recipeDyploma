package com.vitalii.recipe.retrofit

import com.vitalii.recipe.pojo.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {
    //BASE_URL = "https://api.spoonacular.com/recipes/"
    //https://api.spoonacular.com/recipes/findByIngredients?apiKey=bf63200886cd4dc595d8d02421308cf7&ingredients=chiken,+flour,+chees
    @GET("findByIngredients?apiKey=bf63200886cd4dc595d8d02421308cf7&ingredients=chiken,+flour,+chees")
    fun getMovieList(): Call<MutableList<Recipe>>

    /**
     * @GET("myObjects/{id}")
    fun myObjectById(@Path("id") id: Int?, @Query("a_param") aParam: String?): Call<MyObject>
     */
    @GET("findByIngredients?apiKey=bf63200886cd4dc595d8d02421308cf7&")
    fun getRecipeByIngredients(@Query("ingredients") aParam: String?) : Call<MutableList<Recipe>>


    //https://api.spoonacular.com/recipes/{id}/information
    //https://api.spoonacular.com/recipes/1181931/information?apiKey=bf63200886cd4dc595d8d02421308cf7&
    @GET("{id}/information?apiKey=bf63200886cd4dc595d8d02421308cf7&")
    fun getRecipeByID(@Path("id") id: Int) : Call<Recipe>
}



















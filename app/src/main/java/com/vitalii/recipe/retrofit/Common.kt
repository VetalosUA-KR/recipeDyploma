package com.vitalii.recipe.retrofit

object Common {
    //https://api.spoonacular.com/recipes/findByIngredients?apiKey=bf63200886cd4dc595d8d02421308cf7&ingredients=chiken,+flour,+chees
    private val BASE_URL = "https://api.spoonacular.com/recipes/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}
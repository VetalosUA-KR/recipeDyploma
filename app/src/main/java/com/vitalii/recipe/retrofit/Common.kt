package com.vitalii.recipe.retrofit

object Common {
    private val BASE_URL = "https://api.spoonacular.com/recipes/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}




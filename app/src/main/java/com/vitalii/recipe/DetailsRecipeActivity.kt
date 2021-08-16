package com.vitalii.recipe

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vitalii.recipe.pojo.Recipe
import com.vitalii.recipe.retrofit.Common
import com.vitalii.recipe.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class DetailsRecipeActivity : AppCompatActivity() {

    var TAG = "TATATA"
    private var recipe_id: Int = 0
    lateinit var mServices: RetrofitServices

    lateinit var recipePic :ImageView
    lateinit var recipeTitle :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_recipe)

        recipePic = findViewById(R.id.imageView_recipe)
        recipeTitle = findViewById(R.id.title_recipe)


        var bundle :Bundle ?= intent.extras
        recipe_id = bundle!!.getInt("recipe_id") // 1

        Log.i(TAG, "onCreate: $recipe_id")

        mServices = Common.retrofitService


        mServices.getRecipeByID(recipe_id).enqueue(object : Callback<Recipe>{
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                Glide.with(recipePic)
                    .load(response.body()?.image)
                    .thumbnail(0.33f)
                    .centerCrop()
                    .into(recipePic)

                recipeTitle.setText(response.body()?.title)
            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {

            }
        })

    }

}
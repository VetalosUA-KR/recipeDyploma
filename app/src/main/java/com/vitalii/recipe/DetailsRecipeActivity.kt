package com.vitalii.recipe

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vitalii.recipe.pojo.recipeDetail.AnalyzedInstruction
import com.vitalii.recipe.pojo.recipeDetail.RecipeDetail
import com.vitalii.recipe.pojo.recipeList.Recipe
import com.vitalii.recipe.retrofit.Common
import com.vitalii.recipe.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class DetailsRecipeActivity : AppCompatActivity() {

    var TAG = "detailRecipeActivity"
    private var recipe_id: Int = 0
    lateinit var mServices: RetrofitServices

    lateinit var recipePic :ImageView
    lateinit var recipeTitle :TextView
    lateinit var recipeStep :TextView
    lateinit var recipeSummary :TextView
    lateinit var favorite: ImageButton
    var isFav:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_recipe)

        recipePic = findViewById(R.id.imageView_recipe)
        recipeTitle = findViewById(R.id.title_recipe)
        recipeStep = findViewById(R.id.tv_step)
        recipeSummary = findViewById(R.id.tv_summary)
        favorite = findViewById(R.id.ib_favorite)


        var bundle :Bundle ?= intent.extras
        recipe_id = bundle!!.getInt("recipe_id") // 1

        Log.i(TAG, "onCreate: $recipe_id")

        mServices = Common.retrofitService



        mServices.getRecipeByID(recipe_id).enqueue(object : Callback<RecipeDetail>{
            override fun onResponse(call: Call<RecipeDetail>, response: Response<RecipeDetail>) {
                fillHeader(response)
                recipeSummary.text = Html.fromHtml(response.body()?.summary)

                fillSteps(response)

                response.body()?.toString()?.let { Log.i(TAG, it) }
            }

            override fun onFailure(call: Call<RecipeDetail>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })

        initIsFavorite()
        favorite.setOnClickListener(View.OnClickListener {
            initIsFavorite()
        })

    }

    private fun initIsFavorite() {
        isFav = !isFav
        if (isFav) {
            favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
        } else {
            favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)

        }
    }

    private fun fillHeader(response: Response<RecipeDetail>) {
        Glide.with(recipePic)
            .load(response.body()?.image)
            .thumbnail(0.33f)
            .centerCrop()
            .into(recipePic)
        recipeTitle.text = response.body()?.title
    }

    private fun fillSteps(response: Response<RecipeDetail>) {
        var inst: List<AnalyzedInstruction> = response.body()?.analyzedInstructions!!
        var stepToCook: StringBuffer = StringBuffer("")
        for (instruction in inst) {
            for (step in instruction.steps!!) {
                stepToCook.append("\nStep: ${step.number}\n${step.step}")
            }
        }
        recipeStep.text = stepToCook
    }

}
package com.vitalii.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vitalii.recipe.adapter.RecipeRecyclerAdapter
import com.vitalii.recipe.db.RecipeViewModel
import com.vitalii.recipe.pojo.recipeList.Recipe
import com.vitalii.recipe.retrofit.Common
import com.vitalii.recipe.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteRecipesActivity : AppCompatActivity() {

    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var recyclerView: RecyclerView
    private var listRecipe: MutableList<Recipe> = ArrayList<Recipe>()
    private lateinit var mServices:RetrofitServices
    lateinit var adapter: RecipeRecyclerAdapter
    val TAG = "favoriteRecipeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_recipes)

        recyclerView = findViewById(R.id.recyclerView)
        mServices = Common.retrofitService

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecipeRecyclerAdapter {
                position -> onListItemClick(position)
        }
        recyclerView.adapter = adapter



        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        recipeViewModel.readAllData.observe(this, Observer {
            //adapter.setData(it)
            for (favRec in it) {
                //Log.i(TAG, "id:   ${favRec.recipe_id}" )
                getRecipeById(favRec.recipe_id)
            }

        })
    }


    private fun getRecipeById(id: Int)  {
        mServices.getRecipeByIDForFavorite(id).enqueue(object :
        Callback<Recipe>{
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {

                listRecipe.add(response.body()!!)
                adapter.setData(response.body()!!)
            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Log.i(TAG, (t.message!!))
            }
        })
    }

    private fun onListItemClick(position: Int) {
        Log.i(TAG, "position:  $position")
        Log.i(TAG, "id to detail:   "+listRecipe.get(position).id )
        val intent = Intent(this, DetailsRecipeActivity::class.java)
        intent.putExtra("recipe_id", listRecipe.get(position).id)
        startActivity(intent)
    }
}
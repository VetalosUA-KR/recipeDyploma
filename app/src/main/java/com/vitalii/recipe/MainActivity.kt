package com.vitalii.recipe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vitalii.recipe.adapter.RecipeRecyclerAdapter
import com.vitalii.recipe.pojo.Recipe
import com.vitalii.recipe.retrofit.Common
import com.vitalii.recipe.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var list: List<Recipe>
    lateinit var mServices: RetrofitServices
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecipeRecyclerAdapter

    var TAG = "TATATA"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mServices = Common.retrofitService


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecipeRecyclerAdapter {
                position -> onListItemClick(position)
        }
        recyclerView.adapter = adapter

        getRecipe()

        //"chiken,+flour,+chees"
        /*mServices.getRecipeByID(1181931).enqueue(object : Callback<Recipe> {
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {

            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Log.i(TAG, (t.message!!))
            }
        })*/
    }

    private fun getQuery(vararg strings: String) : String {
        var query : String = "";
        for(str in strings)
            query += str+",+"
        return query
    }


    private fun getRecipe() : List<Recipe> {
        var recipeList : List<Recipe> = ArrayList<Recipe>()
        mServices.getRecipeByIngredients(getQuery("chiken", "potato")).enqueue(object :
            Callback<MutableList<Recipe>> {
            override fun onResponse(
                call: Call<MutableList<Recipe>>,
                response: Response<MutableList<Recipe>>
            ) {
                adapter.setData(response.body()!!)
                Log.i(TAG, "onResponse: ${response.body()!!.size}")
            }

            override fun onFailure(call: Call<MutableList<Recipe>>, t: Throwable) {
                Log.i(TAG, (t.message!!))
            }
        })

        Log.i(TAG, "getRecipe: size: ${recipeList.size}")
        return recipeList
    }

    fun onListItemClick(pos: Int) {
        Log.i(TAG, "onListItemClick: $pos")
    }
}
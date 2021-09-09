package com.vitalii.recipe

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vitalii.recipe.adapter.RecipeRecyclerAdapter
import com.vitalii.recipe.db.FavoriteRecipe
import com.vitalii.recipe.db.RecipeViewModel
import com.vitalii.recipe.pojo.recipeList.Recipe
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
    lateinit var fabSearch: FloatingActionButton
    lateinit var fabFavorite: FloatingActionButton
    lateinit var globalRequest: String

    var TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mServices = Common.retrofitService
        globalRequest = "chicken"

        fabSearch = findViewById(R.id.fab_search)
        fabFavorite = findViewById(R.id.fab_favorite)


        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecipeRecyclerAdapter {
                position -> onListItemClick(position)
        }
        recyclerView.adapter = adapter

        getRecipe(globalRequest)



        fabSearch.setOnClickListener(View.OnClickListener {
            var li : LayoutInflater = LayoutInflater.from(this);
            var view : View = li.inflate(R.layout.for_search_recipe, null)
            var userInput: EditText = view.findViewById(R.id.input_text)
            userInput.setText(globalRequest)
            val dialogBuilder = MaterialAlertDialogBuilder(this)
                .setView(view)
                .setCancelable(false)
                .setPositiveButton("Search",
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.i(TAG, "search:  ${userInput.text}")
                        globalRequest = userInput.text.toString()
                        getRecipe(globalRequest)
                    })
                .setNegativeButton("Cancel", null)
                .create()
                .show()
        })

        fabFavorite.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FavoriteRecipesActivity::class.java)
            startActivity(intent)
        })
    }

    private fun getQuery(vararg strings: String) : String {
        var query : String = "";
        for(str in strings)
            query += str+","
        return query
    }


    private fun getRecipe(query: String) : List<Recipe> {
        list  = ArrayList<Recipe>()
        mServices.getRecipeByIngredients(getQuery(query)).enqueue(object :
            Callback<MutableList<Recipe>> {
            override fun onResponse(
                call: Call<MutableList<Recipe>>,
                response: Response<MutableList<Recipe>>
            ) {
                list = response.body()!!
                adapter.setData(response.body()!!)
            }

            override fun onFailure(call: Call<MutableList<Recipe>>, t: Throwable) {
                Log.i(TAG, (t.message!!))
            }
        })
        return list
    }

    fun onListItemClick(pos: Int) {
        Log.i(TAG, "recipe_id: $list.get(pos).id")

        val intent = Intent(this, DetailsRecipeActivity::class.java)
        intent.putExtra("recipe_id", list.get(pos).id)
        startActivity(intent)

    }
}













































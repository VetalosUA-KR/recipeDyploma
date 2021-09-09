package com.vitalii.recipe.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteRecipe::class], version = 3, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun recipeDAO() : RecipeModelDao

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "recipeDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as MyDatabase
        }
    }
}
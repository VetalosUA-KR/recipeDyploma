package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ingredient {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("localizedName")
    @Expose
    var localizedName: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null
    override fun toString(): String {
        return "Ingredient(" +
                "id=$id, " +
                "name=$name, " +
                "localizedName=$localizedName, " +
                "image=$image" +
                ")"
    }


}
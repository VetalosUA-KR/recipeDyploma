package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Length {
    @SerializedName("number")
    @Expose
    var number: Int? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null
}
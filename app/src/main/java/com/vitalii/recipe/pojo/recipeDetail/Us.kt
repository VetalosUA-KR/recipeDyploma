package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Us {
    @SerializedName("amount")
    @Expose
    var amount: Float? = null

    @SerializedName("unitShort")
    @Expose
    var unitShort: String? = null

    @SerializedName("unitLong")
    @Expose
    var unitLong: String? = null
}
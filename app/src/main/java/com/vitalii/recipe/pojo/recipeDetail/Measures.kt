package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Measures {
    @SerializedName("us")
    @Expose
    var us: Us? = null

    @SerializedName("metric")
    @Expose
    var metric: Metric? = null
}
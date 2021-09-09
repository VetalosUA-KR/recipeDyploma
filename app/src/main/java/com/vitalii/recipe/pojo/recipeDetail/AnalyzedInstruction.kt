package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AnalyzedInstruction {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("steps")
    @Expose
    var steps: List<Step>? = null

}
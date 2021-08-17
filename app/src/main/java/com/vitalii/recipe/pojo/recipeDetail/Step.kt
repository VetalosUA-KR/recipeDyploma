package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Step {
    @SerializedName("number")
    @Expose
    var number: Int? = null

    @SerializedName("step")
    @Expose
    var step: String? = null

    @SerializedName("ingredients")
    @Expose
    var ingredients: List<Ingredient>? = null

    @SerializedName("equipment")
    @Expose
    var equipment: List<Equipment>? = null

    @SerializedName("length")
    @Expose
    var length: Length? = null


    override fun toString(): String {
        return "\nStep(" +
                "number=$number, " +
                "step=$step, " +
                "ingredients=$ingredients, " +
                "equipment=$equipment, " +
                "length=$length" +
                ")"
    }


}
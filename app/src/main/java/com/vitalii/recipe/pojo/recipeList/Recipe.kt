package com.vitalii.recipe.pojo.recipeList

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Recipe : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("imageType")
    @Expose
    var imageType: String? = null

    @SerializedName("usedIngredientCount")
    @Expose
    var usedIngredientCount: Int? = null

    @SerializedName("missedIngredientCount")
    @Expose
    var missedIngredientCount: Int? = null

    @SerializedName("missedIngredients")
    @Expose
    var missedIngredients: List<MissedIngredient>? = null

    @SerializedName("usedIngredients")
    @Expose
    var usedIngredients: List<Any>? = null

    @SerializedName("unusedIngredients")
    @Expose
    var unusedIngredients: List<Any>? = null

    @SerializedName("likes")
    @Expose
    var likes: Int? = null

    companion object {
        private const val serialVersionUID = 8323775344626603038L
    }

    override fun toString(): String {
        return "Recipe(" +"\n\n\n"+
                "id=$id, " +"\n\n\n"+
                "title=$title, " +"\n\n\n"+
                "image=$image, " +"\n\n\n"+
                "imageType=$imageType, " +"\n\n\n"+
                "usedIngredientCount=$usedIngredientCount, " +"\n\n\n"+
                "missedIngredientCount=$missedIngredientCount, " +"\n\n\n"+
                "missedIngredients=$missedIngredients, " +"\n\n\n"+
                "usedIngredients=$usedIngredients, " +"\n\n\n"+
                "unusedIngredients=$unusedIngredients, " +"\n\n\n"+
                "likes=$likes" +"\n\n\n"+
                ")"
    }


}
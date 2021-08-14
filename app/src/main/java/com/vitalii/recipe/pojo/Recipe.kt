package com.vitalii.recipe.pojo

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
        return "Recipe(" +"\n"+
                "id=$id, " +"\n"+
                "title=$title, " +"\n"+
                "image=$image, " +"\n"+
                "imageType=$imageType, " +"\n"+
                "usedIngredientCount=$usedIngredientCount, " +"\n"+
                "missedIngredientCount=$missedIngredientCount, " +"\n"+
                "missedIngredients=$missedIngredients, " +"\n"+
                "usedIngredients=$usedIngredients, " +"\n"+
                "unusedIngredients=$unusedIngredients, " +"\n"+
                "likes=$likes" +"\n"+
                ")"
    }


}
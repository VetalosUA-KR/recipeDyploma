package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecipeDetail{


    @SerializedName("isFavorite")
    @Expose
    var isFavorite: Boolean? = false

    @SerializedName("vegetarian")
    @Expose
    var vegetarian: Boolean? = null

    @SerializedName("vegan")
    @Expose
    var vegan: Boolean? = null

    @SerializedName("glutenFree")
    @Expose
    var glutenFree: Boolean? = null

    @SerializedName("dairyFree")
    @Expose
    var dairyFree: Boolean? = null

    @SerializedName("veryHealthy")
    @Expose
    var veryHealthy: Boolean? = null

    @SerializedName("cheap")
    @Expose
    var cheap: Boolean? = null

    @SerializedName("veryPopular")
    @Expose
    var veryPopular: Boolean? = null

    @SerializedName("sustainable")
    @Expose
    var sustainable: Boolean? = null

    @SerializedName("weightWatcherSmartPoints")
    @Expose
    var weightWatcherSmartPoints: Int? = null

    @SerializedName("gaps")
    @Expose
    var gaps: String? = null

    @SerializedName("lowFodmap")
    @Expose
    var lowFodmap: Boolean? = null

    @SerializedName("preparationMinutes")
    @Expose
    var preparationMinutes: Int? = null

    @SerializedName("cookingMinutes")
    @Expose
    var cookingMinutes: Int? = null

    @SerializedName("aggregateLikes")
    @Expose
    var aggregateLikes: Int? = null

    @SerializedName("spoonacularScore")
    @Expose
    var spoonacularScore: Double? = null

    @SerializedName("healthScore")
    @Expose
    var healthScore: Double? = null

    @SerializedName("creditsText")
    @Expose
    var creditsText: String? = null

    @SerializedName("sourceName")
    @Expose
    var sourceName: String? = null

    @SerializedName("pricePerServing")
    @Expose
    var pricePerServing: Double? = null

    @SerializedName("extendedIngredients")
    @Expose
    var extendedIngredients: List<ExtendedIngredient>? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("readyInMinutes")
    @Expose
    var readyInMinutes: Int? = null

    @SerializedName("servings")
    @Expose
    var servings: Int? = null

    @SerializedName("sourceUrl")
    @Expose
    var sourceUrl: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("imageType")
    @Expose
    var imageType: String? = null

    @SerializedName("summary")
    @Expose
    var summary: String? = null

    @SerializedName("cuisines")
    @Expose
    var cuisines: List<String>? = null

    @SerializedName("dishTypes")
    @Expose
    var dishTypes: List<String>? = null

    @SerializedName("diets")
    @Expose
    var diets: List<String>? = null

    @SerializedName("occasions")
    @Expose
    var occasions: List<Any>? = null

    @SerializedName("winePairing")
    @Expose
    var winePairing: WinePairing? = null

    @SerializedName("instructions")
    @Expose
    var instructions: String? = null

    @SerializedName("analyzedInstructions")
    @Expose
    var analyzedInstructions: List<AnalyzedInstruction>? = null

    @SerializedName("originalId")
    @Expose
    var originalId: Any? = null


}
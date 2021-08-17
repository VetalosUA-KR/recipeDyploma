package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class WinePairing {
    @SerializedName("pairedWines")
    @Expose
    var pairedWines: List<Any>? = null

    @SerializedName("pairingText")
    @Expose
    var pairingText: String? = null

    @SerializedName("productMatches")
    @Expose
    var productMatches: List<Any>? = null
}
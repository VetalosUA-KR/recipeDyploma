package com.vitalii.recipe.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MissedIngredient : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("amount")
    @Expose
    var amount: Double? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null

    @SerializedName("unitLong")
    @Expose
    var unitLong: String? = null

    @SerializedName("unitShort")
    @Expose
    var unitShort: String? = null

    @SerializedName("aisle")
    @Expose
    var aisle: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("original")
    @Expose
    var original: String? = null

    @SerializedName("originalString")
    @Expose
    var originalString: String? = null

    @SerializedName("originalName")
    @Expose
    var originalName: String? = null

    @SerializedName("metaInformation")
    @Expose
    var metaInformation: List<String>? = null

    @SerializedName("meta")
    @Expose
    var meta: List<String>? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("extendedName")
    @Expose
    var extendedName: String? = null

    companion object {
        private const val serialVersionUID = 2785243931711798529L
    }
}
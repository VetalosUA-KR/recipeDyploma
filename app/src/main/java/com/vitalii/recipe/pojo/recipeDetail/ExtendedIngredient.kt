package com.vitalii.recipe.pojo.recipeDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExtendedIngredient {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("aisle")
    @Expose
    var aisle: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("consistency")
    @Expose
    var consistency: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("nameClean")
    @Expose
    var nameClean: String? = null

    @SerializedName("original")
    @Expose
    var original: String? = null

    @SerializedName("originalString")
    @Expose
    var originalString: String? = null

    @SerializedName("originalName")
    @Expose
    var originalName: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Float? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null

    @SerializedName("meta")
    @Expose
    var meta: List<String>? = null

    @SerializedName("metaInformation")
    @Expose
    var metaInformation: List<String>? = null

    @SerializedName("measures")
    @Expose
    var measures: Measures? = null
    override fun toString(): String {
        return "\nExtendedIngredient(" +
                "id=$id, " +
                "aisle=$aisle, " +
                "image=$image, " +
                "consistency=$consistency, " +
                "name=$name, " +
                "nameClean=$nameClean, " +
                "original=$original, " +
                "originalString=$originalString, " +
                "originalName=$originalName, " +
                "amount=$amount, " +
                "unit=$unit, " +
                "meta=$meta, " +
                "metaInformation=$metaInformation, " +
                "measures=$measures" +
                ")"
    }


}
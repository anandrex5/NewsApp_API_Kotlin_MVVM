package com.example.newsapp1.model.datamodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PojoItemItem(

    @SerializedName("articles")
    val pojoItem: List<PojoItemItem>,
    val tagline: String,
    val name: String,
    val description: String,
    val image_url: String,
    val first_brewed: String,





//    @SerializedName("description")
//    val description: String,
//    @SerializedName("name")
//    val name: String,
//    @SerializedName("tagline")
//    val tagline: String,


//    val abv: Double,
//    val attenuation_level: Double,
//    val boil_volume: BoilVolume,
//    val brewers_tips: String,
//    val contributed_by: String,
//    val ebc: Int,
//    val first_brewed: String,
//    val food_pairing: List<String>,
//    val ibu: Double,
//    val id: Int,
//    val image_url: String,
//    val ingredients: Ingredients,
//    val method: Method,
//    val ph: Double,
//    val srm: Double,
//    val target_fg: Int,
//    val target_og: Double,
//    val volume: Volume
): Parcelable
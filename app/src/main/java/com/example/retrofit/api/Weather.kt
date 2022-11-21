package com.example.retrofit.api

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("temp") var temp          : Int?    = null,
    @SerializedName("date") var date          : String? = null,
    @SerializedName("time") var time          : String? = null,
    @SerializedName("condition_code") var conditionCode : String? = null,
    @SerializedName("description") var description   : String? = null,
    @SerializedName("currently") var currently     : String? = null,
    @SerializedName("cid") var cid           : String? = null,
    @SerializedName("city") var city          : String? = null,
    @SerializedName("img_id" ) var imgId         : String? = null,
    @SerializedName("humidity") var humidity      : Int?    = null,
    @SerializedName("cloudiness") var cloudiness    : Int?    = null,
    @SerializedName("rain") var rain          : Int?    = null,
    @SerializedName("wind_speedy") var windSpeedy    : String? = null,
    @SerializedName("wind_direction") var windDirection : Int?    = null,
    @SerializedName("sunrise") var sunrise       : String? = null,
    @SerializedName("sunset") var sunset        : String? = null,
    @SerializedName("condition_slug") var conditionSlug : String? = null,
    @SerializedName("city_name") var cityName      : String? = null

)
package com.example.data.codemodel

import com.example.domain.codemodel.Suggests
import com.google.gson.annotations.SerializedName


data class SuggestsDto (

    @SerializedName("country_id"         ) var countryId         : Int?     = null,
    @SerializedName("disputed_territory" ) var disputedTerritory : Boolean? = null,
    @SerializedName("full_title"         ) var fullTitle         : String?  = null,
    @SerializedName("full_title_en"      ) var fullTitleEn       : String?  = null,
    @SerializedName("full_title_ru"      ) var fullTitleRu       : String?  = null,
    @SerializedName("full_title_uk"      ) var fullTitleUk       : String?  = null,
    @SerializedName("id"                 ) var id                : Int?     = null,
    @SerializedName("majority"           ) var majority          : Int?     = null,
    @SerializedName("object_id"          ) var objectId          : Int?     = null,
    @SerializedName("type"               ) var type              : String?  = null,
    @SerializedName("order"              ) var order             : Int?     = null,
    @SerializedName("point_key"          ) var pointKey          : String?  = null,
    @SerializedName("region_id"          ) var regionId          : Int?     = null,
    @SerializedName("ttype"              ) var ttype             : String?  = null,
    @SerializedName("title"              ) var title             : String?  = null,
    @SerializedName("title_en"           ) var titleEn           : String?  = null,
    @SerializedName("title_ru"           ) var titleRu           : String?  = null,
    @SerializedName("title_uk"           ) var titleUk           : String?  = null,
    @SerializedName("zone_id"            ) var zoneId            : Int?     = null,
    @SerializedName("slug"               ) var slug              : String?  = null,
    @SerializedName("popular_title"      ) var popularTitle      : String?  = null,
    @SerializedName("station_type"       ) var stationType       : String?  = null,
    @SerializedName("settlement_title"   ) var settlementTitle   : String?  = null,
    @SerializedName("region_title"       ) var regionTitle       : String?  = null,
    @SerializedName("country_title"      ) var countryTitle      : String?  = null

) {
    fun toDomain(): Suggests = Suggests(
        countryId,
        disputedTerritory,
        fullTitle,
        fullTitleEn,
        fullTitleRu,
        fullTitleUk,
        id,
        majority,
        objectId,
        type,
        order,
        pointKey,
        regionId,
        ttype,
        title,
        titleEn,
        titleRu,
        titleUk,
        zoneId,
        slug,
        popularTitle,
        stationType,
        settlementTitle,
        regionTitle,
        countryTitle
    )
}

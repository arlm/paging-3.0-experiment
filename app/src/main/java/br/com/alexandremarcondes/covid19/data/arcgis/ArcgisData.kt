package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class ArcgisData (
    @SerializedName("objectIdFieldName") val objectIdFieldName : String,
    @SerializedName("uniqueIdField") val uniqueIdField : UniqueIdField,
    @SerializedName("globalIdFieldName") val globalIdFieldName : String,
    @SerializedName("geometryType") val geometryType : String,
    @SerializedName("spatialReference") val spatialReference : SpatialReference,
    @SerializedName("fields") val fields : List<Fields>,
    @SerializedName("exceededTransferLimit") val exceededTransferLimit : Boolean,
    @SerializedName("features") val features : List<Features>,
    @SerializedName("error") val error : Error
)
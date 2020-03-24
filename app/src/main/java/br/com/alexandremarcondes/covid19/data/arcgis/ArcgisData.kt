package br.com.alexandremarcondes.covid19.data.arcgis

data class ArcgisData (
    val objectIdFieldName : String,
    val uniqueIdField : UniqueIdField,
    val globalIdFieldName : String,
    val geometryType : String,
    val spatialReference : SpatialReference,
    val fields : List<Fields>,
    val features : List<Features>
)
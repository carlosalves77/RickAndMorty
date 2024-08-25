package br.com.dev.rickandmorty.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListOfCharacters(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<Result>
)
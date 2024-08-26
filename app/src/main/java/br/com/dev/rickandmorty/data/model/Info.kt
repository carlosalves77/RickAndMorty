package br.com.dev.rickandmorty.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: Any
)
package com.kroger.classapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RickAndMortyCharacterResponse(
    @field:Json(name = "info")
    val info: Info,
    @field:Json(name = "results")
    val characters: List<RickAndMortyCharacter>
) {
    @JsonClass(generateAdapter = true)
    data class Info(
        @field:Json(name = "count")
        val count: Int,
        @field:Json(name = "next")
        val next: String,
        @field:Json(name = "pages")
        val pages: Int,
        @field:Json(name = "prev")
        val prev: Any?
    )
}
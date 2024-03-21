package com.kroger.classapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RickAndMortyCharacter(
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "episode")
    val episode: List<String>,
    @field:Json(name = "gender")
    val gender: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "location")
    val location: Location,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "origin")
    val origin: Origin,
    @field:Json(name = "species")
    val species: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "url")
    val url: String
) {
    @JsonClass(generateAdapter = true)
    data class Location(
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "url")
        val url: String
    )

    @JsonClass(generateAdapter = true)
    data class Origin(
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "url")
        val url: String
    )
}

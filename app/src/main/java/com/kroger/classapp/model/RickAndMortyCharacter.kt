package com.kroger.classapp.model

data class RickAndMortyCharacter(
    val name: String,
    val picture: String,
    val age: Int,
    val id: Int,
    val planet: String,
    val relation: List<Int>,
)
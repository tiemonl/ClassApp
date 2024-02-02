package com.kroger.classapp

data class RickAndMortyCharacter(
    val name: String,
    val picture: Int,
    val age: Int,
    val id: Int,
    val planet: String,
    val relation: List<Int>,
)

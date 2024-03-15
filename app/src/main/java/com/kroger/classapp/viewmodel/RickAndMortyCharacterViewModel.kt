package com.kroger.classapp.viewmodel

import androidx.lifecycle.ViewModel
import com.kroger.classapp.model.RickAndMortyCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RickAndMortyCharacterViewModel @Inject constructor() : ViewModel() {
    private val characters = mutableListOf<RickAndMortyCharacter>()

    private val characterNames = listOf("Rick", "Morty", "Summer", "Beth")

    private val characterImages = listOf(
        "https://rickandmortyapi.com/api/character/avatar/100.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/23.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/26.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/24.jpeg",
    )

    init {
        createCharacters()
    }

    fun fillData() = characters.toList()

    fun fetchById(id: Int) = characters.first { it.id == id }

    private fun createCharacters() = (0..30).map { id ->
        characters.add(
            RickAndMortyCharacter(
                name = characterNames.random(),
                picture = characterImages.random(),
                age = Random.nextInt(10, 99),
                id = id,
                planet = "patrioque",
                relation = listOf(),
            )
        )
    }

}
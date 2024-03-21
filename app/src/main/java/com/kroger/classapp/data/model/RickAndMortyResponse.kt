package com.kroger.classapp.data.model

import com.kroger.classapp.model.RickAndMortyCharacter

sealed class RickAndMortyResponse {
    data class Success(val characters: List<RickAndMortyCharacter>) : RickAndMortyResponse()
    object Error : RickAndMortyResponse()
}
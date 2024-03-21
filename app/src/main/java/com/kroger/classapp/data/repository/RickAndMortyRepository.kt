package com.kroger.classapp.data.repository

import com.kroger.classapp.data.model.RickAndMortyResponse

interface RickAndMortyRepository {
    suspend fun getCharacters(): RickAndMortyResponse
}
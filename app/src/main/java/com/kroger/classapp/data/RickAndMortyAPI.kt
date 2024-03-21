package com.kroger.classapp.data

import com.kroger.classapp.model.RickAndMortyCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyAPI {
    @GET("/api/character")
    suspend fun getCharacters(): Response<RickAndMortyCharacterResponse>
}
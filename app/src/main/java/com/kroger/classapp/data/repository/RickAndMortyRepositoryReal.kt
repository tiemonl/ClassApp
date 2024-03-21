package com.kroger.classapp.data.repository

import com.kroger.classapp.data.RickAndMortyAPI
import com.kroger.classapp.data.model.RickAndMortyResponse
import javax.inject.Inject

class RickAndMortyRepositoryReal  @Inject constructor(
    private val rickAndMortyApi: RickAndMortyAPI,
) : RickAndMortyRepository {
    override suspend fun getCharacters(): RickAndMortyResponse {
        val result = rickAndMortyApi.getCharacters()
        return if (result.isSuccessful) {
            RickAndMortyResponse.Success(result.body()?.characters ?: emptyList())
        } else {
            RickAndMortyResponse.Error
        }
    }
}
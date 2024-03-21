package com.kroger.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroger.classapp.data.model.RickAndMortyResponse
import com.kroger.classapp.data.repository.RickAndMortyRepository
import com.kroger.classapp.model.RickAndMortyCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@HiltViewModel
class RickAndMortyCharacterViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
) : ViewModel() {

    private val _characters = MutableStateFlow<RickAndMortyCharacterEvent>(RickAndMortyCharacterEvent.Loading)
    val characters: StateFlow<RickAndMortyCharacterEvent> = _characters

    fun fillData() = viewModelScope.launch {
            when (val response = rickAndMortyRepository.getCharacters()) {
                RickAndMortyResponse.Error -> _characters.value = RickAndMortyCharacterEvent.Failure
                is RickAndMortyResponse.Success -> _characters.value = RickAndMortyCharacterEvent.Success(response.characters)
            }
    }

    sealed class RickAndMortyCharacterEvent {
        data class Success(val characters: List<RickAndMortyCharacter>) : RickAndMortyCharacterEvent()
        data object Failure : RickAndMortyCharacterEvent()
        data object Loading : RickAndMortyCharacterEvent()
    }

}
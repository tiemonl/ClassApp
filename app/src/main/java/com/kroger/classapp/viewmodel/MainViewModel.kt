package com.kroger.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _splashScreen = MutableStateFlow(true)
    val splashScreen = _splashScreen.asStateFlow()

    init {
        viewModelScope.launch {
            delay(5000L)
            _splashScreen.value = false
        }
    }

}
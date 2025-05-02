package com.example.infoapp.presentation.random_image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoapp.domain.model.Image
import com.example.infoapp.domain.usecase.GetRandomImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomImageViewModel @Inject constructor(
    private val getRandomImageUseCase: GetRandomImageUseCase
) : ViewModel() {

    private val _image = MutableStateFlow<Image?>(null)
    val image: StateFlow<Image?> = _image.asStateFlow()

    init {
        loadImage()
    }

    fun loadImage() {
        viewModelScope.launch {
            getRandomImageUseCase().collect {
                _image.value = it
            }
        }
    }
}
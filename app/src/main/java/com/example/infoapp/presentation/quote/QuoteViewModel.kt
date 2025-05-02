package com.example.infoapp.presentation.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoapp.domain.model.Quote
import com.example.infoapp.domain.usecase.GetQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase: GetQuoteUseCase
) : ViewModel() {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote.asStateFlow()

    init {
        getNewQuote()
    }

    fun getNewQuote() {
        viewModelScope.launch {
            getQuoteUseCase().collect {
                _quote.value = it
            }
        }
    }
}
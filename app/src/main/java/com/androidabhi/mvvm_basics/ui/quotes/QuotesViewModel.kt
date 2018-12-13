package com.androidabhi.mvvm_basics.ui.quotes

import androidx.lifecycle.ViewModel
import com.androidabhi.mvvm_basics.data.Quote
import com.androidabhi.mvvm_basics.data.QuoteRepository


// In case of orientation change we donot want to recreate an instantiate
// the viewmodels because it will reset all of the fields and negate it purpose
// Hence comes the need of ViewModelProvider which checks whether viewModel
// or repository is already present  --> pass it back to activity
class QuotesViewModel(private var quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}
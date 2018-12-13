package com.androidabhi.mvvm_basics.utilities

import com.androidabhi.mvvm_basics.data.FakeDatabase
import com.androidabhi.mvvm_basics.data.QuoteRepository
import com.androidabhi.mvvm_basics.ui.quotes.QuotesViewModelFactory


// Use dagger in complex projects
object InjectorsUtils {

    fun providesQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDAO)
        return QuotesViewModelFactory(quoteRepository)
    }
}
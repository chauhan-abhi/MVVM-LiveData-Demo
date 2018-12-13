package com.androidabhi.mvvm_basics.data

// FakeQuoteDao must be passed in - it is a dependency
// You could also instantiate the DAO right inside the class without all the fuss, right?
// No. This would break testability - you need to be able to pass a mock version of a DAO
// to the repository (e.g. one that upon calling getQuotes() returns a dummy list of quotes for testing)
// This is the core idea behind DEPENDENCY INJECTION - making things completely modular and independent.

class QuoteRepository private constructor(private val quoteDAO: FakeQuoteDAO){

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addQuote(quote: Quote) {
        quoteDAO.addQuote(quote)
    }

    fun getQuotes() = quoteDAO.getQuotes()

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile
        private var instance: QuoteRepository? = null

        // The only way to get hold of the QuoteRepository object
        fun getInstance(quoteDAO: FakeQuoteDAO) =
        // Already instantiated? - return the instance
        // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: QuoteRepository(quoteDAO).also { instance = it }
            }

    }
}
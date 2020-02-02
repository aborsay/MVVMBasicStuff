package xyz.borsay.mvvmbasicstuff.ui.quotes

import androidx.lifecycle.ViewModel
import xyz.borsay.mvvmbasicstuff.data.Quote
import xyz.borsay.mvvmbasicstuff.data.QuoteRepository

class QuoteViewModel(private val  quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)
}
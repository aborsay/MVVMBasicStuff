package xyz.borsay.mvvmbasicstuff.utililities

import xyz.borsay.mvvmbasicstuff.data.FakeDatabase
import xyz.borsay.mvvmbasicstuff.data.QuoteRepository
import xyz.borsay.mvvmbasicstuff.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}
package xyz.borsay.mvvmbasicstuff.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import xyz.borsay.mvvmbasicstuff.R
import xyz.borsay.mvvmbasicstuff.data.Quote
import xyz.borsay.mvvmbasicstuff.utililities.InjectorUtils
import java.lang.StringBuilder
import kotlin.text.Typography.quote

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView_quotes.movementMethod = ScrollingMovementMethod()

        //( ScrollingMovementMethod())
        initializeUi()

    }
    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }
}

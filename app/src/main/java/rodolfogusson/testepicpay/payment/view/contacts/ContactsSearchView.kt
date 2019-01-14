package rodolfogusson.testepicpay.payment.view.contacts

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.RelativeLayout
import rodolfogusson.testepicpay.R

class ContactsSearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val searchEditText: EditText
    var search: ((String) -> Unit)? = null

    init {
        View.inflate(context, R.layout.search_view, this)
        searchEditText = findViewById(R.id.searchEditText)
        searchEditText.setOnFocusChangeListener(::editTextFocusChanged)
        this.setOnClickListener(::onClick)
        observeEditText()
    }

    private fun editTextFocusChanged(view: View?, hasFocus: Boolean) {
        this.isSelected = hasFocus
    }

    private fun onClick(v: View){
        searchEditText.requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(searchEditText, 0)
    }

    private fun observeEditText() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                search?.let { it(s.toString()) }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}
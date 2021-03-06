package rodolfogusson.testepicpay.core.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso
import rodolfogusson.testepicpay.core.utils.toCurrencyString
import java.math.BigDecimal

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Picasso
        .get()
        .load(url)
        .into(imageView)
}

@BindingAdapter("errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}

@BindingAdapter("decimalValue", "decimalTextFormat", requireAll = true)
fun setDecimalText(view: TextView, decimalValue: BigDecimal?, decimalTextFormat: String) {
    val string = decimalValue?.toCurrencyString()
    view.text = String.format(decimalTextFormat, string)
}
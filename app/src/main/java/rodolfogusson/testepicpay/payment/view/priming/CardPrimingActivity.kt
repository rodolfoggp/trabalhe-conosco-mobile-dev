package rodolfogusson.testepicpay.payment.view.priming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_card_priming.*
import rodolfogusson.testepicpay.R
import rodolfogusson.testepicpay.core.ui.customize
import rodolfogusson.testepicpay.payment.model.contact.Contact
import rodolfogusson.testepicpay.payment.view.register.CardRegisterActivity

class CardPrimingActivity : AppCompatActivity() {

    var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_priming)
        contact = intent.getParcelableExtra(Contact.key)
        setupLayout()
    }

    private fun setupLayout() {
        supportActionBar?.customize()
        button.setOnClickListener(::registerCard)
    }

    private fun registerCard(v: View) {
        Intent(this, CardRegisterActivity::class.java).apply {
            putExtra(Contact.key, contact)
            startActivity(this)
        }
    }
}
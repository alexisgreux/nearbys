package com.example.myfirstandroidapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstandroidapplication.model.Account
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {


    companion object {

        private val ACCOUNT_EXTRA = "account_extra"

        fun createIntent(context: Context, account: Account): Intent {
            val signupIntent = Intent(context, SignupActivity::class.java)
            signupIntent.putExtra(ACCOUNT_EXTRA, account)

            return signupIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //Récupération de la valeur transférée via l'intent
/*
        val randomValue = intent.getIntExtra("random_value_extra", 0)

        detail1textView.text = randomValue.toString()
*/

        val myAccount = intent.getParcelableExtra<Account>(ACCOUNT_EXTRA)

        detail1textView.text = myAccount.name
        detail2textView.text = myAccount.age.toString()


        callBackButton.setOnClickListener {
         //On peut renvoyer le résultat
        setResult(Activity.RESULT_OK)

            // On force le retour sur l'activité précédente
            this.finish()



        }
    }


}

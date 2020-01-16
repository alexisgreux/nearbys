package com.example.myfirstandroidapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.myfirstandroidapplication.model.Account
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private val REQUEST_CODE_SIGNUP = 112

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)



        //On vérifie d'où provient le code de retour grâce au request code
        when(requestCode) {
            REQUEST_CODE_SIGNUP -> {
                if(resultCode== Activity.RESULT_OK) {
                    Snackbar.make(mainContainer, android.R.string.ok, Snackbar.LENGTH_SHORT)
                        .show()
                } else {
                    Snackbar.make(mainContainer, android.R.string.cancel, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Retirer l'action bar
        if (supportActionBar != null)
            supportActionBar?.hide()

        // Ici l'écran est chargé et affiché


        //Old School
        // var button = findViewById<Button>(R.id.signinButton)

        //NEW SCHOOL
        signinButton.setOnClickListener {

            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()){
                //GREEN
                textView.text = getString(R.string.label_success_login)
                textView.setBackgroundColor(ContextCompat
                    .getColor(this, R.color.awesome_green))
                    Snackbar
                        .make(mainContainer, R.string.label_success_login, Snackbar.LENGTH_SHORT)
                        .show()

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)

                    //Pour empêcher le back sur l'écran, on le quitte
                    this.finish()

            } else {
                //RED
                textView.text = getString(R.string.label_failure_login)
                textView.setBackgroundColor(Color.RED)

            }

        }

        signupButton.setOnClickListener {

            val myAccount = Account("Jack", 65)
            val signupIntent = SignupActivity.createIntent(this, myAccount)
           // signupIntent.putExtra("account_extra", myAccount)


//REQUEST CODE = IDENTIFIANT POUR DÉFINIR UN CHEMIN VERS UNE ACTIVITÉ
            startActivityForResult(signupIntent, REQUEST_CODE_SIGNUP)
        }

    }
}

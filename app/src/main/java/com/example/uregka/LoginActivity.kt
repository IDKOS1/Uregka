package com.example.uregka

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val signUpButton = findViewById<Button>(R.id.btn_sign_up)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val idEditText = findViewById<EditText>(R.id.et_login_id)
        val idWrongText = findViewById<TextView>(R.id.tv_login_id_wrong)
        val passwordEditText = findViewById<EditText>(R.id.et_login_password)
        val passwordWrongText = findViewById<TextView>(R.id.tv_login_password_wrong)
        val passwordButton = findViewById<ImageView>(R.id.login_visibility_password)

        val developerMode = findViewById<ImageView>(R.id.img_login_icon)

        developerMode.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var isPasswordVisibility = false

        passwordButton.setOnClickListener {
            isPasswordVisibility = passwordToggle(isPasswordVisibility, passwordEditText)
        }

        loginButton.setOnClickListener {

            if (idEditText.text.toString().trim().isEmpty() || passwordEditText.text.toString()
                    .trim()
                    .isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.login_empty_check), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val id = idEditText.text.toString().trim()
            if (isDuplicationId(id)) {
                idWrongText.visibility = View.VISIBLE
                return@setOnClickListener
            } else {
                idWrongText.visibility = View.INVISIBLE
            }

            val password = passwordEditText.text.toString().trim()
            if (!isRegularPassword(password)) {
                passwordWrongText.setText(getString(R.string.login_wrong_password))
                passwordWrongText.visibility = View.VISIBLE
                return@setOnClickListener
            } else {
                passwordWrongText.visibility = View.INVISIBLE
            }

            if (!isCheckPassword(id, password)) {
                Toast.makeText(
                    this,
                    getString(R.string.login_different_password),
                    Toast.LENGTH_SHORT
                ).show()
                passwordWrongText.setText(getString(R.string.login_different_password))
                passwordWrongText.visibility = View.VISIBLE
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", idEditText.text.toString())
            startActivity(intent)

        }

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val data: User? = it.data?.getParcelableExtra("data")
                    idEditText.setText(data?.userId)
                    passwordEditText.setText(data?.userPassword)
                }
            }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }


    }
}
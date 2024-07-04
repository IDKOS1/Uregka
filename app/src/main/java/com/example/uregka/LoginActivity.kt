package com.example.uregka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val passwordEditText = findViewById<EditText>(R.id.et_login_password)





        loginButton.setOnClickListener {



            if (idEditText.text.toString().trim().isEmpty() || passwordEditText.text.toString().trim()
                    .isEmpty()
            ) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", idEditText.text.toString())
            startActivity(intent)

        }

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""
                    val user_password = it.data?.getStringExtra("password") ?: ""
                    idEditText.setText(user_id)
                    passwordEditText.setText(user_password)
                }
            }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }


    }
}
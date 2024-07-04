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

        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val et_id = findViewById<EditText>(R.id.et_login_id)
        val et_password = findViewById<EditText>(R.id.et_login_password)


        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""
                    val user_password = it.data?.getStringExtra("password") ?: ""
                    et_id.setText(user_id)
                    et_password.setText(user_password)
                }
            }

        btn_login.setOnClickListener {
            if (et_id.text.toString().trim().isEmpty() || et_password.text.toString().trim()
                    .isEmpty()
            ) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", et_id.text.toString())
            startActivity(intent)

        }


        btn_sign_up.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }


    }
}
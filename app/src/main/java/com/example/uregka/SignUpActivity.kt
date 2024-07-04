package com.example.uregka

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var idEditText: EditText
    private lateinit var idWrongTextView: TextView
    private lateinit var passwordEditText: EditText
    private lateinit var passwordWrongTextView: TextView
    private lateinit var nicknameEditText: EditText
    private lateinit var nicknameWrongTextView: TextView
    private lateinit var emailEditText: EditText
    private lateinit var emailWrongTextView: TextView
    private lateinit var introEditText: EditText
    private lateinit var introWrongTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        idEditText = findViewById(R.id.et_sign_up_id)
        idWrongTextView = findViewById(R.id.tv_sign_up_id_wrong)
        passwordEditText = findViewById(R.id.et_sign_up_password)
        passwordWrongTextView = findViewById(R.id.tv_sgin_up_password_wrong)
        nicknameEditText = findViewById(R.id.et_sign_up_nick_name)
        nicknameWrongTextView = findViewById(R.id.tv_sign_up_nickname_wrong)
        emailEditText = findViewById(R.id.et_sign_up_email)
        emailWrongTextView = findViewById(R.id.tv_sign_up_email_wrong)
        introEditText = findViewById(R.id.et_sign_up_intro)
        introWrongTextView = findViewById(R.id.tv_sign_up_intro_wrong)
        val signUpButton = findViewById<Button>(R.id.btn_sign_up_complete)
        val returnClickTextView = findViewById<TextView>(R.id.tv_return_click)

        var isId = false
        var isPassword = false
        var isNickname = false
        var isEmail = false
        var isIntro = false

        //아이디 입력
        idEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val id = idEditText.text.toString().trim()

                if (isDuplicationId(id)) {
                    idWrongTextView.visibility = View.INVISIBLE
                    isId = true
                } else {
                    idWrongTextView.visibility = View.VISIBLE
                    isId = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //비밀번호 입력
        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = passwordEditText.text.toString().trim()

                if (isRegularPassword(password)) {
                    passwordWrongTextView.visibility = View.INVISIBLE
                    isPassword = true
                } else {
                    passwordWrongTextView.visibility = View.VISIBLE
                    isPassword = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //닉네임 입력
        nicknameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val nickname = nicknameEditText.text.toString().trim()

                if (isDuplicationNickname(nickname)) {
                    nicknameWrongTextView.visibility = View.INVISIBLE
                    isNickname = true
                } else {
                    nicknameWrongTextView.visibility = View.VISIBLE
                    isNickname = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //이메일 입력
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = emailEditText.text.toString().trim()

                if (isRegularEmail(email)) {
                    emailWrongTextView.visibility = View.INVISIBLE
                    isEmail = true
                } else {
                    emailWrongTextView.visibility = View.VISIBLE
                    isEmail = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //짧은 소개 입력
        introEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val intro = introEditText.text.toString().trim()

                if (isRegularIntro(intro)) {
                    introWrongTextView.visibility = View.INVISIBLE
                    isIntro = true
                } else {
                    introWrongTextView.visibility = View.VISIBLE
                    isIntro = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //회원 가입 버튼
        signUpButton.setOnClickListener {

            // 비었을 때
            if (idEditText.text.toString().trim()
                    .isEmpty() || passwordEditText.text.toString()
                    .trim()
                    .isEmpty() || nicknameEditText.text.toString()
                    .isEmpty() || emailEditText.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //유효한 입력 체크
            if (!isId || !isPassword || !isNickname || !isEmail || !isIntro) {
                Toast.makeText(this, "유효하지 않은 입력이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //이메일 중복 체크
            val email = emailEditText.text.toString()
            if (!isDuplicationEmail(email)) {
                emailWrongTextView.setText("이미 등록된 이메일 입니다.")
                emailWrongTextView.visibility = View.VISIBLE
                Toast.makeText(this, "이미 등록된 이메일 입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //데이터 전달
            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("id", idEditText.text.toString())
                putExtra("password", passwordEditText.text.toString())
            }
            setResult(RESULT_OK, intent)

            if (!isFinishing) finish()

        }

        // 로그인 화면으로 돌아가기 버튼
        returnClickTextView.setOnClickListener {
            if (!isFinishing) finish()
        }

    }


}

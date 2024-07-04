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
import java.util.regex.Pattern

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


        //아이디 입력
        idEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isDuplicationId()) {
                    idWrongTextView.visibility = View.INVISIBLE
                } else {
                    idWrongTextView.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //비밀번호 입력
        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isRegularPassword()) {
                    passwordWrongTextView.visibility = View.INVISIBLE
                } else {
                    passwordWrongTextView.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //닉네임 입력
        nicknameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isDuplicationNickname()) {
                    nicknameWrongTextView.visibility = View.INVISIBLE
                } else {
                    nicknameWrongTextView.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        //이메일 입력
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isRegularEmail()) {
                    emailWrongTextView.visibility = View.INVISIBLE
                } else {
                    emailWrongTextView.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //짧은 소개 입력
        introEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isRegularIntro()) {
                    introWrongTextView.visibility = View.INVISIBLE
                } else {
                    introWrongTextView.visibility = View.VISIBLE
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

            if (!isDuplicationId()) {
                return@setOnClickListener
            }

            if (!isRegularEmail()) {
                return@setOnClickListener
            }

            if (!isRegularPassword()) {
                return@setOnClickListener
            }

            if (!isDuplicationNickname()) {
                return@setOnClickListener
            }

            if (!isDuplicationEmail()) {
                emailWrongTextView.setText("이미 등록된 이메일 입니다.")
                emailWrongTextView.visibility = View.VISIBLE
                return@setOnClickListener
            }

            if(!isRegularIntro()){
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

    private fun isDuplicationId(): Boolean {
        val id = idEditText.text.toString().trim()
        return if (UserData.userList.containsKey(id)) {
            false
        } else {
            true
        }
    }

    //비밀번호 유효성
    private fun isRegularPassword(): Boolean {
        val password = passwordEditText.text.toString().trim()
        val passwordPattern =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@!%*#?&.]{5,12}$"
        val pattern = Pattern.matches(passwordPattern, password)

        return pattern
    }

    //이메일 유효성
    private fun isRegularEmail(): Boolean {
        val email = emailEditText.text.toString().trim()
        val pattern = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        return pattern
    }

    private fun isDuplicationNickname(): Boolean {
        val nickname = nicknameEditText.text.toString().trim()
        for ((_, value) in UserData.userList) {
            if (value.userNickName == nickname) {
                return false
            }
        }
        return true
    }


    //이메일 중복
    private fun isDuplicationEmail(): Boolean {
        val email = emailEditText.text.toString()
        for ((_, value) in UserData.userList) {
            if (value.userEmail == email) {
                return false
            }
        }
        return true
    }

    //소개 유효성
    private fun isRegularIntro(): Boolean {
        val intro = introEditText.text.toString().trim()
        val introPattern = "^[A-Za-z0-9가-힣\$@!%*#?&.]{2,18}\$"
        val pattern = Pattern.matches(introPattern, intro)
        return pattern
    }
}

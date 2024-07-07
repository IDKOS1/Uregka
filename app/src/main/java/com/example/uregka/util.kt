package com.example.uregka

import android.content.Context
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

//아이디 중복 체크
fun isDuplicationId(id: String): Boolean {
    return if (UserData.userList.containsKey(id)) {
        false
    } else {
        true
    }
}

//비밀번호 유효성
fun isRegularPassword(password: String): Boolean {
    val passwordPattern =
        "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@!%*#?&.]{5,12}$"
    val pattern = Pattern.matches(passwordPattern, password)

    return pattern
}

fun isCheckPassword(id: String, password: String): Boolean {
    return UserData.userList[id]?.userPassword == password
}

//이메일 유효성
fun isRegularEmail(email: String): Boolean {
    val pattern = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    return pattern
}

//이메일 중복
fun isDuplicationEmail(email: String): Boolean {
    for ((_, value) in UserData.userList) {
        if (value.userEmail == email) {
            return false
        }
    }
    return true
}

//닉네임 중복
fun isDuplicationNickname(nickname: String): Boolean {
    for ((_, value) in UserData.userList) {
        if (value.userNickName == nickname) {
            return false
        }
    }
    return true
}

//소개 유효성
fun isRegularIntro(intro: String): Boolean {
    val introPattern = "^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ\$@!%*#?&.]{2,18}$"
    val pattern = Pattern.matches(introPattern, intro)
    return pattern
}

//비밀번호 토클 버튼
fun passwordToggle(
    isPasswordVisibility: Boolean,
    passwordEditText: EditText,
): Boolean {
    if (isPasswordVisibility) {
        passwordEditText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        passwordEditText.setSelection(passwordEditText.text.length)
        return false
    } else {
        passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        passwordEditText.setSelection(passwordEditText.text.length)
        return true
    }
}

fun showToast(context: Context,message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
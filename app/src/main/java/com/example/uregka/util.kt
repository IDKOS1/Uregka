package com.example.uregka

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
package com.example.uregka

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


// copyTo, 기존 객체 제거 및 교체
@Parcelize
data class User(
    var userId: String,
    var userPassword: String,
    var userNickName: String,
    var userEmail: String,
    var follower: Int = 0,
    var userIntro: String = "",
    var profileImg: String = ""
) : Parcelable

object UserData {
    val userList: MutableMap<String, User> = mutableMapOf(
        "idkos" to User(
            "idkos",
            "a1b2c3d4!",
            "이강진",
            "kss3736@naver.com",
            8813,
            "안드로이드 어려워요",
            "profile_kj"
        ),
        "kdbswo" to User(
            "kdbswo",
            "a1b2c3d4!",
            "김윤재",
            "kdbswo@gmail.com",
            5,
            "일상의 작은 변화 속 진실을 찾아보도합니다.",
            "profile_yj"
        ),
        "dacafo77" to User(
            "dacafo77",
            "a1b2c3d4!",
            "최봉준",
            "dacafo77@nate.com",
            5,
            "꽁꽁얼어붙은 한강위를 중점으로 취재합니다",
            "profile_bj"
        ),
        "jisung15" to User(
            "jisung15",
            "a1b2c3d4!",
            "김성진",
            "gimseongjin302@gmail.com",
            5,
            "렉카인듯 렉카같지 않은 렉카같은 렉카기자",
            "profile_sj"
        ),
        "GGOging" to User(
            "GGOging",
            "a1b2c3d4!",
            "조인기",
            "GGOging@gmail.com",
            5,
            "군부대를 중점으로 취재합니다",
            "profile_ik"
        ),
        "johnDoe" to User(
            "johnDoe",
            "jd1234!",
            "JohnD",
            "john.doe@example.com",
            1634,
            "Love coding and coffee!",
            "profile03"
        ),
        "janeSmith" to User(
            "janeSmith",
            "js5678!",
            "JaneS",
            "jane.smith@example.com",
            26,
            "Traveller and foodie.",
            "profile04"
        ),
        "charlieBrown" to User(
            "charlieBrown",
            "cb91011!",
            "CharlieB",
            "charlie.brown@example.com",
            561,
            "Peanuts fan.",
            "profile05"
        ),
        "aliceJohnson" to User(
            "aliceJohnson",
            "aj1213!",
            "AliceJ",
            "alice.johnson@example.com",
            71,
            "Book lover and writer.",
            "profile06"
        ),
        "michaelWhite" to User(
            "michaelWhite",
            "mw1415!",
            "MichaelW",
            "michael.white@example.com",
            952,
            "Fitness enthusiast.",
            "profile07"
        ),
        "sarahConnor" to User(
            "sarahConnor",
            "sc1617!",
            "SarahC",
            "sarah.connor@example.com",
            196,
            "Tech geek and movie buff.",
            "profile08"
        ),
        "davidMiller" to User(
            "davidMiller",
            "dm1819!",
            "DavidM",
            "david.miller@example.com",
            79,
            "Music and arts.",
            "profile09"
        ),
        "emilyClark" to User(
            "emilyClark",
            "ec2021!",
            "EmilyC",
            "emily.clark@example.com",
            2,
            "Nature lover.",
            "profile10"
        ),
        "danielLewis" to User(
            "danielLewis",
            "dl2223!",
            "DanielL",
            "daniel.lewis@example.com",
            81,
            "Gamer and streamer.",
            "profile11"
        ),
    )
}


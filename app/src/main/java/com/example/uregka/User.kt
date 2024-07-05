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
    var follower: Int,
    var userIntro: String = "",
    var profileImg: String = ""
) : Parcelable

object UserData {
    val userList: MutableMap<String, User> = mutableMapOf(
        "idkos" to User(
            "idkos",
            "a1b2c3d4!",
            "강아지맛쥬스",
            "kss3736@naver.com",
            8813,
            "안드로이드 어려워요",
            "sample"
        ),
        "MGone" to User(
            "MGone",
            "mgmgmg!",
            "말감지원",
            "mzone@gmail.com",
            7212,
            "뷁",
            "sample"
        ),
        "johnDoe" to User(
            "johnDoe",
            "jd1234!",
            "JohnD",
            "john.doe@example.com",
            1634
            "Love coding and coffee!",
            "sample"
        ),
        "janeSmith" to User(
            "janeSmith",
            "js5678!",
            "JaneS",
            "jane.smith@example.com",
            26,
            "Traveller and foodie.",
            "sample"
        ),
        "charlieBrown" to User(
            "charlieBrown",
            "cb91011!",
            "CharlieB",
            "charlie.brown@example.com",
            561,
            "Peanuts fan.",
            "sample"
        ),
        "aliceJohnson" to User(
            "aliceJohnson",
            "aj1213!",
            "AliceJ",
            "alice.johnson@example.com",
            71,
            "Book lover and writer.",
            "sample"
        ),
        "michaelWhite" to User(
            "michaelWhite",
            "mw1415!",
            "MichaelW",
            "michael.white@example.com",
            952,
            "Fitness enthusiast.",
            "sample"
        ),
        "sarahConnor" to User(
            "sarahConnor",
            "sc1617!",
            "SarahC",
            "sarah.connor@example.com",
            196,
            "Tech geek and movie buff.",
            "sample"
        ),
        "davidMiller" to User(
            "davidMiller",
            "dm1819!",
            "DavidM",
            "david.miller@example.com",
            79,
            "Music and arts.",
            "sample"
        ),
        "emilyClark" to User(
            "emilyClark",
            "ec2021!",
            "EmilyC",
            "emily.clark@example.com",
            2,
            "Nature lover.",
            "sample"
        ),
        "danielLewis" to User(
            "danielLewis",
            "dl2223!",
            "DanielL",
            "daniel.lewis@example.com",
            81,
            "Gamer and streamer.",
            "sample"
        ),
    )
}


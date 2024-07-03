package com.example.uregka

data class User(
    var userId: String,
    var userPassword: String,
    var userNickName: String,
    var userEmail: String,
    var userIntro: String = "",
    var profileImg: String = ""
)

object UserData {
    var userList: MutableMap<String, User> = mutableMapOf(
        "idkos" to User(
            userId = "idkos",
            userPassword = "a1b2c3d4!",
            userNickName = "강아지맛쥬스",
            userEmail = "kss3736@naver.com",
            userIntro = "안드로이드 어려워요",
            profileImg = ""
        ),
        "johnDoe" to User(
            userId = "johnDoe",
            userPassword = "jd1234!",
            userNickName = "JohnD",
            userEmail = "john.doe@example.com",
            userIntro = "Love coding and coffee!",
            profileImg = ""
        ),
        "janeSmith" to User(
            userId = "janeSmith",
            userPassword = "js5678!",
            userNickName = "JaneS",
            userEmail = "jane.smith@example.com",
            userIntro = "Traveller and foodie.",
            profileImg = ""
        ),
        "charlieBrown" to User(
            userId = "charlieBrown",
            userPassword = "cb91011!",
            userNickName = "CharlieB",
            userEmail = "charlie.brown@example.com",
            userIntro = "Peanuts fan.",
            profileImg = ""
        ),
        "aliceJohnson" to User(
            userId = "aliceJohnson",
            userPassword = "aj1213!",
            userNickName = "AliceJ",
            userEmail = "alice.johnson@example.com",
            userIntro = "Book lover and writer.",
            profileImg = ""
        ),
        "michaelWhite" to User(
            userId = "michaelWhite",
            userPassword = "mw1415!",
            userNickName = "MichaelW",
            userEmail = "michael.white@example.com",
            userIntro = "Fitness enthusiast.",
            profileImg = ""
        ),
        "sarahConnor" to User(
            userId = "sarahConnor",
            userPassword = "sc1617!",
            userNickName = "SarahC",
            userEmail = "sarah.connor@example.com",
            userIntro = "Tech geek and movie buff.",
            profileImg = ""
        ),
        "davidMiller" to User(
            userId = "davidMiller",
            userPassword = "dm1819!",
            userNickName = "DavidM",
            userEmail = "david.miller@example.com",
            userIntro = "Music and arts.",
            profileImg = ""
        ),
        "emilyClark" to User(
            userId = "emilyClark",
            userPassword = "ec2021!",
            userNickName = "EmilyC",
            userEmail = "emily.clark@example.com",
            userIntro = "Nature lover.",
            profileImg = ""
        ),
        "danielLewis" to User(
            userId = "danielLewis",
            userPassword = "dl2223!",
            userNickName = "DanielL",
            userEmail = "daniel.lewis@example.com",
            userIntro = "Gamer and streamer.",
            profileImg = ""
        ),
    )
}


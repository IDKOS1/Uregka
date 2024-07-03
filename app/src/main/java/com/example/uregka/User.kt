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
        "lindaMoore" to User(
            userId = "lindaMoore",
            userPassword = "lm2425!",
            userNickName = "LindaM",
            userEmail = "linda.moore@example.com",
            userIntro = "Fashion enthusiast.",
            profileImg = ""
        ),
        "robertBrown" to User(
            userId = "robertBrown",
            userPassword = "rb2627!",
            userNickName = "RobertB",
            userEmail = "robert.brown@example.com",
            userIntro = "History buff.",
            profileImg = ""
        ),
        "nancyDavis" to User(
            userId = "nancyDavis",
            userPassword = "nd2829!",
            userNickName = "NancyD",
            userEmail = "nancy.davis@example.com",
            userIntro = "Yoga practitioner.",
            profileImg = ""
        ),
        "stevenKing" to User(
            userId = "stevenKing",
            userPassword = "sk3031!",
            userNickName = "StevenK",
            userEmail = "steven.king@example.com",
            userIntro = "Horror writer.",
            profileImg = ""
        ),
        "kateWilson" to User(
            userId = "kateWilson",
            userPassword = "kw3233!",
            userNickName = "KateW",
            userEmail = "kate.wilson@example.com",
            userIntro = "Photographer.",
            profileImg = ""
        ),
        "georgeHarris" to User(
            userId = "georgeHarris",
            userPassword = "gh3435!",
            userNickName = "GeorgeH",
            userEmail = "george.harris@example.com",
            userIntro = "Mountain climber.",
            profileImg = ""
        ),
        "annaMartinez" to User(
            userId = "annaMartinez",
            userPassword = "am3637!",
            userNickName = "AnnaM",
            userEmail = "anna.martinez@example.com",
            userIntro = "Cooking enthusiast.",
            profileImg = ""
        ),
        "jasonLee" to User(
            userId = "jasonLee",
            userPassword = "jl3839!",
            userNickName = "JasonL",
            userEmail = "jason.lee@example.com",
            userIntro = "DIY projects.",
            profileImg = ""
        ),
        "victoriaClark" to User(
            userId = "victoriaClark",
            userPassword = "vc4041!",
            userNickName = "VictoriaC",
            userEmail = "victoria.clark@example.com",
            userIntro = "Gardening and plants.",
            profileImg = ""
        ),
        "peterMartinez" to User(
            userId = "peterMartinez",
            userPassword = "pm4243!",
            userNickName = "PeterM",
            userEmail = "peter.martinez@example.com",
            userIntro = "Travel blogger.",
            profileImg = ""
        )
    )
}


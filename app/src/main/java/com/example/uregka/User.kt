package com.example.uregka

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var userId: String,
    var userPassword: String,
    var userNickName: String,
    var userEmail: String,
    var userIntro: String = "",
    var profileImg: String = ""
) : Parcelable

@Parcelize
data class Article(
    val writerNickName: String,
    val writeDate: String,
    val articleTitle: String,
    val articleContent: String,
    val articleImg: String,
) : Parcelable

object UserData {
    val userList: MutableMap<String, User> = mutableMapOf(
        "idkos" to User(
            userId = "idkos",
            userPassword = "a1b2c3d4!",
            userNickName = "강아지맛쥬스",
            userEmail = "kss3736@naver.com",
            userIntro = "안드로이드 어려워요",
            profileImg = "sample"
        ),
        "johnDoe" to User(
            userId = "johnDoe",
            userPassword = "jd1234!",
            userNickName = "JohnD",
            userEmail = "john.doe@example.com",
            userIntro = "Love coding and coffee!",
            profileImg = "sample"
        ),
        "janeSmith" to User(
            userId = "janeSmith",
            userPassword = "js5678!",
            userNickName = "JaneS",
            userEmail = "jane.smith@example.com",
            userIntro = "Traveller and foodie.",
            profileImg = "sample"
        ),
        "charlieBrown" to User(
            userId = "charlieBrown",
            userPassword = "cb91011!",
            userNickName = "CharlieB",
            userEmail = "charlie.brown@example.com",
            userIntro = "Peanuts fan.",
            profileImg = "sample"
        ),
        "aliceJohnson" to User(
            userId = "aliceJohnson",
            userPassword = "aj1213!",
            userNickName = "AliceJ",
            userEmail = "alice.johnson@example.com",
            userIntro = "Book lover and writer.",
            profileImg = "sample"
        ),
        "michaelWhite" to User(
            userId = "michaelWhite",
            userPassword = "mw1415!",
            userNickName = "MichaelW",
            userEmail = "michael.white@example.com",
            userIntro = "Fitness enthusiast.",
            profileImg = "sample"
        ),
        "sarahConnor" to User(
            userId = "sarahConnor",
            userPassword = "sc1617!",
            userNickName = "SarahC",
            userEmail = "sarah.connor@example.com",
            userIntro = "Tech geek and movie buff.",
            profileImg = "sample"
        ),
        "davidMiller" to User(
            userId = "davidMiller",
            userPassword = "dm1819!",
            userNickName = "DavidM",
            userEmail = "david.miller@example.com",
            userIntro = "Music and arts.",
            profileImg = "sample"
        ),
        "emilyClark" to User(
            userId = "emilyClark",
            userPassword = "ec2021!",
            userNickName = "EmilyC",
            userEmail = "emily.clark@example.com",
            userIntro = "Nature lover.",
            profileImg = "sample"
        ),
        "danielLewis" to User(
            userId = "danielLewis",
            userPassword = "dl2223!",
            userNickName = "DanielL",
            userEmail = "daniel.lewis@example.com",
            userIntro = "Gamer and streamer.",
            profileImg = "sample"
        ),
    )

    val articleList: MutableList<Article> = mutableListOf(
        Article(
            writerNickName = "johnDoe",
            writeDate = "2024-07-25",
            articleTitle = "실감나는 가상현실 컨텐츠, 엔터테인먼트 산업의 혁신 동력",
            articleContent = """
            가상현실(VR) 기술의 발전이 엔터테인먼트 산업에 큰 혁신을 일으키고 있습니다. VR 기술은 사용자에게 몰입감 있는 경험을 제공하여 영화, 게임, 테마파크 등 다양한 분야에서 활용되고 있습니다. 특히, 영화 산업에서는 VR 영화가 새로운 형식으로 주목받고 있으며, 관객에게 실제로 영화 속에 들어가 있는 듯한 체험을 제공합니다.
            게임 분야에서는 VR 게임이 인기를 끌고 있으며, 플레이어에게 보다 현실적인 경험을 제공하고 있습니다. 또한, 테마파크에서는 VR 어트랙션이 도입되어 방문객에게 새로운 즐거움을 선사하고 있습니다. 이러한 변화는 엔터테인먼트 산업의 미래를 밝게 하고 있으며, VR 기술의 발전은 계속해서 우리의 일상에 큰 영향을 미칠 것입니다.
            최근 발표된 VR 헤드셋은 기존 모델보다 더 가볍고 사용이 편리하며, 높은 해상도와 빠른 반응 속도로 사용자 경험을 극대화합니다. 이러한 기술 발전은 교육, 의료, 부동산 등 다양한 산업에서도 활용될 것으로 기대됩니다. VR을 통해 우리는 더욱 현실감 넘치는 세상을 경험하게 될 것입니다.
        """.trimIndent(),
            articleImg = "news"
        ),
        Article(
            writerNickName = "janeSmith",
            writeDate = "2024-07-25",
            articleTitle = "AI 기술의 발전과 우리의 미래",
            articleContent = """
            인공지능(AI) 기술이 빠르게 발전하면서 우리의 생활 방식에도 큰 변화를 가져오고 있습니다. AI는 의료, 금융, 제조업 등 다양한 분야에서 활용되며, 업무 효율성을 크게 향상시키고 있습니다. 특히, 의료 분야에서는 AI를 통해 보다 정확한 진단과 치료가 가능해지고 있으며, 환자 맞춤형 의료 서비스가 제공되고 있습니다.
            금융 산업에서는 AI를 이용한 자동화 시스템이 도입되어 고객 서비스의 질을 높이고 있습니다. AI 기반의 챗봇은 24시간 고객 응대를 가능하게 하며, 금융 사기 탐지 시스템은 불법 거래를 신속히 파악해 내고 있습니다.
            제조업에서는 AI를 통한 스마트 팩토리가 도입되어 생산 효율성을 극대화하고 있습니다. AI 기술을 통해 공정 자동화와 품질 관리가 더욱 정교해지고 있으며, 생산 비용 절감과 생산성 향상에 기여하고 있습니다.
            또한, AI 기술은 우리의 일상 생활에도 큰 변화를 가져오고 있습니다. AI 기반의 가상 비서와 스마트홈 기술을 통해 우리는 더욱 편리하고 효율적인 생활을 누릴 수 있게 되었습니다. AI는 이제 더 이상 먼 미래의 이야기가 아니라, 우리의 현재와 미래를 변화시키는 중요한 기술로 자리 잡고 있습니다.
        """.trimIndent(),
            articleImg = "news"
        ),
        Article(
            writerNickName = "alexJohnson",
            writeDate = "2024-07-25",
            articleTitle = "재생 에너지의 현재와 미래",
            articleContent = """
            재생 에너지는 지속 가능한 미래를 위한 중요한 에너지 자원으로 주목받고 있습니다. 태양광, 풍력, 수력 등 다양한 재생 에너지 기술이 개발되고 있으며, 이를 통해 탄소 배출을 줄이고 환경 보호에 기여하고 있습니다. 특히, 태양광 에너지는 최근 몇 년간 급격히 성장하며 에너지 시장에서 중요한 역할을 하고 있습니다.
            풍력 에너지는 바람의 힘을 이용하여 전기를 생산하는 기술로, 해상 풍력 발전이 특히 주목받고 있습니다. 수력 에너지는 오래된 기술이지만 여전히 중요한 재생 에너지 자원으로 사용되고 있습니다.
            이러한 재생 에너지 기술들은 에너지 저장 기술과 결합하여 더욱 효율적인 에너지 사용을 가능하게 하고 있습니다. 배터리 기술의 발전은 재생 에너지의 간헐성 문제를 해결하고, 지속 가능한 에너지 공급을 가능하게 합니다.
            앞으로 재생 에너지의 발전은 더욱 가속화될 것으로 예상되며, 이를 통해 우리는 더욱 깨끗하고 지속 가능한 에너지 미래를 만들어 나갈 수 있을 것입니다.
        """.trimIndent(),
            articleImg = "news"
        ),
        Article(
            writerNickName = "sophiaLee",
            writeDate = "2024-07-28",
            articleTitle = "스마트 홈 기술의 진화",
            articleContent = """
            스마트 홈 기술은 우리의 생활을 더욱 편리하고 안전하게 만들고 있습니다. 스마트 조명, 스마트 온도 조절기, 스마트 보안 시스템 등 다양한 기기가 우리의 집을 더 스마트하게 변화시키고 있습니다. 이러한 기기들은 인터넷에 연결되어 원격으로 제어할 수 있으며, 우리의 생활 패턴에 맞춰 자동으로 동작합니다.
            특히, 스마트 스피커와 같은 음성 인식 기술은 스마트 홈의 중심이 되어 가고 있습니다. 음성 명령을 통해 집안의 모든 기기를 제어할 수 있으며, 이는 사용자 경험을 크게 향상시킵니다.
            또한, 스마트 홈 기술은 에너지 효율성을 높이는 데 중요한 역할을 합니다. 스마트 온도 조절기와 조명 시스템은 사용자의 생활 패턴을 학습하여 에너지 사용을 최적화하며, 이는 비용 절감과 환경 보호에 기여합니다.
            그러나 스마트 홈 기술의 발전에는 보안 문제도 함께 고려되어야 합니다. 인터넷에 연결된 기기들은 해킹의 위험에 노출될 수 있으며, 이에 대한 철저한 보안 대책이 필요합니다.
            스마트 홈 기술은 앞으로 더욱 발전하여 우리의 생활을 더욱 편리하고 안전하게 만들 것입니다. 지속적인 연구와 개발을 통해 더욱 혁신적인 기술이 등장할 것으로 기대됩니다.
        """.trimIndent(),
            articleImg = "news"
        ),
        Article(
            writerNickName = "danielKim",
            writeDate = "2024-07-29",
            articleTitle = "건강한 식습관을 위한 10가지 팁",
            articleContent = """
            건강한 식습관은 우리의 삶의 질을 높이는 데 중요한 역할을 합니다. 첫 번째로, 균형 잡힌 식단을 유지하는 것이 중요합니다. 다양한 음식을 섭취하여 필요한 영양소를 고루 섭취해야 합니다. 두 번째로, 식사 시간을 규칙적으로 유지하는 것이 중요합니다. 규칙적인 식사는 소화와 대사를 원활하게 합니다.
            세 번째로, 물을 충분히 마시는 것이 중요합니다. 수분 섭취는 체내 대사를 촉진하고, 피부 건강에도 좋습니다. 네 번째로, 과일과 채소를 많이 섭취해야 합니다. 이러한 식품들은 비타민과 미네랄이 풍부하여 건강에 좋습니다.
            다섯 번째로, 적절한 단백질 섭취가 중요합니다. 단백질은 근육을 유지하고, 에너지를 공급하는 중요한 영양소입니다. 여섯 번째로, 식이섬유를 충분히 섭취해야 합니다. 식이섬유는 소화를 돕고, 장 건강에 좋습니다.
            일곱 번째로, 가공식품과 당분 섭취를 줄이는 것이 중요합니다. 이러한 식품들은 건강에 해로울 수 있으며, 비만과 만성 질환의 원인이 될 수 있습니다. 여덟 번째로, 소금을 적게 섭취해야 합니다. 소금은 혈압을 높이고, 심장 질환의 위험을 증가시킬 수 있습니다.
            아홉 번째로, 적절한 양을 섭취하는 것이 중요합니다. 과식은 비만의 원인이 되며, 건강에 해로울 수 있습니다. 마지막으로, 긍정적인 식습관을 유지하는 것이 중요합니다. 스트레스를 받지 않고, 즐겁게 식사하는 것이 건강에 좋습니다.
        """.trimIndent(),
            articleImg = "news"
        ),
        Article(
            writerNickName = "oliviaPark",
            writeDate = "2024-07-30",
            articleTitle = "미래 자동차 기술: 자율주행과 전기차",
            """
            자동차 산업은 자율주행과 전기차 기술의 발전으로 큰 변화를 겪고 있습니다. 자율주행 자동차는 운전자의 개입 없이 스스로 주행할 수 있는 차량으로, 안전성과 편리성을 크게 향상시키고 있습니다. 자율주행 기술은 센서, 카메라, 레이더 등을 사용하여 주변 환경을 인식하고, 이를 통해 차량을 제어합니다.
            전기차는 환경 친화적인 대안으로 주목받고 있습니다. 배기가스를 배출하지 않으며, 에너지 효율이 높아 지속 가능한 이동 수단으로 각광받고 있습니다. 전기차의 배터리 기술은 빠르게 발전하고 있으며, 충전 인프라도 확대되고 있습니다.
            이러한 기술들은 우리의 이동 방식을 크게 변화시키고 있습니다. 자율주행 자동차는 교통 사고를 줄이고, 교통 혼잡을 완화시키는 데 기여할 수 있습니다. 또한, 전기차는 기후 변화와 환경 오염 문제에 대한 해결책으로서 중요한 역할을 할 것으로 기대됩니다. 
            전 세계적으로 자율주행과 전기차 기술에 대한 투자와 연구가 활발히 진행되고 있으며, 이는 긍정적인 결과를 가져올 것으로 기대됩니다. 앞으로도 자동차 산업의 기술 발전은 우리의 삶을 더욱 편리하고 지속 가능하게 만들어 나갈 것입니다.
        """.trimIndent(),
            articleImg = "news"
        ),
    )
}


package com.potatomeme.programmers.codingtest.years23.may.level2


//순위 검색
//문제 설명
//[본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]
//
//카카오는 하반기 경력 개발자 공개채용을 진행 중에 있으며 현재 지원서 접수와 코딩테스트가 종료되었습니다. 이번 채용에서 지원자는 지원서 작성 시 아래와 같이 4가지 항목을 반드시 선택하도록 하였습니다.
//
//코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
//지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
//지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
//선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
//인재영입팀에 근무하고 있는 니니즈는 코딩테스트 결과를 분석하여 채용에 참여한 개발팀들에 제공하기 위해 지원자들의 지원 조건을 선택하면 해당 조건에 맞는 지원자가 몇 명인 지 쉽게 알 수 있는 도구를 만들고 있습니다.
//예를 들어, 개발팀에서 궁금해하는 문의사항은 다음과 같은 형태가 될 수 있습니다.
//코딩테스트에 java로 참여했으며, backend 직군을 선택했고, junior 경력이면서, 소울푸드로 pizza를 선택한 사람 중 코딩테스트 점수를 50점 이상 받은 지원자는 몇 명인가?
//
//물론 이 외에도 각 개발팀의 상황에 따라 아래와 같이 다양한 형태의 문의가 있을 수 있습니다.
//
//코딩테스트에 python으로 참여했으며, frontend 직군을 선택했고, senior 경력이면서, 소울푸드로 chicken을 선택한 사람 중 코딩테스트 점수를 100점 이상 받은 사람은 모두 몇 명인가?
//코딩테스트에 cpp로 참여했으며, senior 경력이면서, 소울푸드로 pizza를 선택한 사람 중 코딩테스트 점수를 100점 이상 받은 사람은 모두 몇 명인가?
//backend 직군을 선택했고, senior 경력이면서 코딩테스트 점수를 200점 이상 받은 사람은 모두 몇 명인가?
//소울푸드로 chicken을 선택한 사람 중 코딩테스트 점수를 250점 이상 받은 사람은 모두 몇 명인가?
//코딩테스트 점수를 150점 이상 받은 사람은 모두 몇 명인가?
//즉, 개발팀에서 궁금해하는 내용은 다음과 같은 형태를 갖습니다.
//
//* [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
//[문제]
//지원자가 지원서에 입력한 4가지의 정보와 획득한 코딩테스트 점수를 하나의 문자열로 구성한 값의 배열 info, 개발팀이 궁금해하는 문의조건이 문자열 형태로 담긴 배열 query가 매개변수로 주어질 때,
//각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
//
//[제한사항]
//info 배열의 크기는 1 이상 50,000 이하입니다.
//info 배열 각 원소의 값은 지원자가 지원서에 입력한 4가지 값과 코딩테스트 점수를 합친 "개발언어 직군 경력 소울푸드 점수" 형식입니다.
//개발언어는 cpp, java, python 중 하나입니다.
//직군은 backend, frontend 중 하나입니다.
//경력은 junior, senior 중 하나입니다.
//소울푸드는 chicken, pizza 중 하나입니다.
//점수는 코딩테스트 점수를 의미하며, 1 이상 100,000 이하인 자연수입니다.
//각 단어는 공백문자(스페이스 바) 하나로 구분되어 있습니다.
//query 배열의 크기는 1 이상 100,000 이하입니다.
//query의 각 문자열은 "[조건] X" 형식입니다.
//[조건]은 "개발언어 and 직군 and 경력 and 소울푸드" 형식의 문자열입니다.
//언어는 cpp, java, python, - 중 하나입니다.
//직군은 backend, frontend, - 중 하나입니다.
//경력은 junior, senior, - 중 하나입니다.
//소울푸드는 chicken, pizza, - 중 하나입니다.
//'-' 표시는 해당 조건을 고려하지 않겠다는 의미입니다.
//X는 코딩테스트 점수를 의미하며 조건을 만족하는 사람 중 X점 이상 받은 사람은 모두 몇 명인 지를 의미합니다.
//각 단어는 공백문자(스페이스 바) 하나로 구분되어 있습니다.
//예를 들면, "cpp and - and senior and pizza 500"은 "cpp로 코딩테스트를 봤으며, 경력은 senior 이면서 소울푸드로 pizza를 선택한 지원자 중 코딩테스트 점수를 500점 이상 받은 사람은 모두 몇 명인가?"를 의미합니다.
//[입출력 예]
//info	query	result
//["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]	["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]	[1,1,1,1,2,4]
//입출력 예에 대한 설명
//지원자 정보를 표로 나타내면 다음과 같습니다.
//
//언어	직군	경력	소울 푸드	점수
//java	backend	junior	pizza	150
//python	frontend	senior	chicken	210
//python	frontend	senior	chicken	150
//cpp	backend	senior	pizza	260
//java	backend	junior	chicken	80
//python	backend	senior	chicken	50
//"java and backend and junior and pizza 100" : java로 코딩테스트를 봤으며, backend 직군을 선택했고 junior 경력이면서 소울푸드로 pizza를 선택한 지원자 중 코딩테스트 점수를 100점 이상 받은 지원자는 1명 입니다.
//"python and frontend and senior and chicken 200" : python으로 코딩테스트를 봤으며, frontend 직군을 선택했고, senior 경력이면서 소울 푸드로 chicken을 선택한 지원자 중 코딩테스트 점수를 200점 이상 받은 지원자는 1명 입니다.
//"cpp and - and senior and pizza 250" : cpp로 코딩테스트를 봤으며, senior 경력이면서 소울푸드로 pizza를 선택한 지원자 중 코딩테스트 점수를 250점 이상 받은 지원자는 1명 입니다.
//"- and backend and senior and - 150" : backend 직군을 선택했고, senior 경력인 지원자 중 코딩테스트 점수를 150점 이상 받은 지원자는 1명 입니다.
//"- and - and - and chicken 100" : 소울푸드로 chicken을 선택한 지원자 중 코딩테스트 점수를 100점 이상을 받은 지원자는 2명 입니다.
//"- and - and - and - 150" : 코딩테스트 점수를 150점 이상 받은 지원자는 4명 입니다.

class Solution72412() {
    /*enum class Language {
        ALL, CPP, JAVA, PYTHON
    }

    enum class Job {
        ALL, BACK_END, FRONT_END
    }

    enum class Career {
        ALL, JUNIOR, SENIOR
    }

    enum class Food {
        ALL, CHICKEN, PIZZA
    }

    data class Person(
        val lang: Language,
        val job: Job,
        val career: Career,
        val food: Food,
        val score: Int,
    ) {
        fun isRight(question: Question): Boolean {
            if (question.score > score) return false
            if (question.lang != Language.ALL && question.lang != lang) return false
            if (question.job != Job.ALL && question.job != job) return false
            if (question.career != Career.ALL && question.career != career) return false
            return !(question.food != Food.ALL && question.food != food)
        }
    }

    data class Question(
        val lang: Language = Language.ALL,
        val job: Job = Job.ALL,
        val career: Career = Career.ALL,
        val food: Food = Food.ALL,
        val score: Int = 0,
    )

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val people = Array(info.size) { i ->
            val st = StringTokenizer(info[i])
            Person(
                lang = when (st.nextToken()) {
                    "cpp" -> Language.CPP
                    "java" -> Language.JAVA
                    "python" -> Language.PYTHON
                    else -> Language.ALL
                },
                job = when (st.nextToken()) {
                    "backend" -> Job.BACK_END
                    "frontend" -> Job.FRONT_END
                    else -> Job.ALL
                },
                career = when (st.nextToken()) {
                    "junior" -> Career.JUNIOR
                    "senior" -> Career.SENIOR
                    else -> Career.ALL
                },
                food = when (st.nextToken()) {
                    "chicken" -> Food.CHICKEN
                    "pizza" -> Food.PIZZA
                    else -> Food.ALL
                },
                score = st.nextToken().toInt()
            )
        }.sortedBy { it.score }

        fun binarySearch(score: Int): Int {
            var low = 0
            var high = people.size -1
            while (low <= high) {
                val mid = (low + high) / 2
                if (people[mid].score < score ){
                    low = mid+1
                }else{
                    high = mid-1
                }
            }
            return  low
        }

        val answers = IntArray(query.size) { i ->
            val st = StringTokenizer(query[i])

            val lang = st.nextToken()
            st.nextToken()
            val job = st.nextToken()
            st.nextToken()
            val career = st.nextToken()
            st.nextToken()
            val food = st.nextToken()

            val question = Question(
                lang = when (lang) {
                    "cpp" -> Language.CPP
                    "java" -> Language.JAVA
                    "python" -> Language.PYTHON
                    else -> Language.ALL
                },
                job = when (job) {
                    "backend" -> Job.BACK_END
                    "frontend" -> Job.FRONT_END
                    else -> Job.ALL
                },
                career = when (career) {
                    "junior" -> Career.JUNIOR
                    "senior" -> Career.SENIOR
                    else -> Career.ALL
                },
                food = when (food) {
                    "chicken" -> Food.CHICKEN
                    "pizza" -> Food.PIZZA
                    else -> Food.ALL
                },
                score = st.nextToken().toInt()
            )

            //이분 탐색
            var count = 0
            for (j in binarySearch(question.score) until people.size) {
                if (people[j].isRight(question)) count++
            }
            count
        }

        return answers
    }*/
    // 효율성 실패

    private val hm = HashMap<String, MutableList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        info.forEach { dfs("", 0, it.split(" ")) }
        hm.values.forEach { it.sort() }

        for (i in query.indices) {
            val str = query[i].replace(" and ", "").split(" ")
            answer[i] = binarySearch(str[0], str[1].toInt())
        }
        return answer
    }

    private fun dfs(key: String, depth: Int, row: List<String>) {
        if (depth == 4) {
            if (hm.containsKey(key)) {
                hm[key]!!.add(row[depth].toInt())
            } else {
                hm[key] = mutableListOf(row[depth].toInt())
            }
            return
        }
        dfs("$key-", depth + 1, row)
        dfs("$key${row[depth]}", depth + 1, row)
    }

    private fun binarySearch(key: String, score: Int): Int {
        return hm[key]?.let { list ->
            var start = 0
            var end = list.size - 1
            while (start <= end) {
                val mid = (start + end) / 2
                if (list[mid] < score) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            list.size - start
        } ?: 0
    }
}


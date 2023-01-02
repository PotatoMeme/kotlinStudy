# 배낭문제, KnapsackProblem

## 개요

조합 최적화 문제의 일종이다.
간략하게 말하자면, 담을 수 있는 최대 무게가 정해진 배낭과 함께 각각의 무게와 가치가 주어진 아이템의 집합이 주어졌을 때, 배낭에 담은 아이템들의 가치의 합이 최대가 되도록 하는 아이템들의 부분집합을 찾는 문제이다.

## 분할가능한 배낭문제
주어지는 물품들이 분할가능하여 **그리디알고리즘** 즉, 해당물품들의 최소 분할단위로 나누었을때의 가치로나누어 정렬한후 최대무게까지넣으면 된다.

### <a href="https://namu.wiki/w/%EB%B0%B0%EB%82%AD%20%EB%AC%B8%EC%A0%9C"> 탐욕법 예시 </a>

    def knapsack1(W, w, p): # W는 최대 무게, w는 무게 배열, p는 가치의 배열
        n = len(w) - 1
        K = [0] * (n + 1)
        weight = 0
        for i in range(1, n + 1):
            weight += w[i]
            K[i] = w[i]
            if (weight > W):
                K[i] -= (weight - W)
                break;
        return K

## 분할 불가능한 배낭문제
이러한문제의 종류같은경우 **탐욕법**으로는 해를 구할수 없습니다.
따라서 **동적 계획법**이나 **백트래킹**같은 조합 최적화 문제의 풀이 방법으로 풀어야 합니다.

### 동적 계획법 예시 
    //try2 use Dynamic Programming,Top-Down
    class Solution12865_try2(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
        private val valueArr = Array(n) { IntArray(k + 1) { -1 } }
        var max: Int
    
        init {
            max = knapsack(n - 1, k)
        }
    
        private fun knapsack(index: Int, kg: Int): Int {
            if (index < 0) return 0
            if (valueArr[index][kg] < 0) {
                if (arr[index].first > kg) {
                    valueArr[index][kg] = knapsack(index - 1, kg)
                } else {
                    valueArr[index][kg] =
                        max(
                            knapsack(index - 1, kg),
                            knapsack(index - 1, kg - arr[index].first) + arr[index].second
                        )
                }
            }
            return valueArr[index][kg]
        }
    }

    //try3 use Dynamic Programming,Bottom-Up
    class Solution12865_try3(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
        private val valueArr = Array(n + 1) { IntArray(k + 1) { 0 } }
        val max: Int
            get() = valueArr[n][k]
    
        init {
            knapsack()
        }
    
        private fun knapsack() {
            for (i in 1..n) {
                for (j in 1..k) {
                    valueArr[i][j] = if (arr[i - 1].first > j) {
                        valueArr[i - 1][j]
                    } else {
                        max(
                            valueArr[i - 1][j],
                            valueArr[i - 1][j - arr[i - 1].first] + arr[i - 1].second
                        )
                    }
                }
            }
        }
    }
    
    //try4 use Dynamic Programming,Bottom-Up
    class Solution12865_try4(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
        private val valueArr = IntArray(k + 1) { 0 }
        val max: Int
            get() = valueArr[k]
    
        init {
            knapsack()
        }
    
        private fun knapsack() {
            for (i in 1..n) {
                for (j in k downTo arr[i-1].first) {
                    valueArr[j] = max(
                        valueArr[j],
                        valueArr[j - arr[i - 1].first] + arr[i - 1].second
                    )
                }
            }
        }
    }

###  백트래킹 예시
    class Solution12865_try1(val n: Int, val k: Int, val arr: Array<Pair<Int, Int>>) {
        val visited: BooleanArray = BooleanArray(n)
        var max = Int.MIN_VALUE
    
        init {
            dfs(0, 0)
        }
    
        fun dfs(totalWeight: Int, totalValue: Int) {
            for (i in 0 until n) {
                if (!visited[i]) {
                    val save = totalWeight + arr[i].first
                    if (save > k) {
                        if (max < totalValue) max = totalValue
                    } else {
                        visited[i] = true
                        dfs(save, totalValue + arr[i].second)
                        visited[i] = false
                    }
                }
            }
        }//시간 초과
    }



### 참고
https://namu.wiki/w/%EB%B0%B0%EB%82%AD%20%EB%AC%B8%EC%A0%9C
https://jeonyeohun.tistory.com/86
https://chanhuiseok.github.io/posts/improve-6/
https://st-lab.tistory.com/141
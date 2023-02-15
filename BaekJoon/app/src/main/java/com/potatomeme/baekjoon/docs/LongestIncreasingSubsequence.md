# LIS ( Longest Increasing Subsequence , 최장 증가 부분 수열

## 개요 및 정의

어떤 임의의 수열이 주어질 때, 이 수열에서 몇 개의 수들을 제거해서 부분수열을 만들 수 있다.
이때 만들어진 부분수열 중 오름차순으로 정렬된 가장 긴 수열을 최장 증가 부분 수열이라 한다.

##  1번 알고리즘 ( 시간복잡도, O(N^2)
DFS(Depth First Search)는 상태공간을 나타낸 트리에서 바닥에 도달할 때까지 한 쪽 방향으로만 내려가는 방식이다.

### 장점
* 단지 현 경로상의 노드들만을 기억하면 되므로 저장 공간의 수요가 비교적 적다.
* 목표 노드가 깊은 단계에 있을 경우 해를 빨리 구할 수 있다.

### 단점
* 해가 없는 경로에 깊이 빠질 가능성이 있다. 따라서 실제로는 미리 지정한 임의 깊이까지만 탐색하고 목표 노드를 발견하지 못하면 다음 경로를 따라 탐색하는 방법이 유용할 수 있다.
* 얻어진 해가 최단 경로가 된다는 보장이 없다. 이는 목표에 이르는 경로가 다수인 문제에 대해 깊이우선탐색은 해에 다다르면 탐색을 끝내버리므로, 이때 얻어진 해는 최적이 아닐 수 있다는 의미이다.

### 예시 (C++) : https://namu.wiki/w/%EA%B9%8A%EC%9D%B4%20%EC%9A%B0%EC%84%A0%20%ED%83%90%EC%83%89?from=DFS

    const int MAX = 100'001;

    bool visited[MAX]; // 방문 배열. visited[node] = true이면 node는 방문이 끝난 상태이다.
    
    void dfs(const vector<int> graph[], int current) { // graph는 인접 리스트, current는 현재 노드
        visited[current] = true; // current 방문
    
        for(int next: graph[current]) { // current의 인접 노드를 확인한다. 이 노드를 next라고 하자.
            if(!visited[next]) { // 만일 next에 방문하지 않았다면
                dfs(graph, next); // next 방문
            }
        }
    }

### 예시 (Kotlin) : https://toonraon.tistory.com/44

    fun main () {
    // 입력
    val inputs = """
        15 16
        1 2
        1 8
        1 9
        2 3
        2 7
        2 5
        3 4
        3 6
        4 5
        9 10
        9 15
        9 13
        10 11
        10 12
        13 12
        13 14
    """.trimIndent().lines()
    println("============= inputs =============")
    inputs.forEach { println(it) }

    // 입력을 배열로 저장
    val (v, e) = inputs[0].split(" ").map { it.toInt() }
    val edges = Array<ArrayList<Int>>(e + 1) { ArrayList() } // 0 버림
    val visited = BooleanArray(v + 1) // 0 버림
    for (i in 1 .. e) {
        val (a, b) = inputs[i].split(" ").map { it.toInt() }
        edges[a].add(b)
        edges[b].add(a)
    }

    // dfs
    println("============= dfs =============")
    fun dfs(index: Int) {
        visited[index] = true
        println(index)

        // 구현
        for (next in edges[index]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }
    dfs(1)


## BFS(너비 우선 탐색)
BFS(Breadth First Search)는 모든 분기점을 다 검사하면서 진행하는 방식이다.

### 로직
1. 루트에서 시작한다.
2. 자식 노드들을 [1]에 저장한다.
3. [1]에 저장된 노드들을 차례로 방문한다. 또한 각각의 자식들을 [2]에 저장한다.
4. [2]에 저장된 노드들을 차례로 방문한다. 또한 각각의 자식들을 [3]에 저장한다.
5. 위의 과정을 반복한다.
6. 모든 노드를 방문하면 탐색을 마친다.

### DFS와 차이
DFS는 갈림길에서 하나의 길로 들어서서 막다른 길이 나올 때까지 깊게 탐색을 하는 것을 볼 수 있고, BFS는 갈림길에 연결되어 있는 모든 길을 한번씩 탐색한 뒤 다시 연결되어 있는 모든 길을 넓게 탐색하는 것을 볼 수 있다.

### 예시 (C++) : https://namu.wiki/w/%EB%84%88%EB%B9%84%20%EC%9A%B0%EC%84%A0%20%ED%83%90%EC%83%89

    const int MAX = 100'001;

    queue<int> q;
    bool visited[MAX]; // 방문 배열. visited[node] = true이면 node는 방문이 끝난 상태이다.
    
    void bfs(const vector<int> graph[], int source) { // graph는 인접 리스트, source는 시작 노드
    // source 방문
    q.push(source);
    visited[source] = true;
    
        while(!q.empty()) { // 큐가 빌 때까지 반복
            // 큐에서 노드를 하나 빼 온다. 이 노드를 current라고 하자.
            int current = q.front();
            q.pop();
    
            for(int next: graph[current]) { // current의 인접 노드들을 확인한다. 이 각각의 노드를 next라고 하자.
                if(!visited[next]) { // 만일 next에 방문하지 않았다면
                    // next 방문
                    q.push(next);
                    visited[next] = true;
                }
            }
        }
    }


### 예시 (Kotlin) : https://toonraon.tistory.com/44

    fun main () {
    // 입력
    val inputs = """
        15 16
        1 2
        1 8
        1 9
        2 3
        2 7
        2 5
        3 4
        3 6
        4 5
        9 10
        9 15
        9 13
        10 11
        10 12
        13 12
        13 14
    """.trimIndent().lines()
    println("============= inputs =============")
    inputs.forEach { println(it) }

    // 입력을 배열로 저장
    val (v, e) = inputs[0].split(" ").map { it.toInt() }
    val edges = Array<ArrayList<Int>>(e + 1) { ArrayList() } // 0 버림
    val visited = BooleanArray(v + 1) // 0 버림
    for (i in 1 .. e) {
        val (a, b) = inputs[i].split(" ").map { it.toInt() }
        edges[a].add(b)
        edges[b].add(a)
    }

    // bfs
    println("============= bfs =============")
    val queue = LinkedList<Int>()
    fun bfs(start: Int) {
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val head = queue.poll() // 첫 원소 반환 후 remove
            println(head)

            for (next in edges[head]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
    }
    bfs(1)

### 참고
https://namu.wiki/w/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9
https://ko.wikipedia.org/wiki/%ED%87%B4%EA%B0%81%EA%B2%80%EC%83%89
https://toonraon.tistory.com/44
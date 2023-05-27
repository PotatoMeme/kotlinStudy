package com.potatomeme.programmers.codingtest.years23.may.level3

//길 찾기 게임
//문제 설명
//길 찾기 게임
//전무로 승진한 라이언은 기분이 너무 좋아 프렌즈를 이끌고 특별 휴가를 가기로 했다.
//내친김에 여행 계획까지 구상하던 라이언은 재미있는 게임을 생각해냈고 역시 전무로 승진할만한 인재라고 스스로에게 감탄했다.
//
//라이언이 구상한(그리고 아마도 라이언만 즐거울만한) 게임은, 카카오 프렌즈를 두 팀으로 나누고, 각 팀이 같은 곳을 다른 순서로 방문하도록 해서 먼저 순회를 마친 팀이 승리하는 것이다.
//
//그냥 지도를 주고 게임을 시작하면 재미가 덜해지므로, 라이언은 방문할 곳의 2차원 좌표 값을 구하고 각 장소를 이진트리의 노드가 되도록 구성한 후, 순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾도록 할 계획이다.
//
//라이언은 아래와 같은 특별한 규칙으로 트리 노드들을 구성한다.
//
//트리를 구성하는 모든 노드의 x, y 좌표 값은 정수이다.
//모든 노드는 서로 다른 x값을 가진다.
//같은 레벨(level)에 있는 노드는 같은 y 좌표를 가진다.
//자식 노드의 y 값은 항상 부모 노드보다 작다.
//임의의 노드 V의 왼쪽 서브 트리(left subtree)에 있는 모든 노드의 x값은 V의 x값보다 작다.
//임의의 노드 V의 오른쪽 서브 트리(right subtree)에 있는 모든 노드의 x값은 V의 x값보다 크다.
//아래 예시를 확인해보자.
//
//라이언의 규칙에 맞게 이진트리의 노드만 좌표 평면에 그리면 다음과 같다. (이진트리의 각 노드에는 1부터 N까지 순서대로 번호가 붙어있다.)
//
//tree_3.png
//
//이제, 노드를 잇는 간선(edge)을 모두 그리면 아래와 같은 모양이 된다.
//
//tree_4.png
//
//위 이진트리에서 전위 순회(preorder), 후위 순회(postorder)를 한 결과는 다음과 같고, 이것은 각 팀이 방문해야 할 순서를 의미한다.
//
//전위 순회 : 7, 4, 6, 9, 1, 8, 5, 2, 3
//후위 순회 : 9, 6, 5, 8, 1, 4, 3, 2, 7
//다행히 두 팀 모두 머리를 모아 분석한 끝에 라이언의 의도를 간신히 알아차렸다.
//
//그러나 여전히 문제는 남아있다. 노드의 수가 예시처럼 적다면 쉽게 해결할 수 있겠지만, 예상대로 라이언은 그렇게 할 생각이 전혀 없었다.
//
//이제 당신이 나설 때가 되었다.
//
//곤경에 빠진 카카오 프렌즈를 위해 이진트리를 구성하는 노드들의 좌표가 담긴 배열 nodeinfo가 매개변수로 주어질 때,
//노드들로 구성된 이진트리를 전위 순회, 후위 순회한 결과를 2차원 배열에 순서대로 담아 return 하도록 solution 함수를 완성하자.
//
//제한사항
//nodeinfo는 이진트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열이다.
//nodeinfo의 길이는 1 이상 10,000 이하이다.
//nodeinfo[i] 는 i + 1번 노드의 좌표이며, [x축 좌표, y축 좌표] 순으로 들어있다.
//모든 노드의 좌표 값은 0 이상 100,000 이하인 정수이다.
//트리의 깊이가 1,000 이하인 경우만 입력으로 주어진다.
//모든 노드의 좌표는 문제에 주어진 규칙을 따르며, 잘못된 노드 위치가 주어지는 경우는 없다.
//입출력 예
//nodeinfo	result
//[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]	[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
//입출력 예 설명
//입출력 예 #1
//
//문제에 주어진 예시와 같다.

fun main() {
    println(Solution42892().solution(
        arrayOf(
            intArrayOf(5, 3),
            intArrayOf(11, 5),
            intArrayOf(13, 3),
            intArrayOf(3, 5),
            intArrayOf(6, 1),
            intArrayOf(1, 3),
            intArrayOf(8, 6),
            intArrayOf(7, 2),
            intArrayOf(2, 2)
        )
    ))

}

class Solution42892() {


    // 전위 순회 dfs로 함수 도입부에서 각 값을 추가
    // 후위순회 dfs로 함수 마지막에에 각 값을 추가

    // dfs를 하려면 nodeinfo를 가공 해야함
    // visited : BooleanArray = BooleanArray(nodeinfo.size)

    /*data class Node(
        val x: Int,
        val y: Int,
        val idx: Int,
    )

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val answer = Array(2) { IntArray(nodeinfo.size) }

        val nodes = nodeinfo.mapIndexed { index, ints ->
            Node(ints[0], ints[1], index)
        }.sortedWith(compareBy({ -it.y }, { it.x }))
        val visited = BooleanArray(nodeinfo.size)

        var firstIdx = 0
        var secondIdx = 0

        fun dfs(nodesIdx: Int, min: Int, max: Int) {
            visited[nodesIdx] = true
            val node = nodes[nodesIdx] // 해당 노드
            answer[0][firstIdx++] = node.idx + 1

            val minX =
                if (nodesIdx != 0 && node.y == nodes[nodesIdx - 1].y && nodes[nodesIdx - 1].x > min) nodes[nodesIdx - 1].x else min
            val maxX =
                if (nodesIdx != nodes.lastIndex && node.y == nodes[nodesIdx + 1].y && nodes[nodesIdx + 1].x < max) nodes[nodesIdx + 1].x else max

            var left = false // 왼쪽 확인용
            //같은 레벨(level)에 있는 노드는 같은 y 좌표를 가진다.
            var checkedY = node.y
            var changedYCount = 0


            for (i in nodesIdx + 1..nodes.lastIndex) {
                if (nodes[i].y != checkedY) {
                    checkedY = nodes[i].y
                    changedYCount++
                }
                if (changedYCount == 1) {
                    //임의의 노드 V의 왼쪽 서브 트리(left subtree)에 있는 모든 노드의 x값은 V의 x값보다 작다.
                    if (!left && nodes[i].x > minX && nodes[i].x < node.x && !visited[i]) {
                        left = true
                        dfs(i, minX, node.x)
                    }
                    //임의의 노드 V의 오른쪽 서브 트리(right subtree)에 있는 모든 노드의 x값은 V의 x값보다 크다.
                    if (nodes[i].x >= maxX) break
                    if (nodes[i].x > node.x && !visited[i]) {
                        dfs(i, node.x, maxX)
                        break // 오르쪽 노드를 확인하고 나면 그이후로는 해당 노드의 자식이 아님
                    }
                } else if (changedYCount > 1) break
                // 2번이상 변한 경우 다음레밸 이상이기 때문에 해당노드의 자식이 아님
            }
            answer[1][secondIdx++] = node.idx + 1
        }

        dfs(0, Int.MIN_VALUE, Int.MAX_VALUE)
        return answer
    }*/
    //테스트 1 〉	통과 (17.50ms, 63.4MB)
    //테스트 2 〉	통과 (17.46ms, 64.6MB)
    //테스트 3 〉	통과 (16.83ms, 63.2MB)
    //테스트 4 〉	통과 (17.81ms, 64.7MB)
    //테스트 5 〉	통과 (17.08ms, 63.4MB)
    //테스트 6 〉	통과 (23.61ms, 64.9MB)
    //테스트 7 〉	통과 (22.60ms, 64.5MB)
    //테스트 8 〉	통과 (31.37ms, 71.8MB)
    //테스트 9 〉	통과 (46.59ms, 85.6MB)
    //테스트 10 〉	통과 (24.14ms, 73.4MB)
    //테스트 11 〉	통과 (52.05ms, 85.9MB)
    //테스트 12 〉	통과 (51.31ms, 86MB)
    //테스트 13 〉	통과 (19.69ms, 63.6MB)
    //테스트 14 〉	통과 (32.47ms, 68.4MB)
    //테스트 15 〉	통과 (90.33ms, 75.6MB)
    //테스트 16 〉	통과 (146.28ms, 86.6MB)
    //테스트 17 〉	통과 (26.00ms, 64.9MB)
    //테스트 18 〉	통과 (91.32ms, 88MB)
    //테스트 19 〉	통과 (31.93ms, 67.5MB)
    //테스트 20 〉	통과 (65.94ms, 73.4MB)
    //테스트 21 〉	통과 (75.63ms, 75.7MB)
    //테스트 22 〉	통과 (90.44ms, 86.9MB)
    //테스트 23 〉	통과 (99.52ms, 88.4MB)
    //테스트 24 〉	통과 (17.37ms, 65.1MB)
    //테스트 25 〉	통과 (17.30ms, 63MB)
    //테스트 26 〉	통과 (21.51ms, 67.7MB)
    //테스트 27 〉	통과 (17.58ms, 63.8MB)
    //테스트 28 〉	통과 (17.30ms, 63.4MB)
    //테스트 29 〉	통과 (7.88ms, 63.2MB)


    // user solution
    data class Point(val x:Int, val y:Int, val value:Int)
    data class TreeNode(var left:TreeNode?, var right:TreeNode?, val point:Point)

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {

        val list = ArrayList<Point>()
        var i = 1
        for (y in nodeinfo)
            list.add(Point(y[0], y[1], i++))
        val ret = list.sortedWith(compareByDescending<Point> { it.y }.thenBy { it.x })
        val root = TreeNode(null, null, ret[0])

        for (temp in ret.subList(1, ret.count()))
            addTreeNode(temp, root)
        val preOrderRet = ArrayList<Int>()
        val postOrderRet = ArrayList<Int>()
        preOrder(preOrderRet, root)
        postOrder(postOrderRet, root)
        return arrayOf(preOrderRet.toIntArray(), postOrderRet.toIntArray())
    }
    private fun addTreeNode(target:Point, root:TreeNode){
        if(root.point.x > target.x){
            root.left?.let { addTreeNode(target, root.left!!) }
                ?:let { root.left = TreeNode(null, null, target) }
        }else{
            root.right?.let { addTreeNode(target, root.right!!) }
                ?:let { root.right = TreeNode(null,null, target) }
        }
    }
    private fun preOrder(ret:ArrayList<Int>, root:TreeNode){
        ret.add(root.point.value)
        root.left?.let{preOrder(ret, root.left!!)}
        root.right?.let{preOrder(ret, root.right!!)}
    }
    private fun postOrder(ret:ArrayList<Int>, root:TreeNode){
        root.left?.let { postOrder(ret, root.left!!) }
        root.right?.let { postOrder(ret, root.right!!) }
        ret.add(root.point.value)
    }
    //테스트 1 〉	통과 (17.11ms, 63.7MB)
    //테스트 2 〉	통과 (18.28ms, 64.4MB)
    //테스트 3 〉	통과 (17.32ms, 63.9MB)
    //테스트 4 〉	통과 (17.47ms, 63.3MB)
    //테스트 5 〉	통과 (17.36ms, 63.7MB)
    //테스트 6 〉	통과 (28.40ms, 66.4MB)
    //테스트 7 〉	통과 (33.10ms, 65.2MB)
    //테스트 8 〉	통과 (34.28ms, 74.6MB)
    //테스트 9 〉	통과 (54.68ms, 82.4MB)
    //테스트 10 〉	통과 (24.27ms, 72.8MB)
    //테스트 11 〉	통과 (51.24ms, 85.8MB)
    //테스트 12 〉	통과 (52.42ms, 84.3MB)
    //테스트 13 〉	통과 (19.05ms, 65.7MB)
    //테스트 14 〉	통과 (22.89ms, 66.9MB)
    //테스트 15 〉	통과 (31.30ms, 75.5MB)
    //테스트 16 〉	통과 (37.65ms, 88.4MB)
    //테스트 17 〉	통과 (22.27ms, 69.5MB)
    //테스트 18 〉	통과 (42.97ms, 85.7MB)
    //테스트 19 〉	통과 (24.50ms, 67.6MB)
    //테스트 20 〉	통과 (31.11ms, 73.2MB)
    //테스트 21 〉	통과 (32.95ms, 76.8MB)
    //테스트 22 〉	통과 (38.48ms, 86MB)
    //테스트 23 〉	통과 (38.82ms, 86.7MB)
    //테스트 24 〉	통과 (17.61ms, 64.3MB)
    //테스트 25 〉	통과 (17.56ms, 63.6MB)
    //테스트 26 〉	통과 (38.33ms, 69.3MB)
    //테스트 27 〉	통과 (16.97ms, 63.3MB)
    //테스트 28 〉	통과 (17.78ms, 63.9MB)
    //테스트 29 〉	통과 (7.39ms, 62.1MB)
}


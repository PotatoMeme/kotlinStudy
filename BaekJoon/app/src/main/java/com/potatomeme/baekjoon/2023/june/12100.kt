package com.potatomeme.baekjoon.`2023`.june

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/12100

//2048 (Easy)
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	77597	22452	13083	26.141%
//문제
//2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 링크를 누르면 게임을 해볼 수 있다.
//
//이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다. 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다. 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)
//
//
//<그림 1>	<그림 2>	<그림 3>
//<그림 1>의 경우에서 위로 블록을 이동시키면 <그림 2>의 상태가 된다. 여기서, 왼쪽으로 블록을 이동시키면 <그림 3>의 상태가 된다.
//
//
//<그림 4>	<그림 5>	<그림 6>	<그림 7>
//<그림 4>의 상태에서 블록을 오른쪽으로 이동시키면 <그림 5>가 되고, 여기서 다시 위로 블록을 이동시키면 <그림 6>이 된다. 여기서 오른쪽으로 블록을 이동시켜 <그림 7>을 만들 수 있다.
//
//
//<그림 8>	<그림 9>
//<그림 8>의 상태에서 왼쪽으로 블록을 옮기면 어떻게 될까? 2가 충돌하기 때문에, 4로 합쳐지게 되고 <그림 9>의 상태가 된다.
//
//
//<그림 10>	<그림 11>	<그림 12>	<그림 13>
//<그림 10>에서 위로 블록을 이동시키면 <그림 11>의 상태가 된다.
//
//<그림 12>의 경우에 위로 블록을 이동시키면 <그림 13>의 상태가 되는데, 그 이유는 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문이다.
//
//
//<그림 14>	<그림 15>
//마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다. 예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.
//
//이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.
//
//출력
//최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.
//
//예제 입력 1
//3
//2 2 2
//4 4 4
//8 8 8
//예제 출력 1
//16

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(n) {
            st.nextToken().toInt()
        }
    }
    print(Solution12100Type1(n, board).max)
}


class Solution12100Type1(val n: Int, board: Array<IntArray>) {
    //최대 5번 이동 -> 4*4*4*4*4 => 1024번을 돌리기
    //이경우 최대값을 구하는것이기 때문에 bfs보다는 dfs가 구현하기더편해보임

    var max: Int = Int.MIN_VALUE
    private var board = board.map { it.copyOf() }

    init {
        dfs(0)
    }

    fun dfs(depth: Int) {
        for (y in 0 until n) {
            for (x in 0 until n) {
                if (board[y][x] > max) max = board[y][x]
            }
        }
        if (depth == 5) {
            return
        }
        val save = board.map { it.copyOf() }
        var moved = Array(n) { BooleanArray(n) }
        var movedCnt = 0
        //이동로직 상
        for (y in 1 until n) {
            for (x in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubY = y
                    var isSame = false
                    subLoop@ for (subY in y - 1 downTo 0) {
                        if (moved[subY][x]) break@subLoop
                        if (board[subY][x] == board[y][x]) {
                            lastSubY = subY
                            isSame = true
                            break@subLoop
                        } else if (board[subY][x] == 0) {
                            lastSubY = subY
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubY != y) {
                        board[lastSubY][x] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[lastSubY][x] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }

        //이동로직 좌
        for (x in 1 until n) {
            for (y in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubX = x
                    var isSame = false
                    subLoop@ for (subX in x - 1 downTo 0) {
                        if (moved[y][subX]) break@subLoop
                        if (board[y][subX] == board[y][x]) {
                            lastSubX = subX
                            isSame = true
                            break@subLoop
                        } else if (board[y][subX] == 0) {
                            lastSubX = subX
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubX != x) {
                        board[y][lastSubX] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[y][lastSubX] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }

        //이동로직 하
        for (y in n - 2 downTo 0) {
            for (x in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubY = y
                    var isSame = false
                    subLoop@ for (subY in y + 1 until n) {
                        if (moved[subY][x]) break@subLoop
                        if (board[subY][x] == board[y][x]) {
                            lastSubY = subY
                            isSame = true
                            break@subLoop
                        } else if (board[subY][x] == 0) {
                            lastSubY = subY
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubY != y) {
                        board[lastSubY][x] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[lastSubY][x] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }
        //이동로직 우
        for (x in n - 2 downTo 0) {
            for (y in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubX = x
                    var isSame = false
                    subLoop@ for (subX in x + 1 until n) {
                        if (moved[y][subX]) break@subLoop
                        if (board[y][subX] == board[y][x]) {
                            lastSubX = subX
                            isSame = true
                            break@subLoop
                        } else if (board[y][subX] == 0) {
                            lastSubX = subX
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubX != x) {
                        board[y][lastSubX] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[y][lastSubX] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
        }
    }
}
class Solution12100Type2(val n: Int, board: Array<IntArray>) {
    //최대 5번 이동 -> 4*4*4*4*4 => 1024번을 돌리기
    //이경우 최대값을 구하는것이기 때문에 bfs보다는 dfs가 구현하기더편해보임

    var max: Int = Int.MIN_VALUE
    private var board = board.map { it.copyOf() }

    init {
        dfs(0)
    }

    fun dfs(depth: Int) {
        for (y in 0 until n) {
            for (x in 0 until n) {
                if (board[y][x] > max) max = board[y][x]
            }
        }
        if (depth == 5) {
            return
        }
        val save = board.map { it.copyOf() }
        var moved = Array(n) { BooleanArray(n) }
        var movedCnt = 0
        //이동로직 상
        for (y in 1 until n) {
            for (x in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubY = y
                    var isSame = false
                    subLoop@ for (subY in y - 1 downTo 0) {
                        if (moved[subY][x]) break@subLoop
                        if (board[subY][x] == board[y][x]) {
                            lastSubY = subY
                            isSame = true
                            break@subLoop
                        } else if (board[subY][x] == 0) {
                            lastSubY = subY
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubY != y) {
                        board[lastSubY][x] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[lastSubY][x] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }

        //이동로직 좌
        for (x in 1 until n) {
            for (y in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubX = x
                    var isSame = false
                    subLoop@ for (subX in x - 1 downTo 0) {
                        if (moved[y][subX]) break@subLoop
                        if (board[y][subX] == board[y][x]) {
                            lastSubX = subX
                            isSame = true
                            break@subLoop
                        } else if (board[y][subX] == 0) {
                            lastSubX = subX
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubX != x) {
                        board[y][lastSubX] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[y][lastSubX] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }

        //이동로직 하
        for (y in n - 2 downTo 0) {
            for (x in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubY = y
                    var isSame = false
                    subLoop@ for (subY in y + 1 until n) {
                        if (moved[subY][x]) break@subLoop
                        if (board[subY][x] == board[y][x]) {
                            lastSubY = subY
                            isSame = true
                            break@subLoop
                        } else if (board[subY][x] == 0) {
                            lastSubY = subY
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubY != y) {
                        board[lastSubY][x] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[lastSubY][x] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
            movedCnt = 0
            moved = Array(n) { BooleanArray(n) }
        }
        //이동로직 우
        for (x in n - 2 downTo 0) {
            for (y in 0 until n) {
                if (board[y][x] != 0) {
                    var lastSubX = x
                    var isSame = false
                    subLoop@ for (subX in x + 1 until n) {
                        if (moved[y][subX]) break@subLoop
                        if (board[y][subX] == board[y][x]) {
                            lastSubX = subX
                            isSame = true
                            break@subLoop
                        } else if (board[y][subX] == 0) {
                            lastSubX = subX
                            continue@subLoop
                        } else break@subLoop
                    }
                    if (lastSubX != x) {
                        board[y][lastSubX] = if (isSame) board[y][x] * 2 else board[y][x]
                        board[y][x] = 0
                        if (isSame) moved[y][lastSubX] = true
                        movedCnt++
                    }
                }
            }
        }
        if (movedCnt != 0) {
            dfs(depth + 1)
            //되돌리는 로직
            board = save.map { it.copyOf() }
        }
    }
}
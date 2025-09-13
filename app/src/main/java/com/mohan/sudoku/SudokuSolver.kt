package com.mohan.sudoku

object SudokuSolver {
    fun fillSolution(board: Array<IntArray>) {
        val n = board.size
        // simple backtracking fill for 9x9; for other sizes the implementation is naive but functional for small sizes
        fun isSafe(r: Int, c: Int, v: Int): Boolean {
            for (i in 0 until n) if (board[r][i] == v || board[i][c] == v) return false
            val box = Math.sqrt(n.toDouble()).toInt()
            val br = r / box * box
            val bc = c / box * box
            for (i in br until br + box) for (j in bc until bc + box) if (board[i][j] == v) return false
            return true
        }
        fun solve(idx: Int): Boolean {
            if (idx == n * n) return true
            val r = idx / n
            val c = idx % n
            if (board[r][c] != 0) return solve(idx + 1)
            val nums = (1..n).shuffled()
            for (v in nums) {
                if (isSafe(r, c, v)) {
                    board[r][c] = v
                    if (solve(idx + 1)) return true
                    board[r][c] = 0
                }
            }
            return false
        }
        // start with empty board
        for (r in board.indices) for (c in board[r].indices) board[r][c] = 0
        solve(0)
    }
}

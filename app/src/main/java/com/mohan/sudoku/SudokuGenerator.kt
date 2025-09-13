package com.mohan.sudoku

object SudokuGenerator {
    // Generate a solved board then remove cells according to difficulty (very simple approach)
    fun generate(size: Int, difficulty: Difficulty): SudokuGame {
        val n = size
        val solution = Array(n) { IntArray(n) }
        SudokuSolver.fillSolution(solution)
        val board = Array(n) { IntArray(n) }
        for (r in 0 until n) for (c in 0 until n) board[r][c] = solution[r][c]
        // remove cells
        val removeCount = when (difficulty) {
            Difficulty.Easy -> n * n / 4
            Difficulty.Medium -> n * n / 3
            Difficulty.Hard -> n * n / 2
            Difficulty.Expert -> n * n * 2 / 3
        }
        var removed = 0
        val rand = java.util.Random()
        while (removed < removeCount) {
            val r = rand.nextInt(n)
            val c = rand.nextInt(n)
            if (board[r][c] != 0) {
                board[r][c] = 0
                removed++
            }
        }
        return SudokuGame.from(board, solution)
    }
}

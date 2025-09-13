package com.mohan.sudoku

data class SudokuGame(val size: Int, val board: Array<IntArray>, val solution: Array<IntArray>) {
    companion object {
        fun from(board: Array<IntArray>, solution: Array<IntArray>) = SudokuGame(board.size, board, solution)
    }

    fun isComplete(): Boolean {
        for (r in board.indices) for (c in board[r].indices) if (board[r][c] == 0) return false
        return true
    }
}

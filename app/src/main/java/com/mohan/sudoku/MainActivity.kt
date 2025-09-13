package com.mohan.sudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mohan.sudoku.ui.GameScreen
import com.mohan.sudoku.ui.theme.SudokuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val game = SudokuGenerator.generate(9, Difficulty.Easy)
        setContent {
            SudokuTheme {
                GameScreen(game)
            }
        }
    }
}

enum class Difficulty { Easy, Medium, Hard, Expert }

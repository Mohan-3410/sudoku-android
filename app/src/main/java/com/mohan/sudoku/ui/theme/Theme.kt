package com.mohan.sudoku.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColors = darkColors(
    primary = androidx.compose.ui.graphics.Color(0xFF1E88E5),
    secondary = androidx.compose.ui.graphics.Color(0xFF90CAF9)
)

@Composable
fun SudokuTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = DarkColors) {
        content()
    }
}

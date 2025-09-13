package com.mohan.sudoku.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohan.sudoku.SudokuGame

@Composable
fun GameScreen(game: SudokuGame) {
    var board by remember { mutableStateOf(game.board.map { it.copyOf() }.toTypedArray()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Sudoku", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        val size = board.size
        Column {
            for (r in 0 until size) {
                Row {
                    for (c in 0 until size) {
                        val value = board[r][c]
                        Box(modifier = Modifier.size(36.dp).border(1.dp, Color.Gray).background(Color.White).clickable {
                            // naive input cycle 0->1..n
                            val next = (board[r][c] + 1) % (size + 1)
                            board[r][c] = next
                        }, contentAlignment = Alignment.Center) {
                            if (value != 0) Text(value.toString(), fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

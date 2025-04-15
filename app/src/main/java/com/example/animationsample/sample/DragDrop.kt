package com.example.animationsample.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DragDrop() {
    var points: List<Offset> by remember { mutableStateOf(emptyList()) }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(key1 = Unit) {
                detectTapGestures {
                    points += it
                }
            }
            .background(
                color = Color.White
            )
    ) {
        drawPath(
            path = Path().apply {
                moveTo(x = center.x, y = 100.dp.toPx())

                lineTo(x = center.x + 25.dp.toPx(), y = 150.dp.toPx())
                lineTo(x = center.x + 75.dp.toPx(), y = 150.dp.toPx())
                lineTo(x = center.x + 45.dp.toPx(), y = 195.dp.toPx())
                lineTo(x = center.x + 60.dp.toPx(), y = 250.dp.toPx())
                lineTo(x = center.x, y = 220.dp.toPx())
                lineTo(x = center.x - 60.dp.toPx(), y = 250.dp.toPx())
                lineTo(x = center.x - 45.dp.toPx(), y = 195.dp.toPx())
                lineTo(x = center.x - 75.dp.toPx(), y = 150.dp.toPx())
                lineTo(x = center.x - 25.dp.toPx(), y = 150.dp.toPx())
                lineTo(x = center.x, y = 100.dp.toPx())

            },
            color = Color.White,
            style = Fill,
        )
        val path = Path()
        points.forEachIndexed { index, offset ->
            if (index == 0) {
                path.moveTo(offset.x, offset.y)
                drawCircle(
                    brush = Brush.linearGradient(colors = listOf(Color.Blue, Color.Cyan, Color.Magenta)),
                    radius = 20.dp.toPx(),
                    center = offset
                )
            } else {
                path.lineTo(offset.x, offset.y)
            }
        }
        drawPath(
            path = path,
            brush = Brush.linearGradient(
                listOf(Color.Blue, Color.Cyan, Color.Magenta)
            ),
            style = Stroke(width = 20.dp.toPx())
        )
//        points.forEach {
//            drawCircle(
//                brush = Brush.linearGradient(colors = listOf(Color.Blue, Color.Cyan, Color.Magenta)),
//                radius = 50.dp.toPx(),
//                center = it
//            )
//        }
    }
}
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
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@Preview
@Composable
fun CanvasTest() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        drawLine(
            color = Color.White,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.White,
            start = Offset(size.width, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 2.dp.toPx()
        )
        drawCircle(color = Color.White, radius = 100.dp.toPx(), style = Stroke(width = 2.dp.toPx()))
    }
}

const val Y_UPPER_LINE = 30
const val Y_DOWN_LINE = 75

//@Preview
@Composable
fun Oleg() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // О
        drawCircle(
            color = Color.White,
            radius = 25.dp.toPx(),
            style = Stroke(
                width = 2.dp.toPx()
            ),
            center = Offset(x = 50.dp.toPx(), y = 50.dp.toPx())
        )

        // Л
        drawLine(
            color = Color.White,
            start = Offset(x = 100.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 75.dp.toPx(), y = Y_DOWN_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.White,
            start = Offset(x = 100.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 125.dp.toPx(), y = Y_DOWN_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.White,
            start = Offset(x = 135.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 135.dp.toPx(), y = Y_DOWN_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )

        // Е
        drawLine(
            color = Color.White,
            start = Offset(x = 135.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 175.dp.toPx(), y = 30.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.White,
            start = Offset(x = 135.dp.toPx(), y = 50.dp.toPx()),
            end = Offset(x = 175.dp.toPx(), y = 50.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.White,
            start = Offset(x = 135.dp.toPx(), y = 75.dp.toPx()),
            end = Offset(x = 175.dp.toPx(), y = Y_DOWN_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )

        // Г
        drawLine(
            color = Color.White,
            start = Offset(x = 195.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 195.dp.toPx(), y = Y_DOWN_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )

        drawLine(
            color = Color.White,
            start = Offset(x = 195.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            end = Offset(x = 225.dp.toPx(), y = Y_UPPER_LINE.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )
    }
}

@Preview
@Composable
fun PathTest() {
    var offset: Offset? by remember { mutableStateOf(null) }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(key1 = Unit) {
                detectTapGestures {
                    offset = it
                }
            }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Magenta),
                    start = Offset(x = 0f, y = 100.dp.toPx()),
                    end = Offset(x = 100.dp.toPx(), y = 100.dp.toPx()),
                    tileMode = TileMode.Mirror,

                    )
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
        offset?.let { drawCircle(color = Color.White, radius = 50.dp.toPx(), center = it) }
    }
}

@Composable
fun DrawCircleOnClick(offset: Offset) {
    Canvas(modifier = Modifier) {
        drawCircle(color = Color.White, radius = 50.dp.toPx(), center = offset)
    }
}

@Composable
fun Dp.toPx() = with((LocalDensity.current)) {
    this@toPx.toPx()
}

const val OFFSET = 50
const val LINE_LENGTH = OFFSET * 2

//@Preview
@Composable
fun House() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(colors = listOf(Color.Blue, Color.Magenta)))
    ) {
        drawPath(
            path = Path().apply {
                moveTo(x = center.x, y = center.y - OFFSET.dp.toPx())
                lineTo(x = center.x, y = center.y + OFFSET.dp.toPx())
                moveTo(x = center.x - OFFSET.dp.toPx(), y = center.y)
                lineTo(x = center.x + OFFSET.dp.toPx(), y = center.y)

                lineTo(x = center.x + OFFSET.dp.toPx(), y = center.y + OFFSET.dp.toPx())
                lineTo(x = center.x - OFFSET.dp.toPx(), y = center.y + OFFSET.dp.toPx())
                lineTo(x = center.x - OFFSET.dp.toPx(), y = center.y - OFFSET.dp.toPx())
                lineTo(x = center.x + OFFSET.dp.toPx(), y = center.y - OFFSET.dp.toPx())
                lineTo(center.x + OFFSET.dp.toPx(), y = center.y + OFFSET.dp.toPx() / 2)

                moveTo(x = center.x + LINE_LENGTH.dp.toPx(), y = center.y - LINE_LENGTH.dp.toPx())
                lineTo(x = center.x + LINE_LENGTH.dp.toPx(), y = center.y + LINE_LENGTH.dp.toPx())
                lineTo(x = center.x - LINE_LENGTH.dp.toPx(), y = center.y + LINE_LENGTH.dp.toPx())
                lineTo(x = center.x - LINE_LENGTH.dp.toPx(), y = center.y - LINE_LENGTH.dp.toPx())
                lineTo(x = center.x + LINE_LENGTH.dp.toPx(), y = center.y - LINE_LENGTH.dp.toPx())

                lineTo(x = center.x, y = center.y - 2 * LINE_LENGTH.dp.toPx())
                lineTo(x = center.x - LINE_LENGTH.dp.toPx(), y = center.y - LINE_LENGTH.dp.toPx())
            },
            color = Color.White,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}
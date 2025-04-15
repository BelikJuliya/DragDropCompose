package com.example.animationsample.ui

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val TAG = "TestAnimation"

@Composable
fun BoxesWithText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(
                state = rememberScrollState(),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var isIncreased by remember { mutableStateOf(true) }
        Log.d(TAG, "isIncreased= $isIncreased")

        val infiniteTransition = rememberInfiniteTransition()

        val size by infiniteTransition.animateFloat(
            initialValue = 200f,
            targetValue = 100f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000),
                repeatMode = RepeatMode.Reverse
            )
        )

        val rotation by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000, easing = LinearEasing)
            )
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Log.d(TAG, "Change is increase state from $isIncreased to ${!isIncreased}")
                isIncreased = !isIncreased
            }
        ) {
            Text(
                text = "Animate size",
            )
        }


//        val size by animateDpAsState(
//            targetValue = if (isIncreased) 200.dp else 100.dp,
//            animationSpec = tween(durationMillis = 3000, delayMillis = 500)
//        )

        AnimatedContainer(
            text = "Size",
            size = size.dp
        )

        var isCircle by remember { mutableStateOf(false) }
        val radius by animateIntAsState(targetValue = if (isCircle) 50 else 4)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isCircle = !isCircle
            }
        ) {
            Text(
                text = "Animate shape",
            )
        }

        AnimatedContainer(
            text = "Shape",
            radiusPercent = radius
        )

//        val infiniteTransition = rememberInfiniteTransition()
        val rotateDegrees by infiniteTransition.animateFloat(
            targetValue = 360f, animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000), repeatMode = RepeatMode.Restart
            ),
            initialValue = 0f,
        )

        var hasBorder by remember { mutableStateOf(false) }
        val border by animateDpAsState(if (hasBorder) 4.dp else 0.dp)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { hasBorder = !hasBorder }
        ) {
            Text(
                text = "Animate border",
            )
        }
        AnimatedContainer(
            text = "Border",
            border = border,
            rotate = rotateDegrees
        )

        var isPink by remember { mutableStateOf(false) }
        val color by animateColorAsState(targetValue = if (isPink) Color.Magenta else Color.Blue)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isPink = !isPink }
        ) {
            Text(
                text = "Animate color",
            )
        }
        AnimatedContainer(
            text = "Color",
            color = color
        )

        var isVisible by remember { mutableStateOf(true) }
        val alpha by animateFloatAsState(if (isVisible) 1f else 0f)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isVisible = !isVisible }
        ) {
            Text(
                text = "Animate visibility",
            )
        }
        AnimatedContainer(
            text = "Visibility",
            alpha = alpha
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String,
    size: Dp = 200.dp,
    radiusPercent: Int = 4,
    border: Dp = 0.dp,
    color: Color = Color.Blue,
    alpha: Float = 1f,
    rotate: Float = 0f
) {
    Log.d(TAG, "AnimatedContainer:: set size $size")
    Box(
        modifier = Modifier
            .rotate(rotate)
            .alpha(alpha)
            .clip(RoundedCornerShape(radiusPercent))
            .background(color = color)
            .border(border = BorderStroke(width = border, color = Color.Black))
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}
package com.example.animationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animationsample.sample.CanvasTest
import com.example.animationsample.sample.DragDrop
import com.example.animationsample.sample.PathTest
import com.example.animationsample.ui.AnimateNavigation
import com.example.animationsample.ui.BoxesWithText
import com.example.animationsample.ui.theme.AnimationSampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationSampleTheme {
                DragDrop()
//                CanvasTest()
//                PathTest()
//                AnimateNavigation()
//                BoxesWithText()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationSampleTheme {
        Greeting("Android")
    }
}
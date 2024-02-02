package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

@Composable
fun PlotSurface() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        var xValue by remember { mutableStateOf(0.5f) }
        var yValue by remember { mutableStateOf(0.5f) }

        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(" Coordinate Plotter ",
                fontSize = (36.sp)

            )

            Map(
                xPercent = xValue,
                yPercent = yValue,
            )
            /*side to side slider */
            Slider(
                value = xValue,
                valueRange = 0.01f..1f,
                onValueChange = { value ->
                    xValue = value
                }
            )
            /* up and down slider */
            Slider(
                value = yValue,
                valueRange = 0.01f..1f,
                onValueChange = { value ->
                    yValue = value
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier,
        /*value: Float = 0.5f,
        valueChanged: (Float) -> Unit */
){
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Black)
    ) {
        val xOffset = (xPercent * 300 - 18).dp
        val yOffset = (yPercent * 300 - 18).dp
        Box(
            modifier = Modifier
                .offset(xOffset, yOffset)
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Cyan)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}


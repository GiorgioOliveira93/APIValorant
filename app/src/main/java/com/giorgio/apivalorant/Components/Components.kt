package com.giorgio.apivalorant.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@Composable
fun Hexagon(text: String, Image: String, hexagonSize: Dp, index: Int, DetalheScreen: () -> Unit) {
    val paddingValue = 60.dp
    val HexagonItemShape = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val minSize = min(size.width, size.height)
            val angleRadians = Math.toRadians(70.0).toFloat()
            val radius = minSize / 2f
            return Outline.Generic(
                Path().apply {
                    (0..5).forEach { i ->
                        val currentAngle = angleRadians * i
                        val x = radius + radius * cos(currentAngle)
                        val y = radius + radius * sin(currentAngle)
                        if (i == 0) moveTo(x, y) else lineTo(x, y)
                    }
                    close()
                }
            )
        }
    }
    Box(
        modifier = Modifier
            .padding(
                start = if (index % 2 == 1) paddingValue else 0.dp,
                end = if (index % 2 == 0) paddingValue else 0.dp,
            )
            .size(hexagonSize)
            .clip(HexagonItemShape)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White,
                        Color.DarkGray,
                        Color.Gray
                    )
                )
            )
            .clickable { DetalheScreen() },
        contentAlignment = Alignment.Center

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(38.dp)
        ) {
            AsyncImage(model = Image, contentDescription = "")
            Text(
                text = text,
                modifier = Modifier.padding(46.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal
            )
        }
    }
}


package com.giorgio.apivalorant.ui.Screen


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


@Composable
fun MenuScreem(
    navController: NavController,
){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Android Studio Vresão 2024_10",
        fontSize = 100.sp,
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}
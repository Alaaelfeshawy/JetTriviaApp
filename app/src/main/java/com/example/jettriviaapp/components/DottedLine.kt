package com.example.jettriviaapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettriviaapp.util.AppColors

@Preview
@Composable
fun DottedLine() {
    DashedDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        color = AppColors.mLightGray,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(10f, 10f),
            phase = 0f,
        )
    )
}

@Composable
fun DashedDivider(
    modifier: Modifier,
    color: Color,
    pathEffect : PathEffect
) {
    Canvas(modifier = modifier) {
        drawLine(
            color = color,
            start = Offset(0f,0f),
            end = Offset(size.width,0f),
            pathEffect = pathEffect,
        )
    }
}


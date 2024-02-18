package com.example.jettriviaapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettriviaapp.util.AppColors

@Preview
@Composable
fun Progress(score:Float = 0.3f) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .height(45.dp)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    listOf(
                        AppColors.mLightPurple,
                        AppColors.mLightPurple
                    )
                ),
                shape = RoundedCornerShape(34.dp)
            )
            .clip(
                RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomEndPercent = 50,
                    bottomStartPercent = 50,
                )
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        androidx.compose.material3.Button(
            enabled = false,
            elevation = null,
            contentPadding = PaddingValues(1.dp),
            modifier = Modifier.fillMaxWidth(score).background(
                brush = Brush.linearGradient(listOf(
                    Color(0xFFF95075),
                    Color(0xFFBE6BE5),
                )
            ),
        ),
            colors = buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
            ),
            onClick = { /*TODO*/ }) {

        }
    }

}
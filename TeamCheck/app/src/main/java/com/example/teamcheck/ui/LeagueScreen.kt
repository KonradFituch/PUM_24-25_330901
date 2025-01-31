package com.example.teamcheck.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.runtime.remember
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.teamcheck.R


@Composable
fun LeagueScreen(navController: NavController) {
    val leagues = listOf("Angielska", "Włoska", "Hiszpańska", "Niemiecka", "Polska")

    // Gradient
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF2193b0), Color(0xFF6dd5ed))
    )
    // Czcionka z pliku
    val customFontFamily = FontFamily(
        Font(R.font.logo_font)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(brush = gradientBrush),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Pasek z logiem
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "TEAMCHECK",
                    fontSize = 50.sp,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            // Biały pasek pod logiem
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(Color.White)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SELECT LEAGUE",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            // Wyświetlanie lig
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(leagues) { index, league ->
                    val interactionSource = remember { MutableInteractionSource() }

                    // Śledzenie ruchu myszki
                    val isPressed = interactionSource.collectIsPressedAsState().value
                    val isHovered = interactionSource.collectIsHoveredAsState().value

                    Text(
                        text = league,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    navController.navigate("clubList/$league")
                                },
                                interactionSource = interactionSource,
                                indication = null
                            )
                            .background(color = when {
                                isPressed -> Color.DarkGray
                                else -> Color.Black
                            })
                            .border(
                                width = 1.dp,
                                color = when {
                                    isPressed -> Color.Gray
                                    isHovered -> Color.Green
                                    else -> Color.Black
                                },
                                shape = MaterialTheme.shapes.medium
                            )
                            .padding(20.dp)
                            .wrapContentHeight(Alignment.CenterVertically)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
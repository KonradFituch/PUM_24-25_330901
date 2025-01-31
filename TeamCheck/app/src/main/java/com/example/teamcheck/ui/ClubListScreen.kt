package com.example.teamcheck.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.remember
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.teamcheck.R


@Composable
fun ClubListScreen(league: String, navController: NavController) {
    // Lista klubów podzielona na ligi
    val clubs = when (league) {
        "Angielska" -> listOf("Arsenal FC", "Chelsea FC", "Everton", "Liverpool FC", "Manchester City", "Manchester United", "Tottenham", "West Ham United", "Crystal Palace", "Newcastle United", "Brighton", "Wolves", "Aston Villa", "Brentford FC", "Nottingham Forest", "Fulham FC", "Bournemouth", "Ipswich Town", "Leicester City", "Southampton FC")
        "Włoska" -> listOf("AC Milan", "AC Monza", "ACF Fiorentina", "AS Roma", "Atalanta Bergamo", "Bologna FC", "Cagliari Calcio", "Como 1907", "Empoli FC", "Genoa CFC", "Hellas Verona", "Inter Mediolan", "Juventus FC", "Lazio Rzym", "Parma Calcio", "SSC Napoli", "Torino FC", "Udinese Calcio", "US Lecce","Venezia FC")
        "Hiszpańska" -> listOf("Athletic Bilbao", "Atletico Madryt", "Celta Vigo", "Deportivo Alaves", "Espanyol","FC Barcelona", "Getafe CF", "Girona FC", "Osasuna Pampeluna", "Rayo Vallecano", "RCD Mallorca", "Real Betis", "Real Madryt", "Real Sociedad", "Real Valladolid", "Sevilla FC", "UD Las Palmas", "UD Leganes", "Valencia CF", "Villarreal CF")
        "Niemiecka" -> listOf("Bayer Leverkusen", "Bayern Monachium", "Eintracht Frankfurt", "VFB Stuttgart", "RB Lipsk", "FSV Mainz 05", "VFL Wolfsburg", "Borussia M'gladbach", "Werder Brema", "Freiburg", "Borussia Dortmund", "Augsburg", "St. Pauli", "Union Berlin", "Hoffenheim", "FC Heidenheim", "Holstein Kiel", "VFL Bochum")
        "Polska" -> listOf("Radomiak Radom", "Śląsk Wrocław", "Lech Poznań", "Raków Częstochowa", "Jagiellonia Białystok", "Legia Warszawa", "Cracovia", "Górnik Zabrze", "Motor Lublin", "Pogoń Szczecin", "Widzew Łódź", "GKS Katowice", "Piast Gliwice", "Stal Mielec", "Zagłębie Lubin", "Puszcza Niepołomice", "Korona Kielce", "Lechia Gdańsk")

        else -> emptyList()
    }
    //Gradient
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
                    color = Color.White,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }
            // Pasek pod logiem
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(Color.White)
            )
            // Wybór
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SELECT TEAM",
                    fontSize = 20.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.White)
            }

            // Wyświetlanie klubów
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(clubs) { index, club ->
                    val interactionSource = remember { MutableInteractionSource() }
                    // Śledzenie ruchu myszki
                    val isPressed = interactionSource.collectIsPressedAsState().value
                    val isHovered = interactionSource.collectIsHoveredAsState().value

                    Text(
                        text = club,
                        fontSize = 20.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    navController.navigate("playerList/$club")
                                },
                                interactionSource = interactionSource,
                                indication = null
                            )
                            .background(
                                color = when {
                                    isPressed -> Color.DarkGray
                                    else -> Color.Black
                                }
                            )
                            .border(
                                width = 2.dp,
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

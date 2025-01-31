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
import com.example.teamcheck.model.Player
import androidx.compose.runtime.remember
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.teamcheck.R

@Composable
fun PlayerListScreen(club: String, navController: NavController) {
    val players = when (club) {
        "Real Madryt" -> listOf(
            Player(1, "Karim Benzema", 35, "Napastnik", 9, 12),
            Player(2, "Luka Modrić", 38, "Pomocnik", 10, 8),
            Player(3, "Thibaut Courtois", 32, "Bramkarz", 1, 0),
            Player(4, "Vinícius Júnior", 24, "Napastnik", 11, 10),
            Player(5, "Toni Kroos", 35, "Pomocnik", 8, 5),
            Player(6, "Sergio Ramos", 39, "Obrońca", 4, 3)
        )
        "FC Barcelona" -> listOf(
            Player(7, "Robert Lewandowski", 36, "Napastnik", 9, 15),
            Player(8, "Frenkie de Jong", 28, "Pomocnik", 21, 4),
            Player(9, "Marc-André ter Stegen", 33, "Bramkarz", 1, 0),
            Player(10, "Pedri", 22, "Pomocnik", 16, 6),
            Player(11, "Gerard Piqué", 38, "Obrońca", 3, 2),
            Player(12, "Ansu Fati", 22, "Napastnik", 10, 7)
        )
        "Atletico Madryt" -> listOf(
            Player(13, "João Félix", 25, "Napastnik", 7, 10),
            Player(14, "Koke", 33, "Pomocnik", 6, 5),
            Player(15, "Jan Oblak", 32, "Bramkarz", 13, 0),
            Player(16, "Luis Suárez", 38, "Napastnik", 9, 12),
            Player(17, "Saúl Ñíguez", 30, "Pomocnik", 8, 4),
            Player(18, "Stefan Savić", 34, "Obrońca", 15, 1)
        )
        "Sevilla FC" -> listOf(
            Player(19, "Youssef En-Nesyri", 28, "Napastnik", 15, 11),
            Player(20, "Ivan Rakitić", 37, "Pomocnik", 10, 6),
            Player(21, "Bono", 34, "Bramkarz", 1, 0),
            Player(22, "Jules Koundé", 27, "Obrońca", 12, 2),
            Player(23, "Lucas Ocampos", 30, "Napastnik", 5, 7),
            Player(24, "Jesús Navas", 39, "Obrońca", 16, 3)
        )
        "Real Sociedad" -> listOf(
            Player(25, "Mikel Oyarzabal", 28, "Napastnik", 10, 9),
            Player(26, "David Silva", 39, "Pomocnik", 21, 5),
            Player(27, "Álex Remiro", 30, "Bramkarz", 1, 0),
            Player(28, "Alexander Isak", 26, "Napastnik", 11, 8),
            Player(29, "Asier Illarramendi", 35, "Pomocnik", 4, 3),
            Player(30, "Robin Le Normand", 29, "Obrońca", 24, 2)
        )
            "Juventus FC" -> listOf(
                Player(31, "Cristiano Ronaldo", 40, "Napastnik", 7, 14),
                Player(32, "Paulo Dybala", 31, "Napastnik", 10, 9),
                Player(33, "Gianluigi Buffon", 47, "Bramkarz", 1, 0),
                Player(34, "Leonardo Bonucci", 37, "Obrońca", 19, 2),
                Player(35, "Federico Chiesa", 28, "Pomocnik", 22, 6),
                Player(36, "Arthur Melo", 29, "Pomocnik", 5, 3)
            )
            "Inter Mediolan" -> listOf(
                Player(37, "Romelu Lukaku", 31, "Napastnik", 9, 13),
                Player(38, "Lautaro Martínez", 27, "Napastnik", 10, 11),
                Player(39, "Samir Handanović", 40, "Bramkarz", 1, 0),
                Player(40, "Milan Škriniar", 30, "Obrońca", 37, 2),
                Player(41, "Nicolo Barella", 28, "Pomocnik", 23, 5),
                Player(42, "Achraf Hakimi", 26, "Obrońca", 2, 4)
            )
            "AC Milan" -> listOf(
                Player(43, "Zlatan Ibrahimović", 43, "Napastnik", 11, 12),
                Player(44, "Rafael Leão", 25, "Napastnik", 17, 9),
                Player(45, "Gianluigi Donnarumma", 26, "Bramkarz", 99, 0),
                Player(46, "Theo Hernández", 27, "Obrońca", 19, 4),
                Player(47, "Franck Kessié", 28, "Pomocnik", 79, 7),
                Player(48, "Hakan Çalhanoğlu", 31, "Pomocnik", 10, 6)
            )
            "AS Roma" -> listOf(
                Player(49, "Edin Džeko", 39, "Napastnik", 9, 11),
                Player(50, "Henrikh Mkhitaryan", 36, "Pomocnik", 77, 8),
                Player(51, "Pau López", 31, "Bramkarz", 13, 0),
                Player(52, "Lorenzo Pellegrini", 29, "Pomocnik", 7, 5),
                Player(53, "Chris Smalling", 35, "Obrońca", 6, 2),
                Player(54, "Gianluca Mancini", 28, "Obrońca", 23, 3)
            )
            "SSC Napoli" -> listOf(
                Player(55, "Victor Osimhen", 26, "Napastnik", 9, 14),
                Player(56, "Khvicha Kvaratskhelia", 24, "Napastnik", 77, 10),
                Player(57, "Alex Meret", 28, "Bramkarz", 1, 0),
                Player(58, "Piotr Zieliński", 30, "Pomocnik", 20, 7),
                Player(59, "Giovanni Di Lorenzo", 31, "Obrońca", 22, 4),
                Player(60, "André-Frank Zambo Anguissa", 29, "Pomocnik", 99, 5)
            )
            "Manchester City" -> listOf(
                Player(61, "Erling Haaland", 24, "Napastnik", 9, 20),
                Player(62, "Kevin De Bruyne", 33, "Pomocnik", 17, 12),
                Player(63, "Ederson", 32, "Bramkarz", 31, 0),
                Player(64, "Rodri", 28, "Pomocnik", 16, 5),
                Player(65, "Bernardo Silva", 30, "Pomocnik", 20, 6),
                Player(66, "Rúben Dias", 27, "Obrońca", 3, 2)
            )
            "Arsenal FC" -> listOf(
                Player(67, "Bukayo Saka", 23, "Napastnik", 7, 13),
                Player(68, "Martin Ødegaard", 26, "Pomocnik", 8, 10),
                Player(69, "Aaron Ramsdale", 27, "Bramkarz", 1, 0),
                Player(70, "Gabriel Jesus", 27, "Napastnik", 9, 11),
                Player(71, "Declan Rice", 25, "Pomocnik", 41, 5),
                Player(72, "William Saliba", 24, "Obrońca", 2, 3)
            )
            "Liverpool FC" -> listOf(
                Player(73, "Mohamed Salah", 32, "Napastnik", 11, 18),
                Player(74, "Trent Alexander-Arnold", 26, "Obrońca", 66, 7),
                Player(75, "Alisson Becker", 32, "Bramkarz", 1, 0),
                Player(76, "Virgil van Dijk", 33, "Obrońca", 4, 3),
                Player(77, "Alexis Mac Allister", 25, "Pomocnik", 10, 5),
                Player(78, "Luis Díaz", 28, "Napastnik", 23, 8)
            )
            "Chelsea FC" -> listOf(
                Player(79, "Enzo Fernández", 24, "Pomocnik", 5, 6),
                Player(80, "Christopher Nkunku", 27, "Napastnik", 18, 9),
                Player(81, "Reece James", 26, "Obrońca", 24, 4),
                Player(82, "Raheem Sterling", 30, "Napastnik", 7, 12),
                Player(83, "Moisés Caicedo", 23, "Pomocnik", 25, 3),
                Player(84, "Robert Sánchez", 27, "Bramkarz", 1, 0)
            )
            "Manchester United" -> listOf(
                Player(85, "Bruno Fernandes", 30, "Pomocnik", 8, 11),
                Player(86, "Marcus Rashford", 27, "Napastnik", 10, 14),
                Player(87, "Casemiro", 33, "Pomocnik", 18, 6),
                Player(88, "André Onana", 29, "Bramkarz", 24, 0),
                Player(89, "Lisandro Martínez", 26, "Obrońca", 6, 2),
                Player(90, "Rasmus Højlund", 22, "Napastnik", 9, 7)
            )
            "Bayern Monachium" -> listOf(
                Player(91, "Harry Kane", 31, "Napastnik", 9, 22),
                Player(92, "Jamal Musiala", 22, "Pomocnik", 42, 10),
                Player(93, "Manuel Neuer", 38, "Bramkarz", 1, 0),
                Player(94, "Joshua Kimmich", 29, "Pomocnik", 6, 6),
                Player(95, "Leroy Sané", 29, "Napastnik", 10, 11),
                Player(96, "Matthijs de Ligt", 26, "Obrońca", 4, 2)
            )
            "Borussia Dortmund" -> listOf(
                Player(97, "Marco Reus", 35, "Napastnik", 11, 12),
                Player(98, "Julian Brandt", 29, "Pomocnik", 19, 9),
                Player(99, "Gregor Kobel", 28, "Bramkarz", 1, 0),
                Player(100, "Niklas Süle", 30, "Obrońca", 2, 3),
                Player(101, "Donyell Malen", 26, "Napastnik", 21, 8),
                Player(102, "Salih Özcan", 26, "Pomocnik", 5, 4)
            )
            "RB Lipsk" -> listOf(
                Player(109, "Timo Werner", 28, "Napastnik", 11, 14),
                Player(110, "Dani Olmo", 27, "Pomocnik", 25, 9),
                Player(111, "Peter Gulácsi", 35, "Bramkarz", 1, 0),
                Player(112, "Willi Orbán", 32, "Obrońca", 4, 3),
                Player(113, "Xavi Simons", 22, "Pomocnik", 17, 8),
                Player(114, "Loïs Openda", 25, "Napastnik", 9, 15)
            )
            "Bayer Leverkusen" -> listOf(
                Player(115, "Florian Wirtz", 22, "Pomocnik", 10, 12),
                Player(116, "Jonathan Tah", 29, "Obrońca", 4, 3),
                Player(117, "Lukáš Hrádecký", 35, "Bramkarz", 1, 0),
                Player(118, "Exequiel Palacios", 26, "Pomocnik", 8, 7),
                Player(119, "Patrik Schick", 29, "Napastnik", 14, 11),
                Player(120, "Jeremie Frimpong", 24, "Obrońca", 30, 6)
            )
            "Legia Warszawa" -> listOf(
                Player(103, "Josué", 33, "Pomocnik", 20, 7),
                Player(104, "Bartosz Kapustka", 28, "Pomocnik", 7, 5),
                Player(105, "Artur Jędrzejczyk", 37, "Obrońca", 4, 2),
                Player(106, "Filip Mladenović", 34, "Obrońca", 22, 3),
                Player(107, "Tobiasz Miszta", 26, "Bramkarz", 1, 0),
                Player(108, "Ernest Muçi", 25, "Napastnik", 10, 8)
            )
            "Lech Poznań" -> listOf(
                Player(121, "Mikael Ishak", 31, "Napastnik", 9, 14),
                Player(122, "Jesper Karlström", 28, "Pomocnik", 6, 6),
                Player(123, "Filip Bednarek", 32, "Bramkarz", 1, 0),
                Player(124, "Antonio Milić", 30, "Obrońca", 5, 3),
                Player(125, "João Amaral", 33, "Pomocnik", 10, 7),
                Player(126, "Afonso Sousa", 24, "Pomocnik", 17, 5)
            )
            "Śląsk Wrocław" -> listOf(
                Player(127, "Erik Expósito", 29, "Napastnik", 9, 12),
                Player(128, "Patrick Olsen", 30, "Pomocnik", 8, 6),
                Player(129, "Rafał Leszczyński", 32, "Bramkarz", 1, 0),
                Player(130, "Konrad Poprawa", 27, "Obrońca", 4, 2),
                Player(131, "Dennis Jastrzembski", 26, "Pomocnik", 21, 5),
                Player(132, "Matúš Putnocký", 39, "Bramkarz", 12, 0)
            )
            "Radomiak Radom" -> listOf(
                Player(133, "Jan Grzesik", 29, "Pomocnik", 9, 10),
                Player(134, "Rafał Wolski", 32, "Pomocnik", 8, 5),
                Player(135, "Maciej Kikolski", 21, "Bramkarz", 1, 0),
                Player(136, "Mateusz Cichocki", 32, "Obrońca", 3, 2),
                Player(137, "Leandro", 40, "Pomocnik", 20, 6),
                Player(138, "Raphael Rossi", 34, "Obrońca", 5, 3)
            )
        else -> emptyList()
    }

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF2193b0), Color(0xFF6dd5ed))
    )

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
            // Napis
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SELECT PLAYER",
                    fontSize = 20.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.White
                )
            }

            // Wyświetlanie zawodników
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(players) { index, player ->
                    val interactionSource = remember { MutableInteractionSource() }

                    // Śledzenie ruchu myszki
                    val isPressed = interactionSource.collectIsPressedAsState().value
                    val isHovered = interactionSource.collectIsHoveredAsState().value

                    Text(
                        text = player.name,
                        fontSize = 20.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    navController.navigate("playerDetails/${player.id}")
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
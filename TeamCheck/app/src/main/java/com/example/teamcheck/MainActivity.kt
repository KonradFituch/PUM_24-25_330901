package com.example.teamcheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.teamcheck.ui.TeamListScreen
import com.example.teamcheck.ui.ClubListScreen
import com.example.teamcheck.ui.PlayerListScreen
import com.example.teamcheck.ui.LeagueScreen
import com.example.teamcheck.ui.PlayerDetailsScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamListScreen()
        }
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "leagueScreen") {
                composable("leagueScreen") {
                    LeagueScreen(navController = navController)
                }
                composable("clubList/{league}") { backStackEntry ->
                    val league = backStackEntry.arguments?.getString("league")
                    if (league != null) {
                        ClubListScreen(league = league, navController = navController)
                    }
                }
                composable("playerList/{club}") { backStackEntry ->
                    val club = backStackEntry.arguments?.getString("club")
                    if (club != null) {
                        PlayerListScreen(club = club, navController = navController)
                    }
                }
                // Dodajemy nową ścieżkę dla szczegółów zawodnika
                composable("playerDetails/{playerId}") { backStackEntry ->
                    val playerId = backStackEntry.arguments?.getString("playerId")?.toIntOrNull()
                    if (playerId != null) {
                        PlayerDetailsScreen(playerId = playerId, navController)
                    }
                }
            }
        }
    }
}
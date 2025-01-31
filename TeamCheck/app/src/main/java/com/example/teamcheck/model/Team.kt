package com.example.teamcheck.model

data class Team(
    val id: Int,
    val name: String,
    val players: List<Player>
)
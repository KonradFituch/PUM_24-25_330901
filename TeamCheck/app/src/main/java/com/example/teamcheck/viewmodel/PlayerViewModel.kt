package com.example.teamcheck.viewmodel
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamcheck.model.Player
import com.example.teamcheck.model.Team


class PlayerViewModel {
    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> get() = _players

    init {
        loadPlayers()
    }


    private fun loadPlayers() {
        val samplePlayers = listOf(
            Player(1, "Robert Lewandowski", 36,"Napastnik", 25, 5),
            Player(2, "Lionel Messi", 38,"Pomocnik", 20, 10)
        )
        val sampleTeams = listOf(
            Team(1, "FC Barcelona", samplePlayers),
            Team(2, "Real Madrid", samplePlayers)
        )
        _players.value = samplePlayers
    }


}
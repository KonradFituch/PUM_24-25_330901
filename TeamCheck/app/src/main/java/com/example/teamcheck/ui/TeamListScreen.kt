package com.example.teamcheck.ui

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamcheck.viewmodel.TeamViewModel



@Composable

fun TeamListScreen(viewModel: TeamViewModel = viewModel()) {
    val teams by viewModel.teams.observeAsState(emptyList())

    LazyColumn {
        itemsIndexed(teams) { index, team ->
            Text(text = team.name, fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
    }
}
package com.im.nbaplayerengine.ui.teams.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamPlayerViewModel
@Inject
constructor(
    private val repository: Repository
): ViewModel(){

    fun teamPlayers(team: String) = repository.getTeamPLayers(team).asLiveData()

}
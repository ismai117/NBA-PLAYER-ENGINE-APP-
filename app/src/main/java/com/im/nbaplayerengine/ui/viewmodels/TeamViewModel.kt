package com.im.nbaplayerengine.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamViewModel
@Inject
constructor(
    private val repository: Repository
) : ViewModel(){

    private val apiHost = "nba-player-individual-stats.p.rapidapi.com";
    private val apiKey = "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5";


    val allTeams = repository.getTeams(host = apiHost, key = apiKey).asLiveData()

}
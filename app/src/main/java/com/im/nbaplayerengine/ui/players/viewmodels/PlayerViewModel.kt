package com.im.nbaplayerengine.ui.players.viewmodels

import androidx.lifecycle.*
import com.im.nbaplayerengine.model.players.Player
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel
@Inject
constructor(
    private val repository: Repository
): ViewModel() {


    private val apiHost = "nba-player-individual-stats.p.rapidapi.com";
    private val apiKey = "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5";


    val allPlayers = repository.getPlayers(host = apiHost, key = apiKey).asLiveData()


    fun getSearchResult(searchQuery: String): LiveData<List<Player>>{
        return repository.searchPlayer(searchQuery).asLiveData()
    }

}
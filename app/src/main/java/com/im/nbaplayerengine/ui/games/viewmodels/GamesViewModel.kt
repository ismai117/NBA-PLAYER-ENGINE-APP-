package com.im.nbaplayerengine.ui.games.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel
@Inject
constructor(
    private val repository: Repository,
): ViewModel(){


    fun getGames(date: String) = repository.getGames(
        "livescore-basketball.p.rapidapi.com",
        "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5",
        date,
        "nba"
    ).asLiveData()


}
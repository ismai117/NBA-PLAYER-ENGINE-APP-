package com.im.nbaplayerengine.ui.dashboard.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.im.nbaplayerengine.model.games.Games
import com.im.nbaplayerengine.model.standings.Standing
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
    private val repository: Repository,
) : ViewModel() {


    val getStandings = repository.getStandings("api-basketball.p.rapidapi.com",
        "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5").asLiveData()

    val getEasternConference = repository.getEasternConference("Eastern Conference").asLiveData()

    val getWesternConference = repository.getWesternConference("Western Conference").asLiveData()


}
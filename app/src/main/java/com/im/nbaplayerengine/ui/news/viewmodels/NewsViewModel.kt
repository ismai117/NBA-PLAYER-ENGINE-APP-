package com.im.nbaplayerengine.ui.news.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject
constructor(
    private val repository: Repository
): ViewModel(){


//    private val mutableLiveDataNews: MutableLiveData<List<News>> = MutableLiveData()
//
//
//
//    fun getNews(): MutableLiveData<List<News>> {
//        return mutableLiveDataNews
//    }


        val response = repository.getNews("free-news.p.rapidapi.com","0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5").asLiveData()







}
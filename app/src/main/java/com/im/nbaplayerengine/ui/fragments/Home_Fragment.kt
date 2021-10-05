package com.im.nbaplayerengine.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.inflate
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.ui.viewmodels.PlayerViewModel
import com.im.nbaplayerengine.ui.adapters.PlayerAdapter
import com.im.nbaplayerengine.ui.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import com.im.nbaplayerengine.utils.onQueryTextChanegd
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home_.*
import kotlinx.android.synthetic.main.fragment_home_.view.*
import kotlinx.android.synthetic.main.seasonlayout.*
import java.util.zip.Inflater


@AndroidEntryPoint
class Home_Fragment : Fragment() {

    val playerModel: PlayerViewModel by viewModels()


    lateinit var playerAdapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home_, container, false)


        playerAdapter = PlayerAdapter()

        playerModel.allPlayers.observe(this.viewLifecycleOwner) { result ->

            playerAdapter.setPLayer(result.data)
            view.player_recycler_view.layoutManager = LinearLayoutManager(this.context)
            view.player_recycler_view.adapter = playerAdapter


            home_ProgressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            home_text_error.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            home_text_error.text = result.error?.localizedMessage

        }


        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.mainmenu, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as? SearchView

        searchView?.onQueryTextChanegd {
            searchDatabase(query = it)
        }

    }


    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        playerModel.getSearchResult(searchQuery = searchQuery).observe(this, { players ->

            playerAdapter.setPLayer(players)

            Log.d("searchPlayer", "$players")

        })

    }


}


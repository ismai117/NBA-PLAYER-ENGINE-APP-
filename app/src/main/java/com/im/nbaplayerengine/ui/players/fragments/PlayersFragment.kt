package com.im.nbaplayerengine.ui.players.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.databinding.FragmentPlayersBinding
import com.im.nbaplayerengine.ui.players.adapters.PlayerAdapter
import com.im.nbaplayerengine.ui.players.viewmodels.PlayerViewModel
import com.im.nbaplayerengine.utils.Resource
import com.im.nbaplayerengine.utils.onQueryTextChanged
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class PlayersFragment : Fragment() {

    private var homeBinding: FragmentPlayersBinding? = null
    private val binding get() = homeBinding!!
    private val playerModel: PlayerViewModel by viewModels()
    private lateinit var playerAdapter: PlayerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playerAdapter = PlayerAdapter()

        setHasOptionsMenu(true)



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentPlayersBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().toolbar.title = "Players"

        playerModel.allPlayers.observe(this.viewLifecycleOwner) { result ->


            result?.let {

                if (result.data != null) {

                    initRecycler()
                    playerAdapter.setPLayer(result.data)

                    binding.homeProgressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()

                    binding.homeTextError.isVisible =
                        result is Resource.Error && result.data.isNullOrEmpty()

                    binding.homeTextError.text = result.error?.localizedMessage



                } else {
                    Log.d("player_error", "${result.error?.message}")
                }


            }


        }




        return view
    }


    private fun initRecycler() {
        binding.playerRecyclerView.adapter = playerAdapter
        binding.playerRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.playerRecyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {


        inflater.inflate(R.menu.mainmenu, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as? SearchView

        searchView?.onQueryTextChanged {
            searchDatabase(it)
        }

    }


    private fun searchDatabase(query: String) {

        val searchQuery = "%$query%"

        playerModel.getSearchResult(searchQuery = searchQuery).observe(this, { players ->

            playerAdapter.setPLayer(players)

            Log.d("searchPlayer", "$players")

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        homeBinding = null
    }


}


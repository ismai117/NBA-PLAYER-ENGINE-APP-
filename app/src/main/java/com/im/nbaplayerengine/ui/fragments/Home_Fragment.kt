package com.im.nbaplayerengine.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.view.View.inflate
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.databinding.FragmentHomeBinding
import com.im.nbaplayerengine.ui.viewmodels.PlayerViewModel
import com.im.nbaplayerengine.ui.adapters.PlayerAdapter
import com.im.nbaplayerengine.ui.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import com.im.nbaplayerengine.utils.onQueryTextChanged
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home_.*
import kotlinx.android.synthetic.main.fragment_home_.view.*
import kotlinx.android.synthetic.main.seasonlayout.*
import java.util.zip.Inflater


@AndroidEntryPoint
class Home_Fragment : Fragment() {

    private var homeBinding: FragmentHomeBinding? = null
    private val binding get() = homeBinding!!
    private val playerModel: PlayerViewModel by viewModels()
    private lateinit var playerAdapter: PlayerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerAdapter = PlayerAdapter()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


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



        setHasOptionsMenu(true)

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


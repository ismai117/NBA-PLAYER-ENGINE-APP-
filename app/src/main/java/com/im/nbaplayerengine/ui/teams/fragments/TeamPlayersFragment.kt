package com.im.nbaplayerengine.ui.teams.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.im.nbaplayerengine.databinding.FragmentTeamPlayersBinding
import com.im.nbaplayerengine.ui.teams.adapters.TeamPlayersAdapter
import com.im.nbaplayerengine.ui.teams.viewmodels.TeamPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class TeamPlayersFragment : Fragment() {

    private var teamplayersBinding: FragmentTeamPlayersBinding? = null
    private val binding get() = teamplayersBinding!!
    private val teamplayerModel: TeamPlayerViewModel by viewModels()
    private lateinit var teamPlayersAdapter: TeamPlayersAdapter
    private var teamPlayers: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamPlayersAdapter = TeamPlayersAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        teamplayersBinding = FragmentTeamPlayersBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().toolbar.title = "Team Players"

        arguments?.let {

            val team = TeamPlayersFragmentArgs.fromBundle(it).team

            if(team != null){
                teamPlayers = team.name
            }

        }


        teamPlayers?.let {

            teamplayerModel.teamPlayers(it).observe(this.viewLifecycleOwner, {

                initRecycler()
                teamPlayersAdapter.setPlayer(it)

            })

        }


        return view
    }

    private fun initRecycler() {
        binding.teamPlayersRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.teamPlayersRecyclerView.setHasFixedSize(true)
        binding.teamPlayersRecyclerView.adapter = teamPlayersAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        teamplayersBinding = null
    }
}
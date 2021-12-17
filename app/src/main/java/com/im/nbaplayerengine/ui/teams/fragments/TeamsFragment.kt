package com.im.nbaplayerengine.ui.teams.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.im.nbaplayerengine.databinding.FragmentTeamsBinding
import com.im.nbaplayerengine.ui.teams.adapters.TeamAdapter
import com.im.nbaplayerengine.ui.teams.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private var teamsBinding: FragmentTeamsBinding? = null
    private val binding get() = teamsBinding!!
    private val teamModel: TeamViewModel by activityViewModels()
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamAdapter = TeamAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        teamsBinding = FragmentTeamsBinding.inflate(inflater, container, false)
        val view = binding.root



        teamModel.allTeams.observe(this.viewLifecycleOwner) { result ->

            initRecycler()

            result?.let {

                if (result.data != null) {
                    teamAdapter.setTeam(result.data)
                }

            }


            binding.teamsProgressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            binding.teamsTextError.isVisible =
                result is Resource.Error && result.data.isNullOrEmpty()
            binding.teamsTextError.text = result.error?.localizedMessage

        }





        return view
    }

    private fun initRecycler() {
        binding.teamsRecyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
        binding.teamsRecyclerView.setHasFixedSize(true)
        binding.teamsRecyclerView.adapter = teamAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        teamsBinding = null
    }

}
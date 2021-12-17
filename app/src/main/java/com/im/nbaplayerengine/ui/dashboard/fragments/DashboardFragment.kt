package com.im.nbaplayerengine.ui.dashboard.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.databinding.FragmentDashboardBinding
import com.im.nbaplayerengine.ui.dashboard.adapters.EasternConferenceAdapter
import com.im.nbaplayerengine.ui.dashboard.adapters.GamesAdapter
import com.im.nbaplayerengine.ui.dashboard.adapters.TeamsInterface
import com.im.nbaplayerengine.ui.dashboard.adapters.WesternConferenceAdapter
import com.im.nbaplayerengine.ui.dashboard.viewmodels.DashboardViewModel
import com.im.nbaplayerengine.ui.games.viewmodels.GamesViewModel
import com.im.nbaplayerengine.ui.teams.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.games_item_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DashboardFragment : Fragment(), TeamsInterface{

    private var dashboardBinding: FragmentDashboardBinding? = null
    private val binding get() = dashboardBinding!!
    private val dashboardModel: DashboardViewModel by viewModels()
    private val gamesModel: GamesViewModel by viewModels()
    private val teamModel: TeamViewModel by activityViewModels()
    private lateinit var easternConferenceAdapter: EasternConferenceAdapter
    private lateinit var westernConferenceAdapter: WesternConferenceAdapter
    private lateinit var gamesAdapter: GamesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        easternConferenceAdapter = EasternConferenceAdapter()
        westernConferenceAdapter = WesternConferenceAdapter()
        gamesAdapter = GamesAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root


        val sdf = SimpleDateFormat("yyyyMdd")
        val date = sdf.format(Date())

        Log.d("date", "$date")



        gamesModel.getGames(date = date).observe(this.viewLifecycleOwner, { result ->


            result?.let {


                if (result.data != null){


                    initGamesRecycler()
                    gamesAdapter.setGames(result.data)


                }else {
                    Log.d("dashboardStanding", "${result.error?.message}")
                }


            }



        })


        dashboardModel.getStandings.observe(this.viewLifecycleOwner, { result ->

            result?.let {

                if (result.data != null) {

                    result.data.forEach { Log.d("dashboardStanding", "${it.position}") }
                    binding.dashboardProgressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()

                    binding.dashboardTextError.isVisible =
                        result is Resource.Error && result.data.isNullOrEmpty()

                    binding.dashboardTextError.text = result.error?.localizedMessage

                } else {
                    Log.d("dashboardStanding", "${result.error?.message}")
                }

            }
        })


        dashboardModel.getEasternConference.observe(this.viewLifecycleOwner, { result ->

            result?.let {

                initEasternRecycler()
                easternConferenceAdapter.setEasternCon(it)

            }

        })


        dashboardModel.getWesternConference.observe(this.viewLifecycleOwner, { result ->

            result?.let {

                initWesternRecycler()
                westernConferenceAdapter.setWesternCon(it)

            }

        })



        return view
    }

    private fun initGamesRecycler() {
        binding.gamesRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.gamesRecyclerView.setHasFixedSize(true)
        binding.gamesRecyclerView.adapter = gamesAdapter
    }

    private fun initEasternRecycler() {
        binding.easternConferenceRecyclerView.layoutManager =
            LinearLayoutManager(this.requireContext())
        binding.easternConferenceRecyclerView.setHasFixedSize(true)
        binding.easternConferenceRecyclerView.adapter = easternConferenceAdapter
    }

    private fun initWesternRecycler() {
        binding.westernConferenceRecyclerView.layoutManager =
            LinearLayoutManager(this.requireContext())
        binding.westernConferenceRecyclerView.setHasFixedSize(true)
        binding.westernConferenceRecyclerView.adapter = westernConferenceAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        dashboardBinding = null
    }

    override fun teamName(teamOne: String, teamTwo: String, itemView: View) {

        teamModel.allTeams.observe(this.viewLifecycleOwner, { result ->

            result?.let {


                if (result.data != null){


                    for (team in result.data){

                        if (teamOne.contains(team.name)){

                           Glide.with(requireContext()).load(team.teamLogoUrl).into(itemView.firstTeam_image)

                        }

                        if (teamTwo.contains(team.name)){

                            Glide.with(requireContext()).load(team.teamLogoUrl).into(itemView.secondTeam_image)

                        }

                    }


                }


            }


        })

    }

}
package com.im.nbaplayerengine.ui.players.fragments

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
import com.im.nbaplayerengine.databinding.FragmentPlayerProfileBinding
import com.im.nbaplayerengine.model.players.Player
import com.im.nbaplayerengine.ui.players.adapters.SeasonAdapter
import com.im.nbaplayerengine.ui.players.viewmodels.SeasonViewModel
import com.im.nbaplayerengine.ui.teams.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_player_profile_.view.*

@AndroidEntryPoint
class PlayerProfileFragment : Fragment() {

    private var playerBinding: FragmentPlayerProfileBinding? = null
    private val binding get() = playerBinding!!
    private var player: Player? = null
    private val teamModel: TeamViewModel by activityViewModels()
    private val seasonModel: SeasonViewModel by viewModels()
    private lateinit var seasonAdapter: SeasonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        seasonAdapter = SeasonAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        playerBinding = FragmentPlayerProfileBinding.inflate(inflater, container, false)
        val view = binding.root




        arguments?.let {

            player = PlayerProfileFragmentArgs.fromBundle(it).player
            if (player != null) {

                Glide.with(requireContext()).load(player?.headShotUrl).into(view.player_image)

                binding.playerFullname.text = "${player?.firstName}\n${player?.lastName}"
                binding.playerPosition.text = player?.position
                binding.playerNumber.text = player?.jerseyNumber
                binding.careerPpg.text = player?.careerPoints.toString()
                binding.careerRpg.text = player?.careerRebounds.toString()
                binding.careerApg.text = player?.carrerAssists.toString()
                binding.profileProgressBar.visibility = View.GONE

                binding.playerAge.text = "Age: ${player?.age}"
                binding.playerHeight.text = "Height: ${player?.height}"
                binding.playerWeight.text = "Weight: ${player?.weight}"

                binding.teamName.text = "${player?.team}"

                binding.profileProgressBar.visibility = View.GONE

            } else {

                binding.profileProgressBar.visibility = View.VISIBLE

            }
        }



        teamModel.allTeams.observe(this.viewLifecycleOwner) { result ->

            for (teams in result.data!!) {
                if (player?.team == teams.name) {
                    Glide.with(requireContext()).load(teams.teamLogoUrl).into(binding.teamLogo)
                }
            }

            binding.profileProgressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
//            binding.profileTextError.isVisible =
//                result is Resource.Error && result.data.isNullOrEmpty()
//            binding.profileTextError.text = result.error?.localizedMessage

        }



        seasonModel.allSeasons(playerId = player?.id)
            .observe(this.viewLifecycleOwner) { seasons ->

                seasons?.let {

                    if (it.data != null) {
                        initRecycler()
                        seasonAdapter.setSeason(it.data)
                    } else {
                        Log.d("player_profile", "Error: ${it.error?.message}")
                    }
                }

                binding.profileProgressBar.isVisible =
                    seasons is Resource.Loading && seasons.data.isNullOrEmpty()
//                binding.profileTextError.isVisible =
//                    seasons is Resource.Error && seasons.data.isNullOrEmpty()
//                binding.profileTextError.text = seasons.error?.localizedMessage

                Log.d("seasons", "${seasons.error}")

            }



        return view
    }

    private fun initRecycler() {
        binding.fullStatsRecycler.layoutManager = LinearLayoutManager(this.context)
        binding.fullStatsRecycler.setHasFixedSize(true)
        binding.fullStatsRecycler.adapter = seasonAdapter
    }


//    private fun getTeamThemeColor(team: String?, view: View) {
//        when (team) {
//
//            "Boston Celtics" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.celtics_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.celtics_two))
//            }
//
//            "Brooklyn Nets" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.nets_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.nets_two))
//            }
//
//            "New York Knicks" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.knicks_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.knicks_two))
//            }
//
//            "Philadelphia 76ers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.sevsixers_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.sevsixers_two))
//            }
//
//            "Toronto Raptors" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.raptors_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.raptors_two))
//            }
//
//            "Chicago Bulls" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.bulls_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.bulls_two))
//            }
//
//            "Cleveland Cavaliers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.cleveland_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.cleveland_two))
//            }
//
//
//            "Detroit Pistons" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.pistons_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.pistons_two))
//            }
//
//
//            "Indiana Pacers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.pacers_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.pacers_two))
//            }
//
//
//            "Milwaukee Bucks" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.bucks_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.bucks_two))
//            }
//
//            "Atlanta Hawks" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.hawks_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.hawks_two))
//            }
//
//            "Charlotte Hornets" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.hornets_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.hornets_two))
//            }
//
//
//            "Miami Heat" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.heat_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.heat_two))
//            }
//
//
//            "Orlando Magic" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.magic_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.magic_two))
//            }
//
//
//            "Washington Wizards" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.wizards_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.wizards_two))
//            }
//
//
//            "Denver Nuggets" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.nuggets_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.nuggets_two))
//            }
//
//            "Minnesota Timberwolves" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.timberwolves_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.timberwolves_two))
//            }
//
//
//            "Oklahoma City Thunder" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.thunder_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.thunder_two))
//            }
//
//            "Portland Trail Blazers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.blazers_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.blazers_two))
//            }
//
//            "Utah Jazz" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.jazz_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.jazz_two))
//            }
//
//            "Golden State Warriors" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.warriors_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.warriors_two))
//            }
//
//            "LA Clippers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.clippers_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.clippers_two))
//            }
//
//            "Los Angeles Lakers" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.lakers_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.lakers_two))
//            }
//
//            "Phoenix Suns" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.suns_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.suns_two))
//            }
//
//            "Sacramento Kings" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.kings_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.kings_two))
//            }
//
//            "Dallas Mavericks" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.mavericks_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.mavericks_two))
//            }
//
//            "Houston Rockets" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.rockets_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.rockets_two))
//            }
//
//            "Memphis Grizzlies" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.grizzlies_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.grizzlies_two))
//            }
//
//            "New Orleans Pelicans" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.pelicans_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.pelicans_two))
//            }
//
//            "San Antonio Spurs" -> {
//                binding.layoutOne.setBackgroundColor(this.resources.getColor(R.color.spurs_one))
//                binding.layoutTwo.setBackgroundColor(this.resources.getColor(R.color.spurs_two))
//            }
//
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        playerBinding = null
    }
}
package com.im.nbaplayerengine.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.data.cache.PlayerCacheEntity
import com.im.nbaplayerengine.data.cache.TeamCacheEntity
import com.im.nbaplayerengine.ui.viewmodels.PlayerViewModel
import com.im.nbaplayerengine.ui.viewmodels.TeamViewModel
import com.im.nbaplayerengine.utils.Resource
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home_.*
import kotlinx.android.synthetic.main.fragment_player_profile_.*
import kotlinx.android.synthetic.main.fragment_player_profile_.view.*

@AndroidEntryPoint
class PlayerProfile_Fragment : Fragment() {


    var playerCacheEntity: PlayerCacheEntity? = null

    val teamModel: TeamViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_profile_, container, false)


        arguments?.let {

            playerCacheEntity = PlayerProfile_FragmentArgs.fromBundle(it).playerCacheEntity
            if (playerCacheEntity != null) {

                Picasso.get().load(playerCacheEntity?.headShotUrl).into(view.player_headshot)


                view.player_fullname.text =
                    "${playerCacheEntity?.firstName} ${playerCacheEntity?.lastName}"
                view.player_teamname.text = playerCacheEntity?.team
                view.player_position.text = playerCacheEntity?.position
                view.player_age.text = playerCacheEntity?.age
                view.player_dateOfBirth.text = playerCacheEntity?.dateOfBirth
                view.player_height.text = playerCacheEntity?.height
                view.player_weight.text = playerCacheEntity?.weight
                view.player_jerseyNumber.text = playerCacheEntity?.jerseyNumber
                view.career_ppg.text = playerCacheEntity?.careerPoints.toString()
                view.career_rpg.text = playerCacheEntity?.careerRebounds.toString()
                view.career_apg.text = playerCacheEntity?.carrerAssists.toString()
                view.profile_ProgressBar.visibility = View.GONE


                getTeamThemeColor(playerCacheEntity?.team, view)

                view.profile_ProgressBar.visibility = View.GONE

            } else {

                view.profile_ProgressBar.visibility = View.VISIBLE

            }
        }



        teamModel.allTeams.observe(this.viewLifecycleOwner) { result ->

            for (teams in result.data!!) {
                if (playerCacheEntity?.team == teams.name) {
                    Picasso.get().load(teams.teamLogoUrl).into(view.team_logo)
                }
            }


            profile_ProgressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            profile_text_error.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            profile_text_error.text = result.error?.localizedMessage

        }



        return view
    }


    private fun getTeamThemeColor(team: String?, view: View) {
        when (team) {

            "Boston Celtics" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.celtics_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.celtics_two))
            }

            "Brooklyn Nets" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.nets_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.nets_two))
            }

            "New York Knicks" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.knicks_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.knicks_two))
            }

            "Philadelphia 76ers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.sevsixers_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.sevsixers_two))
            }

            "Toronto Raptors" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.raptors_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.raptors_two))
            }

            "Chicago Bulls" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.bulls_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.bulls_two))
            }

            "Cleveland Cavaliers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.cleveland_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.cleveland_two))
            }


            "Detroit Pistons" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.pistons_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.pistons_two))
            }


            "Indiana Pacers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.pacers_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.pacers_two))
            }


            "Milwaukee Bucks" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.bucks_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.bucks_two))
            }

            "Atlanta Hawks" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.hawks_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.hawks_two))
            }

            "Charlotte Hornets" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.hornets_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.hornets_two))
            }


            "Miami Heat" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.heat_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.heat_two))
            }


            "Orlando Magic" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.magic_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.magic_two))
            }


            "Washington Wizards" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.wizards_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.wizards_two))
            }


            "Denver Nuggets" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.nuggets_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.nuggets_two))
            }

            "Minnesota Timberwolves" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.timberwolves_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.timberwolves_two))
            }


            "Oklahoma City Thunder" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.thunder_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.thunder_two))
            }

            "Portland Trail Blazers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.blazers_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.blazers_two))
            }

            "Utah Jazz" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.jazz_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.jazz_two))
            }

            "Golden State Warriors" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.warriors_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.warriors_two))
            }

            "LA Clippers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.clippers_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.clippers_two))
            }

            "Los Angeles Lakers" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.lakers_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.lakers_two))
            }

            "Phoenix Suns" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.suns_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.suns_two))
            }

            "Sacramento Kings" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.kings_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.kings_two))
            }

            "Dallas Mavericks" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.mavericks_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.mavericks_two))
            }

            "Houston Rockets" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.rockets_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.rockets_two))
            }

            "Memphis Grizzlies" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.grizzlies_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.grizzlies_two))
            }

            "New Orleans Pelicans" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.pelicans_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.pelicans_two))
            }

            "San Antonio Spurs" -> {
                view.layout_one.setBackgroundColor(this.resources.getColor(R.color.spurs_one))
                view.layout_two.setBackgroundColor(this.resources.getColor(R.color.spurs_two))
            }

        }
    }
}
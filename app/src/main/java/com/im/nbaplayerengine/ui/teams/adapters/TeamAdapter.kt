package com.im.nbaplayerengine.ui.teams.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.teams.Team
import com.im.nbaplayerengine.ui.teams.fragments.TeamsFragmentDirections
import kotlinx.android.synthetic.main.team_item_layout.view.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private lateinit var teams: List<Team>

    fun setTeam(teams: List<Team>) {
        this.teams = teams
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.team_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    class TeamViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(team: Team){

            Glide.with(itemView.context).load(team.teamLogoUrl).into(itemView.teams_image)

            itemView.setOnClickListener {

                val action = TeamsFragmentDirections.actionTeamsFragmentToTeamPlayersFragment()
                action.team = team
                Navigation.findNavController(it).navigate(action)

            }

        }

    }


}
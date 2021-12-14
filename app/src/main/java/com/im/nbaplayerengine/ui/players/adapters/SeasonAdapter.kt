package com.im.nbaplayerengine.ui.players.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.seasons.Season
import kotlinx.android.synthetic.main.seasonlayout.view.*

class SeasonAdapter : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    lateinit var seasons: List<Season>

    fun setSeason(seasons: List<Season>){
        this.seasons = seasons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.seasonlayout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder.bind(seasons = seasons[position])
    }

    override fun getItemCount(): Int {
        return seasons.size
    }


    class SeasonViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(seasons: Season) {


            itemView.seasons.text = seasons.season

            itemView.team.text = seasons.team
            itemView.gamesplayed.text = seasons.gamesPlayed
            itemView.minsPerGame.text = seasons.minsPerGame
            itemView.pointspergame.text = seasons.pointsPerGame
            itemView.reboundsPerGame.text = seasons.reboundsPerGame
            itemView.assistsPerGame.text = seasons.assistsPerGame
            itemView.blocksPerGame.text = seasons.blocksPerGame

            itemView.fg.text = seasons.percentageFieldGoal
            itemView.fg3.text = seasons.percentageThree
            itemView.ft.text = seasons.percentageFreeThrow

        }
    }
}
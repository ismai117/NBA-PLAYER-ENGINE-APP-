package com.im.nbaplayerengine.ui.dashboard.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.games.Games
import kotlinx.android.synthetic.main.games_item_layout.view.*

class GamesAdapter(val teamsInterface: TeamsInterface) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>(){

    private lateinit var items: List<Games>

    fun setGames(items: List<Games>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
       return GamesViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.games_item_layout, parent, false)
       )
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {


        return holder.bind(items[position], teamsInterface)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class GamesViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        fun bind(games: Games, teamsInterface: TeamsInterface) {

            itemView.firstTeam_name.text = games.teamNameOne
            itemView.secondTeam_name.text = games.teamNametwo
            itemView.firstTeam_score.text = games.team_1_total.toString()
            itemView.secondTeam_score.text = games.team_2_total.toString()


            val position = adapterPosition

            if (position == adapterPosition){

                teamsInterface.teamName(games.teamNameOne.toString(), games.teamNametwo.toString(), itemView)

            }



        }


    }


}
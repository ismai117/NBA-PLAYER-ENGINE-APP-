package com.im.nbaplayerengine.ui.teams.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.players.Player
import kotlinx.android.synthetic.main.teamplayers_item_layout.view.*

class TeamPlayersAdapter : RecyclerView.Adapter<TeamPlayersAdapter.PlayerViewHolder>() {


    private lateinit var player: List<Player>

    fun setPlayer(player: List<Player>) {
        this.player = player
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.teamplayers_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(player[position])
    }

    override fun getItemCount(): Int {
        return player.size
    }

    class PlayerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(player: Player) {

            itemView.teamPlayer_fullname.text = "${player.firstName}\n${player.lastName}"
            itemView.teamPlayer_age.text = player.age.toString()
            itemView.teamPlayer_height.text = player.height.toString()
            itemView.teamPlayer_weight.text = player.weight.toString()

            Glide.with(itemView.context).load(player.headShotUrl).into(itemView.teamPlayer_image)

            itemView.teamPlayer_number.text = player.jerseyNumber
            itemView.teamPlayer_position.text = player.position


        }


    }

}
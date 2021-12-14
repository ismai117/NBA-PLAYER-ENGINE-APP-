package com.im.nbaplayerengine.ui.players.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.players.Player
import com.im.nbaplayerengine.ui.players.fragments.PlayersFragmentDirections
import kotlinx.android.synthetic.main.player_item_layout.view.*

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    lateinit var players: List<Player>

    fun setPLayer(players: List<Player>?) {
        this.players = players!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.player_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int {
        return players.size
    }


    class PlayerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(player: Player) {

            itemView.playerFullName.text = "${player.firstName} ${player.lastName}"

            Glide.with(itemView.context).load(player.headShotUrl).into(itemView.playerImage)



            itemView.setOnClickListener {

                val action = PlayersFragmentDirections.actionPlayersFragmentToPlayerProfileFragment()
                action.player = player
                Navigation.findNavController(it).navigate(action)
            }

        }
    }
}
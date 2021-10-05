package com.im.nbaplayerengine.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.data.cache.PlayerCacheEntity
import com.im.nbaplayerengine.ui.fragments.Home_FragmentDirections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.player_item_layout.view.*

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    lateinit var players: List<PlayerCacheEntity>

    fun setPLayer(players: List<PlayerCacheEntity>?){
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


    class PlayerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(player: PlayerCacheEntity){

            itemView.playerFullName.text = "${player.firstName} ${player.lastName}"

            Picasso.get().load(player.headShotUrl).into(itemView.playerImage)


            itemView.setOnClickListener {
                val action = Home_FragmentDirections.actionHomeFragmentToPlayerProfileFragment()
                action.playerCacheEntity = player
                Navigation.findNavController(it).navigate(action)
            }

        }
    }
}
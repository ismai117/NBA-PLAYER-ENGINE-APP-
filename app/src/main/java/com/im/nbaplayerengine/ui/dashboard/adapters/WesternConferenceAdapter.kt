package com.im.nbaplayerengine.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.standings.Standing
import kotlinx.android.synthetic.main.standing_item_layout.view.*

class WesternConferenceAdapter :
    RecyclerView.Adapter<WesternConferenceAdapter.WesternViewHolder>() {

    private lateinit var items: List<Standing>

    fun setWesternCon(items: List<Standing>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WesternViewHolder {
        return WesternViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.standing_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WesternViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class WesternViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(standing: Standing) {

            itemView.standing_team_position.text = standing.position.toString()
            Glide.with(itemView.context).load(standing.team).into(itemView.standing_team_logo)
            itemView.standing_team_name.text = standing.logo.toString()

            itemView.win_value.text = standing.win.toString()
            itemView.loss_value.text = standing.lose.toString()

        }


    }

}
package com.im.nbaplayerengine.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.standings.Standing
import kotlinx.android.synthetic.main.standing_item_layout.view.*

class EasternConferenceAdapter :
    RecyclerView.Adapter<EasternConferenceAdapter.EasternViewHolder>() {

    private lateinit var items: List<Standing>

    fun setEasternCon(items: List<Standing>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EasternViewHolder {
        return EasternViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.standing_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EasternViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EasternViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(standing: Standing) {

            itemView.standing_team_position.text = standing.position.toString()
            Glide.with(itemView.context).load(standing.team).into(itemView.standing_team_logo)
            itemView.standing_team_name.text = standing.logo.toString()

        }


    }


}
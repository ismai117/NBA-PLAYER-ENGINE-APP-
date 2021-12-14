package com.im.nbaplayerengine.ui.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.ui.news.fragments.NewsFragmentDirections
import kotlinx.android.synthetic.main.article_item_layout.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private lateinit var items: List<News>

    fun setArticle(items: List<News>){
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NewsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){


        fun bind(news: News) {

            Glide.with(itemView.context).load(news.media).into(itemView.article_item_image)
            itemView.article_item_title.text = news.title


            itemView.setOnClickListener {

                val action = NewsFragmentDirections.actionNewsFragmentToArticleFragment()
                action.news = news

                Navigation.findNavController(it).navigate(action)


            }



        }


    }

}
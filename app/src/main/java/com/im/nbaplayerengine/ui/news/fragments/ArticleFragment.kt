package com.im.nbaplayerengine.ui.news.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.im.nbaplayerengine.R
import com.im.nbaplayerengine.databinding.FragmentArticleBinding
import kotlinx.android.synthetic.main.activity_main.*


class ArticleFragment : Fragment() {

    private var articleBinding: FragmentArticleBinding? = null
    private val binding get() = articleBinding!!
    private var title: String? = null
    private var auther: String? = null
    private var publishedDate: String? = null
    private var link: String? = null
    private var summary: String? = null
    private var media: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        arguments?.let {

            val article = ArticleFragmentArgs.fromBundle(it).news

            if (article != null){

                title = article.title
                auther = article.author
                publishedDate = article.published_date
                link = article.link
                summary = article.summary
                media = article.media

            }


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
      articleBinding = FragmentArticleBinding.inflate(inflater, container, false)
        val view = binding.root


        requireActivity().toolbar.title = "Article"

        binding.articleTitle.text = title
        Glide.with(requireContext()).load(media).into(binding.articleImage)
        binding.articleSummary.text = summary





        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        articleBinding = null
    }

}
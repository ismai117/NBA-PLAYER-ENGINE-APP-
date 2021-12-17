package com.im.nbaplayerengine.ui.news.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.im.nbaplayerengine.databinding.FragmentNewsBinding
import com.im.nbaplayerengine.ui.news.adapters.NewsAdapter
import com.im.nbaplayerengine.ui.news.viewmodels.NewsViewModel
import com.im.nbaplayerengine.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var newsBinding: FragmentNewsBinding? = null
    private val binding get() = newsBinding!!
    private val newsModel: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsAdapter = NewsAdapter()





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        newsBinding = FragmentNewsBinding.inflate(inflater, container,false)
        val view = binding.root



        newsModel.response.observe(this.viewLifecycleOwner, { result ->


            result?.let {

                if (result.data != null){



                    initRecycler()
                    newsAdapter.setArticle(result.data)


                    binding.newsProgressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()

                    binding.newsTextError.isVisible =
                        result is Resource.Error && result.data.isNullOrEmpty()

                    binding.newsTextError.text = result.error?.localizedMessage



                } else {
                    Log.d("newsnba", "error")
                }

            }



        })







        return view
    }

    private fun initRecycler() {
        binding.newsRecyclerViews.adapter = newsAdapter
        binding.newsRecyclerViews.layoutManager = LinearLayoutManager(this.requireContext())
        binding.newsRecyclerViews.setHasFixedSize(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        newsBinding = null
    }

}
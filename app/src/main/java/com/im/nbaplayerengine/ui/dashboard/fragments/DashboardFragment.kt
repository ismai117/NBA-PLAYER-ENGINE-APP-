package com.im.nbaplayerengine.ui.dashboard.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.im.nbaplayerengine.databinding.FragmentDashboardBinding
import com.im.nbaplayerengine.ui.dashboard.adapters.EasternConferenceAdapter
import com.im.nbaplayerengine.ui.dashboard.adapters.WesternConferenceAdapter
import com.im.nbaplayerengine.ui.dashboard.viewmodels.DashboardViewModel
import com.im.nbaplayerengine.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var dashboardBinding: FragmentDashboardBinding? = null
    private val binding get() = dashboardBinding!!
    private val dashboardModel: DashboardViewModel by viewModels()
    private lateinit var easternConferenceAdapter: EasternConferenceAdapter
    private lateinit var westernConferenceAdapter: WesternConferenceAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        easternConferenceAdapter = EasternConferenceAdapter()
        westernConferenceAdapter = WesternConferenceAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container,false)
        val view = binding.root

        requireActivity().toolbar.title = "Home"



        dashboardModel.getStandings.observe(this.viewLifecycleOwner, {  result ->

            result?.let{

                if (result.data != null){

                    result.data.forEach { Log.d("dashboardStanding", "${it.position}") }
                    binding.dashboardProgressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()

                    binding.dashboardTextError.isVisible =
                        result is Resource.Error && result.data.isNullOrEmpty()

                    binding.dashboardTextError.text = result.error?.localizedMessage

                } else {
                    Log.d("dashboardStanding", "${result.error?.message}")
                }

            }
        })


        dashboardModel.getEasternConference.observe(this.viewLifecycleOwner, { result ->

            result?.let {

                initEasternRecycler()
                easternConferenceAdapter.setEasternCon(it)

            }

        })


        dashboardModel.getWesternConference.observe(this.viewLifecycleOwner, { result ->

            result?.let {

                initWesternRecycler()
                westernConferenceAdapter.setWesternCon(it)

            }

        })

        return view
    }

    private fun initEasternRecycler() {
        binding.easternConferenceRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.easternConferenceRecyclerView.setHasFixedSize(true)
        binding.easternConferenceRecyclerView.adapter = easternConferenceAdapter
    }

    private fun initWesternRecycler() {
        binding.westernConferenceRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.westernConferenceRecyclerView.setHasFixedSize(true)
        binding.westernConferenceRecyclerView.adapter = westernConferenceAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        dashboardBinding = null
    }

}
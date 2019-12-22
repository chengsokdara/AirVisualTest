package com.sokdara.cheng.airvisualtest.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sokdara.cheng.airvisualtest.R
import com.sokdara.cheng.airvisualtest.lib.TabPagerAdapter


class MyAirFragment : Fragment() {

    private lateinit var mAdapter: TabPagerAdapter
    private lateinit var mPager: ViewPager
    private lateinit var mTab: TabLayout
    private var listener: OnFragmentInteractionListener? = null

    interface OnFragmentInteractionListener {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = TabPagerAdapter(activity?.supportFragmentManager!!, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_my_air, container, false)
        mPager = view.findViewById(R.id.placeViewPager)
        mTab = view.findViewById(R.id.placeTabLayout)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPager.adapter = mAdapter
        mTab.setupWithViewPager(mPager)
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        mPager.adapter = null
    }*/

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
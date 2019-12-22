package com.sokdara.cheng.airvisualtest.lib

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sokdara.cheng.airvisualtest.ui.DeviceFragment
import com.sokdara.cheng.airvisualtest.ui.PlaceFragment

class TabPagerAdapter(fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PlaceFragment()
            1 -> DeviceFragment()
            else -> throw ArrayIndexOutOfBoundsException()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Places"
            1 -> "Devices"
            else -> ""
        }
    }

    override fun getCount(): Int = 2
}
package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CafeDetailFragment.newInstance("Starbucks")
            1 -> CafeDetailFragment.newInstance("Janji Jiwa")
            2 -> CafeDetailFragment.newInstance("Kopi Kenangan")
            else -> CafeDetailFragment.newInstance("Unknown")
        }
    }
}

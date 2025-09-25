package com.example.lab_week_04

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val context: Context
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val DESCRIPTIONS = arrayOf(
        R.string.starbucks_desc,
        R.string.janjijiwa_desc,
        R.string.kopikenangan_desc
    )

    override fun getItemCount(): Int = DESCRIPTIONS.size

    override fun createFragment(position: Int): Fragment {
        val desc = context.getString(DESCRIPTIONS[position])
        return CafeDetailFragment.newInstance(desc)
    }
}

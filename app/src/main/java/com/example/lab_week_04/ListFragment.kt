package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // daftar semua item kopi
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.mocha)
        )

        // pasang click listener untuk setiap item
        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                // Kirim ID kopi ke DetailFragment lewat Bundle
                val bundle = Bundle().apply {
                    putInt("coffeeId", coffee.id)
                }
                findNavController().navigate(R.id.detailFragment, bundle)
            }
        }
    }
}

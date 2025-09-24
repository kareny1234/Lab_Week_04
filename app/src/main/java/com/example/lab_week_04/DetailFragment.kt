package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var coffeeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ambil coffeeId dari arguments (dikirim dari ListFragment)
        coffeeId = arguments?.getInt("coffeeId") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeTitle: TextView = view.findViewById(R.id.coffee_title)
        val coffeeDesc: TextView = view.findViewById(R.id.coffee_desc)
        val backButton: Button = view.findViewById(R.id.btn_back)

        // isi data kopi berdasarkan ID
        when (coffeeId) {
            R.id.affogato -> {
                coffeeTitle.text = "AFFOGATO"
                coffeeDesc.text = "Espresso poured on a vanilla ice cream. Served in a cappuccino cup."
            }
            R.id.americano -> {
                coffeeTitle.text = "AMERICANO"
                coffeeDesc.text = "Espresso with added hot water (100-150 ml)."
            }
            R.id.latte -> {
                coffeeTitle.text = "CAFFE LATTE"
                coffeeDesc.text = "A tall, mild 'milk coffee'. Espresso with steamed milk and a little milk foam."
            }
            R.id.cappuccino -> {
                coffeeTitle.text = "CAPPUCCINO"
                coffeeDesc.text = "A classic Italian drink with equal parts espresso, steamed milk, and milk foam."
            }
            R.id.mocha -> {
                coffeeTitle.text = "MOCHA"
                coffeeDesc.text = "Espresso, steamed milk, and chocolate syrup, often topped with whipped cream."
            }
        }

        // tombol back: kembali ke fragment sebelumnya
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}

package com.example.fuelondemand.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fuelondemand.R
import com.example.fuelondemand.adapter.CartAdapter
import com.example.fuelondemand.databinding.FragmentCartBinding


class CartFragment : Fragment() {
   private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)



        val cartFuelName = listOf("Petrol","Diesel","CNG")
        val cartItemPrice = listOf("Rs.98.6/-","Rs.96.78/-","Rs.87.6/-")
        val cartImage = listOf(
            R.drawable.petrol,
            R.drawable.diesel,
            R.drawable.cng
            )
        val adapter = CartAdapter(ArrayList(cartFuelName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}
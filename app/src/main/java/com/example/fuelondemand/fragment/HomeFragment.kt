package com.example.fuelondemand.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.fuelondemand.R
import com.example.fuelondemand.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fuelondemand.adapter.PopularAdapter



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,
            ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,
            ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,
            ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setOnClickListener(object: ItemClickListener, View.OnClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()

            }

            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }


        })

        val fuelName = listOf("Petrol", "Diesel", "CNG")
        val Price = listOf("98.6/Ltr", "96.20/Ltr", "89.6/Kg")
        val popularFuelImages = listOf(R.drawable.petrol, R.drawable.diesel, R.drawable.cng)
        val adapter = PopularAdapter(fuelName, Price, popularFuelImages)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
    companion object {

                }

    
}